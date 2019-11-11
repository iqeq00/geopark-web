layui.define(['config', 'lichee', 'upload', 'layer'], function (exports) {
    var $ = layui.$;
    var config = layui.config;
    var lichee = layui.lichee;
    var upload = layui.upload;
    var layer = layui.layer;
    var fileList = new Array();
    var pathList = new Array();

    var defaults = {
        elementId: '',
        hiddenId: '',
        listElement: 'fileList',
        keyPath: ''
    };

    var fileUpload = {

        init: function (elementId, hiddenId, keyPath) {
            fileUpload.clear();
            fileUpload.initValue(elementId, hiddenId, keyPath)
            upload.render({
                elem: '#' + elementId,
                url: '/upload/file',
                headers: {Authorization: config.getToken()},
                data: {keyPath: keyPath},
                multiple: true,
                accept: 'file',
                number: 5,
                done: function (res) {
                    if (res.status = 200) {
                        fileUpload.push(res.result);
                        fileUpload.join();
                        fileUpload.html(res.result);
                        return layer.msg('上传成功');
                    } else {
                        return layer.msg('上传失败');
                    }
                }
            });
        },

        initValue: function (elementId, hiddenId, keyPath) {
            defaults.elementId = elementId;
            defaults.hiddenId = hiddenId;
            defaults.keyPath = keyPath;
        },

        initFileList: function (fileListStr) {
            if (fileListStr) {
                pathList = fileListStr.split(",");
                $(pathList).each(function (index, path) {
                    var file = new Object();
                    file.path = path;
                    file.name = path.substring(path.lastIndexOf("/") + 1);
                    fileList.push(file);
                    fileUpload.html(file);
                });
            }
        },

        clear: function () {
            fileList.length = 0;
            pathList.length = 0;
        },

        push: function (file) {
            fileList.push(file);
            pathList.push(file.path);
        },

        html: function (file) {
            var html = '<tr><td>' + file.name + '</td><td><button class="layui-btn layui-btn-xs layui-btn-danger delete" data-id="' + file.path + '">删除</button></td></tr>';
            $('#' + defaults.listElement).append(html);
            fileUpload.deleteElement();
        },

        join: function () {
            $('#' + defaults.hiddenId).val(pathList.join());
            console.log($('#' + defaults.hiddenId).val()+"@@@");
        },

        deleteElement: function () {
            $('#' + defaults.listElement + " tr td .delete").unbind("click").click(function () {
                var path = $(this).attr("data-id");
                $(this).parent().parent().remove();
                fileUpload.deleteArray(path);
            });
        },

        deleteArray: function (path) {
            fileList.splice(fileList.findIndex(file => file.path === path), 1);
            pathList.splice(pathList.findIndex(val => val === path), 1);
            fileUpload.join();
        },

    };

    exports('fileUpload', fileUpload);
});
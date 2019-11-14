layui.define(['config', 'lichee', 'upload', 'layer'], function (exports) {
    var $ = layui.$;
    var config = layui.config;
    var lichee = layui.lichee;
    var upload = layui.upload;
    var layer = layui.layer;
    var imageList = new Array();
    var pathList = new Array();

    var defaults = {
        elementId: '',
        hiddenId: '',
        listElement: 'upload-list',
        keyPath: ''
    };

    var imageUpload = {

        init: function (elementId, hiddenId, keyPath) {
            imageUpload.clear();
            imageUpload.initValue(elementId, hiddenId, keyPath)
            upload.render({
                elem: '#' + elementId,
                url: '/upload/img',
                headers: {Authorization: config.getToken()},
                data: {keyPath: keyPath},
                multiple: true,
                // accept: 'file',
                // exts: 'jpg|png|gif|bmp|jpeg|tif',
                number: 20,
                done: function (res) {
                    if (res.status = 200) {
                        imageUpload.push(res.result);
                        imageUpload.join();
                        imageUpload.html(res.result);
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

        initImageList: function (imageListStr) {
            if (imageListStr) {
                pathList = imageListStr.split(",");
                $(pathList).each(function (index, path) {
                    var image = new Object();
                    image.path = path;
                    image.name = path.substring(path.lastIndexOf("/") + 1);
                    imageList.push(image);
                    imageUpload.html(image);
                });
            }
        },

        clear: function () {
            imageList.length = 0;
            pathList.length = 0;
        },

        push: function (image) {
            imageList.push(image);
            pathList.push(image.path);
        },

        html: function (image) {
            var html = '<div><img src="' + image.path + '" alt="' + image.name + '" class="layui-upload-img"><span class="delete" data-id="' + image.path + '">删除</span></div>';
            $('.' + defaults.listElement).append(html);
            imageUpload.deleteElement();
            imageUpload.showElement();
        },

        join: function () {
            $('#' + defaults.hiddenId).val(pathList.join());
        },

        showElement: function () {
            $('.' + defaults.listElement + " div .layui-upload-img").unbind("click").click(function () {
                var src = $(this).attr("src");
                $("<img />").attr("src", src).on("load", function () {
                    var width = this.width;
                    var height = this.height;
                    var scaleWH = (width / height).toFixed(2);
                    var bigH = 600;
                    var bigW = scaleWH * bigH;
                    if(bigW > 900){
                        bigW = 900;
                        bigH = bigW / scaleWH;
                    }
                    imageUpload.showImage(bigW, bigH, src);
                });
            });
        },

        showImage: function (width, height, src){
            layer.open({
                type: 1,
                title: false,
                closeBtn: 1,
                shadeClose: true,
                area: [width + 'px', height + 'px'],
                content: "<img width='"+width+"' height='"+height+"' src=" + src + " />"
            });
        },

        deleteElement: function () {
            $('.' + defaults.listElement + " div .delete").unbind("click").click(function () {
                var path = $(this).attr("data-id");
                $(this).parent().remove();
                imageUpload.deleteArray(path);
            });
        },

        deleteArray: function (path) {
            imageList.splice(imageList.findIndex(image => image.path === path), 1);
            pathList.splice(pathList.findIndex(val => val === path), 1);
            imageUpload.join();
        },

    };

    exports('imageUpload', imageUpload);
});
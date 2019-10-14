layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'upload'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;

    upload.render({
        elem: '#uploadBtn',
        url: '/import1/xls',
        headers: {Authorization: config.getToken()},
        data: {keyPath: "geolandscape"},
        multiple: true,
        accept: 'file',
        number: 5,
        done: function (res) {
            var file = res.result;
            if (res.status = 200) {
                // var html = '<tr><td>' + file.name + '</td><td><button class="layui-btn layui-btn-xs layui-btn-danger delete" data-id="' + file.path + '">删除</button></td></tr>';
                // $('#fileList').append(html);
                return layer.msg('导入成功');
            } else {
                return layer.msg('导入失败');
            }
        }
    });

    $('#export').click(function () {
        // lichee.get('/export/xls', {}, function (data) {
        //     layer.msg('导出成功');
        // });
        window.location.href="/export/xls";
        layer.msg('导出成功');
    });

});
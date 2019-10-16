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
        url: '/import/xls',
        headers: {Authorization: config.getToken()},
        data: {
            keyPath: function(){
                return $("#column").val();
            }
        },
        multiple: true,
        accept: 'file',
        number: 5,
        done: function (res) {
            var file = res.result;
            if (res.status = 200) {
                return layer.msg('导入成功');
            } else {
                return layer.msg('导入失败');
            }
        }
    });

    $('#export').click(function () {
        window.location.href="/export/xls?keyPath=" + $("#column").val();
        layer.msg('导出成功');
    });

});
layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/resource/page',
        title: '资源数据表',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            //{type: 'checkbox', fixed: 'left'},
            {field: 'id', title: 'ID'},
            {field: 'resourceName', align: 'center', sort: true, title: '资源名称'},
            {field: 'method', align: 'center', sort: true, title: '请求方式'},
            {field: 'mapping', align: 'center', sort: true, title: '路径映射'},
            {
                minWidth: 80, align: 'center', templet: function (d) {
                    if (d.authType == 1) {
                        return '<span class="layui-badge layui-bg-blue">登录</span>';
                    } else if (d.authType == 2) {
                        return '<span class="layui-badge layui-bg-green">开放</span>';
                    } else if (d.authType == 3) {
                        return '<span class="layui-badge layui-bg-red">鉴权</span>';
                    }
                }, title: '权限类型'
            },
            {field: 'perm', align: 'center', sort: true, title: '权限标识'},
            {field: 'updateTime', align: 'center', sort: true, title: '修改时间'},
        ]]
    });

    table.on('toolbar(tableFilter)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'add':
                break;
            case 'refresh':
                layer.load(2);
                lichee.put('/resource', {}, function (res) {
                    callFunction(res);
                });
                break;
        };
    });

    var callFunction = function (res) {
        layer.closeAll();
        if (res.status == 200) {
            layer.msg("刷新成功",{icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
        }
    };

    $('#searchButton').click(function () {
        tableInfo.reload({where: lichee.getSearchForm()});
    });
});
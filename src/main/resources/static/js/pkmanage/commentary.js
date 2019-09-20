//公园概况

layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'laydate'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var laydate = layui.laydate;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        //width:'auto',
        url: '/commentary/page',
        title: '标示解说系统',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            //{type: 'checkbox', fixed: 'left'},
            // {field: 'id', title: 'ID'},
            {field: 'parkId', align: 'center', sort: true, title: '地质公园ID'},
            {field: 'number', align: 'center', sort: true, title: '编号'},
            {field: 'type', align: 'center', sort: true, title: '类型'},
            {field: 'position', align: 'center', sort: true, title: '位置'},
            {field: 'coordinate', align: 'center', sort: true, title: '坐标'},
            {field: 'constructiontime', align: 'center', sort: true, title: '建设时间'},
            //{field: 'note', align: 'center', sort: true, title: '备注'},
            {fixed: 'right',align : 'center', title: '操作', toolbar: '#bar', width: 180}
        ]]
    });

    table.on('toolbar(tableFilter)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'add':
                showEditModel();
                break;
            case 'getCheckLength':
                var data = checkStatus.data;
                layer.msg('选中了：' + data.length + ' 个');
                break;
            case 'isAll':
                layer.msg(checkStatus.isAll ? '全选' : '未全选');
                break;
        };
    });

    table.on('tool(tableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定要删除吗？', function (index) {
                layer.load(2);
                lichee.delete('/commentary/' + obj.data.id, {}, function () {
                    layer.closeAll('loading');
                    layer.msg('删除成功', {icon: 1});
                    obj.del();
                });
            });
        } else if (obj.event === 'edit') {
            showEditModel(data);
        }
    });

    var showEditModel = function (data) {
        layer.open({
            title: data ? '详情/修改' : '添加',
            type: 1,
            area: '800px',
            offset: '20px',
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                lichee.get('/park/list', {async: false}, function (data) {
                    $('#parkId').vm({parks: data.result});
                    form.render('select');
                });
                if (data) {
                    form.val('formFilter', data);
                }
                $('#form .close').click(function () {
                    layer.closeAll('page');
                });
            }
        });
    };

    var form = layui.form;
    form.on('submit(formSubmit)', function (data) {
        layer.load(2);
        if (data.field.id) {
            lichee.put('/commentary/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/commentary', {data: data.field}, function (res) {
                callFunction(res);
            });
        }
        return false;
    });

    form.verify({
        commonLength: [/^[\S]{1,100}$/, '字符长度最大100'],
        descLength: [/^[\S]{0,180}$/, '字符长度最大180']
    });

    var callFunction = function (res) {
        layer.closeAll();
        if (res.status == 200) {
            layer.msg("修改成功",{icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
        } else if(res.status == 201)  {
            layer.msg("添加成功",{icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
        }
    };

    $('#searchButton').click(function () {
        tableInfo.reload({where: lichee.getSearchForm()});
    });

    laydate.render({
        elem: '#startTime',
        type: 'datetime',
        value: '',
        trigger: 'click'
    });

    $(".laydate").each(function (i,e) {
        laydate.render({
            elem: this,
            type: 'datetime',
            value: '',
            trigger: 'click'
        });
    });

});
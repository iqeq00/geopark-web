layui.use(['jquery', 'layer', 'table', 'form', 'lichee', 'laydate'], function () {

    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var lichee = layui.lichee;
    var laydate = layui.laydate;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/task/page',
        title: '任务数据表',
        page: true,
        limit: 10,
        cols: [[
            {type: 'checkbox', fixed: 'left'},
            {field: 'id', title: 'ID'},
            {field: 'taskName', align: 'center', sort: true, title: '任务名称'},
            {field: 'taskDesc', align: 'center', sort: true, title: '任务描述'},
            {field: 'createTime', align: 'center', sort: true, title: '创建时间'},
            {
                minWidth: 80, align: 'center', templet: function (d) {
                    if (d.status == 1) {
                        return '<span class="layui-badge layui-bg-gray">任务未开始</span>';
                    } else if (d.status == 2) {
                        return '<span class="layui-badge layui-bg-blue">任务进行中</span>';
                    } else if (d.status == 3) {
                        return '<span class="layui-badge layui-bg-green">任务完成</span>';
                    } else if (d.status == 4) {
                        return '<span class="layui-badge layui-bg-red">任务失败</span>';
                    }
                }, title: '状态'
            },
            {fixed: 'right', title: '操作', toolbar: '#bar', width: 150}
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
                lichee.delete('/task/' + obj.data.id, {}, function () {
                    layer.close(index);
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
            title: data ? '修改' : '添加',
            type: 1,
            area: '450px',
            offset: '120px',
            content: $('#form'),
            success: function () {
                $('#form')[0].reset();
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
        if (data.field.id) {
            lichee.put('/task/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/task', {data: data.field}, function (res) {
                callFunction(res);
            });
        }
        return false;
    });

    form.verify({
        nameLength: [/^[\S]{1,100}$/, '字符长度1-100（不包含空格）'],
        descrLength: [/^[\S]{0,200}$/, '字符长度最大200（不包含空格）']
    });

    var callFunction = function (res) {
        layer.closeAll();
        layer.msg(res.msg);
        if (res.code == 0) {
            tableInfo.reload({where: lichee.getSearchForm()});
        }
    };

    $('#searchButton').click(function () {
        console.log("00000");
        console.log(lichee.getSearchForm());
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
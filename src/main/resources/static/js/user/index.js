layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'formSelects'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var formSelects = layui.formSelects;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/user/page',
        title: '用户数据表',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            // {type: 'checkbox', fixed: 'left'},
            // {field: 'id', title: 'ID', width: 10},
            {field: 'loginName', align: 'center', sort: true, title: '账号', width: 100},
            {field: 'nickname', align: 'center', sort: true, title: '用户名', width: 100},
            {field: 'phone', align: 'center', sort: true, title: '手机号', width: 150},
            {field: 'email', align: 'center', sort: true, title: '邮箱', minwidth: 200},
            {field: 'createTime', align: 'center', sort: true, title: '创建时间', width: 200},
            {field: 'status', align: 'center', sort: true, templet: '#user-tpl-status', title: '状态', width: 150},
            {fixed: 'right', title: '操作', toolbar: '#bar', width: 250}
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
                lichee.delete('/user/' + obj.data.id, {}, function () {
                    layer.closeAll('loading');
                    layer.msg('删除成功', {icon: 1});
                    obj.del();
                });
            });
        } else if (obj.event === 'edit') {
            showEditModel(data);
        } else if (obj.event === 'password') {
            layer.confirm('确定重置此用户密码？', function (i) {
                layer.close(i);
                layer.load(2);
                lichee.put('/user/' + obj.data.id + '/password', {}, function () {
                    layer.closeAll('loading');
                    layer.msg('重置密码成功', {icon: 1});
                });
            });
        }
    });

    var showEditModel = function (data) {
        if (data) {
            lichee.get('/user/' + data.id, {async:false}, function (data) {
                lichee.putTempData('t_user', data.result);
            });
        }
        layer.open({
            title: data ? '修改' : '添加',
            type: 1,
            area: '450px',
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                if (data) {
                    form.val('formFilter', data);
                    $("#loginNameDiv").hide();
                    $("#passwordDiv").hide();
                } else {
                    $("#loginNameDiv").show();
                    $("#passwordDiv").show();
                }

                lichee.get('/role/list', {}, function (data) {
                    // 渲染多选下拉框
                    var roleSelectData = new Array();
                    for (var i = 0; i < data.result.length; i++) {
                        roleSelectData.push({name: data.result[i].roleName, value: data.result[i].id});
                    }
                    formSelects.data('roleIds', 'local', {arr: roleSelectData});
                    // 回显user数据
                    var user = lichee.getTempData('t_user');
                    if (user) {
                        form.val('form', user);
                        $("#loginName").attr("readonly", "readonly");
                        var rds = new Array();
                        for (var i = 0; i < user.roleIds.length; i++) {
                            rds.push(user.roleIds[i]);
                        }
                        formSelects.value('roleIds', rds);
                    }
                    layer.closeAll('loading');
                });

                $('#form .close').click(function () {
                    layer.closeAll('page');
                });
            }
        });

    };

    var form = layui.form;
    form.on('submit(formSubmit)', function (data) {
        layer.load(2);
        var roleIds = new Array();
        if (data.field.roleIds) {
            roleIds = data.field.roleIds.split(",");
        }
        data.field.roleIds = roleIds;
        if (data.field.id) {
            lichee.put('/user/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/user', {data: data.field}, function (res) {
                callFunction(res);
            });
        }
        return false;
    });

    form.on('switch(user-tpl-status)', function (obj) {
        layer.load(2);
        lichee.put('/user/' + obj.elem.value + '/status',
            {data: {status: obj.elem.checked ? 0 : 1}}, function () {
                layer.closeAll('loading');
                layer.msg('用户状态更新成功', {icon: 1});
            });
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

});
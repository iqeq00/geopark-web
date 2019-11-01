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
        url: '/role/page',
        title: '角色数据表',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            // {type: 'checkbox', fixed: 'left'},
            // {field: 'id', title: 'ID'},
            {field: 'roleName', align: 'center', sort: true, title: '角色名称'},
            {field: 'remark', align: 'center', sort: true, title: '备注'},
            {field: 'createTime', align: 'center', sort: true, title: '创建时间'},
            {field: 'updateTime', align: 'center', sort: true, title: '修改时间'},
            {fixed: 'right', title: '操作', toolbar: '#bar'}
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
                lichee.delete('/role/' + obj.data.id, {}, function () {
                    layer.closeAll('loading');
                    layer.msg('删除成功', {icon: 1});
                    obj.del();
                });
            });
        } else if (obj.event === 'edit') {
            showEditModel(data);
        } else if (obj.event === 'resource') {
            showMenuTree(data);
        }
    });

    var showEditModel = function (data) {
        layer.open({
            title: data ? '修改' : '添加',
            type: 1,
            area: '450px',
            content: $('#form-model').html(),
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
        layer.load(2);
        if (data.field.id) {
            lichee.put('/role/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/role', {data: data.field}, function (res) {
                callFunction(res);
            });
        }
        return false;
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

    /***tree***/
    var showMenuTree = function (data) {
        var menuIds = data.menuIds;
        layer.open({
            type: 1,
            title: '菜单授权',
            area: ['400px', '600px'],
            content: $('#menu-tree').html(),
            success: function () {
                $('#tree-form')[0].reset();
                form.val("tree-form", {
                    "roleId": data.id
                });
                //树形菜单
                lichee.get('/menu/list', {}, function (data) {
                    var result = data.result;
                    //定义一数组
                    var zNodes = [];
                    for (var i = 0; i < result.length; i++) {
                        var zNode = {};
                        zNode.id = result[i].id;
                        zNode.parentId = result[i].parentId;
                        zNode.menuName = result[i].menuName;
                        zNode.isParent = result[i].menuType == 3 ? false : true;
                        zNodes.push(zNode);
                    }
                    var zTree = $.fn.zTree.init($("#menuTreeData"), setting, zNodes);
                    if (menuIds) {
                        for (var j = 0; j < menuIds.length; j++) {
                            var node = zTree.getNodeByParam("id", menuIds[j]);
                            zTree.checkNode(node, true, false);
                        }
                    }
                    onAsyncSuccess();
                    layer.closeAll('loading');
                });
                $('#tree-form .close').click(function () {
                    layer.closeAll('page');
                });
            }
        });
    };

    // 表单提交事件
    form.on('submit(tree-form-submit)', function (data) {
        layer.load(2);
        var zTree = $.fn.zTree.getZTreeObj("menuTreeData");
        var checked = zTree.getCheckedNodes();
        var menuIds = [];
        for (var i = 0; i < checked.length; i++) {
            menuIds.push(checked[i].id);
        }
        if (menuIds.length == 0) {
            layer.msg('请选择授权菜单', {icon: 5});
            layer.closeAll('page');
            return false;
        }
        lichee.put('/role/' + data.field.roleId + '/menu', {data: menuIds}, function () {
            layer.closeAll('loading');
            layer.msg('授权成功', {icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
            layer.closeAll('page');
        });
        return false;
    });

});
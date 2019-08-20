layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'treetable', 'form', 'iconPicker', 'formSelects'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var treetable = layui.treetable;
    var form = layui.form;
    var iconPicker = layui.iconPicker;
    var formSelects = layui.formSelects;

    var tableId = '#table';
    var tableInfo = treetable.render({
        elem: tableId,
        //树形图标显示在第几列
        treeColIndex: 1,
        //最上级的父级id
        treeSpid: 0,
        //id字段的名称
        treeIdName: 'id',
        //pid字段的名称
        treePidName: 'parentId',
        //是否默认折叠
        treeDefaultClose: false,
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/menu/page',
        title: '菜单数据表',
        headers: {Authorization: config.getToken()},
        cols: [[
            {field: 'id', align: 'center', sort: true, width: 60, title: 'ID'},
            {field: 'menuName', align: 'center', sort: true, title: '菜单名称'},
            {
                field: 'icon', title: '图标', align: 'center', width: 60, templet: function (d) {
                    return d.icon ? '<i class="layui-icon ' + d.icon + '"></i>' : '';
                }
            },
            {field: 'path', align: 'center', sort: true, title: '菜单路径'},
            {field: 'router', align: 'center', sort: true, title: '路由'},
            {
                align: 'center', templet: function (d) {
                    if (d.menuType === 1) {
                        return '<span class="layui-badge layui-bg-gray">目录</span>';
                    } else if (d.menuType === 2) {
                        return '<span class="layui-badge layui-bg-blue">菜单</span>';
                    } else if (d.menuType === 3) {
                        return '<span class="layui-badge layui-badge-rim">按钮</span>';
                    } else {
                        return '<span class="layui-bg-black">未知</span>';
                    }
                }, title: '类型'
            },
            {field: 'status', align: 'center', templet: '#menu-tpl-status', title: '状态', width: 100},
            {field: 'updateTime', align: 'center', sort: true, title: '修改时间'},
            {fixed: 'right', align: 'center', toolbar: '#bar', title: '操作'}
        ]]
    });

    table.on('toolbar(tableFilter)', function (obj) {
        if (obj.event === 'add') {
            showEditModel();
        } else if (obj.event === 'expandAll') {
            treetable.expandAll(tableId);
        } else if (obj.event === 'foldAll') {
            treetable.foldAll(tableId);
        }
    });

    table.on('tool(tableFilter)', function (obj) {
        var data = obj.data;
        if (obj.event === 'del') {
            layer.confirm('确定要删除吗？', function (index) {
                layer.load(2);
                lichee.delete('/menu/' + obj.data.id, {}, function () {
                    layer.closeAll('loading');
                    layer.msg('删除成功', {icon: 1});
                    obj.del();
                });
            });
        } else if (obj.event === 'edit') {
            showEditModel(data);
        }
    });

    form.on('switch(menu-tpl-status)', function (obj) {
        layer.load(2);
        lichee.put('/menu/' + obj.elem.value + '/status', {data: {status: obj.elem.checked ? 0 : 1}}, function () {
            layer.closeAll('loading');
            layer.msg('菜单状态更新成功', {icon: 1});
        });
    });

    var showEditModel = function (data) {

        if (data) {
            lichee.get('/menu/' + data.id, {async: false}, function (data) {
                lichee.putTempData('t_menu', data.result);
            });
        }

        var menu = liche.getTempData('t_menu');
        lichee.get('/resource/list', {async: false}, function (data) {
            // 渲染多选下拉框
            var resourceSelectData = new Array();
            for (var i = 0; i < data.result.length; i++) {
                resourceSelectData.push({
                    name: data.result[i].resourceName + ':' + data.result[i].perm,
                    value: data.result[i].id
                });
            }
            formSelects.data('resourceIds', 'local', {arr: resourceSelectData});
        });

        // 获取所有菜单
        lichee.get('/menu/combos', {}, function (data) {
            $('#parentId').vm({parents: data.result});
            form.render('select');
            // 回显menu数据
            if (menu) {
                if (menu.menuType == 1) {
                    $("#resourceIdsDiv").hide();
                    $("#pathDiv").hide();
                    $("#routerDiv").hide();
                } else if (menu.menuType == 2) {
                    $("#pathDiv").show();
                    $("#routerDiv").show();
                    $("#resourceIdsDiv").show();
                } else if (menu.menuType == 3) {
                    $("#pathDiv").hide();
                    $("#routerDiv").hide();
                    $("#resourceIdsDiv").show();
                }
                if (menu.resourceIds) {
                    var rds = new Array();
                    for (var i = 0; i < menu.resourceIds.length; i++) {
                        rds.push(menu.resourceIds[i]);
                    }
                    formSelects.value('resourceIds', rds);
                }
                crown.fromVal('menu-form', menu);
                iconPicker.checkIcon('iconPicker', menu.icon);
            } else {
                iconPicker.checkIcon('iconPicker', 'layui-icon-rate-half');
            }
        });

        layer.open({
            title: data ? '修改' : '添加',
            type: 1,
            area: '450px',
            offset: '120px',
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

    /***   子页面   ***/
    var form = layui.form;
    form.on('submit(formSubmit)', function (data) {
        layer.load(2);
        if (data.field.id) {
            lichee.put('/menu/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/menu', {data: data.field}, function (res) {
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
        if (res.status == 200) {
            layer.msg("修改成功",{icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
        } else if(res.status == 201)  {
            layer.msg("添加成功",{icon: 1});
            tableInfo.reload({where: lichee.getSearchForm()});
        }
    };

});
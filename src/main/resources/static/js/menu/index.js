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
    var renderTable = function () {
        treetable.render({
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
            url: '/menu/list',
            title: '菜单数据表',
            headers: {Authorization: config.getToken()},
            cols: [[
                {field: 'id', align: 'center', sort: true, width: 60, title: 'ID'},
                {field: 'menuName', align: 'left', sort: true, title: '菜单名称'},
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
                            return '<span class="layui-badge layui-bg-red">目录</span>';
                        } else if (d.menuType === 2) {
                            return '<span class="layui-badge layui-bg-green">菜单</span>';
                        } else if (d.menuType === 3) {
                            return '<span class="layui-badge layui-bg-blue">按钮</span>';
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
    };
    renderTable();

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
                lichee.delete('/menu/' + obj.data.id, {}, function () {
                    layer.closeAll('loading');
                    layer.msg('删除成功', {icon: 1});
                    renderTable();
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
        layer.open({
            title: data ? '修改' : '添加',
            type: 1,
            area: '800px',
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                if (data) {
                    form.val('formFilter', data);
                }

                var menu = lichee.getTempData('t_menu');
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
                            //$("#pathDiv").hide();
                            //$("#routerDiv").hide();
                            $("#pathRouterDiv").hide();
                        } else if (menu.menuType == 2) {
                            $("#resourceIdsDiv").show();
                            //$("#pathDiv").show();
                            //$("#routerDiv").show();
                            $("#resourceIdsDiv").show();
                            $("#pathRouterDiv").show();
                        } else if (menu.menuType == 3) {
                            $("#resourceIdsDiv").show();
                            //$("#pathDiv").hide();
                            //$("#routerDiv").hide();
                            $("#pathRouterDiv").hide();
                        }
                        if (menu.resourceIds) {
                            var rds = new Array();
                            for (var i = 0; i < menu.resourceIds.length; i++) {
                                rds.push(menu.resourceIds[i]);
                            }
                            formSelects.value('resourceIds', rds);
                        }
                        lichee.fromVal('formFilter', menu);
                        iconPicker.checkIcon('iconPicker', menu.icon);
                    } else {
                        iconPicker.checkIcon('iconPicker', 'layui-icon-rate-half');
                    }
                });

                iconPicker.render({
                    // 选择器，推荐使用input
                    elem: '#iconPicker',
                    // 数据类型：fontClass/unicode，推荐使用fontClass
                    type: 'fontClass',
                    // 是否开启搜索：true/false
                    search: true,
                    // 是否开启分页
                    page: true,
                    // 每页显示数量，默认12
                    limit: 12,
                    // 点击回调
                    click: function (data) {
                        $("#iconPicker").val(data.icon);
                    }
                });

                $('#form .close').click(function () {
                    layer.closeAll('page');
                });
            }
        });
    };

    /***   子页面   ***/
    var form = layui.form;

    // 表单提交事件
    form.on('select(menuType)', function (data) {
        if (data.value == 1) {
            $("#resourceIdsDiv").hide();
            // $("#pathDiv").hide();
            // $("#routerDiv").hide();
            $("#pathRouterDiv").hide();
        } else if (data.value == 2) {
            $("#resourceIdsDiv").show();
            // $("#pathDiv").show();
            // $("#routerDiv").show();
            $("#pathRouterDiv").show();
        } else if (data.value == 3) {
            $("#resourceIdsDiv").show();
            // $("#pathDiv").hide();
            // $("#routerDiv").hide();
            $("#pathRouterDiv").hide();
        }
    });

    // form.on('submit(formSubmit)', function (data) {
    //     layer.load(2);
    //     if (data.field.id) {
    //         lichee.put('/menu/' + data.field.id, {data: data.field}, function (res) {
    //             callFunction(res);
    //         });
    //     } else {
    //         lichee.post('/menu', {data: data.field}, function (res) {
    //             callFunction(res);
    //         });
    //     }
    //     return false;
    // });

    // 表单提交事件
    form.on('submit(formSubmit)', function (data) {
        //定义一数组
        var resourceIds = new Array();
        if (data.field.resourceIds) {
            resourceIds = data.field.resourceIds.split(",");
        }
        data.field.resourceIds = resourceIds;
        layer.load(2);
        if (data.field.id) {
            lichee.put('/menu/' + data.field.id, {data: data.field}, function (res) {
                // layer.closeAll('loading');
                // layer.msg('修改成功', {icon: 1});
                // crown.finishPopupCenter();
                callFunction(res);
            });
        } else {
            lichee.post('/menu', {data: data.field}, function (res) {
                // layer.closeAll('loading');
                // layer.msg('添加成功', {icon: 1});
                // crown.finishPopupCenter();
                callFunction(res);
            });
        }
        return false;
    });

    var callFunction = function (res) {
        layer.closeAll();
        if (res.status == 200) {
            layer.msg("修改成功",{icon: 1});
            renderTable();
        } else if(res.status == 201)  {
            layer.msg("添加成功",{icon: 1});
            renderTable();
        }
    };



});
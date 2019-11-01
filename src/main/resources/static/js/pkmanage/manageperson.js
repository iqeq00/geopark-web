//公园概况

layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'laydate','imageUpload'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var laydate = layui.laydate;
    var imageUpload = layui.imageUpload;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        //width:'auto',
        url: '/manageperson/page',
        title: '管理人员',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            //{type: 'checkbox', fixed: 'left'},
            // {field: 'id', title: 'ID'},
            {field: 'name', align: 'center', sort: true, title: '姓名'},
            {field: 'sex', align: 'center', sort: true, title: '性别'},
            {field: 'nation', align: 'center', sort: true, title: '民族'},
            {field: 'birth', align: 'center', sort: true, title: '出生年月'},
            {field: 'college', align: 'center', sort: true, title: '毕业院校'},
            {field: 'subject', align: 'center', sort: true, title: '专业'},
            {field: 'degree', align: 'center', sort: true, title: '学历学位'},
            {field: 'position', align: 'center', sort: true, title: '职务职称'},
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
                lichee.delete('/manageperson/' + obj.data.id, {}, function () {
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
            area: ['800px', '600px'],
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                lichee.get('/managementagency/list', {async: false}, function (data) {
                    $('#managementId').vm({managementagencys: data.result});
                    form.render('select');
                });
                imageUpload.init("uploadBtn", "img", "geolandscape");
                if (data) {
                    form.val('formFilter', data);
                    imageUpload.initImageList(data.img);
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
            lichee.put('/manageperson/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/manageperson', {data: data.field}, function (res) {
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
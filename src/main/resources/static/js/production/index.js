layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'imageUpload', 'layedit'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var imageUpload = layui.imageUpload;
    var layedit = layui.layedit

    var content;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/production/page',
        title: '产品推介信息数据表',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            {field: 'promotionname', align: 'center', sort: true, title: '推介会名称'},
            {field: 'position', align: 'center', sort: true, title: '地点'},
            {field: 'time', align: 'center', sort: true, title: '时间'},
            {field: 'representative', align: 'center', sort: true, title: '参加代表'},
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
                layer.load(2);
                lichee.delete('/production/' + obj.data.id, {}, function () {
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
            title: data ? '修改' : '添加',
            type: 1,
            area: '800px',
            offset: '120px',
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                lichee.get('/park/list', {async: false}, function (data) {
                    $('#parkId').vm({parks: data.result});
                    form.render('select');
                });
                imageUpload.init("uploadBtn", "img", "production");
                if (data) {
                    form.val('formFilter', data);
                    imageUpload.initImageList(data.img);
                }
                editCpt();
                $('#form .close').click(function () {
                    layer.closeAll('page');
                });
            }
        });
    };

    var form = layui.form;
    form.on('submit(formSubmit)', function (data) {
        layer.load(2);
        data.field.promotioncontent = layedit.getContent(content);
        if (data.field.id) {
            lichee.put('/production/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/production', {data: data.field}, function (res) {
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

    var load = function() {
        lichee.get('/park/list', {}, function (data) {
            $('#parkIdSearch').vm({parkIds: data.result});
            form.render('select');
        });
    };
    load();

    var editCpt = function () {
        layedit.set({
            uploadImage: {
                url: '/upload/img',
                type: 'post',
                headers: {Authorization:config.getToken()},
                data: {keyPath : "production"},
                dataType:'json',
                success: function(data){
                    layer.msg('上传成功');
                }
            }
        });
        content = layedit.build('promotioncontent');
    }

});
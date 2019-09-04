layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'upload'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var upload = layui.upload;

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
            area: '450px',
            offset: '120px',
            content: $('#form-model').html(),
            success: function () {
                $('#form')[0].reset();
                lichee.get('/park/list', {async: false}, function (data) {
                    $('#parkId').vm({parks: data.result});
                    form.render('select');
                });
                uploadImg();
                if (data) {
                    form.val('formFilter', data);
                    if(data.img){
                        var imgArray = data.img.split(",");
                        $.each()
                        $(imgArray).each(function(index,element){
                            $('#imgDiv').append('<img src="'+ element +'" alt="'+ element +'" width="100" class="layui-upload-img">')
                        });
                    }
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

    var uploadImg = function (){
        upload.render({
            elem: '#imgBtn',
            url: '/upload/img',
            headers: {Authorization:config.getToken()},
            data: {keyPath : "production"},
            multiple: true,
            number : 2,
            before: function(obj){
                //预读本地文件示例，不支持ie8
                obj.preview(function(index, file, result){
                    $('#imgDiv').append('<img src="'+ result +'" alt="'+ file.name +'" width="100" class="layui-upload-img">')
                });
            },
            done: function(res){
                if(res.status = 200){
                    $('#img').val($('#img').val() + res.result.name + ",");
                    console.log($('#img').val());
                    return layer.msg('上传成功');
                } else {
                    return layer.msg('上传失败');
                }
            }
        });
    };

});
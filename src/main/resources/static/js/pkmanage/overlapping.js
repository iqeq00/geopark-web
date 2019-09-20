//公园概况

layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'laydate','layedit'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var laydate = layui.laydate;
    var layedit = layui.layedit;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        //width:'auto',
        url: '/overlapping/page',
        title: '与其他景区重叠情况',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            //{type: 'checkbox', fixed: 'left'},
            // {field: 'id', title: 'ID'},
            {field: 'parkId', align: 'center', sort: true, title: '地质公园ID'},
            {field: 'othername', align: 'center', sort: true, title: '其他景区名称'},
            {field: 'othertype', align: 'center', sort: true, title: '景区类型'},
            {field: 'othersupervisor', align: 'center', sort: true, title: '主管部门'},
            //{field: 'othermatter', align: 'center', sort: true, title: '开发建设情况'},
            {field: 'overposition', align: 'center', sort: true, title: '重叠区域位置'},
            {field: 'overarea', align: 'center', sort: true, title: '重叠区域面积'},
            //{field: 'overinstruction', align: 'center', sort: true, title: '管理情况'},
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
                lichee.delete('/overlapping/' + obj.data.id, {}, function () {
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
            area: ['800px,700px'],
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
        if (data.field.id) {
            lichee.put('/overlapping/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/overlapping', {data: data.field}, function (res) {
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
        content = layedit.build('othermatter');
    }

});
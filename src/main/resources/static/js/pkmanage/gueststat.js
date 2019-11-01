layui.use(['config', 'lichee', 'jquery', 'layer', 'table', 'form', 'element'], function () {

    var config = layui.config;
    var lichee = layui.lichee;
    var $ = layui.jquery;
    var layer = layui.layer;
    var table = layui.table;
    var form = layui.form;
    var element = layui.element;

    var tableInfo = table.render({
        elem: '#table',
        toolbar: '#toolbar',
        defaultToolbar: [],
        url: '/gueststat/page',
        title: '游客统计',
        page: true,
        headers: {Authorization: config.getToken()},
        request: config.request,
        parseData: config.parseData,
        response: config.response,
        cols: [[
            {field: 'parkId', align: 'center', sort: true, title: '地质公园ID'},
            {field: 'touristssource', align: 'center', sort: true, title: '游客来源'},
            {field: 'touristsnumber', align: 'center', sort: true, title: '游客人数'},
            {field: 'time', align: 'center', sort: true, title: '时间'},
            {fixed: 'right',align : 'center', title: '操作', toolbar: '#bar', width: 180}
        ]]
    });

    table.on('toolbar(tableFilter)', function (obj) {
        var checkStatus = table.checkStatus(obj.config.id);
        switch (obj.event) {
            case 'add':
                showEditModel();
                break;
            case 'report':
                showReportModel();
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
                lichee.delete('/gueststat/' + obj.data.id, {}, function () {
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
            lichee.put('/gueststat/' + data.field.id, {data: data.field}, function (res) {
                callFunction(res);
            });
        } else {
            lichee.post('/gueststat', {data: data.field}, function (res) {
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

    var showReportModel = function () {
        layer.open({
            title: '报表',
            type: 1,
            area: '800px',
            content: $('#report-model').html(),
            success: function () {
                lichee.get('/gueststat/list', {async: false}, function (json) {
                    element.on('tab(reportTab)', function(data){
                        if(data.index == 0){
                            reportLine(json);
                        } else if(data.index == 1){
                            reportBar(json);
                        }
                    });
                    reportLine(json);
                });
            }
        });
    };

    var reportLine = function(data) {
        var line = echarts.init(document.getElementById('reportLine'));
        var option = {
            title : {
                text: '游客访问数量',
                x:'center'
            },
            color: ['#3398DB'],
            xAxis: {
                type: 'category',
                data: getYears(data),
            },
            yAxis: {
                type: 'value'
            },
            series: [{
                data: getYearsData(data),
                type: 'line'
            }]
        };
        line.setOption(option);
    };

    var reportBar = function(data) {
        var bar = echarts.init(document.getElementById('reportBar'));
        var option = {
            title : {
                text: '游客访问数量',
                x:'center'
            },
            color: ['#3398DB'],
            tooltip : {
                trigger: 'axis',
                axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                    type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                }
            },
            grid: {
                left: '3%',
                right: '4%',
                bottom: '3%',
                containLabel: true
            },
            xAxis : [
                {
                    type : 'category',
                    data : getYears(data),
                    axisTick: {
                        alignWithLabel: true
                    }
                }
            ],
            yAxis : [
                {
                    type : 'value'
                }
            ],
            series : [
                {
                    name:'人数',
                    type:'bar',
                    barWidth: '60%',
                    data: getYearsData(data)
                }
            ]
        };
        bar.setOption(option);
    };

    // var reportPie = function(data) {
    //     var pie = echarts.init(document.getElementById('reportPie'));
    //     var option = {
    //         title : {
    //             text: '游客访问数量',
    //             x:'center'
    //         },
    //         tooltip : {
    //             trigger: 'item',
    //             formatter: "{a} <br/>{b} : {c} ({d}%)"
    //         },
    //         legend: {
    //             type: 'scroll',
    //             orient: 'vertical',
    //             right: 10,
    //             top: 20,
    //             bottom: 20,
    //             data: getYears(data),
    //             selected: data.selected
    //         },
    //         series : [
    //             {
    //                 name: '姓名',
    //                 type: 'pie',
    //                 radius : '55%',
    //                 center: ['40%', '50%'],
    //                 data: getYearsData(data),
    //                 itemStyle: {
    //                     emphasis: {
    //                         shadowBlur: 10,
    //                         shadowOffsetX: 0,
    //                         shadowColor: 'rgba(0, 0, 0, 0.5)'
    //                     }
    //                 }
    //             }
    //         ]
    //     };
    //     pie.setOption(option);
    // };

    var getYears = function (data) {
        var years = new Array();
        $.each(data.result, function(i,item){
            years.push(item.time);
        });
        return years;
    }

    var getYearsData = function (data) {
        var yearsData = new Array();
        $.each(data.result, function(i,item){
            yearsData.push(parseInt(item.touristsnumber)*10000);
        });
        return yearsData;
    }

});
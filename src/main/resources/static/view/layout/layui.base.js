layui.config({
    base : '/plugins/layui/module/'
}).extend({
    conf : 'conf',
    lichee : 'lichee',
    index : 'index'
}).use(['conf', 'index', 'lichee'], function () {
    var conf = layui.conf;
    var index = layui.index;
    var lichee = layui.lichee;
    // 检查是否登录
    if (!conf.getToken() || conf.getToken() == '') {
        location.replace('/view/login/login.html');
        return;
    }
    // 获取当前用户信息
    index.getUser(function () {
        index.bindEvent();
    });
    // crown.get('/account/menus', {async: false}, function (data) {
    //     console.log(data);
    //     config.putMenus(data.result);
    // });

});
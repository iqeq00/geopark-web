layui.config({
    base : '/plugins/layui/module/'
}).extend({
    conf : 'conf',
    lichee : 'lichee',
    index : 'index'
}).use(['conf', 'index', 'lichee', 'element'], function () {
    var conf = layui.conf;
    var index = layui.index;
    var lichee = layui.lichee;
    var element = layui.element;
    // 检查是否登录
    if (!conf.getToken() || conf.getToken() == '') {
        location.replace('/view/login/login.html');
        return;
    }
    // 获取当前用户信息
    index.getUser(function (user) {
        $('.layui-header').vm(user);
        element.render('header');
        $('.layui-footer').vm();
        index.bindEvent();
    });
    lichee.get('/account/menus', {async: false}, function (data) {
        conf.putMenus(data.result);
        index.initLeftNav();
    });

});
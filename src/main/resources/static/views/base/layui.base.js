layui.config({
    base : '/plugins/layui/module/'
}).extend({
    formSelects: 'formSelects/formSelects-v4',
    iconPicker: 'iconPicker/iconPicker',
    treetable: 'treetable/treetable'
}).use(['config', 'index', 'lichee', 'imageUpload', 'fileUpload', 'element'], function () {
    var config = layui.config;
    var index = layui.index;
    var lichee = layui.lichee;
    var imageUpload = layui.imageUpload;
    var fileUpload = layui.fileUpload;
    var element = layui.element;
    // 检查是否登录
    if (!config.getToken() || config.getToken() == '') {
        location.replace('/views/login.html');
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
        config.putMenus(data.result);
        index.initLeftNav();
    });

});
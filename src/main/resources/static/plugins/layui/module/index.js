layui.define(['config', 'lichee', 'layer'], function (exports) {
    var $ = layui.$;
    var config = layui.config;
    var lichee = layui.lichee;
    var layer = layui.layer;

    var index = {
        // 渲染左侧导航栏
        initLeftNav: function () {
            var menus = config.getMenus();
            var data = {
                menus: config.getMenus()
            };
            $('.layui-side').vm({menus: config.getMenus()});
            lichee.activeNav();
        },
        // 从服务器获取登录用户的信息
        getUser: function (success) {
            lichee.get('/account/info', {}, function (data) {
                config.putUser(data.result);
                success(data.result);
            });
        },
        // 页面元素绑定事件监听
        bindEvent: function () {
            // 退出登录
            $('#logout').click(function () {
                layer.confirm('确定退出登录？', function (i) {
                    layer.close(i);
                    config.removeAll();
                    location.replace('/views/login.html');
                });
            });
            // // 主题设置
            // $('#setTheme').click(function () {
            //     lichee.popupRight('components/tpl/theme.html');
            // });
            // 修改密码
            $('#setPassword').click(function () {
                lichee.popupRight('/views/password.html');
            });
            // // 个人信息
            // $('#setInfo').click(function () {
            //     lichee.popupRight('components/tpl/userinfo.html');
            // });
            // // 消息
            // $('#btnMessage').click(function () {
            //     lichee.popupRight('components/tpl/message.html');
            // });
        }
    };

    exports('index', index);
});

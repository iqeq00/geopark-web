layui.define(['conf', 'lichee', 'layer'], function (exports) {
    var $ = layui.$;
    var conf = layui.conf;
    var lichee = layui.lichee;
    var layer = layui.layer;

    var index = {
        // 渲染左侧导航栏
        initLeftNav: function () {
            // var menus = conf.getMenus();
            // console.log({menus: conf.getMenus()});

            // var data = {
            //     menus: conf.getMenus()
            // };
            // console.log(JSON.stringify(data));
            $('.layui-side').vm({menus: conf.getMenus()});
            lichee.activeNav();
        },
        // // 路由注册
        // initRouter: function () {
        //     index.regRouter(config.getMenus());
        //     Q.init({
        //         index: 'user'
        //     });
        // },
        // // 使用递归循环注册
        // regRouter: function (menus) {
        //     $.each(menus, function (i, data) {
        //         if (data.router) {
        //             Q.reg(data.router, function () {
        //                 crown.loadView('components/' + data.path);
        //             });
        //         }
        //         if (data.childrens) {
        //             index.regRouter(data.childrens);
        //         }
        //     });
        // },
        // 从服务器获取登录用户的信息
        getUser: function (success) {
            lichee.get('/account/info', {}, function (data) {
                // console.log(data);
                conf.putUser(data.result);
                // $("#nickname").html(data.result.nickname);
                success(data.result);
            });
        },

        // 页面元素绑定事件监听
        bindEvent: function () {
            // 退出登录
            $('#logout').click(function () {
                layer.confirm('确定退出登录？', function (i) {
                    layer.close(i);
                    conf.removeAll();
                    location.replace('/view/login/login.html');
                });
            });
            // // 主题设置
            // $('#setTheme').click(function () {
            //     crown.popupRight('components/tpl/theme.html');
            // });
            // 修改密码
            // $('#setPassword').click(function () {
            //     crown.popupRight('components/tpl/password.html');
            // });
            // // 个人信息
            // $('#setInfo').click(function () {
            //     crown.popupRight('components/tpl/userinfo.html');
            // });
            // // 消息
            // $('#btnMessage').click(function () {
            //     crown.popupRight('components/tpl/message.html');
            // });
        }
    };

    exports('index', index);
});

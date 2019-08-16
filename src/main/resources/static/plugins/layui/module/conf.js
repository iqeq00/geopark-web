layui.define(function (exports) {

    var conf = {
        serverUrl: '', // 服务器地址
        scope: 'lichee',  // 作用域
        autoRender: false,  // 窗口大小改变后是否自动重新渲染表格，解决layui数据表格非响应式的问题
        request: {
            //页码的参数名称，默认：page
            pageName: 'cursor',
            //每页数据量的参数名，默认：limit
            limitName: 'limit'
        },
        parseData: function (res) { //res 即为原始返回的数据
            return {
                "code": res.status, //解析接口状态
                "msg": res.msg, //解析提示文本
                "count": res.result.total, //解析数据长度
                "data": res.result.records //解析数据列表
            };
        },
        response: {
            //规定成功的状态码，默认：0
            statusCode: 200
        },
        // 清空本地缓存
        removeAll: function () {
            layui.data(conf.scope, null);
        },
        // 获取缓存的token
        getToken: function () {
            var token = layui.data(conf.scope).token;
            if (token) {
                return JSON.parse(token);
            }
        },
        // 缓存token
        putToken: function (token) {
            layui.data(conf.scope, {
                key: 'token',
                value: JSON.stringify('Bearer ' + token)
            });
        },
        // 获取缓存的菜单
        getMenus: function () {
            var menus = layui.data(conf.scope).menus;
            if (menus) {
                return JSON.parse(menus);
            }
        },
        // 缓存菜单
        putMenus: function (menus) {
            layui.data(conf.scope, {
                key: 'menus',
                value: JSON.stringify(menus)
            });
        },
        // 获取缓存的权限按钮
        getPermButtons: function () {
            var permButtons = layui.data(conf.scope).permButtons;
            if (permButtons) {
                return JSON.parse(permButtons);
            }
        },
        // 缓存权限按钮
        putPermButtons: function (permButtons) {
            layui.data(conf.scope, {
                key: 'permButtons',
                value: JSON.stringify(permButtons)
            });
        },
        // 获取缓存的token
        getUid: function () {
            var uid = layui.data(conf.scope).uid;
            if (uid) {
                return JSON.parse(uid);
            }
        },
        // 缓存Uid
        putUid: function (uid) {
            layui.data(conf.scope, {
                key: 'uid',
                value: JSON.stringify(uid)
            });
        },
        // 当前登录的用户
        getUser: function () {
            var user = layui.data(conf.scope).user;
            if (user) {
                return JSON.parse(user);
            }
        },
        // 缓存user
        putUser: function (user) {
            layui.data(conf.scope, {
                key: 'user',
                value: JSON.stringify(user)
            });
        }
    };
    exports('conf', conf);
});

var codeflag = false;
layui.config({
    base : '/plugins/layui/module/'
}).use(['config', 'form'], function () {
    var $ = layui.jquery;
    var form = layui.form;
    var config = layui.config;

    var url = "/views/baseInfo-park.html";
    // if (config.getToken()) {
    //     location.replace(url);
    //     return;
    // }
    form.verify({
        loginName: function (value) {
            if (/^\s*$/g.test(value)) {
                return '请填写用户名';
            }
        },
        password: function (value) {
            if (/^\s*$/g.test(value)) {
                return '请填写密码';
            }
        }
    });
    // 表单提交
    form.on('submit(login-submit)', function (obj) {
        if (codeflag) {
            layer.load(2);
            $.ajax({
                url: config.serverUrl + '/account/token',
                data: JSON.stringify(obj.field),
                type: 'POST',
                contentType: 'application/json',
                success: function (data) {
                    console.log(data);
                    console.log(data.result);
                    config.putUid(data.result.uid);
                    config.putToken(data.result.token);
                    location.replace(url);
                },
                error: function (xhr) {
                    // console.log(xhr);
                    layer.msg(JSON.parse(xhr.responseText).msg, {icon: 5});
                    layer.closeAll('loading');
                }
            });
        } else {
            layer.msg('请滑动验证框', {icon: 5});
        }
    });

    jigsaw.init(document.getElementById('captcha'), function () {
        codeflag = true;
        layer.msg('验证成功', {time: 888});
    }, function () {
        codeflag = false;
        layer.msg('请继续验证', {time: 888});
    });
});
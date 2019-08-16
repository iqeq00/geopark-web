layui.use(['jquery'], function () {

    var $ = layui.jquery;
    $(".layui-nav-child dd a").each(function() {
        $(this).removeClass("layui-this");
        var lang = $(this).attr("lang");
        if (window.location.href.indexOf(lang)>0) {
            $(this).addClass("layui-this");
        }
    });
});
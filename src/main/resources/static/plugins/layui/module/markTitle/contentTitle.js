layui.define(['layer'], function(exports){
	var contentTitle = {
			navigation : function(nav){
				var d = '';
				if(nav.describes){
					d = '（<a><cite>'+nav.describes+'</cite></a>）';
				}
				var html ='<h3 class="layui-code-h3">'+
								'<span class="layui-breadcrumb" style="visibility: visible;">'+
								'<a href="'+baseUrl+'/admin/home">首页</a>' +
								'<span lay-separator="">/</span>'+
							  	'<a href="'+baseUrl+nav.url+'">'+nav.theme+'</a>'+
							  	'<span lay-separator="">/</span>'+
							  	'<a><cite>'+nav.title+'</cite></a>'+d+
							  	'</span>'+
						  	'</h3>';
				layui.$('#content-title').html(html);
			}
	};
	exports('contentTitle', contentTitle);
});
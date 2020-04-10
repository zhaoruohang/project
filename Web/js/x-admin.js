
layui.use(['element'], function() {
	$ = layui.jquery;
	element = layui.element;

	//导航的hover效果、二级菜单等功能，需要依赖element模块
	// larry-side-menu向左折叠
	if($(window).width() < 750) {
		trun = 0;
	} else {
		trun = 1;
	}

	$('.larry-side-menu').click(function() {
		if(trun) {
			$('.x-side').animate({
				left: '0px'
			}, 200).siblings('.x-main').animate({
				left: '200px'
			}, 200);
			trun = 0;
		} else {
			$('.x-side').animate({
				left: '-200px'
			}, 200).siblings('.x-main').animate({
				left: '0px'
			}, 200);
			trun = 1;
		}

	});

	//监听导航点击
	element.on('nav(side)', function(elem) {
		title = elem.find('cite').text();
		if(title == "") return;
		url = elem.attr('_href');
		if(url == undefined || url == null || url == "") return;

		for(var i = 0; i < $('.x-iframe').length; i++) {
			if($('.x-iframe').eq(i).attr('src') == url) {
				element.tabChange('x-tab', url);
				return;
			}
		};

		res = element.tabAdd('x-tab', {
			title: title //用于演示
				,
			content: '<iframe frameborder="0" src="' + url + '" class="x-iframe"></iframe>',
			id: url
		});
		element.tabChange('x-tab', url);

		$('.layui-tab-title li').eq(0).find('i').remove();
		
	});
getMenu();
	
function getMenu() {
		 var uid=sessionStorage.getItem('uid');
				  	
        	$.post("http://localhost:8080/maven_web/Getindexmoudles",{"uid":uid},function(r){
					$("#nav_ul").html("");
					$.each(r, function(n, value) {
								var s = "<li class='layui-nav-item'><a class='javascript:;' href = 'javascript:;'><i class='layui-icon' style='top:3px;'>&#xe614;</i><cite>"+value.title+"</cite> </a>";
								s += "<dl class='layui-nav-child'>";
								for(var i = 0; i < value.children.length; i++) {
									    s+="<dd>"
									    var cr = value.children[i];
									  //  var  aa=cr.children;
									    s += "<a href='javascript:;' _href='"+cr.href+"'><cite>"+cr.title+"</cite></a> ";
									 //   s += "<dl class='layui-nav-child'>";
//									    for(var k=0;k<aa.length;k++){
//									    	  s += "<dd><a href='javascript:;' _href='"+aa[k].href+"'><cite>"+aa[k].title+"</cite></a></dd>";
//									    }
									   // s+="</dl></dd>";
								}   
									s += "</dl></li>";
									$("#nav_ul").append($(s));
									});
									element.render("nav", "side");
									}, "json");
									}

/*getRoleNames();
	function getRoleNames(){
		 var uid=sessionStorage.getItem("uid");
   		  $.get("http://127.0.0.1:8080/maven_ssm/api/getRoleNames",{
   		  	"uid":uid
   		  },function(r){
   		  	  var roleName=r.message;
   		  	  window.sessionStorage.setItem("roleNames",roleName);
   		  },"json");
   	}*/
});
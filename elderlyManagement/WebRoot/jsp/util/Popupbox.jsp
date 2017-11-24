<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">  
<meta name="apple-mobile-web-app-status-bar-style" content="black">  
<meta content="telephone=no" name="format-detection">
<title>jQuery+CSS3动画弹出框代码</title>

<link rel="stylesheet" href="css/common.css"/>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript">
var w,h,className;
function getSrceenWH(){
	w = $(window).width();
	h = $(window).height();
	$('#dialogBg').width(w).height(h);
}

window.onresize = function(){  
	getSrceenWH();
}  
$(window).resize();  

$(function(){
	getSrceenWH();
	
	//显示弹框
	$('.box a').click(function(){
		className = $(this).attr('class');
		$('#dialogBg').fadeIn(300);
		$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
	});
	
	//关闭弹窗
	$('.claseDialogBtn').click(function(){
		$('#dialogBg').fadeOut(300,function(){
			$('#dialog').addClass('bounceOutUp').fadeOut();
		});
	});
});
</script>
</head>
<body>

<div id="wrapper">

	<header><h2>移动端之“CSS3多动画弹框”</h2></header>
	
	<div class="box">
		<div class="demo">
			<a href="javascript:;" class="bounceIn">DEMO1</a>
			<a href="javascript:;" class="rollIn">DEMO2</a>
			<a href="javascript:;" class="bounceInDown">DEMO3</a>
			<a href="javascript:;" class="flipInX">DEMO4</a>
		</div>
		
		<div id="dialogBg"></div>
		<div id="dialog" class="animated">
			<img class="dialogIco" width="50" height="50" src="images/ico.png" alt="" />
			<div class="dialogTop">
				<a href="javascript:;" class="claseDialogBtn">关闭</a>
			</div>
			<form action="" method="post" id="editForm">
				<ul class="editInfos">
					<li><label><font color="#ff0000">* </font>昵称：<input type="text" name="" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>手机：<input type="text" name="" required value="" class="ipt" /></label></li>
					<li><label><font color="#ff0000">* </font>地址：<input type="text" name="" required value="" class="ipt" /></label></li>
					<li><input type="submit" value="确认提交" class="submitBtn" /></li>
				</ul>
			</form>
		</div>
	</div>
	
</div>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
<p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
</div>
</body>
</html>
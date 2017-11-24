<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta content="telephone=no" name="format-detection">
<title></title>

<link rel="stylesheet" href="css/common.css" />

<script type="text/javascript" src="js/jquery.min.js"></script>

<style type="text/css">
#messageNotification {
	margin: 0 auto;
	display: none;
	background-color: red;
	position: fixed;
	top: 50%;
	left: 50%;
	margin: -120px 0 0 -150px;
	z-index: 10000;
	border: 1px solid #ccc;
	border-radius: 10px;
	-webkit-border-radius: 10px;
	box-shadow: 3px 2px 4px #ccc;
	-webkit-box-shadow: 3px 2px 4px #ccc;
	opacity: 0.6;
	filter: alpha(opacity = 60);
	text-align: center;
	padding-top: 20px;
}

#showMessage {
	color: white;
	font-size: 1.5em;
}
</style>
<script type="text/javascript">
	var w, h, className;
	function getSrceenWH() {
		w = $(window).width();
		h = $(window).height();
		$('#messageNotification').width(w / 4).height(h / 12);

	}

	window.onresize = function() {
		getSrceenWH();
	}
	$(window).resize();

	$(function() {

		
		
		
	});
</script>
</head>
<body>
	<div id="messageNotification">

		<span id="showMessage">操作成功</span>

	</div>

</body>
</html>
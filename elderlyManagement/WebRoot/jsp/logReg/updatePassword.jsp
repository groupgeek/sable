<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js"> <!--<![endif]-->
	<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>密码找回</title>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
	<meta name="keywords" content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />
	

  

  	<!-- Facebook and Twitter integration -->
	<meta property="og:title" content=""/>
	<meta property="og:image" content=""/>
	<meta property="og:url" content=""/>
	<meta property="og:site_name" content=""/>
	<meta property="og:description" content=""/>
	<meta name="twitter:title" content="" />
	<meta name="twitter:image" content="" />
	<meta name="twitter:url" content="" />
	<meta name="twitter:card" content="" />

	<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/logReg/favicon.ico">

	<link href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300' rel='stylesheet' type='text/css'>
	
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/animate.css">
	<link rel="stylesheet" href="css/style.css">

	<!-- Modernizr JS -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/modernizr-2.6.2.min.js"></script>
	<!-- FOR IE9 below -->
	<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

	</head>
	<body>
<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<div class="container">
			<div class="row">
				<div style="height: 100px;">
				
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-4">
					

					<!-- Start Sign In Form -->
					<form id="from1" action="#" class="fh5co-form animate-box" data-animate-effect="fadeIn">
						<h2>找回密码</h2>
						<!-- <div class="form-group">
							<div class="alert alert-success" role="alert">Your email has been sent.</div>
						</div> -->
						<div class="form-group">
							<label for="" class="sr-only">请输入新密嘛</label>
							<!-- <input type="email" class="form-control" id="email" placeholder="Email" autocomplete="off"> -->
							<input type="password" class="form-control" id="user-new-password" 
							minlength=6 maxlength=15
							placeholder="请输入新密码" autocomplete="off" required>
							<br/>
							<span id = "newPasswordError"></span>
						</div>
						<div class="form-group">
							<label for="" class="sr-only">请再次输入密码</label>
							<!-- <input type="email" class="form-control" id="email" placeholder="Email" autocomplete="off"> -->
							<input type="password" class="form-control" id="user-again-password"
							minlength=6 maxlength=15
							placeholder="请再次输入密码" autocomplete="off" required>
							<br/>
							<span id = "againPasswordError"></span>
						</div>
						<div class="form-group">
							<p><a href="${pageContext.request.contextPath }/jsp/logReg/login.jsp">登录</a> or <a href="${pageContext.request.contextPath }/logReg/sinup.action">注册</a></p>
						</div>
						<div class="form-group">
							<input type="button" value="确定" class="btn btn-primary" id="submit">
						</div>
					</form>
					<!-- END Sign In Form -->


				</div>
			</div>
			<div class="row" style="padding-top: 60px; clear: both;">
				<div class="col-md-12 text-center"><p><small>&copy; 孝和集团 <a href="#" target="_blank" title="孝和集团 ">孝和集团 </a> - Collect from <a href="#" title="孝和集团" target="_blank">孝和集团 </a></small></p></div>
			</div>
		</div>
	
	<!-- jQuery -->
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/main.js"></script>
	
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/updatePassword.js"></script>
	
	
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.1.8.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.messages_zh.js"></script>
	<script>
		$(document).ready(function() {
			$("#from1").validate();
		});
	</script>

	</body>
</html>


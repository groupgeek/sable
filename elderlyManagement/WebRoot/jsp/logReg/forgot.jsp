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
	<title>Minimal and Clean Sign up / Login and Forgot Form by FreeHTML5.co</title>
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
							<label for="email" class="sr-only">手机号码</label>
							<!-- <input type="email" class="form-control" id="email" placeholder="Email" autocomplete="off"> -->
							<input type="text" class="form-control" id="email" 
							minlength=11 maxlength=11 digits=true
							placeholder="请输入手机号码" autocomplete="off" required>
						</div>
						<div class="form-group">
							<p><a href="${pageContext.request.contextPath }/jsp/logReg/login.jsp">登录</a> or <a href="${pageContext.request.contextPath }/logReg/sinup.action">注册</a></p>
						</div>
						<div class="form-group">
							<input type="submit" value="发送" class="btn btn-primary">
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
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/main.js"></script>
	
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


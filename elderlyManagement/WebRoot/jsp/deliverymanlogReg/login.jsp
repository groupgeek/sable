<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>送货员登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />




<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />

<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
<link rel="shortcut icon"
	href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/css/style.css">


<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/modernizr-2.6.2.min.js"></script>


<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body>

	<div class="container">
		<div class="row">
			<div style="height: 50px;"></div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4">


				<!-- Start Sign In Form -->
				<form id="login"
					action="${pageContext.request.contextPath }/employee/login.action"
					class="fh5co-form animate-box" data-animate-effect="fadeIn">
					<center><h2>请用工号登录</h2></center>
					<div class="form-group">
						<label for="employeeid" class="sr-only">工号</label> <input
							type="text" class="form-control" id="employeeid" name="employeeid" digits=true 
							placeholder="工号" autocomplete="off" required>
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码</label> 
						<input type="password" class="form-control" id="password" minlength = 6 maxlength = 15
							   name="password" placeholder="密码" autocomplete="off" required>
					</div>
					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember">
							记住我</label>
					</div>
					<div class="form-group">
						<p>
							没有注册? <a
								href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/sign-up.jsp">注册</a>
							| <a
								href="${pageContext.request.contextPath }/jsp/deliverymanlogReg/forgot.jsp">忘记密码?</a>
						</p>
					</div>
					<div class="form-group">
						<center><input type="submit" value="登录" class="btn btn-primary"></center>
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center">
				<p>
					<small>&copy; 孝和集团 <a href="https://m.eqxiu.com/s/b0AYs6TZ?share_level=1&from_user=4f27606b-9184-4eb3-9b58-a6f2c9c599ec&from_id=1bb7b909-8105-4006-b335-3c0091e853aa&share_time=1507385885435&from=groupmessage" target="_blank"
						title="孝和集团 ">孝和集团 </a> - Collect from <a href="https://m.eqxiu.com/s/b0AYs6TZ?share_level=1&from_user=4f27606b-9184-4eb3-9b58-a6f2c9c599ec&from_id=1bb7b909-8105-4006-b335-3c0091e853aa&share_time=1507385885435&from=groupmessage" title="孝和集团"
						target="_blank">孝和集团 </a>
					</small>
				</p>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/main.js"></script>
	
<!-- 	<script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script> -->
	<script 
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/jquery.validate.1.8.1.min.js"></script>
		<script 
		src="${pageContext.request.contextPath }/jsp/deliverymanlogReg/js/jquery.validate.messages_zh.js"></script>
<!-- <script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script> -->
<script>

	$(document).ready(function() {
		$("#login").validate();
	});
</script>


</body>
</html>


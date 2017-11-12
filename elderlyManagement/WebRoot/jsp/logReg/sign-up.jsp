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
<title>用户注册</title>
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
	href="${pageContext.request.contextPath }/jsp/logReg/favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/style.css">

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath }/jsp/logReg/js/modernizr-2.6.2.min.js"></script>
<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	
	<style type="text/css">
		.select{
			height: 45px;
			width: 200px;
			border-color: #E6E6E6;
			font: #828282;
		}
	</style>

</head>
<body>

	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">


				<!-- Start Sign In Form -->
				<form id="register"
					action="${pageContext.request.contextPath }/logReg/register.action" method="post"
					class="fh5co-form animate-box" data-animate-effect="fadeIn">
					<h2>注册</h2>
					<!-- <div class="form-group">
							<div class="alert alert-success" role="alert">Your info has been saved.</div>
						</div> -->
					<div class="form-group">
						<label for="name" class="sr-only">姓名</label> <input type="text" onfocus="selectArea()"
							class="form-control" id="name" name="username" placeholder="姓名"
							minlength=2 autocomplete="off" required>
					</div>
					<div class="form-group">
						<label for="email" class="sr-only">手机号码</label>
						<!-- <input type="email" class="form-control" id="email" placeholder="Email" autocomplete="off"> -->
						<input type="text" class="form-control" id="email" name="phone"
							digits=true minlength=11 maxlength=11 placeholder="手机号码"
							autocomplete="off" required>
					</div>
					
					<div class="form-group">
						<label for="email" class="sr-only">选择地区</label>
						<!-- <input type="text" class="form-control" id="email" name="areaid"
							autocomplete="off" required> -->
							<div style="height: 10px;"></div>
							<select class="select" id = "selectArea" name="areaid">
								<option>请选择您所在地区</option>
								<c:forEach items="${allAreas }" var="allArea" varStatus="ststus">
									<option value = "${allArea.areaid }">${allArea.areaname }</option>
								</c:forEach>
								
							</select>
					</div>
					
					<div class="form-group">
						<label for="password" class="sr-only">密码</label> <input
							type="password" class="form-control" id="password" minlength=6
							maxlength=15 name="password" placeholder="密码" autocomplete="off"
							required>
					</div>
					<div class="form-group">
						<label for="re-password" class="sr-only">确认密码</label> <input
							type="password" class="form-control" id="re-password"
							equalTo="#password" minlength=6 maxlength=15 placeholder="确认密码"
							autocomplete="off" required>
					</div>
					<!-- <div class="form-group">
							<label for="remember"><input type="checkbox" id="remember"> è®°ä½æ</label>
						</div> -->
					<div class="form-group">
						<p>
							已经注册? <a
								href="${pageContext.request.contextPath }/jsp/logReg/login.jsp">登录</a>
						</p>
					</div>
					<div class="form-group">
						<input type="submit" value="注册" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center">
				<p>
					<small>&copy; 孝和集团 <a href="#" target="_blank"
						title="孝和集团 ">孝和集团 </a> - Collect from <a href="#" title="孝和集团"
						target="_blank">孝和集团 </a> </small>
				</p>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/main.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.1.8.1.min.js"></script>
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.messages_zh.js"></script>
	<script>
		$(document).ready(function() {
			$("#register").validate();
		});
	</script>
	
	
	
	

	<!-- 		<script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
	
	<script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script> -->

</body>
</html>


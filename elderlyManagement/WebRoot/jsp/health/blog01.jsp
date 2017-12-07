<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

<title>活动详情</title>

<!-- Bootstrap core CSS -->
<link
	href="${pageContext.request.contextPath }/jsp/health/assets/css/bootstrap.css"
	rel="stylesheet">


<!-- Custom styles for this template -->
<link
	href="${pageContext.request.contextPath }/jsp/health/assets/css/main.css"
	rel="stylesheet">

<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>

<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<!-- Static navbar -->
	<div class="navbar navbar-inverse navbar-static-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				          <a class="navbar-brand" href="${pageContext.request.contextPath }/branch/index">官网首页</a>
			</div>
			<div class="navbar-collapse collapse">
				<!-- <ul class="nav navbar-nav navbar-right">
					<li><a href="work.html">Work</a>
					</li>
					<li><a href="about.html">About</a>
					</li>
					<li><a href="blog.html">Blog</a>
					</li>
					<li><a href="contact.html">Contact</a>
					</li>
				</ul> -->
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>


	<!-- +++++ Post +++++ -->
	<div id="white">
		<div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2">
					<p>
						<img src="assets/img/user.png" width="50px" height="50px">
					<span id="show"></span> 
					
			<!-- /row -->
		</div>
		<!-- /container -->
	</div>
	<!-- /white -->




	<!-- +++++ Footer Section +++++ -->

	<div id="footer">
		<div class="container">
			<div class="row">
				<div class="col-lg-4">
					
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					
				</div>
				<!-- /col-lg-4 -->

			</div>

		</div>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script
		src="${pageContext.request.contextPath }/jsp/health/assets/js/bootstrap.min.js"></script>
		
		<script> 
var t=3;//设定跳转的时间 
setInterval("refer()",1000); //启动1秒定时 
function refer(){ 
if(t==0){ 
location="${pageContext.request.contextPath }/health/activity.action}"; //#设定跳转 
	$("#show").attr("type","hidden");
	
	
} 
document.getElementById('show').innerHTML="报名成功"+""+t+"秒后跳转"; // 显示倒计时 
t--; // 计数器递减 
//本文转自： 
} 
</script> 
</body>
</html>

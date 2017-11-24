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

<title>STANLEY - Free Bootstrap Theme</title>

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
				<a class="navbar-brand" href="index.html">STANLEY</a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="work.html">Work</a>
					</li>
					<li><a href="about.html">About</a>
					</li>
					<li><a href="blog.html">Blog</a>
					</li>
					<li><a href="contact.html">Contact</a>
					</li>
				</ul>
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
					
					<h4>活动介绍</h4>
					<hr>
				<form action="${pageContext.request.contextPath }/health/insertacrivityreg.action">
					<div
						style="height: 40px;width: 100%;border:1px solid #000;background-color: rgb(26,188,156);">
						<p
							style="font-size: 20px;padding-top: 5px;padding-left: 20px;color: #ffffff">活动视频
						</p>
					</div>
					<video width="100%" height="240" controls autoplay> <source
						src="/upload/${ac.video }" type="video/ogg"> <source
						src="/upload/${ac.video }" type="video/mp4"> <source
						src="/upload/${ac.video }" type="video/webm"> <object
						data="/upload/${ac.video }" width="320" height="240">
						<embed width="100%" height="240" src="/upload/${ac.video }">
					</object></video>
					<br />
					<div style="height: 10px;width: 100%"></div>
					<div
						style="height: 40px;width: 100%;border:1px solid #000;background-color: rgb(26,188,156);">
						<p
							style="font-size: 20px;padding-top: 5px;padding-left: 20px;color: #ffffff">图片及介绍
						</p>
					</div>
					<div>

						<div style="min-height: 300px;">
							<img class="img-responsive" src="/upload/${ac.activitypicture }"
								alt="" style="width:370px;height:275px; float:left;"/>
							${ac.activitydetails}
								
							 <input name="activityid" type="hidden" >
						</div>
					</div>
					<!-- <p><bt>TAGS: <a href="#">Wordpress</a> - <a href="#">Web Design</a></bt></p> -->
					<hr>
				<p><a href="${pageContext.request.contextPath }/health/insertacrivityreg.action?">报名</a></p>
					</form>
			

			</div>
			
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
					<h4>My Bunker</h4>
					<p>
						Some Address 987,<br /> +34 9054 5455, <br /> Madrid, Spain.
					</p>
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<h4>My Links</h4>
					<p>
						<a href="#">Dribbble</a><br /> <a href="#">Twitter</a><br /> <a
							href="#">Facebook</a>
					</p>
				</div>
				<!-- /col-lg-4 -->

				<div class="col-lg-4">
					<h4>About Stanley</h4>
					<p>This cute theme was created to showcase your work in a
						simple way. Use it wisely.</p>
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
</body>
</html>

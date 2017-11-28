<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>head</title>
</head>
<body>
<input type = "hidden" id = "root" value = "${pageContext.request.contextPath }">
<c:import url="/jsp/util/animeMove.jsp"></c:import>
<nav id="top">
		<div class="container">
			<div class="row">
				<div class="col-xs-6">
					<ul class="">
						<li><a href="${pageContext.request.contextPath }/branch/index"> 官网首页</a></li>
					</ul>
				</div>
				<div class="col-xs-6">
					<ul class="top-link">
						<li><a href="${pageContext.request.contextPath }/user/oneUser"><span class="glyphicon glyphicon-user"></span> 个人中心</a></li>
						<li><a href="${pageContext.request.contextPath }/user/logout"><span class="glyphicon glyphicon-envelope"></span> 安全退出</a></li>
					</ul>
				</div>
			</div>
		</div>
	</nav>
	<!--Header-->
	<header class="container">
		<div class="row">
			<div class="col-md-4">
				<div id="logo"><img src="${pageContext.request.contextPath }/jsp/edu/images/logo.png" /></div>
			</div>
			<div class="col-md-4">
				<!-- <form class="form-search">  
					<input type="text" class="input-medium search-query">  
					<button type="submit" class="btn"><span class="glyphicon glyphicon-search"></span></button>  
				</form> -->
			</div>
			<div class="col-md-4">
				<div id="cart"><a class="btn btn-1" href="${pageContext.request.contextPath }/jsp/edu/myActivities.jsp"><!-- <span class="glyphicon glyphicon-shopping-cart"> </span>-->我的课程</a></div>
			</div>
		</div>
	</header>
	<!--Navigation-->
    <nav id="menu" class="navbar">
		<div class="container">
			<div class="navbar-header"><span id="heading" class="visible-xs">0.0</span>
			  <button type="button" class="btn btn-navbar navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse"><i class="fa fa-bars"></i></button>
			</div>
			<div class="collapse navbar-collapse navbar-ex1-collapse">
				<ul class="nav navbar-nav" id = "navData">
					<li><a href="${pageContext.request.contextPath }/jsp/edu/index.jsp">主页</a></li>
					
					
					
				</ul>
			</div>
		</div>
	</nav>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/edu/js/head.js"></script>
</body>
</html>
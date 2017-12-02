<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
  <head>
    <!-- start: Meta -->
	<meta charset="utf-8">
	<title>Ceo管理员系统</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="${pageContext.request.contextPath }/jsp/ceo/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/jsp/ceo/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="${pageContext.request.contextPath }/jsp/ceo/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="${pageContext.request.contextPath }/jsp/ceo/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/ceo/img/favicon.ico">
	<!-- end: Favicon -->

  </head>
  
  <body>
    <!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="${pageContext.request.contextPath }/ceo/index.action"><span>管理员界面</span></a>
				<input id="root" type="hidden" value="${pageContext.request.contextPath }">				
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> <span class = "ceoAdmin">未登录</span>
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								
								<li><a href="${pageContext.request.contextPath }/ceo/logout"><i class="halflings-icon off"></i>注销</a></li>
							</ul>
						</li>
						
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
	<script type="text/javascript">
	var root = $("#root").attr("value");

	$.ajax({
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/ceo/getCeoAdmin",
				success:function(data){
					
					if(data == ""){
						window.location.href = root + "/jsp/AdminLogin/login.jsp";
					}
					$(".ceoAdmin").text(data.ceoaccountnumber);
				}
			});
		
	</script>
  </body>
</html>

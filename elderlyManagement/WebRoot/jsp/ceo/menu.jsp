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
    <!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="${pageContext.request.contextPath }/ceo/index.action"><i class="icon-bar-chart"></i><span class="hidden-tablet">	管理中心</span></a></li>	
						<li><a href="${pageContext.request.contextPath }/ceo/messages.action"><i class="icon-envelope"></i><span class="hidden-tablet"> 用户留言</span></a></li>
						<li>
							<a href="${pageContext.request.contextPath }/ceo/branch.action"><i class="icon-folder-close-alt"></i><span class="hidden-tablet"> 分店信息 </a>
						</li>
						<li><a href="${pageContext.request.contextPath }/ceo/gallery.action"><i class="icon-picture"></i><span class="hidden-tablet"> 活动信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/ceo/table.action"><i class="icon-align-justify"></i><span class="hidden-tablet"> 员工信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/ceo/usertable.action"><i class="icon-star"></i><span class="hidden-tablet"> 用户信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/ceo/producttable.action"><i class="icon-calendar"></i><span class="hidden-tablet"> 商品信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/ceo/allchart.action"><i class="icon-calendar"></i><span class="hidden-tablet"> 报表</span></a></li>
					</ul>
				</div>
			</div>
	<!-- end: Main Menu -->
  </body>
</html>

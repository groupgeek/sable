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
							<li><a href="${pageContext.request.contextPath }/productmanage/producttype.action"><i class="icon-comment"></i><span class="hidden-tablet"> 增加商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/stockout.action"><i class="icon-user"></i><span class="hidden-tablet">缺货商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/NoproductRecommend.action"><i class="icon-thumbs-up"></i><span class="hidden-tablet"> 推荐商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/quertyPopularProduct.action"><i class="icon-random"></i><span class="hidden-tablet">热销商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/recommendproduct.action"><i class="icon-briefcase"></i><span class="hidden-tablet">本店推荐</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/quertyProduct.action"><i class=" icon-shopping-cart"></i><span class="hidden-tablet">商品信息</span></a></li>						
					</ul>
				</div>
			</div>
	<!-- end: Main Menu -->
  </body>
</html>

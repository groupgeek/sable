<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html lang="en">
<head>
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link id="bootstrap-style" href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<link rel="shortcut icon" href="img/favicon.ico">
</head>

<body>
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="brand" href="index.html"><span>JANUX</span></a>
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> 龙腾云
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>账号设定</span>
								</li>
								<li><a href="###"><i class="halflings-icon user"></i>个人中心</a></li>
								<li><a href="login.html"><i class="halflings-icon off"></i>退出登陆</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
			</div>
		</div>
	</div>
	<!-- start: Header -->
	
		<div class="container-fluid-full">
		<div class="row-fluid">
				
			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li><a href="index.jsp"><i class="icon-home"></i><span class="hidden-tablet">管理中心</span></a></li>	
						<li><a href="messages.jsp"><i class="icon-comment"></i><span class="hidden-tablet"> 用户留言</span></a></li>
						<li><a href="table.jsp"><i class="icon-user"></i><span class="hidden-tablet">用户信息</span></a></li>
						<li><a href="form.jsp"><i class="icon-thumbs-up"></i><span class="hidden-tablet"> 客户关系</span></a></li>
						<li><a href="tasks.jsp"><i class="icon-random"></i><span class="hidden-tablet">回访信息</span></a></li>
						<li><a href="chart.jsp"><i class="icon-list-alt"></i><span class="hidden-tablet">报表</span></a></li></ul>
				</div>
			</div>
			<!-- end: Main Menu -->
			<!-- start: Content -->
			<div id="content" class="span10">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">Home</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">Tasks</a></li>
			</ul>

			
			<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>回访记录</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr><th>客户姓名</th>
								  <th>客户地址</th>
								  <th>上次回访时间</th>
								  <th>总回访次数</th>
								  <th>操作</th></tr>
						  </thead>   
						  <tbody>
							<tr>
								<td>Dennis Ji</td>
								<td class="center">2012/01/01</td>
								<td class="center">Member</td>
								<td class="center">
									<span class="label label-success">Active</span>
								</td>
								<td class="center">
									<a class="btn btn-success" href="#">
										<i class="halflings-icon white zoom-in"></i>  
									</a>
									<a class="btn btn-info" href="#">
										<i class="halflings-icon white edit"></i>  
									</a>
									<a class="btn btn-danger" href="#">
										<i class="halflings-icon white trash"></i> 
									</a>
								</td>
							</tr>
						  </tbody>
					  </table>            
					</div>
				</div>
       

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	
	<div class="clearfix"></div>
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2013 <a href="downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">JANUX Responsive Dashboard</a></span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.ui.touch-punch.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/modernizr.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.cookie.js"></script>
	
		<script src='${pageContext.request.contextPath }/js/fullcalendar.min.js'></script>
	
		<script src='${pageContext.request.contextPath }/js/jquery.dataTables.min.js'></script>

		<script src="${pageContext.request.contextPath }/js/excanvas.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.pie.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.stack.js"></script>
	<script src="${pageContext.request.contextPath }/js/jquery.flot.resize.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.chosen.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.uniform.min.js"></script>
		
		<script src="${pageContext.request.contextPath }/js/jquery.cleditor.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.noty.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.elfinder.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.raty.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.iphone.toggle.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.gritter.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.imagesloaded.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.masonry.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.knob.modified.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/jquery.sparkline.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/counter.js"></script>
	
		<script src="${pageContext.request.contextPath }/js/retina.js"></script>

		<script src="${pageContext.request.contextPath }/js/custom.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>

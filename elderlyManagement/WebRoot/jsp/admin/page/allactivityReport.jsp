<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>活动报表</title>
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<link id="bootstrap-style"
	href="${pageContext.request.contextPath }/jsp/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/jsp/admin/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link id="base-style"
	href="${pageContext.request.contextPath }/jsp/admin/css/style.css"
	rel="stylesheet">
<link id="base-style-responsive"
	href="${pageContext.request.contextPath }/jsp/admin/css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<!-- end: CSS -->


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- end: Favicon -->




</head>

<body>
	<!-- start: Header -->
	<c:import url="/jsp/admin/head.jsp"></c:import>

	<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<c:import url="/jsp/admin/menu.jsp"></c:import>

			<!-- start: Content -->
			<div id="content" class="span10">
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="${pageContext.request.contextPath }/jsp/admin/index.jsp">主页</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/jsp/admin/page/mallRebhcrt.jsp">总报表管理</a>
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/jsp/admin/page/allactivityReport.jsp">总活动报表管理</a>
				</li>
			</ul>
			
				<div class="row-fluid sortable">
					<div class="box span12">

						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>活动报表
							</h2>
							<!-- <h2>
								<span class="break"></span>活动数量<span id="activitySum"></span>
							</h2> -->
							<%-- <h2>
								<span class="break"></span><a href="${pageContext.request.contextPath }/jsp/admin/page/addActivity.jsp" style="color: white; text-decoration: none;">添加活动</a>
							</h2> --%>
							
							<div class="box-icon">
								<a href="${pageContext.request.contextPath }/jsp/admin/page/mallRebhcrt.jsp" ><i class="halflings-icon white remove"></i></a>
							</div>
						</div>
						<div class="box-content " id="box">
						<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
						<div style="width:100%;height:400px;margin-bottom: 100px;">
							<div id = "activitychart" style="padding:5px;width:69%;height:100%;float:left"></div>
							<div id="chart1" style="padding:5px;width:29%;height:100%;float:left;"></div>
						</div>
						<div style="width:100%;height:400px;">
							<div id = "activitychartLine" style="padding:5px;width:69%;height:100%;float:left;"></div>
							<div id="chart2" style="padding:5px;width:29%;height:100%;float:left;"></div>
						</div>  
					</div>
				</div>
			</div>
			<!--/span-->
		</div>

	</div>

	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
		</div>
	</div>

	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1"
		role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>

	<div class="clearfix"></div>
	<c:import url="/jsp/admin/footer.jsp"></c:import>

	<!-- start: JavaScript-->

<%-- 	<script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script> --%>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery-migrate-1.0.0.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery-ui-1.10.0.custom.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.ui.touch-punch.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/modernizr.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/bootstrap.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.cookie.js"></script>

	<script
		src='${pageContext.request.contextPath }/jsp/admin/js/fullcalendar.min.js'></script>

	<script
		src='${pageContext.request.contextPath }/jsp/admin/js/jquery.dataTables.min.js'></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/excanvas.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.pie.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.stack.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.resize.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.chosen.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.uniform.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.cleditor.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.noty.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.elfinder.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.raty.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.iphone.toggle.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.uploadify-3.1.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.gritter.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.imagesloaded.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.masonry.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.knob.modified.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.sparkline.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/counter.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/retina.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/custom.js"></script>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/admin/page/js/productReport.js"></script>
		
	<%-- <script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/js/echarts-gl.js"></script> --%>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/js/echarts.min.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/admin/page/js/allactivityReport.js"></script>
		
	<!-- end: JavaScript-->

</body>
</html>

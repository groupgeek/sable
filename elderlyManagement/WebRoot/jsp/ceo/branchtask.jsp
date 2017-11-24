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
  	<jsp:include page="header.jsp"></jsp:include>
  	<div class="container-fluid-full">
	<div class="row-fluid">
	<jsp:include page="menu.jsp"></jsp:include>
  	<!-- start: Content -->
			<div id="content" class="span10">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="${pageContext.request.contextPath }/ceo/index.action">管理员界面</a>
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/ceo/branch.action">分店信息</a>
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">${findBranch.branchname }详情</a></li>
			</ul>
			<div class="row-fluid">
				<div class="span3 statbox purple" onTablet="span6" onDesktop="span3">
					<div class="number">￥${arr[6] }${arr[7] }<i class="icon-arrow-up"></i></div>
					<div class="title"></div>
					<div class="footer">
						总收入
					</div>	
				</div>
				<div class="span3 statbox green" onTablet="span6" onDesktop="span3">
					<div class="number">￥${arr[4] }${arr[5] }<i class="icon-arrow-up"></i></div>
					<div class="title"></div>
					<div class="footer">
						商城收入
					</div>
				</div>
				<div class="span3 statbox blue noMargin" onTablet="span6" onDesktop="span3">
					<div class="number">￥${arr[0] }${arr[1] }<i class="icon-arrow-up"></i></div>
					<div class="title"></div>
					<div class="footer">
						健康收入
					</div>
				</div>
				<div class="span3 statbox yellow" onTablet="span6" onDesktop="span3">
					<div class="number">￥${arr[2] }${arr[3]}<i class="icon-arrow-up"></i></div>
					<div class="title"></div>
					<div class="footer">
						教育收入
					</div>
				</div>	
			</div>		

				<!-- 中间的报表 -->
				
			<%
			String id = request.getParameter("branchid");
			int a = Integer.valueOf(id);
			%>
			<input type="hidden" value="<%=a%>" id="branchid"> 
			<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
			<div id="hh" style="height:540px;width:100%;">
				<div id="branchChart" style="padding:5px;height:500px;width:99%;"></div>
			</div>
		
						
			<div class="row-fluid" >
				<div id="center" class="widget blue span5" style="padding:5px;width:40%;height:100%;float:left;">
					
					<h2><span class="glyphicons globe"><i></i></span> 销量前十产品</h2>
					<div id="branchHotproduct" style="height:350px;width:100%;"> </div>						
				</div>
				<div id="haha" style="padding-left: 20px;width:58%;height:400px;float:left;">
					<div id="branchuser" style="height:393px;width:100%;"></div>
				</div>		
			</div>
			
			<div class="row-fluid">	

				<a class="quick-button metro yellow span2">
					<i class="icon-group"></i>
					<p>总用户</p>
					<span class="badge">${ar[0] }</span>
				</a>
				<a class="quick-button metro red span2">
					<i class="icon-comments-alt"></i>
					<p>全部活动</p>
					<span class="badge">${ar[1] }</span>
				</a>
				<a class="quick-button metro blue span2">
					<i class="icon-shopping-cart"></i>
					<p>总订单</p>
					<span class="badge">${ar[2] }</span>
				</a>
				<a class="quick-button metro green span2">
					<i class="icon-barcode"></i>
					<p>所有商品</p>
					<span class="badge">${ar[3] }</span>
				</a>
				<a class="quick-button metro pink span2">
					<i class="icon-envelope"></i>
					<p>所有留言</p>
					<span class="badge">${ar[4] }</span>
				</a>
				<a class="quick-button metro black span2">
					<i class="icon-calendar"></i>
					<p>Calendar</p>
				</a>
				
				<div class="clearfix"></div>
								
			</div><!--/row-->
			
       

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">Ã</button>
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
			<span style="text-align:left;float:left">&copy; 2017 <a href="${pageContext.request.contextPath }/ceo/index.action" alt="Bootstrap_Metro_Dashboard">欢迎使用Ceo专用管理站点！</a></span>
		</p>

	</footer>
	<!-- start: JavaScript-->
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/js/echarts.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-1.9.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-migrate-1.0.0.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.ui.touch-punch.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/modernizr.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/bootstrap.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.cookie.js"></script>	
		<script src='${pageContext.request.contextPath }/jsp/ceo/js/fullcalendar.min.js'></script>	
		<script src='${pageContext.request.contextPath }/jsp/ceo/js/jquery.dataTables.min.js'></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/excanvas.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.pie.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.stack.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.resize.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.chosen.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.uniform.min.js"></script>		
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.cleditor.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.noty.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.elfinder.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.raty.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.iphone.toggle.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.uploadify-3.1.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.gritter.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.imagesloaded.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.masonry.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.knob.modified.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.sparkline.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/counter.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/retina.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/branchChart.js"></script>
	<!-- end: JavaScript-->
  </body>
</html>

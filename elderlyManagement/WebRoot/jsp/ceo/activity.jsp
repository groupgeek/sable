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
	<title>管理员界面</title>
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
	<link href="${pageContext.request.contextPath }/jsp/ceo/newcss/table.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/ceo/img/favicon.ico">
	<!-- end: Favicon -->

  </head>
  
  <body>
  	<jsp:include page="header.jsp"></jsp:include>
  	<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="${pageContext.request.contextPath }/ceo/index.action">管理员界面</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/ceo/gallery.action">活动中心</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li><a>活动详细信息</a></li>
			</ul>		
			<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="halflings-icon white align-justify"></i><span class="break"></span>活动详情</h2>
						<div class="box-icon">
							
							<a href="${pageContext.request.contextPath }/ceo/gallery.action" ><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<table class="table table-bordered table-striped table-condensed">
							  <thead>
								  <tr>
									  <th>活动属性</th>
									  <th>详细信息</th>                                        
								  </tr>
							  </thead>   
							  <tbody>
								<tr>
									<td>活动名称</td>
									<td class="center">${findCeoActivity.activityname }</td>								                                    
								</tr>
								<tr>
									<td>活动类型</td>
									<td class="center">${findCeoActivity.activitytypename }</td>									                                      
								</tr>
								<tr>
									<td>开设分店</td>
									<td class="center">${findCeoActivity.branchname }</td>                                        
								</tr>
								<tr>
									<td>是否线上</td>
									<td class="center">${findCeoActivity.stringline }</td>									                                        
								</tr>
								<tr>
									<td>活动状态</td>
									<td class="center">${findCeoActivity.activitystatus }</td>								                                        
								</tr>
								<tr>
									<td>活动细节</td>
									<td class="center">${findCeoActivity.activitydetails }</td>									                                       
								</tr>								 
								<tr>
									<td>活动日期</td>
									<td class="center">${findCeoActivity.stringDate }</td>                                        
								</tr>  
								<tr>
									<td>注册费</td>
									<td class="center">${findCeoActivity.registeryfee }</td>                                        
								</tr>
								<tr>
									<td>活动支出</td>
									<td class="center">${findCeoActivity.activityprice }</td>                                        
								</tr>                  
							  </tbody>
						 </table>  
						
					</div>
				</div><!--/span-->
			</div><!--/row-->
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
	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	
	<footer>

		<p>
			<span style="text-align:left;float:left">&copy; 2017 <a href="downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">欢迎使用Ceo专用管理站点！</a></span>
			<a>  使用者：${findCeoById.ceoid }</a>
		</p>

	</footer>
	<!-- start: JavaScript-->

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
	<!-- end: JavaScript-->
  </body>
</html>

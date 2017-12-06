<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>分店活动信息</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="${pageContext.request.contextPath }/jsp/brach/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/jsp/brach/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="${pageContext.request.contextPath }/jsp/brach/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="${pageContext.request.contextPath }/jsp/brach/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
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
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/brach/img/favicon.ico">
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
				<a class="brand" href="index.html"><span>XIAOHE-Admin</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> ${admins.employeename }
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>账号设定</span>
								</li>
								<li><a href="${pageContext.request.contextPath }/brach/vip.action"><i class="halflings-icon user"></i>个人中心</a></li>
								<li><a href="${pageContext.request.contextPath }/brach/logout.action"><i class="halflings-icon off"></i>退出登录</a></li>
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
						<li><a href="${pageContext.request.contextPath }/brach/index.action"><i class="icon-home"></i><span class="hidden-tablet">管理中心</span></a></li>	
						<li><a href="${pageContext.request.contextPath }/brach/fenyeMessage.action"><i class="icon-comment"></i><span class="hidden-tablet"> 用户留言</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/employees.action"><i class="icon-list-alt"></i><span class="hidden-tablet">员工管理</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/users.action"><i class="icon-user"></i><span class="hidden-tablet">用户信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/branchTran.action"><i class="icon-thumbs-up"></i><span class="hidden-tablet"> 客户关系</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/branchVist.action"><i class="icon-random"></i><span class="hidden-tablet">回访信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/allActs.action"><i class="icon-briefcase"></i><span class="hidden-tablet">活动信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/products.action"><i class=" icon-shopping-cart"></i><span class="hidden-tablet">商品信息</span></a></li>
						<li><a href="${pageContext.request.contextPath }/brach/charts.action"><i class="icon-list-alt"></i><span class="hidden-tablet">报表</span></a></li></ul>
				</div>
			</div>
			<!-- end: Main Menu -->
			
			<noscript>
				<div class="alert alert-block span10">
					<h4 class="alert-heading">Warning!</h4>
					<p>You need to have <a href="http://en.wikipedia.org/wiki/JavaScript" target="_blank">JavaScript</a> enabled to use this site.</p>
				</div>
			</noscript>
			
			<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">XIAOHE</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">活动信息</a></li>
			</ul>
			
			
							  
							  
			<div class="row-fluid sortable" style="margin-top: 30px">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>所有活动</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a> -->
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<div class="form-actions">
			<a class="btn btn-primary" href="${pageContext.request.contextPath }/brach/allActTypes.action"><i class=" icon-plus-sign"></i>  添加新的活动</a>
			</div><br><br>
						<table class="table table-striped table-bordered bootstrap-datatable datatable">
						  <thead>
							  <tr>
							  	<th>活动名字</th>
								  <th>活动状态</th>
								  <th>活动报名费</th>
								  <th>活动日期</th>
								  <th>详情</th>
							  </tr>
						  </thead>   
						  <tbody>
							<c:forEach items="${acts }" var="acts">
					<tr>
						<td class="center">${acts.activityname }</td>
						<td class="center">${acts.activitystatus }</td>
						<td class="center">${acts.registeryfee }</td>
						<td class="center"><fmt:formatDate value="${acts.activitydate }" pattern="yyyy-MM-dd" /></td>
						<td class="center">
									<a class="btn btn-info" href="${pageContext.request.contextPath }/brach/oneActCus.action?id=${ acts.activityid}">
										<i class="halflings-icon white edit"></i>                                            
									</a>
									<a class="btn btn-danger" href="${pageContext.request.contextPath }/brach/delAct.action?id=${ acts.activityid}">
										<i class="halflings-icon white trash"></i> 
									</a>
								</td>
					</tr>
				</c:forEach>
							
						  </tbody>
					  </table>            
					</div>
				</div><!--/span-->
			
			</div>
			
			
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>设置官网推荐活动</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a> -->
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
							 
							 <div class="control-group">
								<label class="control-label" for="selectError3" name="">推荐活动1</label>
								<input type="hidden" value="${allBranchActRec[0].activityid }" id = "activityidRec1">
								<div class="controls">
									<select id="selectError1" name="activity" >
									<c:if test="${allBranchActRec[0] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchActRec[0] !=null}">
										<option selected="true" name="activityid">${ allBranchActRec[0].activityname}</option>
									</c:if>
									
									<c:forEach items="${allActs }" var="allActs">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecAct1()">
										<i class="icon-ok-sign"></i>                                            
									</a></div>
							</div> 
							
							<div class="control-group">
								<label class="control-label" for="selectError3">推荐活动2</label>
								<input type="hidden" value="${allBranchActRec[1].activityid }" id = "activityidRec2">
								<div class="controls">
									
									<select id="selectError2" name="activity" >
									<c:if test="${allBranchActRec[1] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchActRec[1] !=null}">
										<option selected="true" name="activityid">${ allBranchActRec[1].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecAct2()">
										<i class="icon-ok-sign"></i>                                            
									</a> </div>
							</div> 
							      
							<div class="control-group">
								<label class="control-label" for="selectError3">推荐活动3</label>
								<input type="hidden" value="${allBranchActRec[2].activityid }" id = "activityidRec3">
								<div class="controls">
									<select id="selectError3" name="activity" >
									<c:if test="${allBranchActRec[2] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchActRec[2] !=null}">
										<option selected="true" name="activityid">${ allBranchActRec[2].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecAct3()">
										<i class="icon-ok-sign"></i>                                            
									</a> 
									
								</div>
							</div> 
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>设置分店官网健康推荐活动</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a> -->
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
							 
							 <div class="control-group">
								<label class="control-label" for="selectError4" name="">推荐活动1</label>
								<input type="hidden" value="${allBranchHealthRec[0].activityid }" id = "activityidRec4">
								<div class="controls">
									<select id="selectError4" name="activity" >
									<c:if test="${allBranchHealthRec[0] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchHealthRec[0] !=null}">
										<option selected="true" name="activityid">${ allBranchHealthRec[0].activityname}</option>
									</c:if>
									
									<c:forEach items="${allActs }" var="allActs">
									<c:if test="${allActs.fathertypeid == 1 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecHealth1()">
										<i class="icon-ok-sign"></i>                                            
									</a></div>
							</div> 
							
							<div class="control-group">
								<label class="control-label" for="selectError5">推荐活动2</label>
								<input type="hidden" value="${allBranchHealthRec[1].activityid }" id = "activityidRec5">
								<div class="controls">
									
									<select id="selectError5" name="activity" >
									<c:if test="${allBranchHealthRec[1] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchHealthRec[1] !=null}">
										<option selected="true" name="activityid">${ allBranchHealthRec[1].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<c:if test="${allActs.fathertypeid == 1 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecHealth2()">
										<i class="icon-ok-sign"></i>                                            
									</a> </div>
							</div> 
							      
							<div class="control-group">
								<label class="control-label" for="selectError6">推荐活动3</label>
								<input type="hidden" value="${allBranchHealthRec[2].activityid }" id = "activityidRec6">
								<div class="controls">
									<select id="selectError6" name="activity" >
									<c:if test="${allBranchHealthRec[2] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchHealthRec[2] !=null}">
										<option selected="true" name="activityid">${ allBranchHealthRec[2].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<c:if test="${allActs.fathertypeid == 1 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecHealth3()">
										<i class="icon-ok-sign"></i>                                            
									</a> 
									
								</div>
							</div> 
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div>
			
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>设置分店官网教育推荐活动</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a> -->
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
						  <fieldset>
							 
							 <div class="control-group">
								<label class="control-label" for="selectError7" name="">推荐活动1</label>
								<input type="hidden" value="${allBranchEduRec[0].activityid }" id = "activityidRec7">
								<div class="controls">
									<select id="selectError7" name="activity" >
									<c:if test="${allBranchEduRec[0] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchEduRec[0] !=null}">
										<option selected="true" name="activityid">${ allBranchEduRec[0].activityname}</option>
									</c:if>
									
									<c:forEach items="${allActs }" var="allActs">
										<c:if test="${allActs.fathertypeid == 2 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecEdu1()">
										<i class="icon-ok-sign"></i>                                            
									</a></div>
							</div> 
							
							<div class="control-group">
								<label class="control-label" for="selectError8">推荐活动2</label>
								<input type="hidden" value="${allBranchEduRec[1].activityid }" id = "activityidRec8">
								<div class="controls">
									
									<select id="selectError8" name="activity" >
									<c:if test="${allBranchEduRec[1] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchEduRec[1] !=null}">
										<option selected="true" name="activityid">${ allBranchEduRec[1].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<c:if test="${allActs.fathertypeid == 2 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecEdu2()">
										<i class="icon-ok-sign"></i>                                            
									</a> </div>
							</div> 
							      
							<div class="control-group">
								<label class="control-label" for="selectError9">推荐活动3</label>
								<input type="hidden" value="${allBranchEduRec[2].activityid }" id = "activityidRec9">
								<div class="controls">
									<select id="selectError9" name="activity" >
									<c:if test="${allBranchEduRec[2] ==null}">
									<option name="activityid" value=""> --请选择-- </option>
									</c:if>
									<c:if test="${allBranchEduRec[2] !=null}">
										<option selected="true" name="activityid">${ allBranchEduRec[2].activityname}</option>
									</c:if>
									<c:forEach items="${allActs }" var="allActs">
										<c:if test="${allActs.fathertypeid == 2 }">
										<option name="activityid"  value="${allActs.activityid }">${allActs.activityname} </option>
									</c:if>
									</c:forEach>
									</select>
									 <a class="btn btn-info" href="" onclick="insertRecEdu3()">
										<i class="icon-ok-sign"></i>                                            
									</a> 
									
								</div>
							</div> 
						  </fieldset>
						</form>   

					</div>
				</div><!--/span-->

			</div>
			
			
			
			
			
			
			
			<!--/row-->

			<!--/row-->
			
			<!--/row-->
			
			<!--/row-->
    

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
			<span style="text-align:left;float:left">&copy; 2013 <a href="${pageContext.request.contextPath }/jsp/index/index.jsp" alt="Bootstrap_Metro_Dashboard">欢迎光临XIAOHE</a></span>
			
		</p>

	</footer>
	
	<!-- start: JavaScript-->

		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery-1.9.1.min.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery-migrate-1.0.0.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery-ui-1.10.0.custom.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.ui.touch-punch.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/modernizr.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/bootstrap.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.cookie.js"></script>
	
		<script src='${pageContext.request.contextPath }/jsp/brach/js/fullcalendar.min.js'></script>
	
		<script src='${pageContext.request.contextPath }/jsp/brach/js/jquery.dataTables.min.js'></script>

		<script src="${pageContext.request.contextPath }/jsp/brach/js/excanvas.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.flot.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.flot.pie.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.flot.stack.js"></script>
	<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.flot.resize.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.chosen.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.uniform.min.js"></script>
		
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.cleditor.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.noty.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.elfinder.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.raty.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.iphone.toggle.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.uploadify-3.1.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.gritter.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.imagesloaded.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.masonry.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.knob.modified.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/jquery.sparkline.min.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/counter.js"></script>
	
		<script src="${pageContext.request.contextPath }/jsp/brach/js/retina.js"></script>

		<script src="${pageContext.request.contextPath }/jsp/brach/js/custom.js"></script>
	<!-- end: JavaScript-->
	
	<script type="text/javascript">
	function insertRecAct1(){
		var select1 = document.getElementById("selectError1");
		var value1 = select1.options[select1.selectedIndex].value;
		var values = document.getElementById("activityidRec1").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value1+'"'+','+'"activityidRec"'+':'+'"'+values+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecAct2(){
		var select2 = document.getElementById("selectError2");
		var value2 = select2.options[select2.selectedIndex].value;
		var value4 = document.getElementById("activityidRec2").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value2+'"'+','+'"activityidRec"'+':'+'"'+value4+'"}',
			success:function(data){
			alert("处理成功");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecAct3(){
		var select3 = document.getElementById("selectError3");
		var value3 = select3.options[select3.selectedIndex].value;
		var value5 = document.getElementById("activityidRec3").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value3+'"'+','+'"activityidRec"'+':'+'"'+value5+'"}',
			success:function(data){
			}
		});
	}
	</script>
	
	
	
	<script type="text/javascript">
	function insertRecHealth1(){
		var select4 = document.getElementById("selectError4");
		var value4 = select4.options[select4.selectedIndex].value;
		var values1 = document.getElementById("activityidRec4").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestHealthAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value4+'"'+','+'"activityidRec"'+':'+'"'+values1+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecHealth2(){
		var select5 = document.getElementById("selectError5");
		var value5 = select5.options[select5.selectedIndex].value;
		var values2 = document.getElementById("activityidRec5").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestHealthAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value5+'"'+','+'"activityidRec"'+':'+'"'+values2+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecHealth3(){
		var select6 = document.getElementById("selectError6");
		var value6 = select6.options[select6.selectedIndex].value;
		var values3 = document.getElementById("activityidRec6").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestHealthAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value6+'"'+','+'"activityidRec"'+':'+'"'+values3+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	
	<script type="text/javascript">
	function insertRecEdu1(){
		var select7 = document.getElementById("selectError7");
		var value7 = select7.options[select7.selectedIndex].value;
		var values7 = document.getElementById("activityidRec7").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestEduAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value7+'"'+','+'"activityidRec"'+':'+'"'+values7+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecEdu2(){
		var select8 = document.getElementById("selectError8");
		var value8 = select8.options[select8.selectedIndex].value;
		var values8 = document.getElementById("activityidRec8").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestEduAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value8+'"'+','+'"activityidRec"'+':'+'"'+values8+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
	
	<script type="text/javascript">
	function insertRecEdu3(){
		var select9 = document.getElementById("selectError9");
		var value9 = select9.options[select9.selectedIndex].value;
		var values9 = document.getElementById("activityidRec9").value;
		$.ajax({
			type:'post',
			url:'${pageContext.request.contextPath }/brach/RequestEduAct.action',
			contentType : 'application/json;charset=utf-8',
			data:'{"activityid"'+':'+'"'+value9+'"'+','+'"activityidRec"'+':'+'"'+values9+'"}',
			success:function(){
			},
			error:function(){
			alert("操作成功！刷新界面！");
			}
		});
	}
	</script>
</body>
</html>

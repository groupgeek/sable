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
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
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
						
						<!-- start: Notifications Dropdown -->
						
						<!-- end: Notifications Dropdown -->
						<!-- start: Message Dropdown -->
						
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i>${admins.employeename}
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>账号设定</span>
								</li>
								<li><a href="#"><i class="halflings-icon user"></i>个人中心</a></li>
								<li><a href="login.html"><i class="halflings-icon off"></i>退出登录</a></li>
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
				<li>
					<i class="icon-edit"></i>
					<a href="#">添加员工</a>
				</li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>添加新员工</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					
					
					
					
					
					
			<form class="form-horizontal" action="${pageContext.request.contextPath }/brach/insertActs.action" method="post" enctype="multipart/form-data">
				<fieldset>
					<div class="control-group">
							  <label class="control-label" for="typeahead">活动名字 </label>
							  <div class="controls">
								<input type="text" name="activityname" onkeyup="long()" class="span6 typeahead" id="typeahead">
							  </div>
					</div>
					
					<div class="control-group">
							  <label class="control-label" for="date01" class="span6 typeahead">活动日期</label>
							  <div class="controls">
								<input name="activitydate" onClick="laydate()"><br /><br />
								<!-- <input type="text" name="activitydate" class="input-xlarge datepicker" id="date01" value=""> -->
							  </div>
					</div>
					
					<div class="control-group">
							  <label class="control-label" for="fileInput">添加图片</label>
							  <div class="controls">
							  <input type="file" name="file">
							  </div>
					</div> 
					
					<div class="control-group">
							  <label class="control-label" for="fileInput">添加视频</label>
							  <div class="controls">
							  <input type="file" name="nice">
							  </div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="selectError3">活动状态</label>
								<div class="controls">
									<select id="selectError3" name="activitystatus">
										<option>已开展</option>
										<option>未开展</option>
										<option>进行中</option>
									</select>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="selectError3">活动类型</label>
								<div class="controls">
									<select id="selectError3" name="activitytypeid">
									<c:forEach items="${actTypes }" var="actTypes">
										<option value="${actTypes.activitytypeid }">${actTypes.activitytypename }</option>
									</c:forEach>
									</select>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="selectError3">线上线下</label>
								<div class="controls">
									<select id="selectError3" name="online">
										<option value="0">线上</option>
										<option value="1">线下</option>
									</select>
								</div>
					</div> 
					
					<div class="control-group">
								<label class="control-label" for="appendedPrependedInput">活动经费</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput" name="activityprice" size="16" type="text">
								  </div>
								</div>
					</div>
							
					<div class="control-group">
								<label class="control-label" for="appendedPrependedInput">活动报名费</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput" name="registeryfee" size="16" type="text">
								  </div>
								</div>
				    </div>
							
					<div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">活动描述</label>
							  <div class="controls">
								<textarea class="cleditor" id="textarea2" name="activitydetails" rows="3"></textarea>
							  </div>
					</div>
					
					<div class="form-actions">
							  <button type="submit" class="btn btn-primary">提交信息</button>
					</div>
					<!-- <div>
						<button type="submit">提交信息</button>
					</div> -->
					
				</fieldset>
			</form>
					
					
					
					
					
					
					
					
						<%-- <form class="form-horizontal" action="${pageContext.request.contextPath }/brach/insertActs.action" method="post" enctype="multipart/form-data">
						 <!--  <fieldset> -->
							<div class="control-group">
							  <label class="control-label" for="typeahead">活动名称 </label>
							  <div class="controls">
								<input type="text" name="activityname" class="span6 typeahead" id="typeahead"  data-provide="typeahead" data-items="4" data-source='["Alabama","Alaska","Arizona","Arkansas","California","Colorado","Connecticut","Delaware","Florida","Georgia","Hawaii","Idaho","Illinois","Indiana","Iowa","Kansas","Kentucky","Louisiana","Maine","Maryland","Massachusetts","Michigan","Minnesota","Mississippi","Missouri","Montana","Nebraska","Nevada","New Hampshire","New Jersey","New Mexico","New York","North Dakota","North Carolina","Ohio","Oklahoma","Oregon","Pennsylvania","Rhode Island","South Carolina","South Dakota","Tennessee","Texas","Utah","Vermont","Virginia","Washington","West Virginia","Wisconsin","Wyoming"]'>
								<!-- <p class="help-block">Start typing to activate auto complete!</p> -->
							  </div>
							</div>
							
							<div class="control-group">
							  <label class="control-label" for="date01" class="span6 typeahead">活动日期</label>
							  <div class="controls">
								<input name="activitydate" onClick="laydate()"><br /><br />
								<!-- <input type="text" name="activitydate" class="input-xlarge datepicker" id="date01" value=""> -->
							  </div>
							</div>

							<div class="control-group">
							  <label class="control-label" for="fileInput">插入视频</label>
							  <div class="controls">
								<input class="input-file uniform_on" name="video" id="fileInput" type="file">
							  </div>
							</div>  
							
							
							<div class="control-group">
							  <label class="control-label" for="fileInput">插入图片</label>
							  <div class="controls">
							  <input type="file" name="activitypicture">
								<!-- <input class="input-file uniform_on" name="activitypicture1" id="fileInput" type="file"> -->
							  </div>
							</div> 
							      
							<div class="control-group">
								<label class="control-label" for="selectError3">活动状态</label>
								<div class="controls">
									<select id="selectError3" name="activitystatus">
										<option>已开展</option>
										<option>未开展</option>
										<option>进行中</option>
									</select>
								</div>
							</div>  
							
							<div class="control-group">
								<label class="control-label" for="selectError3">活动类型</label>
								<div class="controls">
									<select id="selectError3" name="activitytypeid">
									<c:forEach items="${actTypes }" var="actTypes">
										<option value="${actTypes.activitytypeid }">${actTypes.activitytypename }</option>
									</c:forEach>
									</select>
								</div>
							</div> 
							
							<div class="control-group">
								<label class="control-label" for="selectError3">线上线下</label>
								<div class="controls">
									<select id="selectError3" name="online">
										<option value="0">线上</option>
										<option value="1">线下</option>
									</select>
								</div>
							</div> 
							
							<div class="control-group">
								<label class="control-label" for="appendedPrependedInput">活动经费</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput" name="activityprice" size="16" type="text">
								  </div>
								</div>
							  </div>
							
							<div class="control-group">
								<label class="control-label" for="appendedPrependedInput">活动报名费</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput" name="registeryfee" size="16" type="text">
								  </div>
								</div>
							  </div>
							
							<div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">活动描述</label>
							  <div class="controls">
								<textarea class="cleditor" id="textarea2" name="activitydetails" rows="3"></textarea>
							  </div>
							</div>
							<div class="form-actions">
							  <button type="submit" class="btn btn-primary">提交信息</button>
							</div>
						 <!--  </fieldset> -->
						</form>   --%>
						
						<%-- <form action="${pageContext.request.contextPath }/upload.action" method="post" enctype="multipart/form-data">
						 <input type="file" name="file" multiple>
						 <input type="submit" value="提交">
						</form>  --%>

					</div>
				</div><!--/span-->

			</div><!--/row-->

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
		
		<script src="${pageContext.request.contextPath }/jsp/brach/js/laydate.js"></script>
		
		<script src="${pageContext.request.contextPath }/jsp/brach/js/yanzhen/haha.js"></script>
		
	<!-- end: JavaScript-->
	
</body>
</html>

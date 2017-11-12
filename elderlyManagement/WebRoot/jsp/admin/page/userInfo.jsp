<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>用戶详情</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
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
					<a href="${pageContext.request.contextPath }/jsp/admin/page/user.jsp">客户管理</a>
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">客户详情</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>用户详细信息</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a> -->
							<a href="" id = "userUrl"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal">
							<fieldset>
							 <div class="control-group" id = "avatar">
								<label class="control-label">头像</label>
								<div class="controls">
									<img  id = "" src="" style="width: 100px;">
								</div>
							  </div>
							  <div class="control-group" id = "username">
								<label class="control-label">姓名</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "sex">
								<label class="control-label">性别</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "phone">
								<label class="control-label">手机号(账号)</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "password">
								<label class="control-label">密码</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							   <div class="control-group" id = "registrationdate">
								<label class="control-label">注册日期</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "address">
								<label class="control-label">地址</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "status">
								<label class="control-label">账号状态</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "integral">
								<label class="control-label">积分</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							    <div class="control-group" id = "email">
								<label class="control-label">邮箱</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "birthday">
								<label class="control-label">生日</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "bankcardno">
								<label class="control-label">银行卡号</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "healthstatus">
								<label class="control-label">健康状态</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "authoritylevel">
								<label class="control-label">权限</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "level">
								<label class="control-label">等级</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  <div class="control-group" id = "areaname">
								<label class="control-label">地区</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							   <div class="control-group" id = "areaaddress">
								<label class="control-label">地区地址</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							   <!-- <div class="control-group" id = "online">
								<label class="control-label">是否在线</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
								</div> -->
							   <div class="control-group" id = "branchname">
								<label class="control-label">所在分店</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							   <div class="control-group" id = "manager">
								<label class="control-label">分店管理员</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
							  </div>
							  
							  <div class="control-group" id = "nowmedicalrecords">
								<label class="control-label">病例</label>
								<div class="controls">
									<textarea rows="4" style="width: 500px; background-color: #FCFCFC;"></textarea>
								</div>
							  </div>
							  <div class="control-group" id = "beforemedicalrecords">
								<label class="control-label">病例</label>
								<div class="controls">
									<textarea rows="4" style="width: 500px; background-color: #FCFCFC;"></textarea>
								</div>
							  </div>
							  <div class="control-group" id = "personalrecords">
								<label class="control-label">病例</label>
								<div class="controls">
									<textarea rows="4" style="width: 500px; background-color: #FCFCFC;"></textarea>
								</div>
							  </div>
							  <div class="control-group" id = "familyrecords">
								<label class="control-label">病例</label>
								<div class="controls">
									<textarea rows="4" style="width: 500px; background-color: #FCFCFC;"></textarea>
								</div>
							  </div>
							  
							  
							  
							  
							  
							  
							  
							  <!-- <div class="form-actions">
								<button type="submit" class="btn btn-primary">Save changes</button>
								<button class="btn">Cancel</button>
							  </div> -->
							</fieldset>
						  </form>
					
					</div>
				</div>
			</div>
				
				
				
				
				
				
			</div>
			</div>

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
	<c:import url="/jsp/admin/footer.jsp"></c:import>
	
	<!-- start: JavaScript-->

	<%-- <script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script> --%>

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
	
	<script
		src="${pageContext.request.contextPath }/jsp/admin/page/js/userInfo.js"></script>	
	
	<!-- end: JavaScript-->
	
</body>
</html>

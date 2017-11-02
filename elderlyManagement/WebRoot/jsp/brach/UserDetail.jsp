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
	
	<style type="text/css">
	.image1{ 
       
        width:130px; 
        height:130px; 
        border-radius:130px; 
    }
	</style>
		
		
		
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
					<a href="#">用户详情</a>
				</li>
			</ul>
			
			
					
					
					
					<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>用户详情</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" action="${pageContext.request.contextPath }/brach/updateUser.action?userid=${ user.userid}">
							<fieldset>
							
							<div style="padding-left: 35%;padding-bottom: 30px">
							<img class="image1" src="${user.avatar }">
							</div>
							
							<input type="hidden" name="userid" value="${user.userid }"  />
							
							   <div class="control-group">
								<label class="control-label" for="disabledInput">客户姓名</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" name="userid" placeholder="${user.username }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="optionsCheckbox2">客户性别</label>
								<div class="controls">
								  <label class="checkbox">
									<input type="checkbox" id="optionsCheckbox2" name="sex" value="${user.sex }" checked="checked" disabled="">
									${user.sex }
								  </label>
								</div>
							  </div>
							  
							   <div class="control-group">
								<label class="control-label" for="disabledInput">手机号</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" name="phone" value="${user.phone }" type="text" placeholder="${user.phone }" disabled="">
								</div>
							  </div>
							  
							  
							  <!-- <div class="control-group">
								<label class="control-label">Uneditable input</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input">Some value here</span>
								</div>
							  </div> -->
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">客户邮箱</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" name="email" value="${user.email }" placeholder="${user.email }" disabled="">
								</div>
							  </div>
							  
							   <div class="control-group">
								<label class="control-label" for="disabledInput">客户密码</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" value="${user.password }" placeholder="${user.password }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label">客户生日</label>
								<div class="controls">
								<a name="birthday" value="${user.birthday }"></a>
								  <span class="input-xlarge uneditable-input" disabled="" value="${user.birthday }">${user.birthday }</span>
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">客户地址</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${user.address }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">用户积分</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${user.integral }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">银行卡号</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${user.bankcardno }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">健康状况</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${user.healthstatus }" disabled="">
								</div>
							  </div>
							  
							  <%-- <div class="control-group">
								<label class="control-label" for="disabledInput">用户积分</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${user.integral }" disabled="">
								</div>
							  </div> --%>
							  
							  <div class="control-group">
								<label class="control-label" for="disabledInput">用户等级</label>
								<div class="controls">
								  <input class="input-xlarge disabled" id="disabledInput" type="text" placeholder="${level.level }" disabled="">
								</div>
							  </div>
							  
							  <div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">以往病史</label>
							  <div class="controls">
								<textarea id="textarea2" name="beforemedicalrecords"  style="width: 300px;height: 100px;" rows="3">${med.beforemedicalrecords } </textarea>
							  </div>
							</div>
							
							 <div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">现病史</label>
							  <div class="controls">
								<textarea id="textarea2" name="nowmedicalrecords"  style="width: 300px;height: 100px;" rows="3">${med.nowmedicalrecords } </textarea>
							  </div>
							</div>
							
							
							 <div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">家族病史</label>
							  <div class="controls">
								<textarea id="textarea2" name="familyrecords" style="width: 300px;height: 100px;" rows="3">${med.familyrecords } </textarea>
							  </div>
							</div>
							<%-- 
							 <div class="control-group hidden-phone">
							  <label class="control-label" for="textarea2">bingli</label>
							  <div class="controls">
								<textarea id="textarea2" name="medicalrecordsid" style="width: 300px;height: 100px;" rows="3">${med.medicalrecordsid } </textarea>
							  </div>
							</div> --%>
							
							  <div class="form-actions">
								<button type="submit" class="btn btn-primary">提交修改</button>
							  </div>
							</fieldset>
						  </form>
					
					</div>
				</div><!--/span-->
			
			
			
			
			</div>
					
					
					
					
					
					
					
				</div><!--/span-->

			</div><!--/row-->

			<!--/row-->
			
			<!--/row-->
    

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		
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
	<!-- end: JavaScript-->
	
</body>
</html>

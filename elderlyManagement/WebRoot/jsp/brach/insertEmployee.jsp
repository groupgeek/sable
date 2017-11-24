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
	<title>添加员工信息</title>
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
						<!-- 	<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a> -->
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					
					
					
					
					
					
			<form class="form-horizontal" onsubmit="return check()" action="${pageContext.request.contextPath }/brach/insertEmpl.action" method="post" enctype="multipart/form-data">
				<fieldset>
					<div class="control-group">
							  <label class="control-label" for="typeahead">员工姓名 </label>
							  <div class="controls">
								<input type="text" name="employeename" onkeyup="long()" class="span6 typeahead" id="typeahead">
							  </div>
					</div>
					
					<div class="control-group">
							  <label class="control-label" for="date01" class="span6 typeahead" onkeyup="haha()">员工生日</label>
							  <div class="controls">
								<input name="birthday" onClick="laydate()" id="str"><br /><br />
							  </div>
					</div>
					
					<div class="control-group">
							  <label class="control-label" for="fileInput">添加头像</label>
							  <div class="controls">
							  <input type="file" name="file">
							  </div>
					</div> 
					
					<div class="control-group">
							  <label class="control-label" for="typeahead">员工密码</label>
							  <div class="controls">
								<input type="text" name="password" onkeyup="IsString()" class="span6 typeahead" id="pass">
								<p id="pass2" style="color:gray">员工密码不可以为空，否则添加失败</p>
							  </div>
					</div>
					
					
					<div class="control-group">
								<label class="control-label" for="typeahead">员工邮箱</label>
								<div class="controls">
								<input type="text" name="email" class="span6 typeahead" onkeyup="IsEmail()" id="email">
								<p id="mail" style="color:gray">邮箱格式为 xxx@163.com</p>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">员工电话</label>
								<div class="controls">
								<input type="text" name="phone" class="span6 typeahead" onkeyup="IsPhone()" id="phone">
								<p id="phoneNo" style="color:gray"></p>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">员工性别</label>
								<table><tr>
								<td><label class="radio-inline">
								<input name="sex" checked="checked" type="radio" value="男">男</label></td>
								<td><label class="radio-inline">
								<input name="sex" type="radio" value="女">女</label></td>
							</tr></table>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">家庭住址</label>
								<div class="controls">
								<input type="text" name="address" class="span6 typeahead" onkeyup="add()" id="addr">
								</div>
					</div>	
					
					<div class="control-group">
								<label class="control-label" for="typeahead">员工工资</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput" oninput="xixi(this.value)" name="wage" size="16" type="text">
								  </div>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">奖金</label>
								<div class="controls">
								<div class="input-prepend input-append">
									<span class="add-on">￥</span>
									<input id="appendedPrependedInput2" oninput="xixi2(this.value)" name="totalbonus" size="16" type="text">
								  </div>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead" onkeyup="haha2()">入职时间</label>
								<div class="controls">
								<input name="entrytime" onClick="laydate()" id="str2"><br /><br />
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">职位等级*</label>
								<div class="controls">
								<select id="selectError3" name="positionid">
										<option value="3">送货员</option>
										<option value="2">商城管理员</option>
								</select>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">员工权限等级*</label>
								<div class="controls">
								<select id="selectError3" name="authorityid">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										<option value="4">4</option>
									</select>
								</div>
					</div>
					
					<div class="control-group">
								<label class="control-label" for="typeahead">银行卡号</label>
								<div class="controls">
								<input type="text" name="bankcardno"  class="span6 typeahead" id="bankno" onkeyup="bank(this.value)">
								<p id="bank"></p>
								</div>
					</div>
					
					
					
					<div class="control-group">
								<label class="control-label" for="typeahead">工作状态</label>
								<div class="controls">
								<select id="selectError3" name="employeestatus">
										<option value="正常">正常</option>
										<option value="休假">休假</option>
										<option value="请假">请假</option>
									</select>
								</div>
					</div>
					
					
					<div class="form-actions">
							  <button type="submit" class="btn btn-primary">提交信息</button>
					</div>
					
				</fieldset>
			</form>
					
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
		
		<script src="${pageContext.request.contextPath }/jsp/brach/js/yanzhen/xixi.js"></script>
		
	<!-- end: JavaScript-->
	
</body>
</html>

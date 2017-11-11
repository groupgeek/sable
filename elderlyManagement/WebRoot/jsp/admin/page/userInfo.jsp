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
<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse" data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</a>
				<a class="brand" href="index.html"><span>JANUX</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-bell"></i>
								<span class="badge red">
								7 </span>
							</a>
							<ul class="dropdown-menu notifications">
								<li class="dropdown-menu-title">
 									<span>You have 11 notifications</span>
									<a href="#refresh"><i class="icon-repeat"></i></a>
								</li>	
                            	<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">1 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">7 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">8 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">16 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">36 min</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon yellow"><i class="icon-shopping-cart"></i></span>
										<span class="message">2 items sold</span>
										<span class="time">1 hour</span> 
                                    </a>
                                </li>
								<li class="warning">
                                    <a href="#">
										<span class="icon red"><i class="icon-user"></i></span>
										<span class="message">User deleted account</span>
										<span class="time">2 hour</span> 
                                    </a>
                                </li>
								<li class="warning">
                                    <a href="#">
										<span class="icon red"><i class="icon-shopping-cart"></i></span>
										<span class="message">New comment</span>
										<span class="time">6 hour</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon green"><i class="icon-comment-alt"></i></span>
										<span class="message">New comment</span>
										<span class="time">yesterday</span> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="icon blue"><i class="icon-user"></i></span>
										<span class="message">New user registration</span>
										<span class="time">yesterday</span> 
                                    </a>
                                </li>
                                <li class="dropdown-menu-sub-footer">
                            		<a>View all notifications</a>
								</li>	
							</ul>
						</li>
						<!-- start: Notifications Dropdown -->
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-calendar"></i>
								<span class="badge red">
								5 </span>
							</a>
							<ul class="dropdown-menu tasks">
								<li class="dropdown-menu-title">
 									<span>You have 17 tasks in progress</span>
									<a href="#refresh"><i class="icon-repeat"></i></a>
								</li>
								<li>
                                    <a href="#">
										<span class="header">
											<span class="title">iOS Development</span>
											<span class="percent"></span>
										</span>
                                        <div class="taskProgress progressSlim red">80</div> 
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="header">
											<span class="title">Android Development</span>
											<span class="percent"></span>
										</span>
                                        <div class="taskProgress progressSlim green">47</div> 
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                        <div class="taskProgress progressSlim yellow">32</div> 
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                        <div class="taskProgress progressSlim greenLight">63</div> 
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="header">
											<span class="title">ARM Development</span>
											<span class="percent"></span>
										</span>
                                        <div class="taskProgress progressSlim orange">80</div> 
                                    </a>
                                </li>
								<li>
                            		<a class="dropdown-menu-sub-footer">View all tasks</a>
								</li>	
							</ul>
						</li>
						<!-- end: Notifications Dropdown -->
						<!-- start: Message Dropdown -->
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-envelope"></i>
								<span class="badge red">
								4 </span>
							</a>
							<ul class="dropdown-menu messages">
								<li class="dropdown-menu-title">
 									<span>You have 9 messages</span>
									<a href="#refresh"><i class="icon-repeat"></i></a>
								</li>	
                            	<li>
                                    <a href="#">
										<span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	6 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>  
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	56 min
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>  
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	3 hours
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>  
                                    </a>
                                </li>
								<li>
                                    <a href="#">
										<span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	yesterday
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>  
                                    </a>
                                </li>
                                <li>
                                    <a href="#">
										<span class="avatar"><img src="img/avatar.jpg" alt="Avatar"></span>
										<span class="header">
											<span class="from">
										    	Dennis Ji
										     </span>
											<span class="time">
										    	Jul 25, 2012
										    </span>
										</span>
                                        <span class="message">
                                            Lorem ipsum dolor sit amet consectetur adipiscing elit, et al commore
                                        </span>  
                                    </a>
                                </li>
								<li>
                            		<a class="dropdown-menu-sub-footer">View all messages</a>
								</li>	
							</ul>
						</li>
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> Dennis Ji
								<span class="caret"></span>
							</a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>Account Settings</span>
								</li>
								<li><a href="#"><i class="halflings-icon user"></i> Profile</a></li>
								<li><a href="login.html"><i class="halflings-icon off"></i> Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header --><div class="copyrights">Collect from <a href="http://www.cssmoban.com/" >企业网站模板</a></div>
	
			<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li id = "home"><a href="${pageContext.request.contextPath }/jsp/admin/index.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">主页</span>
						</a>
						</li>
						<li id = "userInfo"><a href="${pageContext.request.contextPath }/jsp/admin/page/user.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">客户信息管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/employee.jsp"><i class="icon-envelope"></i><span
								class="hidden-tablet">员工信息管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/customerRelations.jsp"><i class="icon-tasks"></i><span
								class="hidden-tablet">客户关系</span>
						</a>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/returnVisitRecord.jsp"><i class="icon-tasks"></i><span
								class="hidden-tablet">回访记录</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/activity.jsp"><i class="icon-eye-open"></i><span
								class="hidden-tablet">活动管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/branch.jsp"><i class="icon-dashboard"></i><span
								class="hidden-tablet">分店管理</span>
						</a>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/message.jsp"><i class="icon-dashboard"></i><span
								class="hidden-tablet">留言管理</span>
						</a>
						</li>
						<li><a href="javaScript:;" id = "demo"><i class="icon-dashboard"></i><span
								class="hidden-tablet">报表统计</span>
						</a>
						</li>

					</ul>
				</div>
			</div>

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
							   <div class="control-group" id = "online">
								<label class="control-label">是否在线</label>
								<div class="controls">
								  <span class="input-xlarge uneditable-input"></span>
								</div>
								</div>
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
	<footer>

	<p>
		<span style="text-align:left;float:left">&copy; 2013 <a
			href="javaScript:;" alt="Bootstrap_Metro_Dashboard">哈哈哈哈哈哈哈哈哈或哈哈</a>
		</span>

	</p>

	</footer>
	
	<!-- start: JavaScript-->

	<script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script>

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
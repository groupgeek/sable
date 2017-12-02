<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>

<meta charset="utf-8">
<title>head</title>
<meta name="description" content="admin">
<meta name="keyword" content="admin">
<script type="text/javascript" src="//g.alicdn.com/de/prismplayer/2.3.0/aliplayer-min.js"></script>
<link rel="stylesheet" href="//g.alicdn.com/de/prismplayer/2.3.0/skins/default/aliplayer-min.css" />
<link href="${pageContext.request.contextPath }/jsp/util/_css/wait.css" rel="stylesheet" type="text/css" />
</head>


<body>
<c:import url="/jsp/util/messageNotification.jsp"></c:import>
<div id="loading" style="z-index: 10000000000;display: none;">
				<div id="loading-center">
					<div id="loading-center-absolute">
						<div class="object" id="object_one"></div>
						<div class="object" id="object_two"></div>
						<div class="object" id="object_three"></div>
						<div class="object" id="object_four"></div>
		
					</div>
				</div>

			</div>
	
	<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> </a> <a class="brand" href="${pageContext.request.contextPath }/jsp/admin/index.jsp"><span>XIAOHE-ADMIN</span>
				</a>

				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<!-- start: Message Dropdown -->
						<!-- <li class="dropdown hidden-phone"><a
							class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-envelope"></i> <span class="badge red"> 4
							</span> </a>
							<ul class="dropdown-menu messages">
								<li class="dropdown-menu-title"><span>You have 9
										messages</span> <a href="#refresh"><i class="icon-repeat"></i>
								</a></li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar">
									</span> <span class="header"> <span class="from"> Dennis
												Ji </span> <span class="time"> 3 hours </span> </span> <span
										class="message"> Lorem ipsum dolor sit amet consectetur
											adipiscing elit, et al commore </span> </a></li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar">
									</span> <span class="header"> <span class="from"> Dennis
												Ji </span> <span class="time"> yesterday </span> </span> <span
										class="message"> Lorem ipsum dolor sit amet consectetur
											adipiscing elit, et al commore </span> </a></li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar">
									</span> <span class="header"> <span class="from"> Dennis
												Ji </span> <span class="time"> Jul 25, 2012 </span> </span> <span
										class="message"> Lorem ipsum dolor sit amet consectetur
											adipiscing elit, et al commore </span> </a></li>
								<li><a class="dropdown-menu-sub-footer">View all
										messages</a></li>
							</ul></li> -->

						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="halflings-icon white user"></i> <span class = "superAdmin">未登录</span> <span
								class="caret"></span> </a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title"><span>设置
										</span></li>
								<!-- <li><a href="#"><i class="halflings-icon user"></i>
										Profile</a>
								</li> -->
								<li><a href="${pageContext.request.contextPath }/superAdmin/logout"><i class="halflings-icon off"></i>
										注销</a>
								</li>
							</ul></li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->

			</div>
		</div>
	</div>
	<!-- start: Header -->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">企业网站模板</a>
	</div>

<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

<script type="text/javascript">

	
	var root = $("#root").attr("value");
	$.ajax({
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/getSuperAdmin",
				success:function(data){
					if(data == null){
						window.location.href = root + "/jsp/AdminLogin/login.jsp";
					}
					$(".superAdmin").text(data.employeename);
				}
			});
	
	$(document).ready(function(){
			var message = $("#message").attr("value");
			if(message != "" && message != undefined){
				//显示提示信息
				$("#showMessage").text(message);
				$('#messageNotification').fadeIn(2000);
				getSrceenWH();
				$('#messageNotification').fadeOut(3000);
			}
		
		});
</script>

</body>
</html>

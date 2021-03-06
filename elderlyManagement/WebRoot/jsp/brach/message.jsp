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
	<title>分店留言信息</title>
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
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/brach/img/favicon.ico">
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
	<script type="text/javascript">
			
        	function queryMessage(id){
	        	alert(id);
	        	//var message= $("#span1").html();
	        		$.ajax({
	        			type:"post",
	        			contentType:"application/json;charset=utf-8",
	        			url:"${pageContext.request.contextPath }/brach/jsonMessage.action",
	        			//data:'messagecontext:'+message,
	        			data:'{"messagecontext"'+':'+'"'+message+'"}',
	        			success:function(data,status){
	        				/* $("#megUserName").html(data.username);
	        				$("#megEmail").html(data.email);
	        				$("#megDate").html(data.messagetime);
	        				$("#megContent").html(data.messagecontext);*/
	        				alert(data);
	        			}
	        		
	        		});
        	 }
        
        </script>
		
		
		
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
								<i class="halflings-icon white user"></i>${admins.employeename }
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
			<!-- start: Main Menu -->
			<!-- end: Main Menu -->
			<!-- start: Content -->
			<div id="content" class="span10" style="height: 700px">
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="index.html">XIAOHE</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">留言信息</a></li>
			</ul>

			<div class="row-fluid">
				
				<div class="span7">
					<h1>所有留言</h1>
					<ul class="messagesList">
						<c:forEach items="${messages }" var="message">
							<li id="hh" onclick="change(${message.messageid })">
							<span class="from"><span class="glyphicons star"><i></i></span> ${message.username } <span class="glyphicons paperclip"><i></i></span></span><span id = "span1" class="title"> ${message.messagecontext }</span><span class="date">
							<fmt:formatDate value="${message.messagetime }"
								pattern="yyyy-MM-dd HH:mm:ss" /></span>
						</c:forEach>
					</ul>
				</div>
				<div class="span5 noMarginLeft">
					
					<div class="message dark">
						<div class="header">
							<div class="from"><i class="halflings-icon user"></i> <b id="username">${messages[0].username}</b> /<b id="email"> ${messages[0].email }</b></div>
							<%-- <div class="date"><i class="halflings-icon time"></i><span id="time"><fmt:formatDate value="${messages[0].messagetime }"
								pattern="yyyy-MM-dd HH:mm:ss" /></span></div>
							<div class="menu"></div></div> --%>
							<div style="margin-top: 30px">
							<h6>留言详情：</h6>
							</div>
						<div class="content" style="margin-top: 30px">
							<p id="context">${messages[0].messagecontext}</p>
						</div>
					</div>	
					
				</div>
				
			</div>
			<div  style="position:absolute;left:430px;top:620px">
			<table>
<tr>
	<c:choose>
				<c:when test="${messageVo.nowPage==1}">
					首页
					上一页
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}/brach/fenyeMessage.action?nowPage=1">
						首页</a>
					<a href="${pageContext.request.contextPath}/brach/fenyeMessage.action?nowPage=${messageVo.nowPage-1}">
						上一页</a>
				</c:otherwise>
	</c:choose>
	<c:choose>
				<c:when test="${messageVo.nowPage==messageVo.count}">
					下一页
					尾页
				</c:when>
				<c:otherwise>
					<a style="text-decoration:none" href="${pageContext.request.contextPath}/brach/fenyeMessage.action?nowPage=${messageVo.nowPage+1}">
						下一页</a>
					<a style="text-decoration:none" href="${pageContext.request.contextPath}/brach/fenyeMessage.action?nowPage=${messageVo.count}">
						尾页</a>
				</c:otherwise>
	</c:choose>
	
	</tr>
</table>
</div>
</div>
       

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		<!--/fluid-row-->
		
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
		
		<script type="text/javascript">
			function change(id){
				$.ajax({
					type : 'post',
					/*${pageContext.request.contextPath }/*/
					/* data:'{"userid":"1"}', */
					url:'${pageContext.request.contextPath }/brach/RequestMessage.action',
					contentType : 'application/json;charset=utf-8',
					data:'{"messageid"'+':'+'"'+id+'"}',
					success:function(data){
						$("#username").html(data.username);
						$("#context").html(data.messagecontext);
						$("#email").html(data.email);
						/* function fmt(data){
						var year = date.getFullYear();
						var month = date.getMonth()+1;
						var day = date.getDate();
						var hour = date.getHours();
						var minute = date.getMinutes();
						var second = date.getSeconds();
						return [year,month,day].map(formatNumber).join('-')+''+[hour,minute,second].map(formatNumber).join(':');
						}
						function fmtn(n){
						n = n.toString();
						return n[1]?n:'0'+n;
						}
						var time = $("#time").html(data.messagetime);
						fmtn(data); */
						/* alert(new Date(parseInt(data.Data[1].Data.replace(igm,"")))); */
						
						/* $("#time").html(data.messagetime); */
					}
				});
			}
		</script>
		
		
		
	<!-- end: JavaScript-->
	
</body>
</html>

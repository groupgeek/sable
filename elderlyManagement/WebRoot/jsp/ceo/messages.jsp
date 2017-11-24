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
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	<script type="text/javascript">
			function change(id){
				$.ajax({
					type : 'post',					
					url:'${pageContext.request.contextPath }/ceo/readmessage.action',
					contentType : 'application/json;charset=utf-8',
					data:'{"messageid"'+':'+'"'+id+'"}',
					success:function(data){
						$("#username").html(data.username);
						$("#email").html(data.email);
						$("#messagetime").html(data.stringDate);
						$("#message").html(data.messagecontext);									
					}
				});
			}
	</script>
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
			<li><a href="#">用户留言</a></li>
		</ul>
		<div class="row-fluid">
			<div class="span7">
				<h1>留言板</h1>					
				<ul class="messagesList">
					<c:forEach items="${findMessageCustoms }" var="e">
						<li id="hh" onclick="change(${e.messageid })">
							
								<span class="from"> ${e.username } </span><span class="title"> ${e.messagecontext }</span><span class="date"><b>${e.stringDate }</b></span>
						
						</li>
					</c:forEach>
				</ul>				
			</div>
			<div name="message" class="span5 noMarginLeft">					
				<div class="message dark">					
						<%
						String id = request.getParameter("id");
						int a = 0;
						if(id != null){
						a = Integer.valueOf(id);
						}
						%>
					 	<input type="hidden" value="<%=a%>" id="messageid">
					 	<input type="hidden" id = "root" value="${pageContext.request.contextPath }">					
					<div class="header">
						<h1>详细信息</h1>
						<div class="from"><i class="halflings-icon user"></i> <b id="username">${findMessageCustoms[0].username }</b> / <b id="email">${findMessageCustoms[0].email }</b></div>
						<div class="date"><i class="halflings-icon time"></i> <b id="messagetime">${findMessageCustoms[0].stringDate }</b></div>
						<br>							
						<div class="menu"></div>		
						<br>					
					</div>						
									
					<form class="replyForm"method="post" action="">
						<fieldset>
						<br>
							<div  tabindex="3" class="input-xlarge span12" id="message" name="body" rows="12" placeholder="没有内容">${findMessageCustoms[0].messagecontext }</div>
							
						</fieldset>
					</form>							
				</div>						
			</div>						
		</div>
	</div><!--/.fluid-container-->	
	<!-- end: Content -->
</div><!--/#content.span10-->
</div><!--/fluid-row-->		
	
	<footer>
		<p>
			<span style="text-align:left;float:left">&copy; 2017 <a href="${pageContext.request.contextPath }/ceo/index.action" alt="Bootstrap_Metro_Dashboard">欢迎使用Ceo专用管理站点！</a></span>
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/message.js"></script>
	<!-- end: JavaScript-->

  </body>
</html>

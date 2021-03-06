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
	<title>Ceo管理员系统</title>
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
		
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/brach/img/favicon.ico">
	<!-- end: Favicon -->
	
	<style type="text/css">
	#header {
	height:100px;
	width:100%;
    padding-up:5px;
    padding-left:0px;
	}
	#nav {
   	 line-height:30px;
  	 height:100%;
  	 width:40%;
   	 float:left;
   	 padding:5px;	      
	}
	#section {
   	 width:49%;
   	 float:left;
 	 
	}
	#avatar{
	 width:49%;
   	 float:left;
	}
	#section1{
	width:100%;
	height:140px;
	}
	#image1{ 
       	padding-left:10%;
        width:130px; 
        height:150px;
        float:left; 
 
    }
    .form-actions{
    	clear:both;
   	 	text-align:center;
  	 	padding:5px;	
    }
	</style>
		
		
		
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
				<li>					
					<a href="${pageContext.request.contextPath }/ceo/usertable.action">用户信息</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li><a>用户详细信息</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>用户详情</h2>
						<div class="box-icon">
							<a href="${pageContext.request.contextPath }/ceo/usertable.action" ><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" action="">
							<fieldset>
							<input type="hidden" name="userid" value="${findUserById.userid }"  />
							<div style="padding-bottom: 30px">
								<div id="header">
									<div id="nav">
										<div class="control-group">
											<label class="control-label" for="disabledInput">用户姓名</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="username" value="${findUserById.username }" disabled="">
											</div>
							  			</div>
							   			<div class="control-group">
							 				<label class="control-label" for="typeahead">用户性别 </label>
							  				<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="sex" value="${findUserById.sex }" disabled="">
							  				</div>
							  			</div>
							 			 <div class="control-group">
											<label class="control-label" for="optionsCheckbox2">出生日期</label>
											<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="birthday" value="${findUserById.stringDate }" disabled="">
							  				</div>
							  			</div>
							  			
									</div>
									<%
										String id = request.getParameter("userid");
										int a = Integer.valueOf(id);
						 			%>
						 			<input type="hidden" id="userid" value="<%=a %>">
									<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
									<div class="control-group" id = "avatar">
										<label class="control-label">用户头像</label>
										<div class="controls" id="section1">
											<img  id = "image1" src="" >
										</div>
							  		</div>
								</div>
								<div id="nav">
									<div class="control-group">
										<label class="control-label" for="disabledInput">用户账号</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="accountnumber" value="${findUserById.accountnumber }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label">用户积分</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="integral" value="${findUserById.integral }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="appendedPrependedInput">邮箱地址</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="email" value="${findUserById.email }" disabled="">
							  			</div>
				    				</div>
				    				<div class="control-group">
										<label class="control-label" for="disabledInput">注册分店</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="branchname" value="${findUserById.branchname }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">健康情况</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="healthstatus" value="${findUserById.healthstatus }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="appendedPrependedInput">用户等级</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="levelid" value="lv${findUserById.levelid }" disabled="">
							  			</div>
				   					</div>
				   					<div class="control-group">
										<label class="control-label" for="disabledInput">用户状态</label>
										<div class="controls">
								  			<input class="input-xlarge disabled" id="disabledInput" type="text" name="status" value="${findUserById.stringuser }" disabled="">
										</div>
							  		</div>
								</div>
								<div id="section">
									<div class="control-group">
										<label class="control-label" for="disabledInput">用户密码</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="password" value="${findUserById.password }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">联系方式</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="phone" value="${findUserById.phone }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">用户地址</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="address" value="${findUserById.address }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">注册时间</label>
										<div class="controls">
								  			<input class="input-xlarge disabled" id="disabledInput" type="text" name="registrationdate" value="${findUserById.stringregistrationdate }" disabled="">
										</div>
							  		</div>
							  		
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">用户权限</label>
										<div class="controls">
								  			<input class="input-xlarge disabled" id="disabledInput" type="text" name="authorityid" value="${findUserById.authorityid }" disabled="">
										</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">银行卡号</label>
										<div class="controls">
								  			<input class="input-xlarge disabled" id="disabledInput" type="text" name="bankcardno" value="${findUserById.bankcardno }" disabled="">
										</div>
							  		</div>
							  		<!-- <div class="control-group">
										<label class="control-label" for="disabledInput">是否在线</label>
										<div class="controls">
								  			<input class="input-xlarge disabled" id="disabledInput" type="text" name="bankcardno" value="${findUserById.bankcardno }" disabled="">
										</div>
							  		</div> -->
								</div>
							</div>
							</fieldset>
						  </form>					
					</div>
				</div><!--/span-->	
			</div>			
				</div><!--/span-->
			</div><!--/row-->
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
			<span style="text-align:left;float:left">&copy; 2017 <a href="${pageContext.request.contextPath }/jsp/index/index.jsp" alt="Bootstrap_Metro_Dashboard">欢迎使用XIAOHE</a></span>
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/user.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>

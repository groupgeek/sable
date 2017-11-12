<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>用戶修改</title>
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
				<li><a href="#">客户信息修改</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>用户信息修改</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a> -->
							<a href="#"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					
					
					<div class="box-content">
						<form class="form-horizontal" action = "${pageContext.request.contextPath }/superAdmin/updateUserInfo" method="post" enctype="multipart/form-data">
							<fieldset>
							 <div class="control-group" id = "avatar">
								<label class="control-label">头像</label>
								<div class="controls">
									<c:choose>
										<c:when test="${userInfo.avatar == null}">
											<p>无</p>
										</c:when>
									
										<c:otherwise>
											<img  id = "" src="/upload/${userInfo.avatar }" style="width: 100px;">
										</c:otherwise>
									</c:choose>
								</div>
							  </div>
							<div class="control-group" id = "avatartemp">
								<label class="control-label">更改头像</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "pictureUpload" type="file">
								</div>
							  </div>
							  <div class="control-group" id="username">
								<label class="control-label" for="focusedInput">姓名</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "username" type="text" value="${userInfo.username }">
								</div>
							  </div>
							  
							   <!-- <div class="control-group" id = "sex">
								<label class="control-label">性别</label>
								 <div class="controls">
									<label class="radio"><input name="sex" type="radio" value=1 checked="checked"/>男 </label>
									<div style="clear:both"></div> 
									<label class="radio"><input name="sex" type="radio" value=0 checked=""/>女 </label> 
								</div>
							  </div> -->
							   <div class="control-group" id = "sex">
								<label class="control-label">性别</label>
								<div class="controls">
								  <select name="sex">
								  	<c:choose>
								  		<c:when test='${userInfo.sex == "男" }'>
									  		<option value = "女" id = "sex_0">女</option>
											<option value = "男" id = "sex_1" selected="selected">男</option>
											<option value = "无" id = "sex_2">无</option>
								  		</c:when>
								  		<c:when test='${userInfo.sex == "女" }'>
									  		<option value = "女" id = "sex_0" selected="selected">女</option>
											<option value = "男" id = "sex_1">男</option>
											<option value = "无" id = "sex_2">无</option>
								  		</c:when>
								  		<c:otherwise>
								  			<option value = "女" id = "sex_0">女</option>
											<option value = "男" id = "sex_1">男</option>
											<option value = "无" id = "sex_2" selected="selected">无</option>
								  		</c:otherwise>
								  	</c:choose>
								  
								  
								  </select>
								</div>
							  </div>
							  <div class="control-group" id = "phone">
								<label class="control-label">手机号(账号)</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "phone" type="text" value="${userInfo.phone }">
								</div>
							  </div>
							  
							  <div class="control-group" id = "password">
								<label class="control-label">密码</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "password" type="text" value="${userInfo.password }">
								</div>
							  </div>
							   <div class="control-group" id = "registrationdate">
								<label class="control-label">注册日期</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "registrationdate" type="text" onClick="laydate()" value="<fmt:formatDate value="${userInfo.registrationdate }"pattern="yyyy-MM-dd" />">
								</div>
							  </div>
							  <div class="control-group" id = "address">
								<label class="control-label">家庭地址</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "address" type="text" value="${userInfo.address }">
								</div>
							  </div>
							  <div class="control-group" id = "status">
								<label class="control-label">账号状态</label>
								<div class="controls">
								  <select name="status">
								  <c:if test="${userInfo.status == true }">
								  
								  	<option value = 1 id="statusNormal" selected="selected">正常</option>
									<option value = 0 id="statusAbnormal">禁止登陆</option>
								  
								  </c:if>
								  
								  <c:if test="${userInfo.status == false }">
								  
								  	<option value = 1 id="statusNormal">正常</option>
									<option value = 0 id="statusAbnormal" selected="selected">禁止登陆</option>
								  
								  </c:if>
								  
								  </select>
								</div>
							  </div>
							  <div class="control-group" id = "integral">
								<label class="control-label">积分</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "integral" type="text" value="${userInfo.integral }">
								</div>
							  </div>
							    <div class="control-group" id = "email">
								<label class="control-label">邮箱</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "email" type="email" value="${userInfo.email }">
								</div>
							  </div>
							  
							  <div class="control-group" id = "birthday">
								<label class="control-label">生日</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "birthday" type="text" onClick="laydate()" value="<fmt:formatDate value="${userInfo.birthday }"pattern="yyyy-MM-dd" />">
								</div>
							  </div>
							  
							  <div class="control-group" id = "bankcardno">
								<label class="control-label">银行卡号</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "bankcardno" type="text" value="${userInfo.bankcardno }">
								</div>
							  </div>
							  
							  <div class="control-group" id = "healthstatus">
								<label class="control-label">健康状态</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "healthstatus" type="text" value="${userInfo.healthstatus }">
								</div>
							  </div>
							  
							  <div class="control-group" id = "authoritylevel">
								<label class="control-label">权限</label>
								<div class="controls">
								  <select id="" data-rel="chosen" name="authorityid">
								  <c:forEach items="${allAuthority }" var="authority">
								  
									<option value = ${authority.authorityid }>${authority.authoritylevel }</option>
								  
								  </c:forEach>
								  </select>
								</div>
							  </div>
							  <div class="control-group" id = "level">
								<label class="control-label">等级</label>
								<div class="controls">
									<select id="" data-rel="chosen" name="levelid">
									  <c:forEach items="${allLevel }" var="level">
									  
										<option value = ${level.levelid }>${level.level }</option>
									  
									  </c:forEach>
								 	 </select>
								</div>
							  </div>
							  <div class="control-group" id = "areaname">
								<label class="control-label">地区</label>
								<div class="controls">
								  <select id="" data-rel="chosen" name="areaid">
									  <c:forEach items="${allArea }" var="area">
									  
										<option value = ${area.areaid }>${area.areaname }</option>
									  
									  </c:forEach>
								  </select>
								</div>
							  </div>
							  <%--  <div class="control-group" id = "areaaddress">
								<label class="control-label">地区地址</label>
								<div class="controls">
								  <!-- <input class="input-xlarge focused" name = "areaaddress" type="text" value=""> -->
								  <select id="" data-rel="chosen" name="area.areaaddress">
									<c:forEach items="${allArea }" var="area">
									  
										<option value = ${area.areaid }>${area.areaname }</option>
									  
									 </c:forEach>
								  </select>
								</div>
							  </div> --%>
							   <!-- <div class="control-group" id = "online">
									<label class="control-label">是否在线</label>
									<div class="controls">
									  <input class="input-xlarge focused" name = "online" type="text" value="">
									</div>
								</div> -->
							   <%-- <div class="control-group" id = "branchname">
								<label class="control-label">所在分店</label>
								<div class="controls">
								  <select id="" data-rel="chosen" name="branch.branchname">
									 <c:forEach items="${allBranch }" var="branch">
									  
										<option value = ${branch.branchid }>${branch.branchname }</option>
									  
									 </c:forEach>
								  </select>
								</div>
							  </div> --%>
							   <%-- <div class="control-group" id = "manager">
								<label class="control-label">分店管理员</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "level.level" type="text" value="${userInfo.manager.employeename }">
								</div>
							  </div> --%>
							  <div class="control-group hidden-phone" id = "nowmedicalrecords">
								  <label class="control-label">病历</label>
								  <div class="controls">
									<textarea class="cleditor" id="" rows="3" name="med.nowmedicalrecords">${userInfo.med.nowmedicalrecords }</textarea>
								  </div>
							  </div>
							  <div class="control-group hidden-phone" id = "beforemedicalrecords">
								  <label class="control-label">病历</label>
								  <div class="controls">
									<textarea class="cleditor" id="" rows="3" name="med.beforemedicalrecords">${userInfo.med.beforemedicalrecords }</textarea>
								  </div>
							  </div>
							  <div class="control-group hidden-phone" id = "personalrecords">
								  <label class="control-label">病历</label>
								  <div class="controls">
									<textarea class="cleditor" id="" rows="3" name="med.personalrecords">${userInfo.med.personalrecords }</textarea>
								  </div>
							  </div>
							  <div class="control-group hidden-phone" id = "familyrecords">
								  <label class="control-label">病历</label>
								  <div class="controls">
									<textarea class="cleditor" id="" rows="3" name="med.familyrecords">${userInfo.med.familyrecords }</textarea>
								  </div>
							  </div>
							  
							  
							 
							 
							 <input type="hidden" value = "${userInfo.userid }" name = "userid">
							 <input type="hidden" value = "${userInfo.med.medicalrecordsid }" name = "med.medicalrecordsid">
							 <input type="hidden" value = "${message }" id = "message">
							  
							  <div class="form-actions">
								<button type="submit" id = "updateUser" class="btn btn-primary">保存</button>
							  </div>
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
		src="${pageContext.request.contextPath }/jsp/admin/page/js/updateUser.js"></script>	
		
		<script src="${pageContext.request.contextPath }/jsp/admin/page/js/laydate.js"></script>	
	
	<!-- end: JavaScript-->
	
	<script type="text/javascript">
		$(document).ready(function(){
			var message = $("#message").attr("value");
			if(message != ""){
				alert(message);
			}
		
		});
	
	</script>
	
</body>
</html>

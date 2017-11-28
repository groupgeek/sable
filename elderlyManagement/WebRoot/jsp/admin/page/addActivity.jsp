<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>添加活动</title>
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
					<a href="${pageContext.request.contextPath }/jsp/admin/page/activity.jsp">活动管理</a>
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">活动信息添加</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>活动信息添加</h2>
						<h2><span class="break"></span>带*必填</h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a> -->
							<a href="#"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					
					
					<div class="box-content">
						<form class="form-horizontal" id = "regActivity" action = "${pageContext.request.contextPath }/superAdmin/addActivity" method="post" enctype="multipart/form-data">
							<fieldset>
							
							  <div class="control-group" id="activityname">
								<label class="control-label" for="focusedInput">活动名字*</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "activityname" type="text"placeholder="活动名字"
										minlength=2 autocomplete="off" required>
								</div>
							  </div>
							  
							   <!-- <div class="control-group" id = "activitytypename">
								<label class="control-label">活动类型*</label>
								<div class="controls">
								 <select data-placeholder="选择分类" name="activitytypename" data-rel="chosen" required>
										<option value=""></option>
								  </select>
								</div>
							  </div> -->
							  
							  <div class="control-group" id = "activitytypename">
								<label class="control-label">活动类型*</label>
								<div class="controls">
								 <select  name="activitytypeid">
								  </select>
								</div>
							  </div>
							  <div class="control-group" id = "activitystatus">
								<label class="control-label">活动状态*</label>
								<div class="controls">
								  	<select name = "activitystatus">
										<option value="已开展" id = "activitystatus1">已开展</option>
										<option value="未开展" id = "activitystatus2">未开展</option>
									</select>
								</div>
							  </div>
							  <div class="control-group" id = "activitydate">
								<label class="control-label">活动时间*</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "activitydate" type="text" onClick="laydate()" value="" placeholder="活动时间" required>
								</div>
							  </div>
							  <div class="control-group" id = "branchname">
								<label class="control-label">所属分店*</label>
								<div class="controls">
								  <select name="branchid">
								  	
								  </select>
								</div>
							  </div>
							   <%-- <div class="control-group" id = "entrytime">
								<label class="control-label">入职时间</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "entrytime" type="text" value="<fmt:formatDate value="${employeeInfo.entrytime }"pattern="yyyy-MM-dd" />">
								</div>
							  </div> --%>
							  <div class="control-group" id = "activityprice">
								<label class="control-label">活动支出*</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">$</span><input id="" size="16" type="text" name = "activityprice" placeholder="活动支出" digits=true required><span class="add-on">.00</span>
								  </div>
								</div>
							  </div>
							  
							  <div class="control-group" id = "registeryfee">
								<label class="control-label">活动报名费*</label>
								<div class="controls">
								  <div class="input-prepend input-append">
									<span class="add-on">$</span><input id="" size="16" type="text" name = "registeryfee" placeholder="活动报名费" digits=true required><span class="add-on">.00</span>
								  </div>
								</div>
							  </div>
							  
							  <div class="control-group" id = "maxnum">
								<label class="control-label">人数上限*</label>
								<div class="controls">
									<div class="input-prepend input-append">
										<input id="appendedPrependedInput" size="16" type="text" name = "maxnum" value="" digits=true required><span class="add-on">人</span>
								    </div>
								</div>
							  </div>
							  
							 <!--  <div class="control-group" id = "employeestatus">
								<label class="control-label">账号状态</label>
								<div class="controls">
								  <select name="employeestatus">
								  	<option value = "正常" id="statusNormal" selected="selected">正常</option>
									<option value = "休假" id="statusAbnormal">休假</option>
									<option value = "辞职" id="statusAbnormal">辞职</option>
								    <option value = "其他" id="statusAbnormal">其他</option>
								  </select>
								</div>
							  </div>
							  -->
							   <div class="control-group" id = "online">
								<label class="control-label">线上*</label>
								<div class="controls">
								  <select id="" data-rel="" name="online">
								  	<option value=true id ="true">是</option>
								  	<option value=false id = "false" selected="selected">否</option>
								  </select>
								</div>
							  </div>
							  
							  <div class="control-group" id = "videoHref" style="display: none;">
								<label class="control-label">活动链接</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "videoHref" type="text">
								</div>
							  </div>
							  
							  <div class="control-group" id = "activitypicture">
								<label class="control-label">上传图片</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "pictureUpload" type="file">
								</div>
							  </div>
							  
							  <div class="control-group" id = "video">
								<label class="control-label">上传视频</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "videoUpload" type="file">
								</div>
							  </div>
							  
							  
							  <div class="control-group hidden-phone" id = "activitydetails">
								  <label class="control-label">活动详情</label>
								  <div class="controls">
									<textarea class="" id="" rows="6"  name="activitydetails" style="width: 500px;"></textarea>
								  </div>
							  </div>
							  
							  
							  
							 <input type="hidden" value = "${message }" id = "message">
							  
							  <div class="form-actions">
								<button type="submit" id = "addEmployee" class="btn btn-primary">保存</button>
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
	
	<input type = "hidden" id = "message" value = "${message }">
	
	<script type="text/javascript">
	$(document).ready(function(){
	//显示提示信息
		var message = $("#message").val();
		if(message != ""){
	
			
			$("#showMessage").text(message);
			$('#messageNotification').fadeIn(2000);
			getSrceenWH();
			$('#messageNotification').fadeOut(3000);
		}
		
	})
		
	</script>
	
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
		
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/admin/page/js/addActivity.js"></script>
	
	<script 
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.1.8.1.min.js"></script>
	<script 
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.messages_zh.js"></script>
		
	<script src="${pageContext.request.contextPath }/jsp/admin/page/js/laydate.js"></script>
	
		
	<script>

		$(document).ready(function() {
			$("#regEmployee").validate();
		});
</script>
	<!-- end: JavaScript-->
	
<!-- 	<script type="text/javascript">
		$(document).ready(function(){
			var positional = $("#authorityid").attr("value");
			var positional = $("#positional").attr("value");
			var positional = $("#areaid").attr("value");
			var positional = $("#branchid").attr("value");
		});
	
	</script> -->
	
</body>
</html>

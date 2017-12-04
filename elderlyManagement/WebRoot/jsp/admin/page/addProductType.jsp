<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>商品分类添加</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="zb">
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
					<a href="${pageContext.request.contextPath }/jsp/admin/page/branch.jsp">分店管理</a>
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/jsp/admin/page/mallInfo.jsp">商城管理</a>
					<i class="icon-angle-right"></i>
				</li>
				<li><a href="#">商品添加</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>商品分类添加</h2>
						<h2 id = "adminMall"></h2>
						<div class="box-icon">
							<!-- <a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a> -->
							<a href="" id = "updateProductUrl"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
					
					<div class="box-content">
						<form class="form-horizontal" action = "${pageContext.request.contextPath }/superAdmin/addProduct" method="post" enctype="multipart/form-data">
							<fieldset>
							 
							 <div style="height: 20px;padding-bottom: 20px;">
							 	<select id = "selectType">
									<option>空</option>
								 	<option value = "0">添加商品大类</option>
								 	<option value = "1">添加商品小类</option>
								</select>
							 </div>
							 
							 
							 <div id = "fatherType" style="display: none;">
							 	<div class="control-group" id = "fathertypename">
									<label class="control-label">商品父类类型</label>
									<div class="controls">
									  <input type="text" value="" id = "fathertypeid">
									  <p id = "fatherType-name-error" style="color: red;display: none;">名字不能包含特殊字符，最少1个字符</p>
									</div>
								  </div>
							 </div>
							  
							   <div id = "smallType" style="display: none;">
								   	<div class="control-group" id = "smallFathertypename">
									<label class="control-label">商品父类类型</label>
									<div class="controls">
									  <select name = "smallfathertypeid">
									  </select>
									</div>
								  </div>
								  
								  <div class="control-group" id = "producttypename">
									<label class="control-label">商品分类名字</label>
									<div class="controls">
									  <input class="input-xlarge focused" name = "producttypename" type="text" value="">
									  <p id = "producttype-name-error" style="color: red;display: none;">名字不能包含特殊字符，最少1个字符</p>
									</div>
								  </div>
							   
							   </div>
							  
							  <div class="form-actions">
							  	<button type="button" class="btn btn-primary" id = "addFatherType" style="display: none;">保存</button>
							  	<button type="button" class="btn btn-primary" id = "addProductType" style="display: none;">保存</button>
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
		src="${pageContext.request.contextPath }/jsp/admin/page/js/addProductType.js"></script>
	
	<!-- end: JavaScript-->
	
</body>
</html>

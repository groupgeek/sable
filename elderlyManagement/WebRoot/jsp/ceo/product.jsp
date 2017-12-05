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
	height:355px;
	width:100%;
    padding-up:10px;
    padding-left:0px;
	}
	#center{
	height:100px;
	width:100%;
	}
	#nav {
   	 line-height:30px;
  	 height:100%;
  	 width:40%;
   	 float:left;
   	 padding:5px;	      
	}
	#section {
	height:100%;
   	 width:49%;
   	 float:left;
   	 padding:10px;	 	 
	}
	#section1{
	width:100%;
	height:140px;
	}
	#image1{ 
       	padding-left:10%;
        width:300px; 
        height:350px;
        float:left; 
 
    }
    #footer{
    	width:100%;
    	height:100%;	 	
    }
    .message{
    	padding-left:30%;
    	width:900px;
    	height:100px;
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
					<a href="${pageContext.request.contextPath }/ceo/producttable.action">商品信息</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li><a>商品详细信息</a></li>
			</ul>
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>商品详情</h2>
						<div class="box-icon">
							<a href="${pageContext.request.contextPath }/ceo/producttable.action" ><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<form class="form-horizontal" action="">
							<fieldset>
							<input type="hidden" name="productid" value="${findProductById.productid }"  />
							<div style="padding-bottom: 30px">
								<div id="header">
									
									<div id="nav">
										<%
											String id = request.getParameter("productid");
											int a = Integer.valueOf(id);
						 				%>
						 				<input type="hidden" id="productid" value="<%=a %>">
										<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
										<div class="control-group" id="picture">
											<label class="control-label" for="disabledInput">商品照片</label>
											<div class="controls" id="section1">
								  				<img id="image1" src="">
											</div>
							  			</div>							
									</div>
									<div id="section">
										<div class="control-group">
											<label class="control-label" for="disabledInput">商品名称</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productname" value="${findProductById.productname }" disabled="">
											</div>
							  			</div>
							   			<div class="control-group">
							 				<label class="control-label" for="typeahead">商品存货 </label>
							  				<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="instock" value="${findProductById.instock }" disabled="">
							  				</div>
							  			</div>
							 			 <div class="control-group">
											<label class="control-label" for="optionsCheckbox2">商品单价</label>
											<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="price" value="${findProductById.price }" disabled="">
							  				</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">成交量</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="buyno" value="${findProductById.buyno }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">商品进价</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="purchaseprice" value="${findProductById.purchaseprice }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">好评量</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="good" value="${findProductById.good }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">保质期</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="shelflife" value="${findProductById.shelflife }" disabled="">
											</div>
							  			</div>
									</div>
									
								</div>
								<div id="center">
								<div id="nav">
									<div class="control-group">
										<label class="control-label" for="disabledInput">产品标准号</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="producstandards" value="${findProductById.producstandards }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label">产品规格</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productspecifications" value="${findProductById.productspecifications }" disabled="">
							  			</div>
							  		</div>							  		
								</div>
								<div id="section">
									<div class="control-group">
										<label class="control-label" for="disabledInput">生产许可证号码</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productionlicensenumber" value="${findProductById.productionlicensenumber }" disabled="">
							  			</div>
							  		</div>					  
								</div>
								</div>
								<div id="footer">
									<div class="control-group">
										<label class="control-label" for="disabledInput">商品描述</label>
										<div class="controls">
											<textarea rows="4" disabled="" style="width: 700px; background-color: #FCFCFC;">${findProductById.description }</textarea>					  
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">存储方式</label>
										<div class="controls">
											<textarea rows="4" disabled="" style="width: 700px; background-color: #FCFCFC;">${findProductById.storagemethod }</textarea>
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label" for="disabledInput">食用方法</label>
										<div class="controls">
											<textarea rows="4" disabled="" style="width: 700px; background-color: #FCFCFC;">${findProductById.ediblemethod }</textarea>
							  			</div>
							  		</div>
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/oneproduct.js"></script>
	<!-- end: JavaScript-->
	
</body>
</html>

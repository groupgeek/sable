<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>商品详情</title>
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
<link id="superAdmin"
	href="${pageContext.request.contextPath }/jsp/admin/page/css/superAdmin.css"
	rel="stylesheet">
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
				<a class="brand" href="index.html"><span>商品详情</span></a>
								
				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<li class="dropdown hidden-phone">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								
							</a>
							
						</li>
						<!-- end: Notifications Dropdown -->
						<!-- start: Message Dropdown -->
						
						
						<!-- start: User Dropdown -->
						<li class="dropdown">
							<a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="halflings-icon white user"></i> ${admins.employeename }
								<span class="caret"></span>
							</a>
								<ul class="dropdown-menu">
								<li class="dropdown-menu-title">
 									<span>账号设定</span>
								</li>
							
								<li><a href="${pageContext.request.contextPath }/productmanage/loginout.action"><i class="halflings-icon off"></i>退出登录</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->
				
			</div>
		</div>
	</div>
	<!-- start: Header --><div class="copyrights">Collect from <a href="#" >颐养天年</a></div>
	
			<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
				<%-- 		<li id = "home"><a href="JavaScript:;"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">主页</span>
						</a>
						</li>
						<li id = "userInfo"><a href="${pageContext.request.contextPath }/jsp/admin/page/userInfo.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">客户信息管理</span>
						</a>
						</li>
						<li><a href="JavaScript:;"><i class="icon-envelope"></i><span
								class="hidden-tablet">员工信息管理</span>
						</a>
						</li>
						<li><a href="JavaScript:;"><i class="icon-tasks"></i><span
								class="hidden-tablet"> 报表统计</span>
						</a>
						</li>
						<li><a href="JavaScript:;"><i class="icon-eye-open"></i><span
								class="hidden-tablet">活动管理</span>
						</a>
						</li>
						<li><a href="JavaScript:;"><i class="icon-dashboard"></i><span
								class="hidden-tablet">商城管理</span>
						</a>
						<li><a href="JavaScript:;"><i class="icon-dashboard"></i><span
								class="hidden-tablet">留言管理</spa --%>
							
								<li><a href="#"><i class="halflings-icon user"></i> 个人中心</a></li>
								<li><a href="${pageContext.request.contextPath }/jsp/productmanage/logReg/login.jsp"><i class="halflings-icon off"></i>退出登录</a></li>
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
						<li><a href="${pageContext.request.contextPath }/productmanage/producttype.action"><i class="icon-comment"></i><span class="hidden-tablet"> 增加商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/stockout.action"><i class="icon-user"></i><span class="hidden-tablet">缺货商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/NoproductRecommend.action"><i class="icon-thumbs-up"></i><span class="hidden-tablet"> 推荐商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/quertyPopularProduct.action"><i class="icon-random"></i><span class="hidden-tablet">热销商品</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/recommendproduct.action"><i class="icon-briefcase"></i><span class="hidden-tablet">本店推荐</span></a></li>
						<li><a href="${pageContext.request.contextPath }/productmanage/quertyProduct.action"><i class=" icon-shopping-cart"></i><span class="hidden-tablet">商品信息</span></a></li>						
				</ul>
				</div>
			</div>
				

			<!-- start: Content -->
			
			<div id="content" class="span10">
			
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white edit"></i><span class="break"></span>商品详情</h2>
						<div class="box-icon">
					<!-- 		<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a> -->
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
						</div>
					</div>
				<form  class="form-horizontal" action="${pageContext.request.contextPath }/productmanage/update.action"   method="post" enctype="multipart/form-data">
			
					<div class="box-content">
							 <input type="hidden" name="productid" value="${product.productid }" >
							<fieldset>
							  <div class="control-group" id = "productname">
								<label class="control-label">商品名</label>
								<div class="controls">
								 
								  <input class="input-xlarge" type="text" id="grumble" name="productname" value="${product.productname}"/>
							
								</div>
							  </div>
							  	  <div class="control-group" id = "picture">
								<label class="control-label">图片</label>
								
								  <img class="img-responsive"  src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${product.picture }" alt="" style="width:100px;height:80px"/>
							
							  </div>
							  <div class="control-group" id = "producPpicture">
								<label class="control-label">更改图片</label>
								<div class="controls">
								  <input class="input-xlarge focused" name = "producPpicture" type="file">
								</div>
							  </div>
							  <div class="control-group" id = "instock">
								<label class="control-label">库存</label>
								<div class="controls">
								<input class="input-xlarge " type="text" class="warning" name="instock" value="${product.instock}" />
								  
								</div>
							  </div>
							  <div class="control-group" id = "price">
								<label class="control-label">价格</label>
								<div class="controls">
								
								   <input class="input-xlarge"   name="price" value="${product.price}"/>
								 
								</div>
							  </div>
							  
							  <div class="control-group" id = "producttypeid">
								<label class="control-label">类别</label>
								
								<div class="controls">
                              <input class="input-xlarge "  name="producttypeid"  value="${product.producttypeid}"/>
                             
								</div>
							  </div>
							   <div class="control-group" id = "productname">
								<label class="control-label">状态</label>
								<div class="controls">
								  
								  <input class="input-xlarge" type="text" id="picture" name="picture" value="${prodcut.picture}"/>
							
								</div>
							  </div> 
							 
							  
							  <div class="control-group" id = "buyno">
								<label class="control-label">购买次数</label>
								<div class="controls">
								
								   <input class="input-xlarge" readonly="readonly"  name="buyno" value="${product.buyno}"/>
								 
								</div>
							  </div>
							  
							
							  
							   <div class="control-group" id = "discount">
								<label class="control-label">折扣</label>
								<div class="controls">
								
								   <input class="input-xlarge"   name="discount" value="${product.discount}"/>
								 
								</div>
							  </div>
							  
							  
							  
							
							  
							  	   <div class="control-group" id = "good">
								<label class="control-label">货物</label>
								<div class="controls">
								
								   <input class="input-xlarge"   name="good" value="${product.good}"/>
								 
								</div>
							  </div>
							  
							  
							 
							     <div class="control-group" id = "branchid">
								<label class="control-label">起源</label>
								<div class="controls">
								  <input type="text" class="input-xlarge " readonly="readonly"  name="origin"  value="${product.origin}"/>
								</div>
							  </div>
							  
							  	   <div class="control-group" id = "productspecifications">
								<label class="control-label">商品规格扣</label>
								<div class="controls">
								
								   <input class="input-xlarge"    name="productspecifications" value="${product.productspecifications}"/>
								 
								</div>
							  </div>
							
								  	   <div class="control-group" id = "shelflife">
								<label class="control-label">保质期</label>
								<div class="controls">
								
								   <input class="input-xlarge" readonly="readonly" name="shelflife" value="${product.shelflife}"/>
								 
								</div>
							  </div>
								  	   <div class="control-group" id = "producstandards">
								<label class="control-label">商品标准号</label>
								<div class="controls">
								
								   <input class="input-xlarge"  readonly="readonly"  name="producstandards" value="${product.producstandards}"/>
								 
								</div>
							  </div>
							 
							
							  		  	   <div class="control-group" id = "productionlicensenumber">
								<label class="control-label">商品生产许可</label>
								<div class="controls">
								   <input class="input-xlarge" readonly="readonly" name="productionlicensenumber" value="${product.productionlicensenumber}"/>
								 
								</div>
							  </div>
							 
							  		  	   <div class="control-group" id = "storagemethod">
								<label class="control-label">存储方法</label>
								<div class="controls">
								   <input class="input-xlarge" readonly="readonly"  name="storagemethod" value="${product.storagemethod}"/>
								 
								</div>
							  </div>
							  
							 
							  
							   		  	   <div class="control-group" id = "ediblemethod">
								<label class="control-label">食用方法</label>
								<div class="controls">
								   <input class="input-xlarge"   name="ediblemethod" value="${product.ediblemethod}"/>
								 
								</div>
							  </div>
							 
							 		  <div class="control-group" id = "description">
								<label class="control-label">商品描述</label>
								<div class="controls">
								   <input class="input-xlarge"   name="description" value="${product.description}"/>
								 
								</div>
							  </div>
							   </fieldset>
							  </div> 
							  <div class="form-actions">
								<button type="submit" class="btn btn-primary">提交</button>
								
							  </div>
							
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
	
<%-- 	<script
		src="${pageContext.request.contextPath }/jsp/admin/page/js/userInfo.js"></script>	 --%>
	
	<!-- end: JavaScript-->
</body>
</html>

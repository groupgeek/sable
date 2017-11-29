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
	<link href="${pageContext.request.contextPath }/jsp/ceo/newcss/allchart.css" rel="stylesheet">
	<!-- end: CSS -->
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="img/favicon.ico">
	<!-- end: Favicon -->
	<style type="text/css">
		#box td{
			vertical-align: middle;   		
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
				<li><a href="#">报表</a></li>
			</ul>
			<div id="tou">
				<div id="zhong">
					<form class="branchsumbit" name="myform" method="get">
						<label><span id="juzhong" class="btn btn-info btn-setting">选择分店：</span>
						<select id="branchchart" name="branchchart">
							<option value ="-1">--请选择--</option>
        					<c:forEach items = "${branchCustoms}" var= "branch">
        						<option value="${branch.branchid}">${branch.branchname }</option>
        					</c:forEach>
    					</select>    					
    					</label>   					
    					<input type="hidden" id = "root" value="${pageContext.request.contextPath }">  				
					</form>
				</div>
				<div id="zhonghou">
					<a id="branchproductcharts" href="#" class="btn btn-info">查看该分店的商品报表</a>
				</div>
				<div id="zhonghou">
					<a id="branchactivitycharts" href="#" class="btn btn-info">查看该分店的活动报表</a>
				</div>
				<div id="hou">			
					<a href="${pageContext.request.contextPath }/jsp/ceo/allproductchart.jsp" class="btn btn-info">查看总商品报表</a>
				</div>					
				<div id="hou">
					<a href="${pageContext.request.contextPath }/jsp/ceo/allactivitychart.jsp" class="btn btn-info">查看总活动报表</a>
				</div>
			</div>
			<div class="row-fluid sortable">		
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>商品报表</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>		
						</div>
					</div>
					<div class="box-content" id="box">
							<div>
								<div id="pageNumBox">
									<select id="selectPageNum">
										<option value="5">5</option>
										<option value="10" selected="selected">10</option>
										<option value="20">20</option>
									</select>
								</div>
								<select id="selectSort">
									<!-- <option>排序方式</option> -->
									<option value="buynum">销售量</option>
									<option value="price">商品单价</option>	
									<option value="getprice">销售收入</option>
									<!-- <option>0.0</option> -->
								</select>  
								<input type="text" id="search" placeholder="搜索">

							</div>
						<table  class="table table-striped table-bordered bootstrap-datatable">
						 <thead>
							  <tr>
							  	  <th>商品名称</th>	
							  	  <th>所属分店</th>
								  <th>商品单价</th>
								  <th>销售量</th>
								  <th>销售收入</th>								 
								  <th style="width:200px;">查看报表</th>
							  </tr>
						</thead>
						<tbody>
							
						</tbody>						  
					  </table> 
					  		<div class="page">
								<div id="employeePage">
									<p>
										当前为第<strong id="currentPage">1</strong>页,共<strong id="pageSum">0</strong>页
									</p>
								</div>

								<ul class="am-pagination am-pagination-right" id="pageUl">
									<li value=1 id="home"><a href="javascript:;">首页</a></li>
									<li id="previousPage"><a href="javascript:;">上一页</a></li>
									<li id="nextPage"><a href="javascript:;">下一页</a></li>
									<li id="lastPage"><a href="javascript:;">尾页</a></li>
								</ul>
							</div>           
					</div>
				</div><!--/span-->			
			</div><!--/row-->		
			<div class="row-fluid sortable">
				<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white picture"></i><span class="break"></span> 活动报表</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>		
						</div>						
					</div>
					<div class="box-content" id="actchart">
						<div>
								<div id="pageNumBox">
									<select id="selectPageNumofactivity">
										<option value="5">5</option>
										<option value="10" selected="selected">10</option>
										<option value="20">20</option>
									</select>
								</div>
								<select id="selectSortofactivity">
									<!-- <option>排序方式</option> -->
									<option value="totalprice">活动收入</option>
									<option value="averagepeople">参与人数</option>	
									<option value="totalexpenditure">活动支出</option>
									<!-- <option>0.0</option> -->
								</select>  
								<input type="text" id="searchofactivity" placeholder="搜索">

							</div>
						<table class="table table-striped table-bordered bootstrap-datatable">
						  <thead>
							  <tr>
							  	  <th>活动名称</th>
								  <th>开设分店</th>
								  <th>活动收入</th>
								  <th>活动支出</th>
								  <th>参与人数</th>
								  <th style="width:200px;">查看报表</th>
							  </tr>
						  </thead>
						  <tbody>
							
						  </tbody>						  	
					  </table>
					 		<div class="page">
								<div id="employeePage">
									<p>
										当前为第<strong id="currentPageofactivity">1</strong>页,共<strong id="pageNumofact">0</strong>页
									</p>
								</div>

								<ul class="am-pagination am-pagination-right" id="pageofactUl">
									<li value=1 id="homeofact"><a href="javascript:;">首页</a></li>
									<li id="previousPageofact"><a href="javascript:;">上一页</a></li>
									<li id="nextPageofact"><a href="javascript:;">下一页</a></li>
									<li id="lastPageofact"><a href="javascript:;">尾页</a></li>
								</ul>
							</div>
					</div>
					<hr>						
				</div><!--/span-->			
			</div><!--/row-->    
	</div><!--/.fluid-container-->	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->	
	<div class="clearfix"></div>	
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
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/allchart.js"></script>
	<!-- end: JavaScript-->
	
  </body>
</html>

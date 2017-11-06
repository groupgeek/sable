<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5 Transitional//EN">
<html lang="en">
<head>
	
	<!-- start: Meta -->
	<meta charset="utf-8">
	<title>Bootstrap Metro Dashboard by Dennis Ji for ARM demo</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="superAdmin"
	href="${pageContext.request.contextPath }/jsp/brach/css/user_employee.css"
	rel="stylesheet">
	<link id="bootstrap-style" href="${pageContext.request.contextPath }/jsp/brach/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/jsp/brach/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="${pageContext.request.contextPath }/jsp/brach/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="${pageContext.request.contextPath }/jsp/brach/css/style-responsive.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/brach/img/favicon.ico">
	<!-- end: Favicon -->
	
		
		
		
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>		
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

			<div>

					<div class="control-group" style="margin-top: 30px" >
						<h3>选择分店：</h3>
						<div class="controls">
							<select id="activitystatus">
								<c:forEach items="${findBranchs }" var="branch">
									<option value="${branch.branchid }">${branch.branchname }</option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="control-group" style=" position: absolute;left:300px; top:70px" >
					
							  <h3>运营间隔：</h3>
							  <div class="controls">
								从：<input name="activitydate" onClick="laydate()" id="begin">&nbsp&nbsp&nbsp&nbsp
								至：<input name="activitydate" onClick="laydate()" id="end">&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
								 <a class="btn btn-info" href="javaScript:;" onclick="productReport()">
										<i class="icon-ok-sign"></i>            确认查询                                
									</a>
							  </div>
					</div>
					
					</div>
					
					

			<div class="row-fluid sortable">
			
			
			<div class="box span12">
					<div class="box-header" data-original-title>
						<h2><i class="halflings-icon white user"></i><span class="break"></span>分店收益报表</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content" id="ddd">
						<table class="table table-striped table-bordered bootstrap-datatable " >
						  <thead>
						  <tr>
							  	<th>分店名字</th>
								<th>总收入</th>
								<th>总支出</th>
								<td>合计</td>
						 </tr>
						 <tr>
							   <td>${findBranchs[0].branchname }</td>
							   <td>${branchtTotalreport.sumtotalprice }</td>
							   <td>${branchtTotalreport.sumtotalexpenditure }</td>
							   <td>${branchtTotalreport.sumtotalprice-branchtTotalreport.sumtotalexpenditure }</td>
						 </tr>
							</thead>
							
							<tr>
							  	<th>商城收入</th>
								<th>消费人数</th>
								<th>活动收入</th>
								<th>参与人数</th>
							  </tr>
							  <tbody>
							  </tbody>
							 
						 
						 
					  </table> 
					  
					  <div class="page">
								<div id="userPage">
									<p>
										当前为第<strong id="currentPage">1</strong>页,共<strong id="pageSum">0</strong>页
									</p>
								</div>

								<ul class="am-pagination am-pagination-right" id="pageUl">
									<li value=1 id="home"><a href="javascript:;">首页</a></li>
									<li id="previousPage"><a href="javascript:;">&laquo;</a></li>
									<li id="nextPage"><a href="javascript:;">&raquo;</a></li>
									<li id="lastPage"><a href="javascript:;">尾页</a></li>
								</ul>
							</div>
					             
					</div>
				</div>

					<!-- <div class="box span6">
					<div class="box-header">
						<h2><i class="halflings-icon white list-alt"></i><span class="break"></span>商品收支百分比饼图</h2>
						<div class="box-icon">
							<a href="#" class="btn-setting"><i class="halflings-icon white wrench"></i></a>
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					custom.js 1627行代码
							<div id="piechart" style="height:300px"></div>
					</div>
				</div> -->
			</div><!--/row-->
		
			<hr>
		
			
			
		
		

	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
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
			<span style="text-align:left;float:left">&copy; 2017 <a href="downloads/janux-free-responsive-admin-dashboard-template/" alt="Bootstrap_Metro_Dashboard">欢迎使用Ceo专用管理站点！</a></span>
			<a>  使用者：${findCeoById.ceoid }</a>
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
		<script src="${pageContext.request.contextPath }/jsp/brach/js/laydate.js"></script>
	<!-- end: JavaScript-->
	<script type="text/javascript">
	
		function productReport() {
			//var select = document.getElementById("activitystatus").value;
			//alert(select);
			//var begin = document.getElementById("begin").value;
			//var end = document.getElementById("end").value;
			$.ajax({
						type : 'post',
						url : '${pageContext.request.contextPath}/ceo/requestchart.action',
						contentType : 'application/json;charset=utf-8',
						data : '{"branchid"' + ':' + '"' + select + '"'+','+'"startingTime"'+':'+'"'+begin+'"'+','+'"endTime"'+':'+'"'+end+'"'+'}',
						success : function(data) {
							//alert("查询成功");
							$("#ddd tbody").html("");
							createbranchTable(data);
						},
						error : function() {
							$("#ddd tbody").html("");
							alert("没有查询到任何数据！");
						}

					});
			
			function createbranchTable(data){
			//alert("start");
			for(var i in data){
				$("#ddd tbody").append(
							'<tr>'+
							'<td class="center">'+ data[i].branchname +'</td>'+
							'<td class="center">'+'<fmt:formatDate value="${data[i].duringtime }" pattern="yyyy-MM-dd"/> '+'</td>'+
							'<td class="center">'+ data[i].sumtotalprice+'</td>'+
							'<td class="center">'+ data[i].sumtotalexpenditure +'</td>'+
							'</tr>'
							);
					}
		}
			
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");//每页的条数
			currentPage = 1;//当前页
			$.ajax({
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllUser",
				data:'{"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#box tbody").html("");
					$("#home").attr("value",1);
					$("#previousPage").attr("value",1);
					$("#nextPage").attr("value",1);
					$("#lastPage").attr("value",data.pageSum);
					$("#pageSum").text(data.pageSum);
					$("#currentPage").text(currentPage);
					createUserTable(data);
				}
			});
		}			

		}
	</script>
	
	
	
</body>
</html>

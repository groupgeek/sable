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
	<title>管理员界面</title>
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
				<li><a href="#">管理中心</a></li>
			</ul>

			<div class="row-fluid">
				
				<div class="span3 statbox purple" onTablet="span6" onDesktop="span3">
					<div class="boxchart">
						<c:forEach items="${sumBigDecimalByTim }" var="a">${a },</c:forEach>
					</div>
					<div class="number">￥${sumAllBigDecimal[0] }${sumAllBigDecimal[1] }</div>									
					<div class="title">${sumBigDecimalByTim[0] }</div>			
					<div class="footer">
						<a>公司盈利总额</a>
					</div>	
				</div>
				<div class="span3 statbox green" onTablet="span6" onDesktop="span3">
					<div class="boxchart">
						<c:forEach items="${sumProductMoneyByTime }" var="b">${b },</c:forEach>
					</div>
					<div class="number" >￥${sumProductAllMoney[0] }${sumProductAllMoney[1] }</div>
					<div class="title">${sumProductMoneyByTime[0] }</div>
					<div class="footer">
						<a>商城盈利总额</a>
					</div>
				</div>
				<div class="span3 statbox blue noMargin" onTablet="span6" onDesktop="span3">
					<div class="boxchart">
						<c:forEach items="${findSumActivities }" var="j">${j },</c:forEach>
					</div>
					<div class="number">￥${sumActivityBigdecimal[0] }${sumActivityBigdecimal[1] }</div>
					<div class="title">${findSumActivityregisteryFeeByTime[0] }</div>
					<div class="footer">
						<a>活动盈利总额</a>
					</div>
				</div>
				<div class="span3 statbox yellow" onTablet="span6" onDesktop="span3">		
					<div class="boxchart">
						<c:forEach items="${alluserByTime }" var="i">${i },</c:forEach>
					</div>
					<div class="number">${alluser[0] }${alluser[1] }人</i></div>
					<div class="title">${alluserByTime[0] }</div>
					<div class="footer">
						<a>公司总用户量</a>
					</div>
				</div>	
				
			</div>		
				
			<div class="row-fluid">
				
				<div class="widget blue span5" onTablet="span6" onDesktop="span5">
					
					<h2><span class="glyphicons globe"><i></i></span>分店总盈利前十名</h2>
					
					<hr>
					
					<div class="content">
						
						<div class="verticalChart">
							<c:forEach items = "${findTotalreportandBranch }" var="k">
								<div class="singleBar">
									<div class="bar">
										<div class="value">
											<span>${k.stringbigdecimal }</span>
										</div>								
									</div>								
									<div class="title">${k.branchname }</div>							
								</div>
							</c:forEach>

							<div class="clearfix"></div>
							
						</div>
					
					</div>
					
				</div><!--/span-->
				
				<div class="widget blue span5" onTablet="span6" onDesktop="span5">
					
					<h2><span class="glyphicons globe"><i></i></span>分店总用户前十名</h2>
					
					<hr>
					
					<div class="content">
						
						<div class="verticalChart">
							<c:forEach items = "${findUserCustoms }" var="m">
								<div class="singleBar">
									<div class="bar">
										<div class="value">
											<span>${m.stringuser }</span>
										</div>								
									</div>								
									<div class="title">${m.branchname }</div>							
								</div>
							</c:forEach>

							<div class="clearfix"></div>
							
						</div>
					
					</div>
					
				</div><!--/span-->
			
			</div>
			
			<div class="row-fluid">
				
				<div class="box black span4" onTablet="span6" onDesktop="span4">
					<div class="box-header">
						<h2><i class="halflings-icon white list"></i><span class="break"></span>热销商品</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<ul class="dashboard-list metro">
							<c:forEach items = "${findHotProduct }" var="l">
								<li>
									<a href="${pageContext.request.contextPath }/ceo/product.action?productid=${l.productid}">
										<i class="icon-arrow-up green"></i>                               
										<strong>${l.productid }</strong>
										${l.productname } 							      
									</a>
								</li>
							</c:forEach>
						  <li>		
						</ul>
					</div>
				</div><!--/span-->
				
				<div class="box black span4" onTablet="span6" onDesktop="span4">
					<div class="box-header">
						<h2><i class="halflings-icon white user"></i><span class="break"></span>新用户</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<ul class="dashboard-list metro">
							<li class="green">
								<a href="${pageContext.request.contextPath }/ceo/user.action?userid=${findFourUser[0].userid}">
									<img class="avatar" alt="${findFourUser[0].username }" src="img/avatar.jpg">
								</a>
								<strong>姓名：</strong> ${findFourUser[0].username}<br>
								<strong>性别：</strong> ${findFourUser[0].sex }<br>
								<strong>注册时间：</strong> ${findFourUser[0].stringregistrationdate }             
							</li>
							<li class="yellow">
								<a href="${pageContext.request.contextPath }/ceo/user.action?userid=${findFourUser[1].userid}">
									<img class="avatar" alt="${findFourUser[1].username }" src="img/avatar.jpg">
								</a>
								<strong>姓名：</strong> ${findFourUser[1].username }<br>
								<strong>性别：</strong> ${findFourUser[1].sex }<br>
								<strong>注册时间：</strong> ${findFourUser[1].stringregistrationdate }                                
							</li>
							<li class="red">
								<a href="${pageContext.request.contextPath }/ceo/user.action?userid=${findFourUser[2].userid}">
									<img class="avatar" alt="${findFourUser[2].username }" src="img/avatar.jpg">
								</a>
								<strong>姓名：</strong> ${findFourUser[2].username }<br>
								<strong>性别：</strong> ${findFourUser[2].sex }<br>
								<strong>注册时间：</strong> ${findFourUser[2].stringregistrationdate }                                
							</li>
							<li class="blue">
								<a href="${pageContext.request.contextPath }/ceo/user.action?userid=${findFourUser[3].userid}">
									<img class="avatar" alt="${findFourUser[3].username }" src="img/avatar.jpg">
								</a>
								<strong>姓名：</strong> ${findFourUser[3].username }<br>
								<strong>性别：</strong> ${findFourUser[3].sex }<br>
								<strong>注册时间：</strong> ${findFourUser[3].stringregistrationdate }                        
							</li>
						</ul>
					</div>
				</div><!--/span-->
				
				<div class="box black span4 noMargin" onTablet="span12" onDesktop="span4">
					<div class="box-header">
						<h2><i class="icon-envelope-alt"></i><span class="break"></span>新留言</h2>
						<div class="box-icon">
							<a href="#" class="btn-minimize"><i class="halflings-icon white chevron-up"></i></a>
							<a href="#" class="btn-close"><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
						<div class="todo metro">
							<ul class="todo-list">
								<li class="red">
									<i class="icon-envelope-alt"></i>	
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[0].messageid }">${findNewMessage[0].username } </a>
									<strong>${findNewMessage[0].stringDate }</strong>
								</li>
								<li class="red">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[1].messageid }">${findNewMessage[1].username } </a>
									<strong>${findNewMessage[1].stringDate }</strong>
								</li>
								<li class="yellow">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[2].messageid }">${findNewMessage[2].username } </a>
									<strong>${findNewMessage[2].stringDate }</strong>
								</li>
								<li class="yellow">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[3].messageid }">${findNewMessage[3].username } </a>
									<strong>${findNewMessage[3].stringDate }</strong>
								</li>
								<li class="green">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[4].messageid }">${findNewMessage[4].username } </a>
									<strong>${findNewMessage[4].stringDate }</strong>
								</li>
								<li class="green">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[5].messageid }">${findNewMessage[5].username } </a>
									<strong>${findNewMessage[5].stringDate }</strong>
								</li>
								<li class="blue">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[6].messageid }">${findNewMessage[6].username } </a>
									<strong>${findNewMessage[6].stringDate }</strong>
								</li>
								<li class="blue">
									<i class="icon-envelope-alt"></i>
									<a href="${pageContext.request.contextPath }/ceo/messages.action?id=${findNewMessage[7].messageid }">${findNewMessage[7].username } </a>
									<strong>${findNewMessage[7].stringDate }</strong>
								</li>
							</ul>
						</div>	
					</div>
				</div>
			
			</div>
			<div class="row-fluid">	

				<a class="quick-button metro yellow span2">
					<i class="icon-group"></i>
					<p>用户</p>
					<span class="badge">${alluser[0] }${alluser[1] }人</span>
				</a>
				<a class="quick-button metro red span2">
					<i class="icon-comments-alt"></i>
					<p>活动</p>
					<span class="badge">${allActivity }</span>
				</a>
				<a class="quick-button metro blue span2">
					<i class="icon-shopping-cart"></i>
					<p>订单</p>
					<span class="badge">${allorders }</span>
				</a>
				<a class="quick-button metro green span2">
					<i class="icon-calendar"></i>
					<p>商品</p>
					<span class="badge">${findCountProduct }</span>
				</a>
				<a class="quick-button metro pink span2">
					<i class="icon-envelope"></i>
					<p>留言</p>
					<span class="badge">${findCountMessage }</span>
				</a>
				<a class="quick-button metro black span2">
					<i class="icon-barcode"></i>
					<p>Calendar</p>
				</a>
				
				<div class="clearfix"></div>
								
			</div><!--/row-->
			
       

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
	<!-- end: JavaScript-->
  </body>
</html>

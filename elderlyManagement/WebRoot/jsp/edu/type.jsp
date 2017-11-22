<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta name="description" content="">
    <meta name="author" content="">
	
    <title>分类</title>
	
    <!-- Bootstrap Core CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/css/bootstrap.min.css"  type="text/css">
	
	<!-- Custom CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/css/style.css">
	
	
	<!-- Custom Fonts -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/font-awesome/css/font-awesome.min.css"  type="text/css">
    <link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/fonts/font-slider.css" type="text/css">
	
	<!-- jQuery and Modernizr-->
	<script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
	
	<!-- Core JavaScript Files -->  	 
    <script src="${pageContext.request.contextPath }/jsp/edu/js/bootstrap.min.js"></script>
	
	<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
	<!--Top-->
	<c:import url="head.jsp"></c:import>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Category Page//////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="${pageContext.request.contextPath }/jsp/edu/index.jsp">主页</a></li>
						<li><a href="javascript:;">分类</a></li>
					</ul>
					<a href="javascript:;">共查询到数据<span id = "activitySum">0</span>条</a>
				</div>
			</div>
			<div class="row">
				<div id="main-content" class=""><!-- col-md-8 -->
					<div class="row">
						<div class="col-md-12">
							<div class="products">
								
								
								
								<div class="col-lg-4 col-md-4 col-xs-12">
									<div class="product">
										<div class="image"><a href="product.html"><img src="images/galaxy-note.jpg" /></a></div>
										<div class="buttons">
											<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>
											<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>
											<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>
										</div>
										<div class="caption">
											<div class="name"><h3><a href="product.html">Aliquam erat volutpat</a></h3></div>
											<div class="price">$122<span>$98</span></div>
											<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span></div>
										</div>
									</div>
								</div>
								
								
							</div>
						</div>
					</div>
					
					
					<div class="row text-center">
							<div id="activityPage">
								<p>
									当前为第<strong id="currentPage">1</strong>页,共<strong id="pageSum">0</strong>页
								</p>
							</div>
						<ul class="pagination" id="pageUl">
						  <li class="active" id="home"><a href="#navData">首页</a></li>
						  <li id="previousPage"><a href="#navData">上一页</a></li>
						  <li id="nextPage"><a href="#navData">下一页</a></li>
						  <li id="lastPage"><a href="#navData">尾页</a></li>
						</ul>
					</div>
				</div>
				
			</div>
		</div>
	</div>	
	<!-- footer -->
	<c:import url="footer.jsp"></c:import>
	
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/edu/js/type.js"></script>
</body>
</html>

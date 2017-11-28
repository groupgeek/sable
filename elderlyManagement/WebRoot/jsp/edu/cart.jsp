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

<title>Mobile Shop</title>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/bootstrap.min.css"
	type="text/css">

<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/style.css">


<!-- Custom Fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/font-awesome/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/fonts/font-slider.css"
	type="text/css">

<!-- jQuery and Modernizr-->


	
<script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

<!-- Core JavaScript Files -->
<script
	src="${pageContext.request.contextPath }/jsp/edu/js/bootstrap.min.js"></script>
	
<script
	src="${pageContext.request.contextPath }/jsp/edu/js/photo-gallery.js"></script>

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
	<!--///////////////////Cart Page//////////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a>
						</li>
						<li><a href="cart.html">Cart</a>
						</li>
					</ul>
				</div>
			</div>


			<div class="row">
				<div class="product well">
					<div class="col-md-3">
						<div class="image">
							<img src="images/galaxy-note.jpg" />
						</div>
					</div>
					<div class="col-md-9">
						<div class="caption">
							<div class="name">
								<h3>
									<a href="product.html">Aliquam erat volutpat</a>
								</h3>
							</div>
							<div class="info">
								<ul>
									<li>Brand: text</li>
									<li>ID: 0122222</li>
								</ul>
							</div>
							<div class="price">
								$122<span>$98</span>
							</div>
							<label>Qty: </label> <input class="form-inline quantity"
								type="text" value="1"><a href="#" class="btn btn-2 ">Update</a>
							<hr>
							<a href="#" class="btn btn-default pull-right">REMOVE</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="row">
				<div class="product well">
					<div class="col-md-3">
						<div class="image">
							<img src="images/Z1.png" />
						</div>
					</div>
					<div class="col-md-9">
						<div class="caption">
							<div class="name">
								<h3>
									<a href="product.html">Aliquam erat volutpat</a>
								</h3>
							</div>
							<div class="info">
								<ul>
									<li>Brand: text</li>
									<li>ID: 0122222</li>
								</ul>
							</div>
							<div class="price">
								$122<span>$98</span>
							</div>
							<label>Qty: </label> <input class="form-inline quantity"
								type="text" value="1"><a href="#" class="btn btn-2 ">Update</a>
							<hr>
							<a href="#" class="btn btn-default pull-right">REMOVE</a>
						</div>
					</div>
					<div class="clear"></div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-4 col-md-offset-8 ">
					<center>
						<a href="#" class="btn btn-1">Continue To Shopping</a>
					</center>
				</div>
			</div>

		</div>
	</div>
	<!-- footer -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>

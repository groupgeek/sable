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
	<!--///////////////////Account Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a href="index.html">Home</a></li>
						<li><a href="account.html">Account</a></li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="heading"><h2>Login</h2></div>
					<form name="form1" id="ff1" method="post" action="login.php">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="Username :" name="username" id="username" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="email" id="email" required>
						</div>
						<button type="submit" class="btn btn-1" name="login" id="login">Login</button>
						<a href="#">Forgot Your Password ?</a>
					</form>
				</div>
				<div class="col-md-6">
					<div class="heading"><h2>New User ? Create An Account.</h2></div>
					<form name="form2" id="ff2" method="post" action="register.php">
						<div class="form-group">
							<input type="text" class="form-control" placeholder="First Name :" name="firstname" id="firstname" required>
						</div>
						<div class="form-group">
							<input type="email" class="form-control" placeholder="Last Name :" name="lastname" id="lastname" required>
						</div>
						<div class="form-group">
							<input type="tel" class="form-control" placeholder="Email Address :" name="email" id="email" required>
						</div>
						<div class="form-group">
							<input type="tel" class="form-control" placeholder="Mobile :" name="phone" id="phone" required>
						</div>
						<div class="form-group">
							<input name="gender" id="gender" type="radio"> Male <input name="gender" id="gender" type="radio"> Female 
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Password :" name="password" id="password" required>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" placeholder="Retype Password :" name="repassword" id="repassword" required>
						</div>
						<div class="form-group">
							<input name="agree" id="agree" type="checkbox" > I agree to your website.
						</div>
						<button type="submit" class="btn btn-1">Create</button>
					</form>
				</div>
			</div>
		</div>
	</div>
		<!-- footer -->
	<c:import url="footer.jsp"></c:import>
</body>
</html>
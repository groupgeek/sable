<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<script type="text/javascript">

function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(employeeid,"xxxx")==false)
    {employeeid.focus();return false}
  }
}
</script>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>登录</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="Free HTML5 Template by FreeHTML5.co" />
<meta name="keywords"
	content="free html5, free template, free bootstrap, html5, css3, mobile first, responsive" />




<!-- Facebook and Twitter integration -->
<meta property="og:title" content="" />
<meta property="og:image" content="" />
<meta property="og:url" content="" />
<meta property="og:site_name" content="" />
<meta property="og:description" content="" />
<meta name="twitter:title" content="" />
<meta name="twitter:image" content="" />
<meta name="twitter:url" content="" />
<meta name="twitter:card" content="" />
<link rel="shortcut icon" href="/jsp/producmanage/logReg/images/favicon.png">
<!-- Place favicon.ico and apple-touch-icon.png in the root directory -->
 
<link rel="shortcut icon"

	href="${pageContext.request.contextPath }/jsp/logReg/favicon.ico">

<link
	href='https://fonts.googleapis.com/css?family=Open+Sans:400,700,300'
	rel='stylesheet' type='text/css'>

<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/bootstrap.min.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/animate.css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/logReg/css/style.css">
 <!-- Bootstrap CSS -->    
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/css/bootstrap.min.css" rel="stylesheet">
    <!-- bootstrap theme -->
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/css/bootstrap-theme.css" rel="stylesheet">
    <!--external css-->
    <!-- font icon -->
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/css/elegant-icons-style.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/css/font-awesome.css" rel="stylesheet" />
    <!-- Custom styles -->
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/login/css/style.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath }/jsp/AdminLogin/login/css/style-responsive.css" rel="stylesheet" />

<!-- Modernizr JS -->
<script
	src="${pageContext.request.contextPath }/jsp/logReg/js/modernizr-2.6.2.min.js"></script>


<!-- FOR IE9 below -->
<!--[if lt IE 9]>
	<script src="js/respond.min.js"></script>
	<![endif]-->

</head>
<body style="background-image: url('/elderlyManagement/jsp/AdminLogin/images/ligbg2.jpg');height: 100%;">

	<div class="container">
		<div class="row">
			<div style="height: 50px;"></div>
		</div>
		<div class="row">
			<div class="col-md-4 col-md-offset-4" ">
				<!-- Start Sign In Form -->
				<form id="login"
					action="${pageContext.request.contextPath }/adminlogin/AdminLogin.action"
					class="fh5co-form animate-box" data-animate-effect="fadeIn" style="background-color:rgba(0,0,0,0.5); padding-bottom: 50px;"   method="post">
					<h2>登录</h2>
					<div class="form-group">
						<label for="employeeid" class="sr-only" >员工账号</label> <input
							type="text" class="form-control" id="id" name="id" digits=true  
							placeholder="员工账号" autocomplete="off" required>
					</div>
					<div class="form-group">
						<label for="password" class="sr-only">密码 </label> <input
							type="password" class="form-control" id="password" minlength = 6 maxlength = 15
							name="password" placeholder="密码" autocomplete="off" required>
					</div>
					<div class="form-group">
						<label for="remember"><input type="checkbox" id="remember">
							记住我</label>
					</div>
					<div class="form-group">
						<p>
							没有注册? <a
								href="${pageContext.request.contextPath }/logReg/sinup.action">注册</a>
							| <a
								href="${pageContext.request.contextPath }/jsp/logReg/forgot.jsp">忘记密码?</a>
						</p>
					</div>
					<div class="control-group">
								<label class="control-label" for="selectError3"></label>
								<div class="controls">
								
								<label> 
                                <input type="radio" value="1" name="mark"  checked/>
                            		    员工</label> 
                            		    <label>
                                <input type="radio" value="0" name="mark" />
      							   CEO
      							    </label>
               
								</div>
					</div> 
					<div class="form-group">
						<input type="submit" value="登录" class="btn btn-primary">
					</div>
				</form>
				<!-- END Sign In Form -->

			</div>
		</div>
		<div class="row" style="padding-top: 60px; clear: both;">
			<div class="col-md-12 text-center">
				<p>
					<small>&copy; 孝和集团 <a href="#" target="_blank"
						title="孝和集团 ">孝和集团 </a> - Collect from <a href="#" title="孝和集团"
						target="_blank">孝和集团 </a>
					</small>
				</p>
			</div>
		</div>
	</div>

	<!-- jQuery -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.min.js"></script>
	<!-- Bootstrap -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/bootstrap.min.js"></script>
	<!-- Placeholder -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.placeholder.min.js"></script>
	<!-- Waypoints -->
	<script
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.waypoints.min.js"></script>
	<!-- Main JS -->
	<script src="${pageContext.request.contextPath }/jsp/logReg/js/main.js"></script>
	
<!-- 	<script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script> -->
	<script 
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.1.8.1.min.js"></script>
		<script 
		src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.messages_zh.js"></script>
<!-- <script
	src="//www.w3cschool.cn/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script> -->
<script>

	$(document).ready(function() {
		$("#login").validate();
	});
</script>


</body>
</html>


	

	


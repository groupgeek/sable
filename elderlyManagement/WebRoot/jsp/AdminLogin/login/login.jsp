<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
<title>Sign In & Sign Up Form Widget Flat Responsive Widget Template :: 孝和</title>
<!-- for-mobile-apps -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="Sign In Form Widget Responsive web template, Bootstrap Web Templates, Flat Web Templates, Android Compatible web template, 
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyEricsson, Motorola web design" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
		function hideURLbar(){ window.scrollTo(0,1); } </script>
<!-- //for-mobile-apps -->
<!-- js -->
<script src="js/jquery-1.11.1.min.js"></script>
<!-- //js -->
<link href="${pageContext.request.contextPath }/jsp/AdminLogin/login/css/style.css" rel="stylesheet" type="text/css" media="all" />
<link href='http://fonts.googleapis.com/css?family=Raleway:400,100,100italic,200,200italic,300,300italic,400italic,500,500italic,600,600italic,700,700italic,800,800italic,900,900italic' rel='stylesheet' type='text/css'>
</head>
<body>
	<div class="main">
		<h1 >登录</h1>
		<div class="w3_login">
			<div class="w3_login_module">
				<div class="module form-module" style="margin-top:-30px;">
				  <div class=""><i class="fa fa-times fa-pencil"></i>
					<!-- <div class="tooltip">Click Me</div> -->
				  </div>
				  <div class="form" >
					<h2></h2>
					<form action="${pageContext.request.contextPath }/adminlogin/AdminLogin.action" method="post">
					  <c:if test="${Massage!=null }">
					
					<label for="employeeid" class="sr-only" style="color: red;font-size: 20px" > ${Massage}</label> <input
							type="text" class="form-control" id="id" name="id" digits=true  
							placeholder="员工账号" autocomplete="off" required >
					
					</c:if>
					<c:if test="${Massage==null }">
						<label for="employeeid" class="sr-only" ></label> <input
							type="text" class="form-control" id="id" name="id" digits=true  
							placeholder="员工账号" autocomplete="off" required>
					</c:if>
					<label for="password" class="sr-only"></label>
					  <input id="pass" type="password" name="password" placeholder="密码" password=" ">
					  <div class="controls">
								
								<label> 
                                <input type="radio" value="1" name="mark"  checked/>
                            		    员工</label> 
                            		    &nbsp; &nbsp; &nbsp; &nbsp;
                            		    <label>
                                <input type="radio" value="0" name="mark" />
      							   CEO
      							    </label>
               
								</div>
					
					  <input type="submit" onclick="yonghu()" value="登录">
					  	<div class="control-group">
								<label class="control-label" for="selectError3"></label>
							</div> 	
					</form>
				  </div>
				 
				  <div class="cta"><a href="#" onclick="tanchuang()">忘记密码?</a></div>
				
			</div>
			<script>
				$('.toggle').click(function(){
				  // Switches the Icon
				  $(this).children('i').toggleClass('fa-pencil');
				  // Switches the forms  
				  $('.form').animate({
					height: "toggle",
					'padding-top': 'toggle',
					'padding-bottom': 'toggle',
					opacity: "toggle"
				  }, "slow");
				});
			</script>
		</div>
		<div class="agileits_copyright">
			<p>© 2016 Sign In | Design by <a href="#">孝和</a></p>
		</div>
	</div>
	<script>

	$(document).ready(function() {
		$("#login").validate();
	});
</script>
	<script type="text/javascript">
		function yonghu(){
			var x=document.getElementById("user").value;
			var p=document.getElementById("pass").value;
			if (x==""||p=="") {
				alert("员工号或密码不能为空")
			}

		}
	</script>
	<script>

	function tanchuang(){
		alert("联系网管");
	}
</script>
</body>
</html>
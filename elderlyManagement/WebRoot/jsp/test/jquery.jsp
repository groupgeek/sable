<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'jquery.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-1.4.4.min.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/aa.js"></script>
  
  <script type="text/javascript">
/*js以及jquery的测试  */
  $(document).ready(function(){
  
  $("#demo2").click(function(){
  
  	$("#p1").hide();
  });
 });
  
  $(document).ready(function(){
  	$("#demo1").click(function(){
  		$.ajax(
  			{
  				type:"post",
  				url:"${pageContext.request.contextPath }/test/user_RequestJson.action",
  				//contentType:"application/json;charset=utf-8",
  				//data:'{"username":"demo1","sex":"男"}',
  				data:'username="demo1"&sex="nv"',
  				success:function(data,status){
					alert(data.sex);
					alert(data.username);
					alert(status);
				}
  			
  			}
  		
  		);
  		
  	});
  });

  </script>
  
  
  
  </head>
  
  <body>
   

		<p id="p1">2</p>
		<p id="p2">2</p>
		<p id="p3">2</p>
		<p id="p4">2</p>
	
	<input id="demo1"  type="button" value="json">
		<input id="demo1"  type="button" onclick="ha()" value="ha">
		<input id="demo2"  type="button" value="hide">



<img src="jsp/picture/1.jpg">


<img  src="${pageContext.request.contextPath }/picture/1.jpg">
  </body>
</html>

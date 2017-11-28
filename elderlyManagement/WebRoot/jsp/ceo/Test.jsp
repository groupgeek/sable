<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/js/echarts.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		#header{
			padding-top:20px;
			height:500px;
			width:100%;
			
		}
		#chartmain{
			
			padding:20px;
			height:100%;
			width:47%;
			float:left;
		}
		#main{
			padding:20px;
			height:100%;
			width:47%;
			float:left;
		}
		
	</style>
	
  </head>
  
  <body>
  		<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
  		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-1.9.1.min.js"></script>
    <div id="header">
    	<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
    	<div id="chartmain"></div>
    	<div id="main"></div>
    </div>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/Test.js"></script>
  </body>
</html>

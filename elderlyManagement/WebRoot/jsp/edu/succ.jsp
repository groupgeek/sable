<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>报名成功</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <div  style="width: 200;height: 200;margin-left: 600;margin-top: 200;">
   <h2> 报名成功</h2><br>
    <div >
     <a href="${pageContext.request.contextPath }/edu/queryActivityByUserId.action">我的课程</a>
     <a href="${pageContext.request.contextPath }/edu/getpicture.action">返回首页</a>
    </div>
  </div>
  </body>
</html>

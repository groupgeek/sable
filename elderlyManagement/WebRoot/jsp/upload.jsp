<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'upload.jsp' starting page</title>
    
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
  ${url }
	  <img  src="/upload/${url }">
	  	  <%-- <img  src="/pic/${url }"> --%>
	  	   <img  src="${pageContext.request.contextPath }/jsp/picture/1.jpg">
	  	   

  <form action="${pageContext.request.contextPath }/upload.action" method="post" enctype="multipart/form-data">
   <input type="file" name="file" multiple>
  <input type="submit" value="提交">
  
  </form>
  
  
  </body>
</html>

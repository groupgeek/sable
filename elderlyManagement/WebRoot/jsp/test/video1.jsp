<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>





<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<title>My JSP 'vido.jsp' starting page</title>

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

<video width="320" height="240" controls autoplay>
  <source src="${pageContext.request.contextPath }/video/1.mp4" type="video/mp4">
</video>
<embed src="${pageContext.request.contextPath }/video/1.mp4" height="200" width="200">

<object height="200" width="200" data="${pageContext.request.contextPath }/video/1.mp4"></object>


<video width="320" height="240" controls autoplay>
  <source src="${pageContext.request.contextPath }/video/1.mp4" type="video/ogg">
  <source src="${pageContext.request.contextPath }/video/1.mp4" type="video/mp4">
  <source src="${pageContext.request.contextPath }/video/1.mp4" type="video/webm">
  <object data="${pageContext.request.contextPath }/video/1.mp4" width="320" height="240">
    <embed width="320" height="240" src="${pageContext.request.contextPath }/video/1.mp4">
  </object>
</video>


——————————————————————————————————————————————————————————————————————————————————————————————
<video width="320" height="240" controls autoplay>
  <source src="/video/${url }" type="video/ogg">
  <source src="/video/${url }" type="video/mp4">
  <source src="/video/${url }" type="video/webm">
  <object data="/video/${url }" width="320" height="240">
    <embed width="320" height="240" src="/video/${url }">
  </object>
</video>


  <form action="${pageContext.request.contextPath }/test/video.action" method="post" enctype="multipart/form-data">
   <input type="file" name="video">
  <input type="submit" value="提交">
  
  </form>
  

	<a href="${pageContext.request.contextPath }/video/1.mp4">vidao</a>
</body>
</html>


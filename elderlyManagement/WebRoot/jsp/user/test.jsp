<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'test.jsp' starting page</title>
    
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
  <c:if test="${user.username!=null }">
   ${user.username }
  </c:if>
   <br>
    <a href="${pageContext.request.contextPath }/user/log.action">登录</a>
    <a href="${pageContext.request.contextPath }/user/oneUser.action">用户信息</a>
    <a href="${pageContext.request.contextPath }/user/userMed.action">用户病历</a>
    <a href="${pageContext.request.contextPath }/user/userAct.action">用户病历</a>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

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
    <ul class="messagesList">
						<c:forEach items="${messages }" var="message">
							<li id="hh" onclick="haha(${message.messageid })">
							<span class="from"><span class="glyphicons star"><i></i></span> ${message.username } <span class="glyphicons paperclip"><i></i></span></span><span id = "span1" class="title"> ${message.messagecontext }</span><span class="date">
							<fmt:formatDate value="${message.messagetime }"
								pattern="yyyy-MM-dd HH:mm:ss" /></span>
						</c:forEach>
	</ul>
	${user.employeename }
  </body>
</html>

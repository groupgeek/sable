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
						<c:forEach items="${visits }" var="visits">
							<tr>
							<td>${visits.username }</td>
							<td>${visits.address }</td>
							<fmt:formatDate value="${visits.lastvisttime }"pattern="yyyy-MM-dd" />
							<td>${visits.countvisit }</td>
							</tr>
						</c:forEach>
	</ul>
	管理员姓名：${employee.employeename }<br>
	<table>
	<tr>
		<td>教育收入</td>
		<td>健康收入</td>
		<td>商城收入</td>
		<td>总收入</td>
	</tr>
	<tr> 
			<td>${arr[0] }</td>
		    <td>${arr[1] }</td>
		 	<td>${arr[2] }</td>
			<td>${arr[3] }</td>
	</tr>
	
	</table>
	<a href="${pageContext.request.contextPath }/brach/log.action">登陆成功</a><br>
	<a href="${pageContext.request.contextPath }/brach/index.action">首页测试</a>
	<a href="${pageContext.request.contextPath }/brach/users.action">信息展示</a>
	<a href="${pageContext.request.contextPath }/brach/fenyeMessage.action">留言信息</a>
	<a href="${pageContext.request.contextPath }/brach/branchTran.action">客户关系</a>
	<a href="${pageContext.request.contextPath }/brach/branchVist.action">客户回访</a>
	
  </body>
</html>

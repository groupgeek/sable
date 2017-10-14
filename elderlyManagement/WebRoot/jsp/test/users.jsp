<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title></title>


<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-1.4.4.min.js"></script>

<script type="text/javascript">
	$(document).ready(function(){
		$("p").click(function(){
			$(this).hide();
		});
	});
	
	



</script>


</head>
<body>
	<center>
		<div>
			<table border=1>
				<tr>
					<td>用户名称</td>
					<td>用户性别</td>
					<td>用户密码</td>
				</tr>
				<c:forEach items="${users }" var="user">
					<tr>
						<td>${user.username }</td>
						<td>${user.sex }</td>
						<td>${user.password }</td>
						<td><fmt:formatDate value="${user.birthday }"
								pattern="yyyy-MM-dd HH:mm:ss" />
						</td>
						<td><a
							href="${pageContext.request.contextPath}/test/queryUserById.action?id=${user.id }">修改</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>

	</center>
	
	<div id="div1">
		<p id="p1">点我啊</p>
	
	</div>
	
</body>
</html>

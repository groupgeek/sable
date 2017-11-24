<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

        ${user.username }
		${user.sex }
		${user.password }
		${user.birthday }

<form action="${pageContext.request.contextPath }/test/modifyUser.action">
<input type="hidden" name="id" value="${user.id }">
<input type="text" name="username" value="${user.username }">
<input type="text" name="sex" value="${user.sex }">
<input type="text" name="password" value="${user.password }">

<input type="text" name="birthday" value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd HH:mm:ss"/>">
<input type="submit" value="提交">
</form>

<!--  测试-->
</body>
</html>
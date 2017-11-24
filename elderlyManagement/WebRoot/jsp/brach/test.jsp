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
<link href="${pageContext.request.contextPath }/jsp/brach/css/mybranch/haha.css" rel="stylesheet">
  </head>
  
  <body style="background: url(/img/7.jpg)">
  
  
						  
    <ul class="messagesList">
						<c:forEach items="${acts }" var="acts">
							<tr>
							<td>${acts.activityid}</td>
							<td>${acts.activityname }</td>
							<td>${acts.activitystatus }</td>
							<fmt:formatDate value="${acts.activitydate }"pattern="yyyy-MM-dd" />
							<td>${acts.registeryfee }</td>
							<td><a href="${pageContext.request.contextPath }/brach/oneActCus.action?id=${ acts.activityid}">详情</a></td>
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
	<a href="${pageContext.request.contextPath }/brach/allActs.action">所有活动</a>
	<a href="${pageContext.request.contextPath }/brach/allActTypes.action">添加活动</a>
	<a href="${pageContext.request.contextPath }/brach/charts.action">报表</a>
	<a href="${pageContext.request.contextPath }/brach/employees.action">员工</a>
	
	<br>
	
	<input type="button" onclick="hello()" value="json请求"/>
	<div class="product"></div>
	
	
	
	
	
	
	
	
	<p class="zb">你好啊  ！</p>
	<script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script>
	
	<script type="text/javascript">
	function hello(){
	alert(11111);
	$.ajax({
		type : 'post',
		/*${pageContext.request.contextPath }/*/
		url : 'brach/demo.action',
		//data:'username = "1"&password = "123"',
		//数据格式是json串
		contentType : 'application/json;charset=utf-8',
		//data:'{"username":"zhangbiao","password":"123"}',
		data:'{"userid":"1"}',
		success : function(data) {
			alert(data.username);
			alert(data.password);
			$("#zb").html(data.username+""+data.password);
		}
	});


}
	
	
	
	
	
	</script>
  </body>
</html>

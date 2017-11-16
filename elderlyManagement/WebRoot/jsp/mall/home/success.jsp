<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
<title>付款成功页面</title>
<link
	href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css"
	rel="stylesheet" type="text/css">
<link
	href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath }/jsp/mall/css/sustyle.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

</head>

<body>


	<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
	<!--顶部导航条 -->
	<c:import url="/jsp/mall/head.jsp"></c:import>

	<div class="clear"></div>



	<div class="take-delivery">
		<div class="status">
			<h2>您已成功付款</h2>
			<div class="successInfo">
				<ul>
					<li>付款金额<em>¥9.90</em>
					</li>
					<div class="user-info">
						<p>收货人：艾迪</p>
						<p>联系电话：15871145629</p>
						<p>收货地址：湖北省 武汉市 武昌区 东湖路75号众环大厦</p>
					</div>
					<li>请认真核对您的收货信息，如有错误请联系客服</li>

				</ul>
				<div class="option">
					<span class="info">您可以</span> <a
						href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp"
						class="J_MakePoint">查看<span>已买到的宝贝</span>
					</a> <a href="javascript:;" class="J_MakePoint" id="orderInfo">查看<span>交易详情</span>
					</a>
				</div>
			</div>
		</div>
	</div>


	<c:import url="/jsp/mall/footer.jsp"></c:import>

	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/home/js/success.js"></script>
</body>
</html>

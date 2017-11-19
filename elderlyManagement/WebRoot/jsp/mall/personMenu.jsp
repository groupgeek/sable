<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>head</title>

</head>

<body>
<aside class="menu">
				<ul>
					<li class="person active">
						<a href="${pageContext.request.contextPath }/jsp/mall/person/index.jsp">个人中心</a>
					</li>
					<li class="person">
						<a href="javascript:;">个人资料</a>
						<ul>
							<li> <a href="${pageContext.request.contextPath }/jsp/mall/person/information.jsp">个人信息</a></li>
							<li> <a href="${pageContext.request.contextPath }/jsp/mall/person/safety.jsp">安全设置</a></li>
							<li> <a href="${pageContext.request.contextPath }/jsp/mall/person/shippingAddress.jsp">收货地址</a></li>
						</ul>
					</li>
					<li class="person">
						<a href="javascript:;">我的交易</a>
						<ul>
							<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp">订单管理</a></li>
							<!-- <li> <a href="change.html">退款售后</a></li> -->
						</ul>
					</li>
					<li class="person">
						<a href="javascript:;">我的资产</a>
						<ul>
							<!-- <li> <a href="coupon.html">优惠券 </a></li>
							<li> <a href="bonus.html">红包</a></li> -->
							<li> <a href="${pageContext.request.contextPath }/jsp/mall/person/points.jsp">我的积分</a></li>
						</ul>
					</li>

					<li class="person">
						<a href="javascript:;">我的小窝</a>
						<ul>
							<!-- <li> <a href="collection.html">收藏</a></li> -->
							<!-- <li> <a href="foot.html">足迹</a></li> -->
							<li> <a href="${pageContext.request.contextPath }/jsp/mall/person/evaluation.jsp">评价</a></li>
							<!-- <li> <a href="news.html">消息</a></li> -->
						</ul>
					</li>

				</ul>

			</aside>
	
</body>

</html>
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
<c:import url="/jsp/util/animeMove.jsp"></c:import>
			<div class="am-container header">
			<ul class="message-r">
			<div class="topMessage home">
					<div class="menu-hd">
						<a href="${pageContext.request.contextPath }/branch/index" target="_top" class="h">官网首页</a>
					</div>
				</div>
				<div class="topMessage home">
					<div class="menu-hd">
						<a href="${pageContext.request.contextPath }/product/mallIndex" target="_top" class="h">商城首页</a>
					</div>
				</div>
				<div class="topMessage my-shangcheng">
					<div class="menu-hd MyShangcheng">
						<a href="${pageContext.request.contextPath }/jsp/mall/person/index.jsp" target="_top"><i class="am-icon-user am-icon-fw"></i>个人中心</a>
					</div>
				</div>
				<div class="topMessage mini-cart">
					<div class="menu-hd">
						<a id="mc-menu-hd" href="${pageContext.request.contextPath }/jsp/mall/home/shopcart.jsp" target="_top"><i
							class="am-icon-shopping-cart  am-icon-fw"></i><span>购物车</span><!-- <strong
							id="J_MiniCartNum" class="h">0</strong> </a> -->
					</div>
				</div>
				<div class="topMessage favorite">
					<div class="menu-hd">
						<a href="${pageContext.request.contextPath }/logReg/logout" target="_top"><i class="am-icon-heart am-icon-fw"></i><span>安全退出<%-- ${user.username } --%></span>
						</a>
					</div>
			</ul>
		</div>
		<!--悬浮搜索框-->
		<div class="nav white">
			<div class="logo">
				<%-- <img
					src="${pageContext.request.contextPath }/jsp/mall/images/logo.png" /> --%>
			</div>
			<div class="logoBig">
				<li><img
					src="${pageContext.request.contextPath }/jsp/mall/images/logobig.png" />
				</li>
			</div>

			<div class="search-bar pr">
				<a name="index_none_header_sysc" href="#"></a>
				<form action="${pageContext.request.contextPath }/product/search" method="post">
					<!--商品搜索  -->
					<input id="searchInput" name="searchCondition" type="text"
						placeholder="搜索" autocomplete="off"> <input
						id="ai-topsearch" class="submit am-btn" value="搜索" index="1"
						type="submit">
				</form>
			</div>
		</div>
	
</body>

</html>
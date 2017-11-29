<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0 ,minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>个人中心</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/systyle.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/util/css/common.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<style type="text/css">
		
		</style>
		
	</head>

	<body>
	
	<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<!--头 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<!-- <li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li> -->
							</ul>
						   <!--  <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div> -->
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">
					<div class="wrap-left">
						<div class="wrap-list">
							<div class="m-user">
								<!--个人信息 -->
								<div class="m-bg"></div>
								<div class="m-userinfo">
									<div class="m-baseinfo">
										<a href="${pageContext.request.contextPath }/jsp/mall/person/information.jsp" id = "userAvatar">
											<img src="../images/getAvatar.do.jpg">
										</a>
										<div class="s-prestige am-btn am-round">
										<em class="s-name">0.0<!-- <span class="vip1"></span> --></em>
										</div>
											
									</div>
									<div class="m-right">
										<div class="m-new">
											<a href="javascript:;"><i class="am-icon-bell-o"></i>0.0</a>
										</div>
										<div class="m-address">
											<a href="${pageContext.request.contextPath }/jsp/mall/person/shippingAddress.jsp" class="i-trigger">我的收货地址</a>
										</div>
									</div>
								</div>

								<!--个人资产-->
								<!-- <div class="m-userproperty">
									<div class="s-bar">
										<i class="s-icon"></i>个人资产
									</div>
									<p class="m-bonus">
										<a href="bonus.html">
											<i><img src="../images/bonus.png"/></i>
											<span class="m-title">红包</span>
											<em class="m-num">2</em>
										</a>
									</p>
									<p class="m-coupon">
										<a href="coupon.html">
											<i><img src="../images/coupon.png"/></i>
											<span class="m-title">优惠券</span>
											<em class="m-num">2</em>
										</a>
									</p>
									<p class="m-bill">
										<a href="bill.html">
											<i><img src="../images/wallet.png"/></i>
											<span class="m-title">钱包</span>
											<em class="m-num">2</em>
										</a>
									</p>
									<p class="m-big">
										<a href="#">
											<i><img src="../images/day-to.png"/></i>
											<span class="m-title">签到有礼</span>
										</a>
									</p>
									<p class="m-big">
										<a href="#">
											<i><img src="../images/72h.png"/></i>
											<span class="m-title">72小时发货</span>
										</a>
									</p>
								</div> -->
							</div>
							<div class="box-container-bottom"></div>

							<!--订单 -->
							<div class="m-order">
								<div class="s-bar">
									<i class="s-icon"></i>我的订单
									<a class="i-load-more-item-shadow" href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "allOrders">全部订单</a>
								</div>
								<ul id = "orderMenu">
									<!-- <li><a href="change.html"><i><img src="../images/refund.png"/></i><span>所有订单</span></a></li> -->
									<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "all"><i><img src="../images/refund.png"/></i><span>所有订单<em class="m-num"></em></span></a></li>
									<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "pendingPayment"><i><img src="../images/pay.png"/></i><span>待付款<em class="m-num"></em></span></a></li>
									<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "tobeDelivered"><i><img src="../images/send.png"/></i><span>待发货<em class="m-num"></em></span></a></li>
									<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "tobeReceived"><i><img src="../images/receive.png"/></i><span>待收货<em class="m-num"></em></span></a></li>
									<li><a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp" name = "beEvaluated"><i><img src="../images/comment.png"/></i><span>待评价<em class="m-num"></em></span></a></li>
								</ul>
							</div>
							<!--九宫格-->
							<!--物流 -->
							<div class="m-logistics">

								<div class="s-bar">
									<i class="s-icon"></i>我的物流
								</div>
								
								<div class="s-content">
									<ul class="lg-list">
										

									</ul>

								</div>

							</div>

							<!--收藏夹 -->

						</div>
					</div>
					<div class="wrap-right">

						<!-- 日历-->
						<div class="day-list">
							<div class="s-bar">
								<a class="i-history-trigger s-icon" href="#"></a>我的日历
								<a class="i-setting-trigger s-icon" href="#"></a>
							</div>
							<div class="s-care s-care-noweather">
								<div class="s-date">
									<em>21</em>
									<span>星期一</span>
									<span>2015.12</span>
								</div>
							</div>
						</div>
						<!--热卖推荐 -->
						<div class="new-goods" id = "hot">
							<div class="s-bar">
								<i class="s-icon"></i>热卖推荐
							</div>
							<div class="new-goods-info">
								<a class="shop-info" href="javascript:;" target="_blank">
									<div class="face-img-panel">
										<img src="" alt="">
									</div>
									<span class="shop-title"></span>
								</a>
								<a class="follow" target="_blank"></a>
							</div>
						</div>

						<!--猜你喜欢 -->
						<div class="new-goods" id = "rec">
							<div class="s-bar">
								<i class="s-icon"></i>猜你喜欢
							</div>
							<div class="new-goods-info">
								<a class="shop-info" href="javascript:;" target="_blank">
									<div>
										<img src="" alt="">
									</div>
                                    <span class="one-hot-goods"></span>
								</a>
							</div>
							<a class="follow" target="_blank"></a>
						</div>

					</div>
				</div>
				<!--底部-->
				<c:import url="/jsp/mall/footer.jsp"></c:import>

			</div>
			
			<!-- 菜单 -->
			<c:import url="/jsp/mall/personMenu.jsp"></c:import>
			
		</div>
		
		<div id="wrapper">
			
				
				<div class="box">
					<div class="demo">
						<!-- <a href="javascript:;" class="rollIn">DEMO2</a> -->
					</div>
					
					<div id="dialogBg"></div>
					<div id="dialog" class="animated" style="height: 230px;">
						<img class="dialogIco" width="50" height="50" src="${pageContext.request.contextPath }/jsp/util/images/ico.png" alt="" />
						<div class="dialogTop">
							<a href="javascript:;" class="claseDialogBtn">关闭</a>
						</div>
						<form method="post" id="editForm">
								<input type="hidden" id = "articleid" name="articleid"/>
							<ul class="editInfos">
								<li><label><input type="hidden" id = "orderid" name="orderid"/></label></li>
								<li><label id = "message" style="color: red;">密码错误</label></li>
								<li><label id = "showOrderid" style="color: black;"></label></li>
								<li><label style="color: black;">密码：<input type="password" id = "password" name="password" required  class="ipt" placeholder="密码"style="color: black;"/></label></li>
								<li><input type="button" value="确认提交" class="submitBtn" /></li>
							</ul>
						</form>
					</div>
				</div>
				
			</div>
		<!-- js -->
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/person/js/index.js"></script>
		
		<c:import url="/jsp/util/messageNotification.jsp"></c:import>
		<!-- <c:import url="/jsp/util/animeMove.jsp"></c:import> -->
	</body>

</html>
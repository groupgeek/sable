<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单管理</title>
		
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/orstyle.css" rel="stylesheet" type="text/css">
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/util/css/common.css"/>
		<%-- <script src="${pageContext.request.contextPath }/jsp/mall/UI//assets/js/jquery.min.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/mall/UI//assets/js/amazeui.js"></script>

	</head>

	<body>
		<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<!--头 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<!-- <ul>
								<li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li>
							</ul>
						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div> -->
						</div>
			</div>
			<b class="line"></b>
		<div class="center">
			<div class="col-main">
				<div class="main-wrap">

					<div class="user-order">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单管理</strong></div>
						</div>
						<hr/>

						<div class="am-tabs am-tabs-d2 am-margin" data-am-tabs>

							<ul class="am-avg-sm-5 am-tabs-nav am-nav am-nav-tabs" id = "orderMenu">
								<li class="am-active"><a href="#allOrders" name = "allOrders">所有订单</a></li>
								<li><a href="#pending-payment" name = "pendingPayment">待付款</a></li>
								<li><a href="#to-be-delivered" name = "tobeDelivered">待发货</a></li>
								<li><a href="#to-be-received" name = "tobeReceived">待收货</a></li>
								<li><a href="#be-evaluated" name = "beEvaluated">待评价</a></li>
							</ul>
							
							<div class="am-tabs-bd">
								
								<!-- 全部-->
								<div class="am-tab-panel am-fade am-in am-active" id="allOrders">
									
								</div>
								
								<!-- 待付款 -->
								<div class="am-tab-panel am-fade" id="pending-payment">

								</div>
								
								<!-- 待发货 -->
								<div class="am-tab-panel am-fade" id="to-be-delivered">
									
								</div>
								
								<!-- 待收货 -->
								<div class="am-tab-panel am-fade" id="to-be-received">
									
								</div>
			
								<!-- 待评价 -->
								<div class="am-tab-panel am-fade" id="be-evaluated">
									

								</div>
							</div>

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
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/person/js/order.js"></script>
		<c:import url="/jsp/util/messageNotification.jsp"></c:import>
	</body>

</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>订单详情</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/orstyle.css" rel="stylesheet" type="text/css">

		<script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

	</head>

	<body>
		<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<!--顶部导航条 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>

		<div class="clear"></div>
            <div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<<!-- ul>
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

					<div class="user-orderinfo">

						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单详情</strong></div>
						</div>
						<hr/>
						<!--进度条-->
						<div class="m-progress">
							<div class="m-progress-list">
								<span class="step" id = "status1">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                   <p class="stage-name">付款</p>
                                </span>
								<span class="step" id = "status2">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                   <p class="stage-name">卖家发货</p>
                                </span>
								<span class="step" id = "status3">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">3<em class="bg"></em></i>
                                   <p class="stage-name">确认收货</p>
                                </span>
								<span class="step" id = "status4">
                                   <em class="u-progress-stage-bg"></em>
                                   <i class="u-stage-icon-inner">4<em class="bg"></em></i>
                                   <p class="stage-name">交易完成</p>
                                </span>
								<span class="u-progress-placeholder"></span>
							</div>
							<div class="u-progress-bar total-steps-2">
								<div class="u-progress-bar-inner"></div>
							</div>
						</div>
						<div class="order-infoaside">
							<div class="order-logistics">
								<!-- <a href="logistics.html">
									<div class="icon-log">
										<i><img src="../images/receive.png"></i>
									</div>
									<div class="latest-logistics">
										<p class="text">已签收,签收人是青年城签收，感谢使用天天快递，期待再次为您服务</p>
										<div class="time-list">
											<span class="date">2015-12-19</span><span class="week">周六</span><span class="time">15:35:42</span>
										</div>
										<div class="inquire">
											<span class="package-detail">物流：天天快递</span>
											<span class="package-detail">快递单号: </span>
											<span class="package-number">373269427868</span>
											<a href="logistics.html">查看</a>
										</div>
									</div>
									<span class="am-icon-angle-right icon"></span>
								</a> -->
								<div class="clear"></div>
							</div>
							<div class="order-addresslist">
								<div class="order-address">
									<div class="icon-add">
									</div>
									<p class="new-tit new-p-re">
										<span class="buy-user"></span>
										<span class="buy-phone"></span>
									</p>
									<div class="new-mu_l2a new-p-re">
										<p class="new-mu_l2cw">
											<span class="street"></span></p>
									</div>
								</div>
							</div>
						</div>
						<div class="order-infomain">

							<div class="order-top">
								<div class="th th-item">
									<td class="td-inner">商品</td>
								</div>
								<div class="th th-price">
									<td class="td-inner">单价</td>
								</div>
								<div class="th th-number">
									<td class="td-inner">数量</td>
								</div>
								<div class="th th-operation">
									<td class="td-inner">商品操作</td>
								</div>
								<div class="th th-amount">
									<td class="td-inner">合计</td>
								</div>
								<div class="th th-status">
									<td class="td-inner">交易状态</td>
								</div>
								<div class="th th-change">
									<td class="td-inner">交易操作</td>
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
			<script type="text/javascript"
				src="${pageContext.request.contextPath }/jsp/mall/person/js/orderInfo.js"></script>
	</body>

</html>
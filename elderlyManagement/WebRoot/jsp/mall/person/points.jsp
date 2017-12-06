<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>积分明细</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/point.css" rel="stylesheet" type="text/css">
		<%-- <script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/jquery.min.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js"></script>
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
					<div class="points">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">我的积分</strong></small></div>
						</div>
						<hr/>
						<div class="pointsTitle">
						   <div class="usable">可用积分<span>0</span></div>
						   <div class="pointshop"><a href="${pageContext.request.contextPath }/jsp/mall/person/pointsMall.jsp"><i><img src="../images/u5.png" /></i>积分商城</a></div>
						   
						</div>
						<div class="pointlist am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active"><a href="#all">全部</a></li>
								<li><a href="#get">获得</a></li>
								<li><a href="#expenditure">支出</a></li>
							</ul>
							<div class="am-tabs-bd">
								<div class="am-tab-panel am-fade am-in am-active" id="all">
									<table>
										<b></b>
										<thead>
											<tr>												
												<th class="th1">积分详情</th>
												<th class="th2">积分变动</th>
												<th class="th3">日期</th>
											</tr>
										</thead>										
										<tbody>
											
											<!-- <tr>
												<td class="pointType">订单号7745926347132商品评论</td>
												<td class="pointNum">+2</td>
												<td class="pointTime">2016-03-12&nbsp09:32</td>
											</tr>
											<tr>
												<td class="pointType">每日签到</td>
												<td class="pointNum">+5</td>
												<td class="pointTime">2016-03-12&nbsp07:32</td>
											</tr>
											<tr>
												<td class="pointType">每日签到</td>
												<td class="pointNum">+5</td>
												<td class="pointTime">2016-03-11&nbsp12:24</td>
											</tr>
											<tr>
												<td class="pointType">邮箱验证</td>
												<td class="pointNum">+50</td>
												<td class="pointTime">2016-03-10&nbsp16:18</td>
											</tr>
											<tr>
												<td class="pointType">手机绑定</td>
												<td class="pointNum">+100</td>
												<td class="pointTime">2016-03-10&nbsp15:27</td>
											</tr> -->
										</tbody>
									</table>
								</div>
								<div class="am-tab-panel am-fade" id="get">
									<table>
										<b></b>
										<thead>
											<tr>												
												<th class="th1">积分详情</th>
												<th class="th2">获取积分</th>
												<th class="th3">日期</th>
											</tr>
										</thead>
										<tbody>
											
										</tbody>
									</table>
								</div>
								<div class="am-tab-panel am-fade" id="expenditure">
									<table>
										<b></b>
										<thead>
											<tr>												
												<th class="th1">积分详情</th>
												<th class="th2">消耗积分</th>
												<th class="th3">日期</th>
											</tr>
										</thead>
										<tbody>
											
										</tbody>
									</table>
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
			
			<c:import url="/jsp/util/messageNotification.jsp"></c:import>
		</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/person/js/points.js"></script>
	</body>

</html>
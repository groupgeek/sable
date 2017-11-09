<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>发表评论</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/appstyle.css" rel="stylesheet" type="text/css">
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery-1.7.2.min.js"></script>
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

					<div class="user-comment">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">发表评论</strong></div>
						</div>
						<hr/>

						<div class="comment-main">
							<div class="comment-list">
								<div class="item-pic">
									<a href="javascript:;" class="J_MakePoint">
										<img src="" class="itempic">
									</a>
								</div>

								<div class="item-title">

									<div class="item-name">
										<a href="javascript:;">
											<p class="item-basic-info"></p>
										</a>
									</div>
									<div class="item-info">
										<div class="info-little">
											
										</div>
										<div class="item-price">
											价格：<strong></strong>
										</div>										
									</div>
								</div>
								<div class="clear"></div>
								<div class="item-comment">
									<textarea placeholder="请写下对宝贝的感受吧，对他人帮助很大哦！"></textarea>
								</div>
								<!-- <div class="filePic">
									<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*" >
									<span>晒照片(0/5)</span>
									<img src="../images/image.jpg" alt="">
								</div> -->
								<div class="item-opinion">
									<ul>
										<li id="3"><i class="op1"></i>好评</li>
										<li id="2"><i class="op2"></i>中评</li>
										<li id="1"><i class="op3"></i>差评</li>
									</ul>
								</div>
							</div>
								<input type="hidden" id = evaluationOption value="">
								<div class="info-btn">
									<div class="am-btn am-btn-danger">发表评论</div>
								</div>							
					<script type="text/javascript">
						$(document).ready(function() {
							$(".comment-list .item-opinion li").click(function() {	
								$(this).prevAll().children('i').removeClass("active");
								$(this).nextAll().children('i').removeClass("active");
								$(this).children('i').addClass("active");
								$("#evaluationOption").attr("value",$(this).attr("id"));
							});
				     })
					</script>					
					
												
							
						</div>

					</div>

				</div>
				<!--底部-->
				<c:import url="/jsp/mall/footer.jsp"></c:import>
			</div>

			<!-- 菜单 -->
			<c:import url="/jsp/mall/personMenu.jsp"></c:import>
		</div>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/person/js/userComment.js"></script>
	</body>

</html>
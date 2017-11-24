<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

<title>商城首页</title>

<link
	href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css"
	rel="stylesheet" type="text/css" />
<link
	href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css"
	rel="stylesheet" type="text/css" />

<link
	href="${pageContext.request.contextPath }/jsp/mall/css/hmstyle.css"
	rel="stylesheet" type="text/css" />
<link href="${pageContext.request.contextPath }/jsp/mall/css/skin.css"
	rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
<%-- <script
	src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/jquery.min.js"></script> --%>
<script
	src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.min.js"></script>

</head>

<body>
	<div class="hmtop">
		<!--顶部导航条 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>

		<div class="clear"></div>
	</div>
	<div class="banner">
		<!--轮播 **************************************************************************-->
		<div class="am-slider am-slider-default scoll" data-am-flexslider
			id="demo-slider-0">
			<ul class="am-slides">
				<li class="banner1"><a
					href="${pageContext.request.contextPath }/jsp/mall/home/introduction.jsp"><img
						src="${pageContext.request.contextPath }/jsp/mall/images/ad1.jpg" />
				</a></li>
				<li class="banner2"><a><img
						src="${pageContext.request.contextPath }/jsp/mall/images/ad2.jpg" />
				</a></li>
				<li class="banner3"><a><img
						src="${pageContext.request.contextPath }/jsp/mall/images/ad3.jpg" />
				</a></li>
				<li class="banner4"><a><img
						src="${pageContext.request.contextPath }/jsp/mall/images/ad4.jpg" />
				</a></li>

			</ul>
		</div>
		<div class="clear"></div>
	</div>
	<div class="shopNav">
		<div class="slideall">

			<div class="long-title">
				<span class="all-goods">全部分类</span>
			</div>
			<div class="nav-cont">
				<!-- <ul>
					<li class="index"><a href="#">首页</a></li>
					<li class="qc"><a href="#">闪购</a></li>
					<li class="qc"><a href="#">限时抢</a></li>
					<li class="qc"><a href="#">团购</a></li>
					<li class="qc last"><a href="#">大包装</a></li>
				</ul> -->
			<!-- 	<div class="nav-extra">
					<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
					<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
				</div> -->
			</div>

			<!--侧边导航 -->
			<div id="nav" class="navfull">
				<div class="area clearfix">
					<div class="category-content" id="guide_2">

						<div class="category">
							<ul class="category-list" id="js_climit_li">
								<!--  分类-->
								<c:forEach items="${productTypes }" var="productType">
									<li class="appliance js_toggle relative first" value="${productType.producttypeid }">
										<div class="category-info">
											<h3 class="category-name b-category-name">
												<i><img
													src="${pageContext.request.contextPath }/jsp/mall/images/cake.png">
												</i><a class="ml-22">${productType.producttypename }</a>
											</h3>
											<em>&gt;</em>
										</div>

										<div class="menu-item menu-in top">
											<div class="area-in">
												<div class="area-bg">
													<div class="menu-srot">
														<div class="sort-side">
															<dl class="dl-sort">
																<dt>
																	<span title="蛋糕">名字</span>
																</dt>
																<dd>
																	<a title="蒸蛋糕" href="#"><span>类容</span> </a>
																</dd>
																
															</dl>

														</div>
														<!-- <div class="brand-side">
															<dl class="dl-sort">
																<dt>
																	<span>实力商家</span>
																</dt>
																<dd>
																	<a rel="nofollow" title="呵官方旗舰店" target="_blank"
																		href="#" rel="nofollow"><span class="red">呵官方旗舰店</span>
																	</a>
																</dd>
																<dd>
																	<a rel="nofollow" title="格瑞旗舰店" target="_blank"
																		href="#" rel="nofollow"><span>格瑞旗舰店</span> </a>
																</dd>
																<dd>
																	<a rel="nofollow" title="飞彦大厂直供" target="_blank"
																		href="#" rel="nofollow"><span class="red">飞彦大厂直供</span>
																	</a>
																</dd>
															</dl>
														</div> -->
													</div>
												</div>
											</div>
										</div> <b class="arrow"></b>
									</li>
								</c:forEach>

							</ul>
						</div>
					</div>

				</div>
			</div>


			<!--轮播-->

			<script type="text/javascript">
				(function() {
					$('.am-slider').flexslider();
				});
				$(document)
						.ready(
								function() {
									$("li")
											.hover(
													function() {
														$(
																".category-content .category-list li.first .menu-in")
																.css("display",
																		"none");
														$(
																".category-content .category-list li.first")
																.removeClass(
																		"hover");
														$(this).addClass(
																"hover");
														$(this)
																.children(
																		"div.menu-in")
																.css("display",
																		"block")
													},
													function() {
														$(this).removeClass(
																"hover")
														$(this).children(
																"div.menu-in")
																.css("display",
																		"none")
													});
								})
			</script>



			<!--小导航 -->
			<%-- <div class="am-g am-g-fixed sjsp/mallnav">
				<div class="am-u-sm-3">
					<a href="sort.html"><img
						src="${pageContext.request.contextPath }/jsp/mall/images/navsjsp/mall.jpg" />
						<div class="title">商品分类</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath }/jsp/mall/images/huisjsp/mall.jpg" />
						<div class="title">大聚惠</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath }/jsp/mall/images/mansjsp/mall.jpg" />
						<div class="title">个人中心</div> </a>
				</div>
				<div class="am-u-sm-3">
					<a href="#"><img
						src="${pageContext.request.contextPath }/jsp/mall/images/moneysjsp/mall.jpg" />
						<div class="title">投资理财</div> </a>
				</div>
			</div> --%>

			<!--走马灯 -->

			<%-- <div class="marqueen">
				<span class="marqueen-title">商城头条</span>
				<div class="demo">

					<ul>
						<li class="title-first"><a target="_blank" href="#"> <img
								src="${pageContext.request.contextPath }/jsp/mall/images/TJ2.jpg"></img>
								<span>[特惠]</span>商城爆品1分秒 </a></li>
						<li class="title-first"><a target="_blank" href="#"> <span>[公告]</span>商城与广州市签署战略合作协议
								<img
								src="${pageContext.request.contextPath }/jsp/mall/images/TJ.jpg"></img>
								<p>XXXXXXXXXXXXXXXXXX</p> </a></li>

						<div class="mod-vip">
							<div class="m-baseinfo">
								<a href="../person/index.html"> <img
									src="${pageContext.request.contextPath }/jsp/mall/images/getAvatar.do.jpg">
								</a> <em> Hi,<span class="s-name">小叮当</span> <a href="#"><p>点击更多优惠活动</p>
								</a> </em>
							</div>
							<div class="member-logout">
								<a class="am-btn-warning btn"
									href="${pageContext.request.contextPath }/jsp/logReg/login.jsp">登录</a>
								<a class="am-btn-warning btn"
									href="${pageContext.request.contextPath }/logReg/sinup.action">注册</a>
							</div>

							<div class="member-login">
								<a href="#"><strong>0</strong>待收货</a> <a href="#"><strong>0</strong>待发货</a>
								<a href="#"><strong>0</strong>待付款</a> <a href="#"><strong>0</strong>待评价</a>
							</div>
							<div class="clear"></div>
						</div>

						<li><a target="_blank" href="#"><span>[特惠]</span>洋河年末大促，低至两件五折</a>
						</li>
						<li><a target="_blank" href="#"><span>[公告]</span>华北、华中部分地区配送延迟</a>
						</li>
						<li><a target="_blank" href="#"><span>[特惠]</span>家电狂欢千亿礼券
								买1送1！</a></li>

					</ul>
					<div class="advTip">
						<img
							src="${pageContext.request.contextPath }/jsp/mall/images/advTip.jpg" />
					</div>
				</div>
			</div> --%>
			<div class="clear"></div>
		</div>
		<script type="text/javascript">
			if ($(window).width() < 640) {
				function autoScroll(obj) {
					$(obj).find("ul").animate({
						marginTop : "-39px"
					}, 500, function() {
						$(this).css({
							marginTop : "0px"
						}).find("li:first").appendTo(this);
					})
				}
				$(function() {
					setInterval('autoScroll(".demo")', 3000);
				})
			}
		</script>
	</div>
	<div class="shopMainbg">
		<div class="shopMain" id="shopmain">

			<!--今日推荐 -->

			<div class="am-g am-g-fixed recommendation">
				<div class="clock am-u-sm-3">
					<img
						src="${pageContext.request.contextPath }/jsp/mall/images/2016.png "></img>
					<p>
						今日<br>推荐
					</p>
				</div>
				<c:forEach items="${productrecommends }" var="productrecommend"
					varStatus="status">
					<div class="am-u-sm-4 am-u-lg-3 ">
						<div class="info ">
							<h3>${productrecommend.productname }</h3>
							<h4></h4>
						</div>
						<div class="recommendationMain one">
							<a
								href="${pageContext.request.contextPath }/product/productInfo?id=${productrecommend.productid }"><img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productrecommend.picture }"></img>
							</a>
						</div>
					</div>
				</c:forEach>
			</div>
			<div class="clear "></div>
			<!--热门活动 -->

			<div class="am-container activity ">
				<div class="shopTitle ">
					<h4>活动</h4>
					<h3>每期活动 优惠享不停</h3>
					<span class="more "> <a href="# ">全部活动<i
							class="am-icon-angle-right" style="padding-left:10px ;"></i> </a> </span>
				</div>
				<div class="am-g am-g-fixed ">
					<c:forEach items="${productDiscounts }" var="productDiscount">
						<div class="am-u-sm-3 " style="padding: 6px;margin: 0px;">
							<div class="icon-sale two "></div>
							<h4>特惠</h4>
							<div class="activityMain">
								<a href="${pageContext.request.contextPath }/product/productInfo?id=${productDiscount.productid }"><img
									src="${pageContext.request.contextPath }/jsp/mall/images/activity2.jpg"></img></a>
							</div>
							<div class="info" style="opacity : 0.5;">
								<h3><a 
								href="${pageContext.request.contextPath }/product/productInfo?id=${productDiscount.productid }">${productDiscount.productname }</a></h3>
							</div>
						</div>

					</c:forEach>




				</div>
			</div>
			<div class="clear "></div>

			<c:forEach items="${allTypeProducts }" var="oneTypeProducts" varStatus="ststus">
				<div id="f1">
					<!--循环展示商品-->
					<div class="am-container ">
						<div class="shopTitle ">
							<h4>${oneTypeProducts.key.producttypename }</h4>
							<!-- <div class="today-brands ">
								<a href="# ">腰果</a> <a href="# ">松子</a> <a href="# ">夏威夷果 </a> <a
									href="# ">碧根果</a> <a href="# ">开心果</a> <a href="# ">核桃仁</a>
							</div> -->
							<span class="more "> <a href="${pageContext.request.contextPath }/jsp/mall/home/allProduct.jsp?producttypeid=${oneTypeProducts.key.producttypeid }&producttypename=${oneTypeProducts.key.producttypename } " target="_black">更多<i
									class="am-icon-angle-right" style="padding-left:10px ;"></i> </a> </span>
						</div>
					</div>
					<div class="am-g am-g-fixed floodThree ">
						<div class="am-u-sm-4 text-four list">
							<!-- <div class="word">
								<a class="outer" href="#"><span class="inner"><b
										class="text">核桃</b> </span> </a> <a class="outer" href="#"><span
									class="inner"><b class="text">核桃</b> </span> </a> <a class="outer"
									href="#"><span class="inner"><b class="text">核桃</b> </span>
								</a> <a class="outer" href="#"><span class="inner"><b
										class="text">核桃</b> </span> </a> <a class="outer" href="#"><span
									class="inner"><b class="text">核桃</b> </span> </a> <a class="outer"
									href="#"><span class="inner"><b class="text">核桃</b> </span>
								</a>
							</div> -->
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[0].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[0].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[0].productname }</div>
									<div class="title ">${oneTypeProducts.value[0].price }</div>
								</div> </a>
							<div class="triangle-topright"></div>
						</div>
						<div class="am-u-sm-4 text-four">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[1].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[1].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[1].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[1].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
						<div class="am-u-sm-4 text-four sug">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[2].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[2].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[2].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[2].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
	
						<div class="am-u-sm-6 am-u-md-3 text-five big ">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[3].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[3].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[3].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[3].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
						<div class="am-u-sm-6 am-u-md-3 text-five ">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[4].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[4].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[4].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[4].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
						<div class="am-u-sm-6 am-u-md-3 text-five sug">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[5].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[5].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[5].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[5].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
						<div class="am-u-sm-6 am-u-md-3 text-five big">
							<a href="${pageContext.request.contextPath }/product/productInfo?id=${oneTypeProducts.value[6].productid }"> <img
								src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${oneTypeProducts.value[6].picture }" />
								<div class="outer-con ">
									<div class="title ">${oneTypeProducts.value[6].productname }</div>
									<div class="sub-title ">¥${oneTypeProducts.value[6].price }</div>
									<i class="am-icon-shopping-basket am-icon-md  seprate"></i>
								</div> </a>
						</div>
	
					</div>
	
					<div class="clear "></div>
				</div>
			</c:forEach>


			<c:import url="/jsp/mall/footer.jsp"></c:import>

		</div>
	</div>
	<%-- <!--引导 -->
	<div class="navCir">
		<li class="active"><a href="home.html"><i
				class="am-icon-home "></i>首页</a></li>
		<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
		<li><a href="shopcart.html"><i
				class="am-icon-shopping-basket"></i>购物车</a></li>
		<li><a
			href="${pageContext.request.contextPath }/jsp/mall/person/index.html"><i
				class="am-icon-user"></i>我的</a></li>
	</div> --%>
	<c:import url="homeMenu.jsp"></c:import>

	
	<script>
		window.jQuery
				|| document
						.write('<script src="${pageContext.request.contextPath }/jsp/mall/basic/js/jquery.min.js "><\/script>');
	</script>
	<script type="text/javascript "
		src="${pageContext.request.contextPath }/jsp/mall/basic/js/quick_links.js "></script>
	<%-- <script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/basic/js/mallIndex.js"></script> --%>
		
		
		
	<script type="text/javascript">
	
	$(document).ready(function(){
		$("#js_climit_li li").mouseenter(function(){
			
			//alert($(this).attr("value"));商品类型的值
			//alert($(this).find("div.sort-side").find("dt").find("span").text());
			var producttypeid = $(this).attr("value");
			var pType = $(this).find("div.category-info").find("a");
			//var dt = $(this).find("div.sort-side").find("dt").find("span");
			var dl = $(this).find("div.sort-side").find("dl");
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:"${pageContext.request.contextPath }/product/quereyProduct_json",
				data:'{"producttypeid"'+':'+'"'+producttypeid+'"'
					+'}',
				
				success:function(data){
					//alert(data);
					/* <dt><span title="蛋糕">名字</span></dt>
																<dd>
																	<a title="蒸蛋糕" href="#"><span>类容</span> </a>
																</dd>
					 */
					dl.html("");
					dl.append('<dt><span title="类型名字">'+ pType.text() +'</span></dt>');
					for(var i in data){
						//dd.text(data[i].productname);
						dl.append(
						
							'<dd>'+
								'<a title="商品" href="${pageContext.request.contextPath }/product/productInfo?id='+ data[i].productid +'"><span>'+ data[i].productname  +'</span> </a>'+
							'</dd>'
						
						);
						
					}
					
					
					
				
				
				
				}
			});
			
			
		});
	});
	</script>
</body>

</html>
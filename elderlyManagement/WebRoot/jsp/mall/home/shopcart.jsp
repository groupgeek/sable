<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>购物车页面</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/css/cartstyle.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/css/optstyle.css" rel="stylesheet" type="text/css" />
		

		<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

	</head>

	<body>
	<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
		<!--顶部导航条 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>


			<div class="clear"></div>

			<!--购物车 -->
			<div class="concent">
				<div id="cartTable">
					<div class="cart-table-th">
						<div class="wp">
							<div class="th th-chk">
								<div id="J_SelectAll1" class="select-all J_SelectAll">

								</div>
							</div>
							<div class="th th-item">
								<div class="td-inner">商品信息</div>
							</div>
							<div class="th th-price">
								<div class="td-inner">单价</div>
							</div>
							<div class="th th-amount">
								<div class="td-inner">数量</div>
							</div>
							<div class="th th-sum">
								<div class="td-inner">金额</div>
							</div>
							<div class="th th-op">
								<div class="td-inner">操作</div>
							</div>
						</div>
					</div>
					<div class="clear"></div>

					<tr class="item-list">
						<div class="bundle  bundle-last ">
							<div class="bundle-hd">
								<!-- <div class="bd-promos">
									<div class="bd-has-promo">已享优惠:<span class="bd-has-promo-content">省￥19.50</span>&nbsp;&nbsp;</div>
									<div class="act-promo">
										<a href="#" target="_blank">第二支半价，第三支免费<span class="gt">&gt;&gt;</span></a>
									</div>
									<span class="list-change theme-login">编辑</span>
								</div> -->
							</div>
							<div class="clear"></div>
							<div class="bundle-main" id = "data">
							</div>
						</div>
					</tr>
					<div class="clear"></div>

				</div>
				<div class="clear"></div>

				<div class="float-bar-wrapper">
					<div id="J_SelectAll2" class="select-all J_SelectAll">
						<div class="cart-checkbox">
							<input checked = "checked" class="check-all check" id="select-all" name="select-all" value="true" type="checkbox" style="position: relative;top: -8px;">
							<label for="J_SelectAllCbx2"></label>
						</div>
						<span>全选</span>
					</div>
					<div class="operations">
						<a href="#" hidefocus="true" class="deleteAll">删除</a>
					</div>
					<div class="float-bar-right">
						<!-- <div class="amount-sum">
							<span class="txt">已选商品</span>
							<em id="J_SelectedItemsCount">0</em><span class="txt">件</span>
							<div class="arrow-box">
								<span class="selected-items-arrow"></span>
								<span class="arrow"></span>
							</div>
						</div>
						<div class="price-sum">
							<span class="txt">合计:</span>
							<strong class="price">¥<em id="J_Total">0.00</em></strong>
						</div> -->
						<div class="btn-area">
							<a href="javascript:;" id="pay" class="submit-btn submit-btn-disabled" aria-label="请注意如果没有选择宝贝，将无法结算">
								<span>结&nbsp;算</span></a>
						</div>
					</div>

				</div>

				<c:import url="/jsp/mall/footer.jsp"></c:import>

			</div>

			<!--操作页面-->

			<div class="theme-popover-mask"></div>

			<div class="theme-popover">
				<div class="theme-span"></div>
				<div class="theme-poptit h-title">
					<a href="javascript:;" title="关闭" class="close">×</a>
				</div>
				<div class="theme-popbod dform" id = "productOption">
					<form class="theme-signin" name="loginform" action="" method="post">

						<div class="theme-signin-left">
							<ul>
							<li class="theme-options">
								<div class="cart-title" id = "colour">颜色：</div>
								<input type="hidden" id = "colourTempId">
								<ul id = "colourList">
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title" id = "size">型号：</div>
								<input type="hidden" id = "sizeTempString" name = "sizeTempString"> 
								<ul id = "sizeList">
									
								</ul>
							</li>
							<li class="theme-options">
								<div class="cart-title" id = "taste">口味：</div>
								<input type="hidden" id = "tasteTempId">
								<ul id = "tasteList">
									<li class="sku-line selected">包装：裸装<i></i></li>
								</ul>
							</li>
							</ul>
							<div class="clear"></div>
							<div class="btn-op">
								<input type="hidden" id = "producttype">
								<input type="hidden" id = "shoppingcarid">
								
								
								
								<div class="btn close am-btn am-btn-warning save">确认</div>
								<div class="btn close am-btn am-btn-warning">取消</div>
							</div>

						</div>

					</form>
				</div>
			</div>
		<!--引导 -->
		<div class="navCir">
			<li><a href="home.html"><i class="am-icon-home "></i>首页</a></li>
			<li><a href="sort.html"><i class="am-icon-list"></i>分类</a></li>
			<li class="active"><a href="shopcart.html"><i class="am-icon-shopping-basket"></i>购物车</a></li>	
			<li><a href="../person/index.html"><i class="am-icon-user"></i>我的</a></li>					
		</div>
		
		
		
		<script type="text/javascript"
			src="${pageContext.request.contextPath }/jsp/mall/home/js/shopcart.js"></script>
	</body>

</html>
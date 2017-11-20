<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>
<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="${pageContext.request.contextPath }/jsp/mall/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath }/jsp/mall/css/style.css" rel="stylesheet" />

		<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/jquery-1.7.min.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/list.js"></script>
	</head>

	<body>


		<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">

		<!--顶部导航条 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>

			<div class="clear"></div>
            <b class="line"></b>
			<div class="listMain">

				<!--分类-->
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<!-- <ul>
								<li class="index"><a href="#">共搜素到商品1件</a></li>
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
				<ol class="am-breadcrumb am-breadcrumb-slash" id = "productSum">
					<li><a href="${pageContext.request.contextPath }/product/mallIndex">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/product/search">分类</a></li>
					<li class="am-active">内容</li>
					<li>共搜素到商品<strong>1</strong>件</li>
				</ol>
				<script type="text/javascript">
					$(function() {});
					$(window).load(function() {
						$('.flexslider').flexslider({
							animation: "slide",
							start: function(slider) {
								$('body').removeClass('loading');
							}
						});
					});
				</script>

				<!--放大镜-->

				<div class="clear"></div>
				
							
				<!-- introduce-->

				<div class="introduce">
					<div class="browse">
					    <div class="mc"> 
						     <ul>					    
						     	<div class="mt">            
						            <h2>热销产品</h2>        
					            </div>
						     	
							     
						     </ul>					
					    </div>
					</div>
					<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">

								<li>
									<a href="#">

										<span class="index-needs-dt-txt">猜你喜欢</span></a>
								</li>
							</ul>

							<div class="am-tabs-bd">


								<div class="am-tab-panel am-fade">
									<div class="like">
										<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes">
											<!-- 数据 -->
											
										</ul>
									</div>
									<div class="clear"></div>

									<!--分页 -->
									<p style="float: right; height: 10px;">当前为第<strong id = "productCurrentPage">1</strong>页</p>
									<ul class="am-pagination am-pagination-right" id = "ull">
										<li value = 0 id = "home"><a href="javascript:;">首页</a></li>
										<li value = 0 id = "previousPage"><a href="javascript:;">&laquo;</a></li>
										<li value = 0 id = "nextPage"><a href="javascript:;">&raquo;</a></li>
										<li value = 0 id = "lastPage"><a href="javascript:;">尾页</a></li>
									</ul>
									<div class="clear"></div>

								</div>

							</div>

						</div>

						<div class="clear"></div>

						<c:import url="/jsp/mall/footer.jsp"></c:import>
					</div>

				</div>
			</div>
			<!-- 菜單 -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/home/js/allProduct.js"></script>
	</body>

</html>
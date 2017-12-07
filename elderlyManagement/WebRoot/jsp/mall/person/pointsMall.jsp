<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品页面</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/util/css/common.css"/>
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
					   <div class="long-title"><span class="all-goods">积分商城</span></div>
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
					<li><a href="${pageContext.request.contextPath }/jsp/mall/person/index.jsp">个人中心</a></li>
					<li><a href="${pageContext.request.contextPath }/jsp/mall/person/pointsMall.jsp">积分商城</a></li>
					<li class="am-active">商品</li>
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

										<span class="index-needs-dt-txt" id = "pointsProduct">积分商品</span></a>
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
										<li id = "home"><a href="javascript:void(0)">首页</a></li>
										<li id = "previousPage"><a href="javascript:void(0)">&laquo;</a></li>
										<li id = "nextPage"><a href="javascript:void(0)">&raquo;</a></li>
										<li id = "lastPage"><a href="javascript:void(0)">尾页</a></li>
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
			<!--菜单 -->
			<c:import url="/jsp/mall/home/homeMenu.jsp"></c:import>
			
			<div id="wrapper">
			
				
				<div class="box">
					<div class="demo">
						<!-- <a href="javascript:;" class="rollIn">DEMO2</a> -->
					</div>
					
					<div id="dialogBg"></div>
					<div id="dialog" class="animated">
						<img class="dialogIco" width="50" height="50" src="${pageContext.request.contextPath }/jsp/util/images/ico.png" alt="" />
						<div class="dialogTop">
							<a href="javascript:;" class="claseDialogBtn">关闭</a>
						</div>
						<form action="${pageContext.request.contextPath }/product/addIntegralOrder" method="post" id="editForm">
								<input type="hidden" id = "articleid" name="articleid"/>
							<ul class="editInfos">
								<li><label><font color="#ff0000">* </font>手机：<input type="text" id = "phone" name="phone" required  class="ipt" placeholder="手机号码"/></label></li>
								<li><label><font color="#ff0000">* </font>密码：<input type="password" id = "password" name="password" required  class="ipt" placeholder="密码"/></label></li>
								<li><label><font color="#ff0000">* </font>地址：<textarea id = "resaddress" name="resaddress" required  class="ipt"  rows="3" cols="3" style="height: 50px;" placeholder="收货地址"></textarea></label></li>
								<li><input type="submit" value="确认提交" class="submitBtn" /></li>
							</ul>
						</form>
					</div>
				</div>
				
			</div>
						
			<script type="text/javascript">
				/* var w,h,className;
				function getSrceenWH(){
					w = $(window).width();
					h = $(window).height();
					$('#dialogBg').width(w).height(h);
				}
				
				window.onresize = function(){  
					getSrceenWH();
				}  
				$(window).resize();  
				
				$(function(){
					getSrceenWH();
					
					//显示弹框
					$('.box a').click(function(){
						className = $(this).attr('class');
						$('#dialogBg').fadeIn(300);
						$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
					});
					
					//关闭弹窗
					$('.claseDialogBtn').click(function(){
						$('#dialogBg').fadeOut(300,function(){
							$('#dialog').addClass('bounceOutUp').fadeOut();
						});
					});
				}); */
			</script>
			
			
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/person/js/pointsMall.js"></script>
	</body>

</html>
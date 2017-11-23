<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu</title>
	
</head>
<body>
<!--菜单 -->
	<div class=tip>
		<div id="sidebar">
			<div id="wrap">
				<div id="prof" class="item ">
					<a href="# "> <span class="setting "></span> </a>
					<div class="ibar_login_box status_login ">
						<div class="avatar_box ">
							<p class="avatar_imgbox ">
								<img src="${pageContext.request.contextPath }/jsp/mall/images/no-img_mid_.jpg " />
							</p>
							<ul class="user_info ">
								<li></li>
								<li></li>
							</ul>
						</div>
						<div class="login_btnbox ">
							<a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp " class="login_order ">我的订单</a> <a href="${pageContext.request.contextPath }/jsp/mall/person/evaluation.jsp"
								class="login_favorite ">我的小窝</a>
						</div>
						<i class="icon_arrow_white "></i>
					</div>

				</div>
				<div id="shopCart " class="item ">
					<a href="${pageContext.request.contextPath }/jsp/mall/home/shopcart.jsp"> <span class="message "></span> </a>
					<p>购物车</p>
					<p class="cart_num ">0</p>
				</div>
				<div id="asset " class="item ">
					<a href="${pageContext.request.contextPath }/jsp/mall/person/points.jsp"> <span class="view "></span> </a>
					<div class="mp_tooltip ">
						我的资产 <i class="icon_arrow_right_black "></i>
					</div>
				</div>

				
				<div id="brand " class="item ">
					<a href="${pageContext.request.contextPath }/jsp/mall/person/order.jsp"> <span class="wdsc "><img
							src="${pageContext.request.contextPath }/jsp/mall/images/wdsc.png " /> </span> </a>
					<div class="mp_tooltip ">
						我的订单<i class="icon_arrow_right_black "></i>
					</div>
				</div>	


				<%-- <div id="broadcast " class="item ">
					<a href="# "> <span class="chongzhi "><img
							src="${pageContext.request.contextPath }/jsp/mall/images/chongzhi.png " /> </span> </a>
					<div class="mp_tooltip ">
						我要充值 <i class="icon_arrow_right_black "></i>
					</div>
				</div> --%>

				<div class="quick_toggle ">
					<!-- <li class="qtitem "><a href="# "><span class="kfzx "></span>
					</a>
						<div class="mp_tooltip ">
							客服中心<i class="icon_arrow_right_black "></i>
						</div>
					</li> -->
					<!--二维码 -->
					<li class="qtitem "><a href="#none "><span
							class="mpbtn_qrcode "></span> </a>
						<div class="mp_qrcode " style="display:none; ">
							<img
								src="${pageContext.request.contextPath }/jsp/mall/images/weixin_code_145.png " /><i
								class="icon_arrow_white "></i>
						</div>
					</li>
					<li class="qtitem "><a href="#top " class="return_top "><span
							class="top "></span> </a>
					</li>
				</div>

				<!--回到顶部 -->
				<div id="quick_links_pop " class="quick_links_pop hide "></div>

			</div>

		</div>
		<div id="prof-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>我</div>
		</div>
		<div id="shopCart-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>购物车</div>
		</div>
		<div id="asset-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>资产</div>

			<div class="ia-head-list ">
				<a href="# " target="_blank " class="pl ">
					<div class="num ">0</div>
					<div class="text ">优惠券</div> </a> <a href="# " target="_blank "
					class="pl ">
					<div class="num ">0</div>
					<div class="text ">红包</div> </a> <a href="# " target="_blank "
					class="pl money ">
					<div class="num ">￥0</div>
					<div class="text ">余额</div> </a>
			</div>

		</div>
		<div id="foot-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>足迹</div>
		</div>
		<div id="brand-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>收藏</div>
		</div>
		<div id="broadcast-content " class="nav-content ">
			<div class="nav-con-close ">
				<i class="am-icon-angle-right am-icon-fw "></i>
			</div>
			<div>充值</div>
		</div>
	</div>
	<input type = "hidden" id = "href" value="${pageContext.request.contextPath }">
	<script type="text/javascript">
	$(document).ready(function(){
		var root =  $("#href").attr("value");
	//var root = ${pageContext.request.contextPath };
	
		//显示当前用户如果没有就跳转到登录界面
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/getLoginUser",
		success:function(data){
				
				$(".user_info li").first().text("用户名："+data.username);
				$(".user_info li").last().text("等级："+data.level.level);
				$(".setting").parent().attr("href",root+"/jsp/mall/person/information.jsp");
				$(".user_info").prev().find("img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.avatar);
		}
	});
	
	
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/user/queryCartNum",
		success:function(data){
				//$(".J_MiniCartNum").text(data);
				$(".cart_num ").text(data);
		}
	});
	});
	
	
	</script>
	
</body>
</html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>安全设置</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/infstyle.css" rel="stylesheet" type="text/css">
		
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

					<!--标题 -->
					<div class="user-safety">
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">账户安全</strong></div>
						</div>
						<hr/>

						<!--头像 -->
						<div class="user-infoPic">

							<div class="filePic">
								<input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*">
								<img class="am-circle am-img-thumbnail" src="../images/getAvatar.do.jpg" alt="" />
							</div>

							<p class="am-form-help">头像</p>

							<div class="info-m">
								<div><b>用户名：<i></i></b></div>
								<div class="u-level">
									<span class="rank r2">
							             <s class="vip1"></s><a class="classes" href="javascript:;"></a>
						            </span>
								</div>
								<div class="u-safety">
									<a href="safety.html">
									 账户安全
									<span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
									</a>
								</div>
							</div>
						</div>

						<div class="check">
							<ul>
								<li>
									<i class="i-safety-lock"></i>
									<div class="m-left">
										<div class="fore1">登录密码</div>
										<div class="fore2"><small>为保证您购物安全，建议您定期更改密码以保护账户安全。</small></div>
									</div>
									<div class="fore3">
										<a href="${pageContext.request.contextPath }/jsp/mall/person/password.jsp">
											<div class="am-btn am-btn-secondary">修改</div>
										</a>
									</div>
								</li>
								<!-- <li>
									<i class="i-safety-wallet"></i>
									<div class="m-left">
										<div class="fore1">支付密码</div>
										<div class="fore2"><small>启用支付密码功能，为您资产账户安全加把锁。</small></div>
									</div>
									<div class="fore3">
										<a href="setpay.html">
											<div class="am-btn am-btn-secondary">立即启用</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-iphone"></i>
									<div class="m-left">
										<div class="fore1">手机验证</div>
										<div class="fore2"><small>您验证的手机：186XXXXXXXX 若已丢失或停用，请立即更换</small></div>
									</div>
									<div class="fore3">
										<a href="bindphone.html">
											<div class="am-btn am-btn-secondary">换绑</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-mail"></i>
									<div class="m-left">
										<div class="fore1">邮箱验证</div>
										<div class="fore2"><small>您验证的邮箱：5831XXX@qq.com 可用于快速找回登录密码</small></div>
									</div>
									<div class="fore3">
										<a href="email.html">
											<div class="am-btn am-btn-secondary">换绑</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-idcard"></i>
									<div class="m-left">
										<div class="fore1">实名认证</div>
										<div class="fore2"><small>用于提升账号的安全性和信任级别，认证后不能修改认证信息。</small></div>
									</div>
									<div class="fore3">
										<a href="idcard.html">
											<div class="am-btn am-btn-secondary">认证</div>
										</a>
									</div>
								</li>
								<li>
									<i class="i-safety-security"></i>
									<div class="m-left">
										<div class="fore1">安全问题</div>
										<div class="fore2"><small>保护账户安全，验证您身份的工具之一。</small></div>
									</div>
									<div class="fore3">
										<a href="question.html">
											<div class="am-btn am-btn-secondary">认证</div>
										</a>
									</div>
								</li> -->
							</ul>
						</div>

					</div>
				</div>
				<!--底部-->
				<c:import url="/jsp/mall/footer.jsp"></c:import>
			</div>

			<!-- 菜单 -->
			<c:import url="/jsp/mall/personMenu.jsp"></c:import>
		</div>
	<script src="${pageContext.request.contextPath }/jsp/mall/person/js/safety.js"></script>	
	</body>

</html>
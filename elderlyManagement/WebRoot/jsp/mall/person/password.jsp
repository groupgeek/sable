<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>修改密码</title>

		
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/stepstyle.css" rel="stylesheet" type="text/css">

		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<script src=".${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js"></script>

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

					<div class="am-cf am-padding">
						<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">修改密码</strong>&nbsp;&nbsp;/&nbsp;&nbsp;
						<a href = "${pageContext.request.contextPath }/jsp/logReg/forgot.jsp">忘记密码?</a></div>
					</div>
					<hr/>
					<!--进度条-->
					<div class="m-progress">
						<div class="m-progress-list">
							<span class="step-1 step">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">1<em class="bg"></em></i>
                                <p class="stage-name">重置密码</p>
                            </span>
							<span class="step-2 step" id ="success">
                                <em class="u-progress-stage-bg"></em>
                                <i class="u-stage-icon-inner">2<em class="bg"></em></i>
                                <p class="stage-name">完成</p>
                            </span>
							<span class="u-progress-placeholder"></span>
						</div>
						<div class="u-progress-bar total-steps-2">
							<div class="u-progress-bar-inner"></div>
						</div>
					</div>
					<form class="am-form am-form-horizontal">
						<div class="am-form-group">
							<label for="user-old-password" class="am-form-label">原密码</label>
							<div class="am-form-content">
								<input type="hidden" value = 0 id = "old-password">
								<input type="password" id="user-old-password" placeholder="请输入原登录密码">
								<span style="color: red;display: none;">密码只能包含字母数字，不能含有特殊字符</span>
								<span></span>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-new-password" class="am-form-label">新密码</label>
							<div class="am-form-content">
								<input type="hidden" value = 0 id = "new-password">
								<input type="password" id="user-new-password" placeholder="由数字、字母组合">
								<span style="color: red;display: none;">密码只能包含字母数字，不能含有特殊字符</span>
							</div>
						</div>
						<div class="am-form-group">
							<label for="user-confirm-password" class="am-form-label">确认密码</label>
							<div class="am-form-content">
								<input type="hidden" value = 0 id = "confirm-password">
								<input type="password" id="user-confirm-password" placeholder="请再次输入上面的密码">
								<span style="color: red; display: none;">密码只能包含字母数字，不能含有特殊字符</span>
							</div>
						</div>
						<div class="info-btn">
							<div class="am-btn am-btn-danger">保存修改</div>
						</div>

					</form>

				</div>
				<!--底部-->
				<c:import url="/jsp/mall/footer.jsp"></c:import>
			</div>

			<!-- 菜单 -->
			<c:import url="/jsp/mall/personMenu.jsp"></c:import>
		</div>
	<script src="${pageContext.request.contextPath }/jsp/mall/person/js/password.js"></script>	
	</body>

</html>
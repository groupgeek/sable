<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>

	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0,maximum-scale=1.0, user-scalable=0">

		<title>个人资料</title>
		
		<link href="${pageContext.request.contextPath }/jsp/util/_css/wait.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css">

		<link href="${pageContext.request.contextPath }/jsp/mall/css/personal.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/mall/css/infstyle.css" rel="stylesheet" type="text/css">
		<link href="${pageContext.request.contextPath }/jsp/css/ssi-uploader.css" rel="stylesheet" type="text/css">
		<script src="${pageContext.request.contextPath }/jsp/js/ssi-uploader.js"></script>
		<%-- <script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/jquery.min.js" type="text/javascript"></script> --%>
		<script src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js" type="text/javascript"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		
		

	</head>

	<body>
	
	<div id="loading" style="display: none;">
				<div id="loading-center">
					<div id="loading-center-absolute">
						<div class="object" id="object_one"></div>
						<div class="object" id="object_two"></div>
						<div class="object" id="object_three"></div>
						<div class="object" id="object_four"></div>
		
					</div>
				</div>

			</div>
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

					<div class="user-info">
						<!--标题 -->
						<div class="am-cf am-padding">
							<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">个人资料</strong></div>
						</div>
						<hr/>

						<!--头像 -->
						<div class="user-infoPic">

							<div class="filePic">
								<!-- <input type="file" class="inputPic" allowexts="gif,jpeg,jpg,png,bmp" accept="image/*"> -->
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
									<a href="JavaScript:;">
									 账户安全
									<span class="u-profile"><i class="bc_ee0000" style="width: 60px;" width="0">60分</i></span>
									</a>
								</div>
							</div>
						</div>

						<!--个人信息 -->
						<div class="info-main">
							<form id = "formSubmit" class="am-form am-form-horizontal" action="${pageContext.request.contextPath }/product/updateUserInfo" method="post" enctype="multipart/form-data">

								<!-- <div class="am-form-group">
									<label for="user-name2" class="am-form-label">昵称</label>
									<div class="am-form-content">
										<input type="text" id="user-name" placeholder="nickname">

									</div>
								</div> -->

								<div class="am-form-group">
									<label for="user-name" class="am-form-label">姓名</label>
									<div class="am-form-content">
										<input type="text" id="user-name" placeholder="姓名" name="username">

									</div>
								</div>

								<div class="am-form-group">
									<label for="user-name" class="am-form-label">修改图片</label>
									<div class="am-form-content">
										<input type="file" multiple id="ssi-upload" name="pictureUpload"/>

									</div>
								</div>
								<div class="am-form-group">
									<label class="am-form-label">性别</label>
									<div class="am-form-content sex">
										<label class="am-radio-inline">
											<input type="radio" name="sex" value="男" data-am-ucheck> 男
										</label>
										<label class="am-radio-inline">
											<input type="radio" name="sex" value="女" data-am-ucheck> 女
										</label>
										<label class="am-radio-inline">
											<input type="radio" name="sex" value="无" data-am-ucheck> 保密
										</label>
									</div>
								</div>

								<div class="am-form-group">
									<label for="user-birth" class="am-form-label">生日</label>
									<div class="am-form-content birth">
										<input type="text"  id="user-birth" name="birthday" value="" onClick="laydate()">
									</div>
							
								</div>
								<div class="am-form-group">
									<label for="user-phone" class="am-form-label">手机(账号)</label>
									<div class="am-form-content">
										<input id="user-phone" placeholder="电话号码" type="text" readonly="readonly" name="phone">
										<!-- <span id = "updatePhone"><a href="javascript:;">点击修改</a></span>
									<label for="update-phone-label" class="update-phone-label" style="color: red;">请谨慎修改</label> -->
									</div>
								</div>
								<div class="am-form-group">
									<label for="user-email" class="am-form-label">电子邮件</label>
									<div class="am-form-content">
										<input id="user-email" placeholder="邮箱" type="email" name="email">

									</div>
								</div>
								
								<div class="info-btn">
									<input type="hidden" id = "userid" name="userid">
									<!-- <input type="submit" value="保存修改"> -->
									<div class="am-btn am-btn-danger" id = "save">保存修改</div>
								</div>
							</form>
						</div>

					</div>

				</div>
				<!--底部-->
				<c:import url="/jsp/mall/footer.jsp"></c:import>
			</div>
			
			

			<!-- 菜单 -->
			<c:import url="/jsp/mall/personMenu.jsp"></c:import>
			
			
			<c:import url="/jsp/util/messageNotification.jsp"></c:import>
			<%-- <input type = "hidden" value = "${message }" id = "showMessageInput"> --%>
			<!--js  -->
			<script type="text/javascript"
				src="${pageContext.request.contextPath }/jsp/mall/person/js/information.js"></script>
			<script 
				src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.1.8.1.min.js"></script>
			<script 
				src="${pageContext.request.contextPath }/jsp/logReg/js/jquery.validate.messages_zh.js"></script>	
				
			<script src="${pageContext.request.contextPath }/jsp/admin/page/js/laydate.js"></script>	
			<script>
		
				$(document).ready(function() {
					$("#").validate();
				});
			</script>
	</body>

</html>
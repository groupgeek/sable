<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">

<title>活动信息</title>

<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/example.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/sweet-alert.css"> --%>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript"
	src="//g.alicdn.com/de/prismplayer/2.3.0/aliplayer-min.js"></script>
<link rel="stylesheet"
	href="//g.alicdn.com/de/prismplayer/2.3.0/skins/default/aliplayer-min.css" />
<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/style.css">


<!-- Custom Fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/font-awesome/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/fonts/font-slider.css"
	type="text/css">

<!-- jQuery and Modernizr-->
<script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

<!-- Core JavaScript Files -->
<script
	src="${pageContext.request.contextPath }/jsp/edu/js/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath }/jsp/edu/js/photo-gallery.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
    
    	<script type="text/javascript" src="//g.alicdn.com/de/prismplayer/2.3.0/aliplayer-min.js"></script>
<link rel="stylesheet" href="//g.alicdn.com/de/prismplayer/2.3.0/skins/default/aliplayer-min.css" />
    
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jsp/edu/css/example.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jsp/edu/css/sweet-alert.css">
</head>
<body>
	<c:import url="head.jsp"></c:import>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Product Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a
							href="${pageContext.request.contextPath }/jsp/edu/index.jsp">主页</a>
						</li>
						<li><a href="javascript:;">活动信息</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content">
					<!-- class="col-md-8" -->
					<div class="product">
						<div class="col-md-6">
							<div class="image" style="width: 350px;height: 400px;">
								<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${act.activitypicture }" />
							</div>
						</div>
						<input type="hidden" value="${act.activityid }" id="regActid" /> <input
							type="hidden" value="${act.activityname }" id="activityname" /> <input
							type="hidden" value="${pageContext.request.contextPath }"
							id="root" />
						<div class="col-md-6">
							<div class="caption">
								<div class="name">
									<h3>${act.activityname }</h3>
								</div>
								<div class="info">
									<ul>
										<li>报名费：￥${act.registeryfee }元</li>
										<li>开展时间：<fmt:formatDate value="${act.activitydate }"
												pattern="yyyy-MM-dd HH:mm:ss" />
										</li>
										<li>活动状态：${act.activitystatus }</li>
										<c:if test="${act.online==true }">
											<li>开展方式：线上</li>
										</c:if>
										<c:if test="${act.online==false }">
											<li>开展方式：线下</li>
										</c:if>
									</ul>
								</div>
								<input type="hidden" value="${act.registeryfee }" id="registery">
								<input type="hidden" value="${a }" id="a">
								<p id="lll" class="lll">已经报名人数：${a }</p>
								<div class="price">最大报名人数：${act.maxnum }</div>
								
								
								<c:choose>
								
									<c:when test="${act.online==true }">
										
										<div id="ready" class="well" style="width: 300px">
												<label>点击观看： </label><a href="${act.video }"
													class="btn btn-2 ">去围观</a>
										</div>
										
									</c:when>
									
									<c:otherwise>
										<c:if test="${activityregistery.registery == '报名' }">
											<div id="ready" class="well" style="width: 300px">
												<label>已报名</label>
											</div>
										</c:if>
										<c:if test="${activityregistery.registery != '报名' }">
											<div id="ready" class="well" style="width: 300px">
												<label>点击参加活动： </label><a href="#" onclick="one()"
													class="btn btn-2 ">报名</a>
											</div>
										</c:if>
									</c:otherwise>
								
								</c:choose>
								
								
								<div id="light" class="white_content">
									<div class="demo1">
										<div class="actname">
											<p id="name">活动名字：</p>
										</div>
										<div class="acttext">
											<P>${act.activityname }</P>
										</div>
									</div>
									<div class="demo2">
										<div class="money">
											<p id="name">付款金额：</p>
										</div>
										<div class="moneytext">
											<P>￥${act.registeryfee }元</P>
										</div>
									</div>
									<div class="demo3">
										<div class="phone">
											<p id="name">登录账号：</p>
										</div>
										<div class="text">
											<input type="text" id="text" name="hahha"
												value="${user.phone}">
										</div>
									</div>
									<div class="demo4">
										<div class="phone">
											<p id="name">账号密码：</p>
										</div>
										<div class="text">
											<input type="text" id="text" name="hahha"
												value="${user.password }">
										</div>
									</div>
									<div class="subandcon">
										<div class="subbmit">
											<button id="consol-1" type="button"
												style="padding-top:10px;padding-bottom:10px;
									    width:150px;height:40px;margin-top: 0px;
									    margin-left:-30px;"
												onmouseout="xixi()" onmouseover="haha()" onclick="actReg()">
												<span>确认报名</span>
											</button>
										</div>
										<div class="consol">
											<button id="consol-2" type="button"
												style="padding-top:10px;padding-bottom:10px;width:150px;height:40px;margin-top: 0px;margin-left:20px;"
												onmouseout="xixi2()" onmouseover="haha2()" onclick="two()">取消</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="clear"></div>
					</div>
					
					
					<div style="margin-top: 20px;height: 30px"></div>
					<c:choose>
								
									<c:when test="${act.activitytypeid == 6}">
										
										<div class="product-desc">
											<ul class="nav nav-tabs">
												<li class="active"><a href="javascript:;">直播描述</a>
												</li>
											</ul>
											<div class="tab-content">
												<div id="description" class="tab-pane fade in active">
													<p>${act.activitydetails }</p>
												</div>
												
											</div>
										</div>
										
									</c:when>
									
									<c:otherwise>
										
										<input type="hidden" id="actvideo" value="${act.video }">
										<div class="product-desc">
											<ul class="nav nav-tabs">
												<li class="active"><a href="#description">活动描述</a>
												</li>
												<li><a href="#review">视频简介</a>
												</li>
											</ul>
											<div class="tab-content">
												<div id="description" class="tab-pane fade in active">
													<p>${act.activitydetails }</p>
												</div>
												<div id="review" class="tab-pane fade"
													style="padding: 1px;width: 600px;">
													<div class="review-text" style="padding: 1px;">
														<c:if test="${act.video!=null }">
															<div class="prism-player" id="J_prismPlayer"></div>
														</c:if>
														<c:if test="${act.video==null }">
															  暂无视频简介，看看详情吧！
												  </c:if>
													</div>
												</div>
											</div>
										</div>
										
									</c:otherwise>
								
								</c:choose>
					
					<div class="product-related">
						<div class="heading">
							<h2>活动推荐</h2>
						</div>
						<div class="products">
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image">
										<a
											href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[0].activityid}"><img
											src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${allActRec[0].activitypicture }" />
										</a>
									</div>
									<div class="caption">
										<div class="name">
											<h3>
												<a
													href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[0].activityid}">${allActRec[0].activityname}</a>
											</h3>
										</div>
										<c:if test="${ allActRec[0]!=null}">
										<div class="price">报名费：￥${allActRec[0].registeryfee}元</div></c:if>
									</div>
								</div>

							</div>
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image">
										<a
											href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[1].activityid}"><img
											src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${allActRec[1].activitypicture }" />
										</a>
									</div>
									<div class="caption">
										<div class="name">
											<h3>
												<a
													href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[1].activityid}">${allActRec[1].activityname}</a>
											</h3>
										</div>
										<c:if test="${ allActRec[1]!=null}">
										<div class="price">报名费：￥${allActRec[1].registeryfee}元</div></c:if>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-4 col-xs-12">
								<div class="product">
									<div class="image">
										<a
											href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[2].activityid}"><img
											src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${allActRec[2].activitypicture }" />
										</a>
									</div>
									<div class="caption">
										<div class="name">
											<h3>
												<a
													href="${pageContext.request.contextPath }/edu/actInfo.action?id=${allActRec[2].activityid}">${allActRec[2].activityname}</a>
											</h3>
										</div>
										<c:if test="${ allActRec[2]!=null}">
										<div class="price">报名费：￥${allActRec[2].registeryfee}元</div></c:if>
									</div>
								</div>

							</div>
						</div>
						<div class="clear"></div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<c:import url="footer.jsp"></c:import>
	<!-- IMG-thumb -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/edu/js/actReg.js"></script>
	<script
		src="${pageContext.request.contextPath }/jsp/edu/js/sweet-alert.min.js"></script>
		<input type="hidden" value="${act.video }" id="actvideo">
	<script type="text/javascript">
		var video = document.getElementById("actvideo");
		var player = new Aliplayer(
				{
					id : 'J_prismPlayer',
					width : '100%',
					height : '100%',
					autoplay : false,
					//支持播放地址播放,此播放优先级最高
					source : 'http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'
							+ video.value,
					//播放方式二：推荐
					//vid : '07e001ab-d0e2-4ba9-be1f-4e1da1353509',
					playauth : '',
					/*  useH5Prism : true, */
					cover : 'http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/picture/00d98634-e2fc-4bec-8f46-f917aa636ca3.gif'
				}, function(player) {
					console.log('播放器创建好了。');
				});
	</script>
	<script>
		$(document).ready(function() {
			$(".nav-tabs a").click(function() {
				$(this).tab('show');
			});
			$('.nav-tabs a').on('shown.bs.tab', function(event) {
				var x = $(event.target).text(); // active tab
				var y = $(event.relatedTarget).text(); // previous tab
				$(".act span").text(x);
				$(".prev span").text(y);
			});
		});
	</script>
</body>
</html>

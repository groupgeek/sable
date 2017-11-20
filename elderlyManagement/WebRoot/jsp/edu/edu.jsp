<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>孝和教育</title>
<meta name="Keywords" content="孝和教育,孝和网络学院">
<meta name="Description" content="这是一个在线网络教育平台">
<!--引入标签栏图片-->
<link href="${pageContext.request.contextPath }/jsp/edu/image/tz/favicon.ico" rel="icon" type="image/x-icon" />
<!--引入外部样式-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/css/edu.css" type="text/css">
<link type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/payfor.js"></script>
</head>
<body>
<!--header start-->
<div id="header">
	<div class="content">
		<div class="logo">
			<a href="#">
			<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/edulogo11.png" width="145" height="40" alt=""/>
			</a>
		</div>
		<div class="meun">
			<div class="hover"></div>
			<ul>
				<li>
					<a href="${pageContext.request.contextPath }/edu/getpicture.action">首页</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/edu/getonline.action">在线课程</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/edu/getlecture.action">讲座</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/edu/getactivity.action">活动</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/edu/getLive.action">直播</a>
				</li>
				
				<div class="clear"></div>
				<!--流体布局，无固定宽度，最大可设置6个li标签-->
			</ul>
		</div>
		<div class="user">
			<!--这是一个权限，布局，当用户登录后显示-->
			<ul>
				<li>
					<a class="msg" href="${pageContext.request.contextPath }/edu/queryActivityByUserId.action">
					我的课程
					</a>
				</li>
			</ul>
		</div>
		<!--seadch start-->
		<div class="search">
			<div class="search-con">
				<!--表单获取方式 action=“提交地址” medhod="get/post" -->
				<form action="#" method="get">
					<input class="info"	type="text"	name="" placeholder="搜索" value=""/>
					<!--placeholder="搜索" HTML5属性 有的浏览器将不支持-->
					<input class="sub"	type="submit" name="" value="" />
				</form>
			</div>
		</div>
		<!--seadch end-->
	</div>
</div>
<!--header end-->
<!--banner start-->
<div class="banner">
	<div class="content">
		<!--content public-->
		<ul id="bannerBox">
			<li id="1">
				<a href="#">
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/banner1.jpg" width="1200px" height="384" alt="" />
				</a>
			</li>
			<li id="2">
				<a href="#">
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/banner2.jpg" width="1200px" height="384" alt="" />
				</a>
			</li>
			<li id="3">
				<a href="#">
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/banner3.jpg" width="1200px" height="384" alt="" />
				</a>
			</li>
		</ul>
		<!--banner-bottom start-->
		<a href="#" class="conn but-left">
		<em></em>
		</a>
		<a href="#" class="conn but-right">
		<em></em>
		</a>
		<!--banner-bottom ent-->
	</div>
</div>
<!--banner end-->
<!--Notice start-->
<!--<div class="Notice">
				<div class="content">
					<em></em>
				</div>
			</div>-->
<!--new start-->
<div id="new-list" class="content">
	<dl>
		<dt>
			在线课程
		</dt>
		<dd>
			<a href="#">太极</a>
		</dd>
		<dd>
			<a href="#">微信二次开发</a>
		</dd>
		<dd>
			<a href="#">C++</a>
		</dd>
		<dd>
			<a href="#">Android</a>
		</dd>
		<dd>
			<a href="#">IOS</a>
		</dd>
		<dd>
			<a href="#">PHP</a>
		</dd>
		<dd>
			<a href="#">游戏开发</a>
		</dd>
	</dl>
	<dl>
		<dt>
	健康
		</dt>
		<dd>
			<a href="#">网络营销</a>
		</dd>
		<dd>
			<a href="#">SEO</a>
		</dd>
		<dd>
			<a href="#">淘宝美工</a>
		</dd>
		<dd>
			<a href="#">影楼后期</a>
		</dd>
		<dd>
			<a href="#">淘宝营运</a>
		</dd>
	</dl>
	<dl>
		<dt>
			养身
		</dt>
		<dd>
			<a href="#">日语</a>
		</dd>
		<dd>
			<a href="#">韩语</a>
		</dd>
		<dd>
			<a href="#">西班牙语</a>
		</dd>
		<dd>
			<a href="#">广东话</a>
		</dd>
		<dd>
			<a href="#">英语</a>
		</dd>
	</dl>
	<dl>
		<dt>
			娱乐
		</dt>
		<dd>
			<a href="#">语文</a>
		</dd>
		<dd>
			<a href="#">数学</a>
		</dd>
		<dd>
			<a href="#">化学</a>
		</dd>
	</dl>
	<dl class="none">
		<dt>
		休闲
		</dt>
		<dd>
			<a href="#">DIY</a>
		</dd>
		<dd>
			<a href="#">吉他</a>
		</dd>
		<dd>
			<a href="#">钢琴</a>
		</dd>
		<dd>
			<a href="#">古筝</a>
		</dd>
	</dl>
</div>
<!--new end-->
<!--Notice start-->
<!--pro 教学分类项目	开始-->
<div id="pro">
	<div class="content">
		<ul>
			<li class="padding-none">
				<div class="soft">
					<h2>在线课程</h2>
					<p>(20门课程)</p>
					<a href="#">查看更多<span>&gt;&gt;</span></a>
				</div>
				<c:forEach items="${onlines}" var="online" begin="0" end="13">
						<div class="pro-list">
						<img src="/upload/${online.activitypicture }" width="222" height="145" alt="" />
							<p>
								<a href="#">${online.activityname }</a>
							</p>
							<div class="submit">
								<p class="sub-title">${online.activityname }</p>
								<p>讲师：<span>arry</span></p>
								<!--在p标签中加span是方便以后做为动态的时候调用-->
								<p>容量：<span>${online.registeryfee }</span></p>
								<a href="${pageContext.request.contextPath }/edu/getactivityid.action?id=${online.activityid }">查看详情</a>
								<!--关于submit在div标签中 待改进的问题-->
							</div>
						</div>
				 </c:forEach>
				
			<li>
				<div class="soft Occupation">
					<h2>讲座</h2>
					<p>(20门课程)</p>
					<a href="#">查看更多<span>&gt;&gt;</span></a>
				</div>
				<c:forEach items="${lectures}" var="lecture" begin="0" end="13">
						<div class="pro-list">
						<img src="/upload/${lecture.activitypicture }" width="222" height="145" alt="" />
							<p>
								<a href="#">${lecture.activityname }</a>
							</p>
							<div class="submit">
								<p class="sub-title">${lecture.activityname }</p>
								<p>讲师：<span>arry</span></p>
								<!--在p标签中加span是方便以后做为动态的时候调用-->
								<p>容量：<span>${lecture.registeryfee }</span></p>
								<a href="${pageContext.request.contextPath }/edu/getactivityid.action?id=${jiangzuo.activityid }">查看详情</a>
								<!--关于submit在div标签中 待改进的问题-->
							</div>
						</div>
				 </c:forEach>
				
			<li class="none">
				<div class="soft Language">
					<h2>活动</h2>
					<p>(20门课程)</p>
					<a href="#">查看更多<span>&gt;&gt;</span></a>
				</div>
				<c:forEach items="${activitys}" var="activity" begin="0" end="13">
						<div class="pro-list">
						<img src="/upload/${activity.activitypicture }" width="222" height="145" alt="" />
							<p>
								<a href="#">${activity.activityname }</a>
							</p>
							<div class="submit">
								<p class="sub-title">${activity.activityname }</p>
								<p>讲师：<span>arry</span></p>
								<!--在p标签中加span是方便以后做为动态的时候调用-->
								<p>容量：<span>${activity.registeryfee }</span></p>
								<a href="${pageContext.request.contextPath }/edu/getactivityid.action?id=${huodong.activityid }">查看详情</a>
								<!--关于submit在div标签中 待改进的问题-->
							</div>
						</div>
				 </c:forEach>
				
			<li>
				<div class="soft edu">
					<h2>直播</h2>
					<p>(20门课程)</p>
					<a href="#">查看更多<span>&gt;&gt;</span></a>
				</div>
				<c:forEach items="${Lives}" var="Live" begin="0" end="13">
						<div class="pro-list">
						<img src="/upload/${Live.activitypicture }" width="222" height="145" alt="" />
							<p>
								<a href="#">${Live.activityname }</a>
							</p>
							<div class="submit">
								<p class="sub-title">${Live.activityname }</p>
								<p>讲师：<span>arry</span></p>
								<!--在p标签中加span是方便以后做为动态的时候调用-->
								<p>容量：<span>${Live.registeryfee }</span></p>
								<a href="${pageContext.request.contextPath }/edu/getactivityid.action?id=${zhibo.activityid }">查看详情</a>
								<!--关于submit在div标签中 待改进的问题-->
							</div>
						</div>
				 </c:forEach>
			</li>
		</ul>
	</div>
</div>
<!--pro 教学分类项目	结束-->
<!--讲师团队 开始-->
<div class="Lecturer">
<div class="content">
<ul>
	<li>
		<h2>讲师团队</h2>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
				孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t2.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				木子老师
			</dd>
			<dd>
			孝和教育HTML5 CSS3
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
				孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
				<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
			孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t2.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				木子老师
			</dd>
			<dd>
				孝和教育HTML5 CSS3
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
				孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
			孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t2.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				木子老师
			</dd>
			<dd>
				孝和教育HTML5 CSS3
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
				孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
		<dl>
			<dt>
				<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/t1.jpg" width="66" height="66" alt=""/>
			</dt>
			<dd>
				<h4>
				Arry老师
			</dd>
			<dd>
				孝和教育Java CTO
			</dd>
			<dd>
				关注:<span>1200</span>
			</dd>
		</dl>
	</li>

	<li>
		<div class="links">
			<h2>友情连接</h2>
			<a href="#" class="pd">YY直播</a>
			|
			<a href="#">腾讯课堂</a>
			|
			<a href="#">潭州学院</a>
			|
			<a href="#">JAVASCRIPC</a>
			|
			<a href="#">YY教育</a>
			|
			<a href="#">极客学院</a>
			|
			<a href="#">慕课网</a>
			|
			<a href="#">csdn</a>
			|
			<a href="#">HTML5</a>
			|
			<a href="#">腾讯课堂</a>
			|
			<a href="#">潭州学院</a>
			|
			<a href="#">JAVASCRIPC</a>
			|
			<a href="#">YY教育</a>
			|
			<a href="#">极客学院</a>
			|
			<a href="#">慕课网</a>
			|
			<a href="#">csdn</a>
			|
			<a href="#">HTML5</a>
			|
			<a href="#">腾讯课堂</a>
			|
			<a href="#">潭州学院</a>
			|
			<a href="#">JAVASCRIPC</a>
			|
			<a href="#">YY教育</a>
			|
			<a href="#">极客学院</a>
			|
			<a href="#">慕课网</a>
			|
			<a href="#">csdn</a>
			|
			<a href="#">HTML5</a>
			|
			<a href="#">腾讯课堂</a>
			|
			<a href="#">潭州学院</a>
			|
			<a href="#">JAVASCRIPC</a>
			|
			<a href="#">YY教育</a>
			|
			<a href="#">极客学院</a>
			|
			<a href="#">慕课网</a>
			|
			<a href="#">csdn</a>
			|
			<a href="#">HTML5</a>
			|
		</div>
	</li>
	<ul>
		</div>
		</div>
		<!--讲师团队 结束-->
		<!--底部导航 开始-->
		<div class="footer">
			<div class="content">
				<div class="left">
					<dl>
						<dt>
							关于潭州
						</dt>
						<dd>
							<a href="#">了解潭州</a>
						</dd>
						<dd>
							<a href="#">加入潭州</a>
						</dd>
						<dd>
							<a href="#">联系我们</a>
						</dd>
					</dl>
					<dl>
						<dt>
							学习资讯
						</dt>
						<dd>
							<a href="#">WEB前端开发</a>
						</dd>
						<dd>
							<a href="#">JAVA</a>
						</dd>
						<dd>
							<a href="#">C++</a>
						</dd>
					</dl>
					<dl>
						<dt>
							服务中心
						</dt>
						<dd>
							<a href="#">安卓APP</a>
						</dd>
						<dd>
							<a href="#">IOS APP</a>
						</dd>
					</dl>
					<dl>
						<dt>
							关注我们
						</dt>
						<dd>
							<a href="#" class="icon sina"></a>
							<a href="#" class="icon qzone"></a>
						</dd>
					</dl>
				</div>
				<div class="right">
					<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/weixin.png" width="102px" height="127" alt="孝和官方微信"/>
					<p class="title">400-009-6359</p>
					<p>周一至周六 9:30-23:00</p>
					<p>（仅收市话费）</p>
					<p class="H24">
						<a href="13888888888">24小时在线客服</a>
					</p>
				</div>
			</div>
			<div class="Copyright">
				<div class="content">
					Copyright&nbsp&nbsp©&nbsp 2013-2014 &nbsp
					<a href="#">www.mooncollege.cn</a>
					&nbsp All Rights Reserved &nbsp版权所有：孝和教育咨询有限公司&nbsp&nbsp备案号：备13016338号&nbsp&nbsp版面重设:非凡
				</div>
			</div>
		</div>
		<!--底部导航 结束-->
	</ul>
</ul>
<script src="js/jquery.js"></script>
<script src="js/index.js"></script>
</body>
</html>

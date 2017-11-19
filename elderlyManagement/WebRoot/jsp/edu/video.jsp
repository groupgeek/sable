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
<title>活动</title>
<!--引入标签栏图片-->
<link href="image/tz/favicon.ico" rel="icon" type="image/x-icon" />
<!--引入外部样式-->
<link rel="stylesheet" href="css/edu.css" type="text/css">
<link type="text/css" href="css/css.css" rel="stylesheet" />
  <link rel="shortcut icon" href="favicon.ico" type="image/x-icon">
  <link rel="icon" href="favicon.ico" type="image/x-icon">

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
					<a href="${pageContext.request.contextPath }/gggg/getpicture.action">首页</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/gggg/getonline.action">课程</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/gggg/getjiangzuo.action">讲座</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/gggg/gethuodong.action">活动</a>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/gggg/getzhibo.action">直播</a>
				</li>
				<div class="clear"></div>
				<!--流体布局，无固定宽度，最大可设置6个li标签-->
			</ul>
		</div>
		<div class="user">
			<!--这是一个权限，布局，当用户登录后显示-->
			<ul>
				<li>
					<a class="msg" href="${pageContext.request.contextPath }/gggg/queryActivityByUserId.action">
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



 <div class="wrapper">
            <video id="player1" width="1200" height="500" style="max-width:100%;" controls preload="none"
                   data-cast-title="Big Buck Bunny"
                   data-cast-description="Big Buck Bunny is now even more a world standard for video standards"
                   poster="http://mediaelementjs.com/images/big_buck_bunny.jpg">
                <source src="https://commondatastorage.googleapis.com/gtv-videos-bucket/CastVideos/mp4/BigBuckBunny.mp4" data-playlist-thumbnail="http://mediaelementjs.com/images/big_buck_bunny.jpg"
                        title="Big Buck Bunny" data-playlist-description="Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis vestibulum justo arcu. Vestibulum commodo lacus bibendum sollicitudin commodo." type="video/mp4"></source>
                <source src="http://www.streambox.fr/playlists/test_001/stream.m3u8" title="Hls.js Demo" data-playlist-description="Curabitur et malesuada arcu. Praesent hendrerit, quam vel pellentesque aliquam, metus felis mattis velit, quis varius metus diam vitae diam. Integer ante massa, tempor in accumsan eu, sodales in lectus." type="application/x-mpegURL"></source>
                <source src="http://la2.indexcom.com/me/flv/guqin.flv" title="Guqin - Ghost" type="video/flv"></source>
            </video>
        </div>
        <script>
	document.body.querySelector('code').innerText = document.getElementById('mejs-code').innerText;
</script>


        
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
					<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/weixin.png" width="102px" height="127" alt="潭州官方微信"/>
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
					&nbsp All Rights Reserved &nbsp版权所有：湖南潭州教育咨询有限公司&nbsp&nbsp备案号：备13016338号&nbsp&nbsp版面重设:非凡
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

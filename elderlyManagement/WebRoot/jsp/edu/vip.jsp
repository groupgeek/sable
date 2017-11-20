<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>我的课程</title>
<link type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/js.js"></script>
<!--引入标签栏图片-->
<link href="${pageContext.request.contextPath }/jsp/edu/image/tz/favicon.ico" rel="icon" type="image/x-icon" />
<!--引入外部样式-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/css/edu.css" type="text/css">
</head>

<body>
 <!--header start-->
<div id="header">
	<div class="content">
		<div class="logo">
			<a href="#">
			<img src="${pageContext.request.contextPath }/jsp/edu/image/tz/edulogo11.png" width="145" height="33" alt=""/>
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


 <div class="vipBox">
  <div class="vipLeft">
   <h2 class="headImg"><img src="${pageContext.request.contextPath }/jsp/edu/image/tz/userp.png" width="183" height="169" /></h2>
   <h3 class="vipName">${sessionScope.user.username }</h3>
   <ul class="buy-nav">
    <li class="buy-nav1"><a href="vip-sell.html">官网首页</a></li>
    <li class="buy-nav2"><a href="${pageContext.request.contextPath }/edu/getpicture.action">教育首页</a></li>
    <li class="buy-nav3 buy-navCur"><a href="${pageContext.request.contextPath }/edu/getonline.action">在线课程</a></li>
    <li class="buy-nav4"><a href="${pageContext.request.contextPath }/edu/getactivity.action">活动</a></li>
    <li class="buy-nav5"><a href="${pageContext.request.contextPath }/edu/getlecture.action">讲座</a></li>
    <li class="buy-nav6"><a href="${pageContext.request.contextPath }/edu/geLive.action">直播</a></li>
    <li class="buy-nav7"><a href="#">商城</a></li>
   </ul><!--buy-nav/-->
  </div><!--vipLeft/-->
  <div class="vipRight">
   <h2 class="vipTitle">课程列表</h2>
   <table class="vip-proList">
    <tr>
     <th width="136">课程</th>
     <th width="136">课程名</th>
     <th width="106">课程编号</th>
     <th width="56">价格</th>
     <th width="86">容量</th>
     <th width="50">操作</th>
    </tr>
    <c:forEach items="${activitys}" var="activity">
	    <tr>
	     <td align="center"><img src="$/upload/${activity.activitypicture }" width="119" height="79" /></td>
	     <td align="center">${activity.activityname }</td>
	     <td align="center"><strong class="sellName">${activity.activityid }</strong></td>
	     <td align="center">${activity.activityprice }</td>
	     <td align="center">${activity.maxnum }</td>
	     <td align="center"><a href="${pageContext.request.contextPath }/edu/delectactivityid.action?activityid=${activity.activityid }" class="shan">删除</a></td>
	    </tr>
    </c:forEach>
   </table><!--vip-proList/-->
  </div><!--vipRight/-->
  <div class="clears"></div>
 </div><!--vipBox/-->
 <div class="footBox">
  <div class="footers">
   <div class="footersLeft">
    <a href="index.html"><img src="${pageContext.request.contextPath }/jsp/edu/image/tz/ftlogo.jpg" width="240" height="64" /></a>
    <h3 class="ftphone">400 000 0000 </h3>
    <div class="ftKe">
     客服 7x24小时(全年无休)<br />
     <span>客服邮箱：kefu@webqin.net </span>
    </div><!--ftKe/-->
   </div><!--footersLeft/-->
   <div class="footersRight">
    <ul>
     <li class="ftTitle">新手指南</li>
     <li><a href="#">购物流程</a></li>
     <li><a href="#">会员计划及划分</a></li>
     <li><a href="#">优惠券规则</a></li>
     <li><a href="#">联系客服</a></li>
     <li><a href="#">常见问题</a></li>
    </ul>
    <ul>
     <li class="ftTitle">付款方式</li>
     <li><a href="#">在线支付</a></li>
     <li><a href="#">礼品卡支付</a></li>
     <li><a href="#">货到付款</a></li>
     <li><a href="#">银行付款</a></li>
    </ul>
    <ul>
     <li class="ftTitle">配送服务</li>
     <li><a href="#">配送时效及运费</a></li>
     <li><a href="#">超时赔付</a></li>
     <li><a href="#">验货与签收</a></li>
     <li><a href="#">配货信息跟踪</a></li>
    </ul>
    <ul>
     <li class="ftTitle">售后服务</li>
     <li><a href="#">退换货政策</a></li>
     <li><a href="#">退换货区域</a></li>
     <li><a href="#">退款时限</a></li>
     <li><a href="#">先行赔付</a></li>
     <li><a href="#">发票说明</a></li>
    </ul>
    <ul>
     <li class="ftTitle">特色服务</li>
     <li><a href="#">礼品卡</a></li>
     <li><a href="#">产品试用</a></li>
     <li><a href="#">花粉中心</a></li>
     <li><a href="#">快速购物</a></li>
     <li><a href="#">推荐好友</a></li>
    </ul>
    
    <div class="clears"></div>
   </div><!--footersRight/-->
   <div class="clears"></div>
  </div><!--footers/-->
 </div><!--footBox/-->
 <div class="footer" style="text-align:left;">
  <a href="#">关于我们</a>
  <a href="#">友情链接</a>
  <a href="#">版权声明</a>
  <a href="#">网站地图</a>
  <br />
  
 </div><!--footer/-->
</body>
</html>

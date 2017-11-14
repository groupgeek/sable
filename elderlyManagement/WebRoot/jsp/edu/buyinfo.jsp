<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>详情</title>
<link href="${pageContext.request.contextPath }/jsp/edu/image/tz/favicon.ico" rel="icon" type="image/x-icon" />
<!--引入外部样式-->
<link rel="stylesheet" href="${pageContext.request.contextPath }/jsp/edu/css/edu.css" type="text/css">
</head>
<link type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/css.css" rel="stylesheet" />
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/js.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/edu/js/payfor.js"></script>
</head>

<body>
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
				<!--li a标签下面的span是最新信息提醒的预留设置,给的固定宽度,最多3个li标签-->
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
 
 <div class="buyinfo">
  <div class="buyDtl">
   <div class="buyDtlLeft">
    <div class="buyimgBig">
     <img src="/upload/${activity.activitypicture }" width="360" height="360" />
        </div><!--buyimgBig/-->
    
   </div><!--buyDtlLeft/-->
   <div class="buyDtlRight">
    <h3>${activity.activityname } </h3>
    <h3>价格：<span>￥</span><strong id="price_item_1">${activity.activityprice }</strong></h3>
    <table class="buyTable">
     <tr>
      <th width="70"><h3>编号</h3></th>
      <td><h3>${activity.activityid}</h3></td>
     </tr>
     <tr>
      <th width="70"><h3>名称</h3></th>
      <td><h3>${activity.activityname}</h3></td>
     </tr>
     <tr>
      <th width="70"><h3>容量</h3></th>
      <td>
       <ul class="buyji">
        <li><h3>${activity.maxnum}</h3></li>
        <div class="clears"></div>
       </ul><!--buyji/-->
      </td>
     </tr>
     <tr>     
        <div class="clears"></div>
       </ul><!--buyji/-->
      </td>
     </tr>
     <tr>
      
     </tr>
     <tr>
 
      <td>
       
		</div>
	
	</div>
      </td>
     </tr>
    </table><!--buyTable/-->
    <div class="goumai">
     <a href="${pageContext.request.contextPath }/gggg/InsertactivityId.action?activityid=${activity.activityid }" class="buy-mai">报名</a>
     <a href="${pageContext.request.contextPath }/jsp/edu/video.jsp" class="buy-mai">观看</a>
    </div><!--goumai/-->
   </div><!--buyDtlRight/-->
   <div class="clears"></div>
  </div><!--buyDtl/-->
  <div class="buyDtl2">
   <ul class="buydel2Eq">
    <li><h3>课程介绍</h3></li>
    
    <div class="clears"></div>	
   </ul><!--buydel2Eq/-->
   <div class="buydlList" style="font-size: 1.3em;">
   ${activity.activitydetails}
   </div><!--buydlList/-->
  
 </div><!--buyDtl2/-->
 </div><!--buyinfo/-->
 
 
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
 
</body>
</html>

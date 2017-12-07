<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" isErrorPage="true"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品详情</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css" rel="stylesheet" type="text/css" />
		<link type="text/css" href="${pageContext.request.contextPath }/jsp/mall/css/optstyle.css" rel="stylesheet" />
		<link type="text/css" href="${pageContext.request.contextPath }/jsp/mall/css/style.css" rel="stylesheet" />
		<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath }/jsp/mall/css/showBo.css" />
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/home/js/showBo.js"></script>

		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>
		<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/jquery-1.7.min.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/quick_links.js"></script>

		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/UI/assets/js/amazeui.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery.imagezoom.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/jquery.flexslider.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/list.js"></script>
		<script type="text/javascript">
		
			$(document).ready(function(){
				/* Date.prototype.Format = function(fmt){
				
					var o = {
					
						"M+" : this.getMonth()+1,
						"d+" : this.getDate(),
						"H+" : this.getHours(),
						"m+" : this.getMinUtes(),
						"s+" : this.getSeconds(),
						"q+" : Manth.floor(this.getMonth()),
						"S+" : this.getMilliseconds()
					};
					if(/(y+)/.test(fmt)) fmt = fmt.replace(RegRxp.$1,(this.getFullYear()+"").substr(4-RegExp.$1.length));
					for(var k in o)
					if(new RegExp("("+k+")").test(fmt)) fmt = fmt.replace(RegExp.$1,(RegExp.$1.length == 1)?(o[k]):(("00"+o[k]).substr((""+o[k]).length)));
					
					return fmt;
					
				
				}; */
				//alert(new Date().Format("yyyy-MM-dd HH:mm:ss"));
			
				$("#allEvaluation").click(function(){
				
				function createEvaluation(data){
					$("#evaluation").html("");
					for(var i in data.evaluationsList){
							
						    $("#evaluation").append(
							'<li class="am-comment">'+
												'<!-- 评论容器 -->'+
												'<a href="">'+
													'<img id = "avatar" class="am-comment-avatar" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.evaluationsList[i].avatar +'" />'+
													'<!-- 评论者头像 -->'+
												'</a>'+
	
												'<div class="am-comment-main">'+
													'<!-- 评论内容容器 -->'+
													'<header class="am-comment-hd">'+
														'<!--<h3 class="am-comment-title">评论标题</h3>-->'+
														'<div class="am-comment-meta">'+
															'<!-- 评论元数据 -->'+
															'<input type = "hidden" value = '+ data.evaluationsList[i].userid +' id = "userid">'+
															'<a href="#link-to-user" class="am-comment-author" id = "username">'+ data.evaluationsList[i].username +'</a>'+
															'<!-- 评论者 -->'+
															'评论于'+
															'<time datetime="'+data.evaluationsList[i].commentdate+'" id = "commentdate">'+data.evaluationsList[i].stringDate+'</time>'+
														'</div>'+
													'</header>'+
	
													'<div class="am-comment-bd">'+
														'<div class="tb-rev-item " data-id="255776406962">'+
															'<div class="J_TbcRate_ReviewContent tb-tbcr-content " id = "evaluationcontent">'+
																'<!--评论类容  -->'+ data.evaluationsList[i].evaluationcontent +
															'</div>'+
															'<div class="tb-r-act-bar" id = "buyProduct">'+
																'<!-- 颜色分类：柠檬黄&nbsp;&nbsp;尺码：S -->'+
															'</div>'+
														'</div>'+
	
													'</div>'+
													'<!-- 评论内容 -->'+
												'</div>'+
											'</li>'
						    );
						}
				};
				
				
				
					var productid = $("#productid").val();
					
					//alert(1);
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:"${pageContext.request.contextPath }/product/queryEvaluation",
						data:'{"productid"'+':'+'"'+productid+'"'+','
								+'"currentPage"'+':'+'"'+1+'"'
					        			+'}',
						success:function(data){
							//alert(data.evaluation);
							var allEvaluation = data.evaluation.praise+data.evaluation.average+data.evaluation.badReview;
							$("#praiseOf").html(data.evaluation.praiseOf);
							$("#allEvaluationNum").html("("+allEvaluation+")");
							$("#praise").html("("+data.evaluation.praise+")");
							$("#average").html("("+data.evaluation.average+")");
							$("#badReview").html("("+data.evaluation.badReview+")");
							$("#lastPage").attr("value",data.pageSum);
							//allEvaluation(data.evaluationsList);
							createEvaluation(data);
							
						}
				});
				
				
				
				$("#page li").click(function(){
				
					
					var currentPage = $(this).attr("value");
					if("previousPage" == $(this).attr("id")){
						if(currentPage > 1){
							$(this).attr("value",parseInt(currentPage)-1);
							$("#nextPage").attr("value",parseInt(currentPage)-1);
						}
					}
					if("nextPage" == $(this).attr("id")){
						//alert(sort);
						if($(this).attr("value") < $("#lastPage").attr("value")){
						
							$(this).attr("value",parseInt(currentPage)+1);
							$("#previousPage").attr("value",parseInt(currentPage)+1);
						}
					}
					if("home" == $(this).attr("id")){
						$("#nextPage").attr("value",1);
						$("#previousPage").attr("value",1);
					}
					if("lastPage" == $(this).attr("id")){
						$("#nextPage").attr("value",$(this).attr("value"));
						$("#previousPage").attr("value",$(this).attr("value"));
						
					}
					$("#currentPage").html(parseInt($(this).attr("value")));
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:"${pageContext.request.contextPath }/product/queryEvaluation",
						data:'{"productid"'+':'+'"'+productid+'"'+','
								+'"currentPage"'+':'+'"'+$(this).attr("value")+'"'
					        			+'}',
					    success:function(data){
					    	createEvaluation(data);
					    }
					
					});
				});
				
					
				});
			});
		
		
		</script>

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
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<ul>
								<!-- <li class="index"><a href="#">首页</a></li>
                                <li class="qc"><a href="#">闪购</a></li>
                                <li class="qc"><a href="#">限时抢</a></li>
                                <li class="qc"><a href="#">团购</a></li>
                                <li class="qc last"><a href="#">大包装</a></li> -->
							</ul>
<!-- 						    <div class="nav-extra">
						    	<i class="am-icon-user-secret am-icon-md nav-user"></i><b></b>我的福利
						    	<i class="am-icon-angle-right" style="padding-left: 10px;"></i>
						    </div>
 -->						</div>
			</div>
				<ol class="am-breadcrumb am-breadcrumb-slash">
					<li><a href="${pageContext.request.contextPath }/product/mallIndex">首页</a></li>
					<li><a href="${pageContext.request.contextPath }/product/search">分类</a></li>
					<li class="am-active">内容</li>
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
				<%-- <div class="scoll">
					<section class="slider">
						<div class="flexslider">
							<ul class="slides">
								<li>
									<img src="${pageContext.request.contextPath }/jsp/mall/images/01.jpg" title="pic" />
								</li>
								<li>
									<img src="${pageContext.request.contextPath }/jsp/mall/images/02.jpg" />
								</li>
								<li>
									<img src="${pageContext.request.contextPath }/jsp/mall/images/03.jpg" />
								</li>
							</ul>
						</div>
					</section>
				</div> --%>

<%-- <a href="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }">
								<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }" 
								alt="细节展示放大镜特效" rel="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }" class="jqzoom" /></a> --%>
				<!--放大镜-->

				<div class="item-inform">
					<div class="clearfixLeft" id="clearcontent">

						
						<div class="box">
							<script type="text/javascript">
								$(document).ready(function() {
									$(".jqzoom").imagezoom();
									$("#thumblist li a").click(function() {
										$(this).parents("li").addClass("tb-selected").siblings().removeClass("tb-selected");
										$(".jqzoom").attr('src', $(this).find("img").attr("mid"));
										$(".jqzoom").attr('rel', $(this).find("img").attr("big"));
									});
								});
							</script>

							<div class="tb-booth tb-pic tb-s310">
								<a href="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }">
								<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }" 
								alt="细节展示放大镜特效" rel="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productInfo.picture }" class="jqzoom" /></a>
							</div>
						</div>

						<div class="clear"></div>
					</div>

					<div class="clearfixRight">

						<!--规格属性-->
						<!--名称-->
						
						<div class="tb-detail-hd">
							<h1 id = "productName">${productInfo.productname }</h1>
						</div>
						<div class="tb-detail-list">
							<!--价格-->
							<div class="tb-detail-price" style="background-color: white;">
								<li class="price iteminfo_price">
									<dt>单价</dt>
									<dd><em>¥</em><b class="sys_item_price" id="price">${productInfo.price }</b>  </dd>                                 
								</li>
								<!-- <li class="price iteminfo_mktprice">
									<dt>原价</dt>
									<dd><em>¥</em><b class="sys_item_mktprice" id = "price">98.00</b></dd>									
								</li> -->
								<div class="clear"></div>
							</div>

							<!--地址-->
							<!-- <dl class="iteminfo_parameter freight">
								<dt>配送至</dt>
								<div class="iteminfo_freprice">
									<div class="am-form-content address">
										<select data-am-selected>
											<option value="a">温州市</option>
											<option value="b">武汉市</option>
										</select>
										<select data-am-selected>
											<option value="a">瑞安区</option>
											<option value="b">洪山区</option>
										</select>
									</div>
									<div class="pay-logis">
										快递<b class="sys_item_freprice">10</b>元
									</div>
								</div>
							</dl> -->
							<div class="clear"></div>

							<!--销量-->
							<ul class="tm-ind-panel">
								<li class="tm-ind-item tm-ind-sellCount canClick">
									<div class="tm-indcon"><span class="tm-label">月销量</span><span class="tm-count">(${salesThisMonth.totalCount })</span></div>
								</li>
								<li class="tm-ind-item tm-ind-sumCount canClick">
									<div class="tm-indcon"><span class="tm-label">累计销量</span><span class="tm-count">(${sales.totalCount })</span></div>
								</li>
								<li class="tm-ind-item tm-ind-reviewCount canClick tm-line3">
									<div class="tm-indcon"><span class="tm-label">累计评价</span><span class="tm-count">(${allEvaluation })</span></div>
								</li>
							</ul>
							<div class="clear"></div>

							<!--各种规格-->
							<dl class="iteminfo_parameter sys_item_specpara">
								<dt class="theme-login"><div class="cart-title">可选规格<span class="am-icon-angle-right"></span></div></dt>
								<dd>
									<!--操作页面-->

									<div class="theme-popover-mask"></div>

									<div class="theme-popover">
										<div class="theme-span"></div>
										<div class="theme-poptit">
											<a href="javascript:;" title="关闭" class="close">×</a>
										</div>
										<div class="theme-popbod dform">
											<form class="theme-signin" name="loginform" action="" method="post">

												<input id = "productid" name="productid" type="hidden" value = ${productInfo.productid }>
												<input id = "price" name="price" type="hidden" value = ${productInfo.price }>
												<!-- <input id = "teast" name="productid" type="hidden">
												<input id = "colour" name="price" type="hidden">
												<input id = "szie" name="productid" type="hidden">
												 -->
												<div class="theme-signin-left">

													<div class="theme-options">
														<ul id = "options"></ul>
													
														<c:choose>
															<c:when test="${productInfo.tasteList != null}">
																<div class="cart-title">口味</div>
																<input type="hidden" name="type" id = "teastType" value = "1">
																<ul id = "teast">
																	<!-- <li class="sku-line selected">原味<i></i></li> -->
																	<c:forEach items="${productInfo.tasteList}" var="taste" varStatus="status">
																	
																		<li class="sku-line" value="${taste.producttasteid}">${taste.producttaste}<i></i></li>
																	</c:forEach>
																</ul>
															
															</c:when>
															
															<c:when test="${productInfo.colourList != null}">
																
																<div class="cart-title">颜色</div>
																<input type="hidden" name="type" id = "colourType" value = "2">
																<ul id = "colour">
																	<!-- <li class="sku-line selected">原味<i></i></li> -->
																	<c:forEach items="${productInfo.colourList}" var="colour">
																		<li class="sku-line" value="${colour.productcolourid}">${colour.productcolour}<i></i></li>
																	</c:forEach>
																</ul>
																
																<c:if test="${productInfo.colourList[0].colourSizeList != null}">
																<div class="cart-title">型号</div>
																<ul id = "size">
																	<%-- <c:forEach items="${productInfo.colourList}" var="colour">
																		<c:forEach items="${colour.colourSizeList}" var="size">
																			<li class="sku-line" value="">${size.size}<i></i></li>
																		</c:forEach>
																	</c:forEach> --%>
																	<li class="sku-line" value= "xs" >xs<i></i></li>
																	<li class="sku-line" value= "s" >s<i></i></li>
																	<li class="sku-line" value= "m" >m<i></i></li>
																	<li class="sku-line" value= "l" >l<i></i></li>
																	<li class="sku-line" value= "xl" >xl<i></i></li>
																	<li class="sku-line" value= "xll" >xll<i></i></li>
																	<!-- <li class="sku-line" value="xlll">xlll<i></i></li> -->
																</ul>
																</c:if>
															</c:when>
															
															<c:otherwise>
																<input type="hidden" name="type" id = "other" value = "3">
															</c:otherwise>
														</c:choose>
														
													</div>
													
													
													
													<!-- <div class="theme-options">
														<div class="cart-title">包装</div>
														<ul>
															<li class="sku-line selected">手袋单人份<i></i></li>
															<li class="sku-line">手袋单人份<i></i></li>
															<li class="sku-line">礼盒双人份<i></i></li>
															<li class="sku-line">全家福礼包<i></i></li>
														</ul>
													</div> -->
													<div class="theme-options">
														<div class="cart-title number">数量</div>
														<dd>
															<input id="min" class="min" name="" type="button" value="-" />
															<input id="text_box" name="number" type="text" value="1" style="width:30px;" />
															<input id="add" class="add" name="" type="button" value="+" />
															<span id="Stock" class="tb-hidden">库存<span class="stock" id="inStock">${productInfo.instock }</span>件</span>
														</dd>

													</div>
													<div class="clear"></div>

													<!-- <div class="btn-op">
														<div class="btn am-btn am-btn-warning">确认</div>
														<div class="btn close am-btn am-btn-warning">取消</div>
													</div> -->
												</div>
											<%-- 	<div class="theme-signin-right">
													<div class="img-info">
														<img src="${pageContext.request.contextPath }/jsp/mall/images/songzi.jpg" />
													</div>
													<div class="text-info">
														<span id="Stock" class="tb-hidden">库存<span class="stock">1000</span>件</span>
													</div>
												</div>
 --%>
											</form>
										</div>
									</div>

								</dd>
							</dl>
							<div class="clear"></div>
							<!--活动	-->
							<div class="shopPromotion gold">
								<!-- <div class="hot">
									<dt class="tb-metatit">店铺优惠</dt>
									<div class="gold-list">
										<p>购物满2件打8折，满3件7折<span>点击领券<i class="am-icon-sort-down"></i></span></p>
									</div>
								</div> -->
								<!-- <div class="clear"></div>
								<div class="coupon">
									<dt class="tb-metatit">优惠券</dt>
									<div class="gold-list">
										<ul>
											<li>125减5</li>
											<li>198减10</li>
											<li>298减20</li>
										</ul>
									</div>
								</div> -->
							</div>
						</div>

						<div class="pay">
<!-- 							<div class="pay-opt">
							<a href="home.html"><span class="am-icon-home am-icon-fw">首页</span></a>
							<a><span class="am-icon-heart am-icon-fw">收藏</span></a>
							
							</div>
							
 -->						<ul id="pay">
	 							<li id="buy">
									<div class="clearfix tb-btn tb-btn-buy theme-login">
										<a title="点此按钮到下一步确认购买信息" href="javaScript:;">立即购买</a>
									</div>
								</li>
								<li id="shoppingCart">
									<div class="clearfix tb-btn tb-btn-basket theme-login">
										<a title="加入购物车" href="javaScript:;"><i></i>加入购物车</a>
									</div>
								</li>
							</ul>
						</div>

					</div>

					<div class="clear"></div>

				</div>

				<!--优惠套装-->
				<div class="match">
					<div class="match-title">0.0</div>
					<div class="match-comment">
						<ul class="like_list">
						</ul>
					</div>
				</div>
				<div class="clear"></div>
				
							
				<!-- introduce-->

				<div class="introduce">
					<div class="browse">
					    <div class="mc"> 
						     <ul>					    
						     	<div class="mt">            
						            <h2>看了又看</h2>        
					            </div>
						     	<c:forEach items="${similarProducts }" var="similarProduct">
							      <li>
							      	<div class="p-img">                    
							      		<a  href="${pageContext.request.contextPath }/product/productInfo?id=${similarProduct.productid }"> 
							      		<img class="" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${similarProduct.picture }" style="max-height: 200px;"> </a>               
							      	</div>
							      	<div class="p-name"><a href="${pageContext.request.contextPath }/product/productInfo?id=${similarProduct.productid }">
							      		${similarProduct.productname }
							      	</a>
							      	</div>
							      	<div class="p-price"><strong>￥${similarProduct.price }</strong></div>
							      </li>
						     	</c:forEach>
						     	
					      
						     </ul>					
					    </div>
					</div>
					<div class="introduceMain">
						<div class="am-tabs" data-am-tabs>
							<ul class="am-avg-sm-3 am-tabs-nav am-nav am-nav-tabs">
								<li class="am-active">
									<a href="#">

										<span class="index-needs-dt-txt">宝贝详情</span></a>

								</li>

								<li>
									<a href="#">

										<span class="index-needs-dt-txt" id = "allEvaluation">全部评价</span></a>

								</li>

								<!-- <li>
									<a href="#">

										<span class="index-needs-dt-txt">猜你喜欢</span></a>
								</li> -->
							</ul>

							<div class="am-tabs-bd">

								<div class="am-tab-panel am-fade am-in am-active">
									<div class="J_Brand">

										<div class="attr-list-hd tm-clear">
											<h4>产品参数：</h4></div>
										<div class="clear"></div>
										<ul id="J_AttrUL">
											<li title="">产品类型:&nbsp;${productInfo.producttypename}类</li>
											<li title="">产地:&nbsp;${productInfo.origin}</li>
											<li title="">产品规格:&nbsp;${productInfo.productspecifications}g</li>
											<li title="">产品标准号:&nbsp;${productInfo.producstandards}</li>
											<li title="">生产许可证编号：&nbsp;${productInfo.productionlicensenumber}</li>
											<c:if test="${productInfo.tasteList != null}">
												<li title="">保质期:&nbsp;${productInfo.shelflife}天</li>
												<li title="">储存方法：&nbsp;${productInfo.storagemethod} </li>
												<li title="">食用方法：&nbsp;${productInfo.ediblemethod}</li>
											</c:if>
										</ul>
										<div class="clear"></div>
									</div>

									<div>
										<div class="attr-list-hd ">
											<h4>商品细节</h4>
										</div>
										<div class="twlistNews">
											<p style="text-align: left;">${productInfo.description}</p>
										</div>
									</div>
									<div class="clear"></div>

								</div>

								<div class="am-tab-panel am-fade">
									
                                    <div class="actor-new">
                                    	<div class="rate">                
                                    		<strong id = "praiseOf"></strong><span style="color: red;">%</span><br> <span>好评度</span>            
                                    	</div>
                                        <!-- <dl>                    
                                            <dt>买家印象</dt>                    
                                            <dd class="p-bfc">
                                            			<q class="comm-tags"><span>味道不错</span><em>(2177)</em></q>
                                            			<q class="comm-tags"><span>颗粒饱满</span><em>(1860)</em></q>
                                            			<q class="comm-tags"><span>口感好</span><em>(1823)</em></q>
                                            			<q class="comm-tags"><span>商品不错</span><em>(1689)</em></q>
                                            			<q class="comm-tags"><span>香脆可口</span><em>(1488)</em></q>
                                            			<q class="comm-tags"><span>个个开口</span><em>(1392)</em></q>
                                            			<q class="comm-tags"><span>价格便宜</span><em>(1119)</em></q>
                                            			<q class="comm-tags"><span>特价买的</span><em>(865)</em></q>
                                            			<q class="comm-tags"><span>皮很薄</span><em>(831)</em></q> 
                                            </dd>                                           
                                         </dl>  -->
                                    </div>	
                                    <div class="clear"></div>
									<div class="tb-r-filter-bar">
										<ul class=" tb-taglist am-avg-sm-4">
											<li class="tb-taglist-li tb-taglist-li-current">
												<div class="comment-info">
													<span>全部评价</span>
													<span class="tb-tbcr-num" id = "allEvaluationNum"></span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li-1">
												<div class="comment-info">
													<span>好评</span>
													<span class="tb-tbcr-num" id = "praise"></span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li-0">
												<div class="comment-info">
													<span>中评</span>
													<span class="tb-tbcr-num" id = "average"></span>
												</div>
											</li>

											<li class="tb-taglist-li tb-taglist-li--1">
												<div class="comment-info">
													<span>差评</span>
													<span class="tb-tbcr-num" id = "badReview"></span>
												</div>
											</li>
										</ul>
									</div>
									<div class="clear"></div>

									<ul class="am-comments-list am-comments-list-flip" id = "evaluation">
										
										
									</ul>

									<div class="clear"></div>

									<!--分页 -->
									
									<ul class="am-pagination am-pagination-right" id = "page">
										<li>当前为第<strong id = "currentPage">1</strong>页</li>
									    <li value=1 id = "home"><a href="javascript:;">首页</a></li>
										<li value=1 id = "previousPage"><a href="javascript:;">&laquo;</a></li>
										<li value=1 id = "nextPage"><a href="javascript:;">&raquo;</a></li>
										<li value=1 id = "lastPage"><a href="javascript:;">尾页</a></li>
									</ul>
									<div class="clear"></div>

									<div class="tb-reviewsft">
										<div class="tb-rate-alert type-attention">购买前请查看该商品的 <a href="#" target="_blank">购物保障</a>，明确您的售后保障权益。</div>
									</div>

								</div>

								

							</div>

						</div>

						<div class="clear"></div>

						<c:import url="/jsp/mall/footer.jsp"></c:import>
					</div>

				</div>
			</div>
			<!-- 菜單 -->
			<c:import url="homeMenu.jsp"></c:import>

			<!-- 信息提示 -->
			<c:import url="/jsp/util/messageNotification.jsp"></c:import>
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/mall/home/js/introduction.js"></script>

	</body>

</html>
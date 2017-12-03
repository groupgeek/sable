<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">

	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">

		<title>商品搜索</title>

		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/amazeui.css" rel="stylesheet" type="text/css" />
		<link href="${pageContext.request.contextPath }/jsp/mall/UI/assets/css/admin.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath }/jsp/mall/basic/css/demo.css" rel="stylesheet" type="text/css" />

		<link href="${pageContext.request.contextPath }/jsp/mall/css/seastyle.css" rel="stylesheet" type="text/css" />

		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/jquery-1.7.min.js"></script>
		<%-- <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script> --%>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/js/script.js"></script>
	</head>

	<body>

		<!--顶部导航条 -->
		<c:import url="/jsp/mall/head.jsp"></c:import>

			<div class="clear"></div>
			<b class="line"></b>
           <div class="search">
			<div class="search-list">
			<div class="nav-table">
					   <div class="long-title"><span class="all-goods">全部分类</span></div>
					   <div class="nav-cont">
							<!-- <ul>
								<li class="index"><a href="#" id = "hah">首页</a></li>
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
			
				
					<div class="am-g am-g-fixed">
						<div class="am-u-sm-12 am-u-md-12">
	                  	<div class="theme-popover">														
							<div class="searchAbout">
								<!-- <span class="font-pale">相关搜索：</span>
								<a title="坚果" href="#">坚果</a>
								<a title="瓜子" href="#">瓜子</a>
								<a title="鸡腿" href="#">豆干</a>
 -->
 									<%-- <ol class="am-breadcrumb am-breadcrumb-slash">
									<li><a href="${pageContext.request.contextPath }/product/mallIndex">首页</a></li>
									<li><a href="${pageContext.request.contextPath }/product/search">分类</a></li>
									<li class="am-active">内容</li>
									</ol> --%>
							</div>
							<ul class="select">
								<p class="title font-normal">
									<span class="total fl">搜索到<strong class="num" id = "productPage">${sum }</strong>页相关商品</span>
								</p>
								<div class="clear"></div>
								<li class="select-result">
									<dl>
										<dt>已选</dt>
										<dd class="select-no"></dd>
										<p class="eliminateCriteria">清除</p>
									</dl>
								</li>
								<div class="clear"></div>
								<li class="select-list">
									<dl id="selectType">
										<dt class="am-badge am-round">种类</dt>
										<div class="dd-conent">
											<!-- <dd class="select-all selected"><a href="#">全部</a></dd> -->
											<c:forEach items="${producttypeCustoms }" var="producttypeCustom">
											<dd><a href="javascript:;">${producttypeCustom.producttypename }</a></dd>
											</c:forEach>
											
										</div>
									</dl>
								</li>
								
								<li class="select-list" id="selectDt">
									<dl id="select2">
										<dt class="am-badge am-round">类型</dt>
										<div class="dd-conent" id="selectTypeSon">
											<dd></dd>
										</div>
									</dl>
								</li>
					        
							</ul>
							<div class="clear"></div>
                        </div>
							<div class="search-content">
								<div class="sort">
									<li value = "buyNo" id = "buyNo"><a title="销量" href="javascript:;">销量排序</a></li>
									<li value = "price" id = "price"><a title="价格" href="javascript:;">价格优先</a></li>
									<li class="big" value = "good" id = "good"><a title="热度" href="javascript:;">热度为主</a></li>
								</div>
								<div class="clear"></div>

								<ul class="am-avg-sm-2 am-avg-md-3 am-avg-lg-4 boxes" id = "products">
									
									<c:forEach items="${blurryProductCustoms }" var="blurryProductCustom">
										<li>
										<a href = "${pageContext.request.contextPath }/product/productInfo?id=${blurryProductCustom.productid}">
											<div class="i-pic limit">
												<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${blurryProductCustom.picture }" />											
												<p class="title fl">${blurryProductCustom.productname }</p>
												<p class="price fl">
													<b>¥</b>
													<strong>${blurryProductCustom.price }</strong>
												</p>
												<p class="number fl">
													销量<span>${blurryProductCustom.buyno}</span>
												</p>
											</div>
										</a>
										</li>
									</c:forEach>
			
								</ul>
							</div>
							<div class="search-side">

								<div class="side-title">
									经典搭配
								</div>
								<c:forEach items="${productCustoms }" var="productCustom">
									
									<ul>
										<li>
											<div class="i-pic check">
												<a href = "${pageContext.request.contextPath }/product/productInfo?id=${productCustom.productid}">
												<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${productCustom.picture }" />
												<p class="check-title">${productCustom.productname }</p>
												<p class="price fl">
													<b>¥</b>
													<strong>${productCustom.price }</strong>
												</p>
												<p class="number fl">
													销量<span>${productCustom.buyno }</span>
												</p>
												</a>
											</div>
										</li>
									</ul>
								
								</c:forEach>
								
								
								

							</div>
							<div class="clear"></div>
							<!--分页 -->
							<p style="float: right; height: 10px;">当前为第<strong id = "productCurrentPage">1</strong>页</p>
							<ul class="am-pagination am-pagination-right" id = "ull">
								<li value="${currentPage }" id = "home"><a href="javascript:;">首页</a></li>
								<li value="${currentPage }" id = "previousPage"><a href="javascript:;">&laquo;</a></li>
								<li value="${currentPage }" id = "nextPage"><a href="javascript:;">&raquo;</a></li>
								<li value="${sum }" id = "lastPage"><a href="javascript:;">尾页</a></li>
							</ul>

						</div>
					</div>
					<c:import url="/jsp/mall/footer.jsp"></c:import>
				</div>

			</div>

		<!-- 菜單 -->
			<c:import url="homeMenu.jsp"></c:import>
		<script>
			window.jQuery || document.write('<script src="${pageContext.request.contextPath }/jsp/mall/basic/js/jquery-1.9.min.js"><\/script>');
		</script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/mall/basic/js/quick_links.js"></script>

<div class="theme-popover-mask"></div>
		<script type="text/javascript">
		
				
				$(document).ready(function(){
				
					$("#selectType dd").click(function(){
					$(this).unbind("click");
						var producttypename = $(this).text();
		        		$.ajax({
		        		
		        			type:"post",
		        			contentType:"application/json;charset=utf-8",
		        			url:"${pageContext.request.contextPath }/product/queryProducttype_json.action",
		        			data:'{"producttypename"'+':'+'"'+producttypename+'"}',
		        			success:function(data,status){
		        				//alert(data[0].producttypename);
		        				//$("#selectTypeSon").html(" ");
		        				for(var temp in data){
		        					$("#selectTypeSon").append('<dd><a href="javascript:;">'+data[temp].producttypename+''+'</a></dd>');
		        				}
		        				
		        				
		        				var hh = document.documentElement.clientHeight;
								var ls = document.documentElement.clientWidth;
								if (ls < 640) {
									$("#selectDt dt").click(function() {
									
										if ($(this).next("div").css("display") == 'none') {
											$(".theme-popover-mask").height(hh);
											$(".theme-popover").css("position", "fixed");
											$(this).next("div").slideToggle("slow");
											$(".select div").not($(this).next()).hide();
										}
							          else{
							          	$(".theme-popover-mask").height(0);
										$(".theme-popover").css("position", "static");
										$(this).next("div").slideUp("slow");;
							          }
							
									})
							
							
									$(".eliminateCriteria").live("click", function() {
										$(".dd-conent").hide();
									})
							
									$("#selectDt dd").live("click", function() {
										$(".theme-popover-mask").height(0);
										$(".theme-popover").css("position", "static");
										$(".dd-conent").hide();
									});
									$(".theme-popover-mask").live("click", function() {
										$(".theme-popover-mask").height(0);
										$(".theme-popover").css("position", "static");
										$(".dd-conent").hide();
									});
							
								}
							
							
								$("span.love").click(function() {
									$(this).toggleClass("active");
								});
							
								$("#select2 dd").click(function() {
								//***************************获取到子类的类型名字**************************/
									$(this).addClass("selected").siblings().removeClass("selected");
									if ($(this).hasClass("select-all")) {
										$("#selectB").remove();
									} else {
										var copyThisB = $(this).clone();
										if ($("#selectB").length > 0) {
											$("#selectB a").html($(this).text());
										} else {
											$(".select-result dl").append(copyThisB.attr("id", "selectB"));
										}
									}
								});
							
								$("#selectA").live("click", function() {
									$(this).remove();
									$("#select1 .select-all").addClass("selected").siblings().removeClass("selected");
								});
							
								$("#selectB").live("click", function() {
									//alert($(this).html());
									$(this).remove();
									queryProducts();
									$("#select2 .select-all").addClass("selected").siblings().removeClass("selected");
								});
							
								$("#selectC").live("click", function() {
									$(this).remove();
									$("#select3 .select-all").addClass("selected").siblings().removeClass("selected");
								});
							
								$("#selectDt dd").live("click", function() {
									if ($(".select-result dd").length > 1) {
										$(".select-no").hide();
										$(".eliminateCriteria").show();
										$(".select-result").show();
									} else {
										$(".select-no").show();
										$(".select-result").hide();
							
									}
								});
							
								$(".eliminateCriteria").live("click", function() {
									$("#selectA").remove();
									$("#selectB").remove();
									$("#selectC").remove();
									$(".select-all").addClass("selected").siblings().removeClass("selected");
									$(".eliminateCriteria").hide();
									$(".select-no").show();
									$(".select-result").hide();
							
								});
								
								
								function queryProducts(){
								
									//alert($(id).html());
									var producttypename = $("#selectB a").html();
									var search = document.getElementById("searchInput").value;
									
									$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProduct_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'+','
					        					+'"currentPage"'+':'+'"'+1+'"'
					        			+'}',	
					        			success:function(data){
					        				//添加展示的商品
					        				$("#products").html(" ");
					        				$("#nextPage").attr("value",1);
					        				$("#previousPage").attr("value",1);
					        				productSumPage();//更新页数
					        				$("#previousPage").attr("value",1);
											$("#nextPage").attr("value",1);
											$("#productCurrentPage").text(1);
											
					        				for (var i in data){
					        					$("#products").append(
						        					'<li>'+
						        						'<a href = "${pageContext.request.contextPath }/product/productInfo?id='+ data[i].productid +'">'+	
															'<div class="i-pic limit">'+
																'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].picture+'" />'+
																'<p class="title fl">'+data[i].productname+'</p>'+
																'<p class="price fl">'+
																	'<b>¥</b>'+
																	'<strong>'+data[i].price+'</strong>'+
																'</p>'+
																'<p class="number fl">'+
																	'销量<span>'+data[i].buyno+'</span>'+
																'</p>'+
															'</div>'+
														'</a>'+
													'</li>'
					        					);
					        				}
					        			}
									});
									
									
									
									
									
								
								}
								function productSumPage(){
								
									var producttypename = $("#selectB a").html();
										var search = document.getElementById("searchInput").value;
										$.ajax({
														type:"post",
														contentType:"application/json;charset=utf-8",
									        			url:"${pageContext.request.contextPath }/product/queryProductSum_json.action",
									        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
									        					+'"search"'+':'+'"'+search+'"'
									        			+'}',	
									        			success:function(data){
									        					//alert(data-1+":尾页");
									        					$("#lastPage").attr("value",data);
									        					$("#productPage").html(data);
									        			}
										});
								
								
								}
												
								
								$("#selectDt dd").click(function(){
									//alert($("#selectB a").html());//类型
									//alert(document.getElementById("searchInput").value);//文本框
									/* var producttypename = $("#selectB a").html();
									var search = document.getElementById("searchInput").value;
									
									$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProduct_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'+','
					        					+'"currentPage"'+':'+'"'+1+'"'
					        			+'}',	
					        			success:function(data){
					        				//添加展示的商品
					        				$("#products").html(" ");
					        				$("#nextPage").attr("value",1);
					        				$("#previousPage").attr("value",1);
					        				productSumPage();//更新页数
					        				for (var i in data){
					        					$("#products").append(
					        						'<li>'+
														'<div class="i-pic limit">'+
															'<img src="${pageContext.request.contextPath }/jsp/mall/images/imgsearch1.jpg" />'+
															'<p class="title fl">'+data[i].productname+'</p>'+
															'<p class="price fl">'+
																'<b>¥</b>'+
																'<strong>'+data[i].price+'</strong>'+
															'</p>'+
															'<p class="number fl">'+
																'销量<span>'+data[i].buyno+'</span>'+
															'</p>'+
														'</div>'+
													'</li>'
					        					);
					        				}
					        			}
									}); */
									queryProducts();
									
								});//选择商品类型进行局部更新商品
		        			}
		        		
		        		});
						
				});

			
			$("#ai-topsearch ,#ull li ,.sort li ,#selectDt dd").click(function(){
				if($(this).attr("id") == "ai-topsearch"){
					var producttypename = $("#selectB a").html();
					var search = document.getElementById("searchInput").value;
					productSum();
					$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProduct_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'+','
					        					
					        					+'"currentPage"'+':'+'"'+1+'"'
					        			+'}',	
					        			success:function(data){
					        				//添加展示的商品
					        				//alert("商品"+data);
					        				$("#products").html(" ");
					        				for (var i in data){
					        					$("#products").append(
						        					'<li>'+
					        							'<a href = "${pageContext.request.contextPath }/product/productInfo?id='+ data[i].productid +'">'+	
															'<div class="i-pic limit">'+
																'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].picture+'" />'+
																'<p class="title fl">'+data[i].productname+'</p>'+
																'<p class="price fl">'+
																	'<b>¥</b>'+
																	'<strong>'+data[i].price+'</strong>'+
																'</p>'+
																'<p class="number fl">'+
																	'销量<span>'+data[i].buyno+'</span>'+
																'</p>'+
															'</div>'+
														'</a>'+	
													'</li>'
					        					);
					        				}
					        			}
									});
					
				}
				
				if($(this).attr("id") == "buyNo" || $(this).attr("id") == "price"  || $(this).attr("id") == "good"){
					var sort = $(this).attr("id");
					$("#previousPage").attr("value",1);
					$("#nextPage").attr("value",1);
					productSum();
					ajacUpdate(this,sort,1);
					
					$("#productCurrentPage").text(1);
				}
				
				if($(this).attr("id") == "home" || $(this).attr("id") == "previousPage"  || $(this).attr("id") == "nextPage"|| $(this).attr("id") == "lastPage"){
					var currentPage = $(this).attr("value");
					//alert(currentPage);
					//if($(this).attr("id") == "lastPage"){
						/* var producttypename = $("#selectB a").html();
						var search = document.getElementById("searchInput").value;
						$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProductSum_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'
					        			+'}',	
					        			success:function(data){
					        					//alert(data-1+":尾页");
					        					$("#lastPage").attr("value",data);
					        					$("#productPage").html(data);
					        			}
						}); */
					//}
					productSum();
					ajacUpdate(this,null,currentPage);
				}
				
				function productSum(){
				
					var producttypename = $("#selectB a").html();
						var search = document.getElementById("searchInput").value;
						$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProductSum_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'
					        			+'}',	
					        			success:function(data){
					        					//alert(data-1+":尾页");
					        					$("#lastPage").attr("value",data);
					        					$("#productPage").html(data);
					        			}
						});
				
				
				}
				
				function ajacUpdate(id,sort,currentPage){
					var producttypename = $("#selectB a").html();
					var search = document.getElementById("searchInput").value;
					
					if("previousPage" == $(id).attr("id")){
						if(currentPage > 1){
							$(id).attr("value",currentPage-1);
							$("#nextPage").attr("value",currentPage-1);
						}
					}
					if("nextPage" == $(id).attr("id")){
						//alert(sort);
						if($(id).attr("value") < $("#lastPage").attr("value")){
						
							$(id).attr("value",currentPage+1);
							$("#previousPage").attr("value",currentPage+1);
						}
					}
					if("home" == $(id).attr("id")){
						$("#nextPage").attr("value",1);
						$("#previousPage").attr("value",1);
					}
					if("lastPage" == $(id).attr("id")){
						$("#nextPage").attr("value",$(id).attr("value"));
						$("#previousPage").attr("value",$(id).attr("value"));
						
					}
					//alert("当前页"+$(id).attr("value"));	
					//alert("页："+$("#productCurrentPage").text());
					$("#productCurrentPage").text($(id).attr("value"));
									$.ajax({
										type:"post",
										contentType:"application/json;charset=utf-8",
					        			url:"${pageContext.request.contextPath }/product/queryProduct_json.action",
					        			data:'{"producttypename"'+':'+'"'+producttypename+'"'+','
					        					+'"search"'+':'+'"'+search+'"'+','
					        					+'"sort"'+':'+'"'+sort+'"'+','
					        					+'"currentPage"'+':'+'"'+$(id).attr("value")+'"'
					        			+'}',	
					        			success:function(data){
					        				//添加展示的商品
					        				//alert("商品"+data)
					        				$("#products").html(" ");
					        				for (var i in data){
					        					$("#products").append(
						        					'<li>'+
					        							'<a href = "${pageContext.request.contextPath }/product/productInfo?id='+ data[i].productid +'">'+	
															'<div class="i-pic limit">'+
																'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].picture+'" />'+
																'<p class="title fl">'+data[i].productname+'</p>'+
																'<p class="price fl">'+
																	'<b>¥</b>'+
																	'<strong>'+data[i].price+'</strong>'+
																'</p>'+
																'<p class="number fl">'+
																	'销量<span>'+data[i].buyno+'</span>'+
																'</p>'+
															'</div>'+
													'	</a>'+
													'</li>'
					        					);
					        				}
					        			}
									});
									
					
				}
			});
			
		
		});
		
		
		</script>
	</body>

</html>
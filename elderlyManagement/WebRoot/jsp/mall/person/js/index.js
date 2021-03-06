$(document)
		.ready(
				function() {
					var root = $("#root").attr("value");

					// 显示当前用户如果没有就跳转到登录界面
					$.ajax({
						type : "post",
						contentType : "application/json;charset=utf-8",
						url : root + "/product/getLoginUser",
						success : function(data) {
							if (data != null) {
								$(".s-name").text("" + data.username + "");
								$("#userAvatar img").attr("src",
										"http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/" + data.avatar);
							} else {
								alert("请登录");
								window.location.href = root
										+ "/jsp/logReg/login.jsp";
							}
						}
					});

					// 当天时间显示
					var show_day = new Array('星期一', '星期二', '星期三', '星期四', '星期五',
							'星期六', '星期日');
					var time = new Date();
					var year = time.getFullYear();
					var month = time.getMonth();
					var date = time.getDate();
					var day = time.getDay();
					$(".s-date").find("em").text(date);
					$(".s-date").find("span").first().text(show_day[day - 1]);
					$(".s-date").find("span").last().text(year + '.' + month);

					// 热门商品的显示
					$.ajax({
						type : "post",
						contentType : "application/json;charset=utf-8",
						url : root + "/product/queryPersonHotProduct",
						success : function(data) {
							$("#hot img")
									.attr("src", "http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/" + data.picture);
							$("#hot span").text(data.productname);
							$("#hot").find("a[class=follow]").text(
									"￥" + data.price);
							$("#hot").find("a[class=follow]").attr(
									"href",
									root + "/product/productInfo?id="
											+ data.productid);
							$("#hot").find("a[class=shop-info]").attr(
									"href",
									root + "/product/productInfo?id="
											+ data.productid);
						}

					});

					// 推荐商品的显示
					$.ajax({
						type : "post",
						contentType : "application/json;charset=utf-8",
						url : root + "/product/queryPersonProductrec",
						success : function(data) {
							$("#rec img")
									.attr("src", "http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/" + data.picture);
							$("#rec span").text(data.productname);
							$("#rec").find("a[class=follow]").text(
									"￥" + data.price);
							$("#rec").find("a[class=follow]").attr(
									"href",
									root + "/product/productInfo?id="
											+ data.productid);
							$("#rec").find("a[class=shop-info]").attr(
									"href",
									root + "/product/productInfo?id="
											+ data.productid);
						}

					});

					// 订单数量显示

					$.ajax({
						type : "post",
						contentType : "application/json;charset=utf-8",
						url : root + "/product/queryCountByOrders",
						success : function(data) {
							$("#orderMenu").find("a[name=pendingPayment]")
									.find("em").text(data.pendingPayment);
							$("#orderMenu").find("a[name=tobeDelivered]").find(
									"em").text(data.tobeDelivered);
							$("#orderMenu").find("a[name=tobeReceived]").find(
									"em").text(data.tobeReceived);
							$("#orderMenu").find("a[name=beEvaluated]").find(
									"em").text(data.beEvaluated);
							$("#orderMenu").find("a[name=all]").find("em").text(data.all);
						}

					});
					// 物流信息

					var logo = "allOrders";
					$.ajax({
								type : "post",
								contentType : "application/json;charset=utf-8",
								url : root + "/product/queryOrders",
								data : JSON.stringify(logo),
								success : function(data) {
									for ( var i in data) {
										if (data[i].orderstatus == "已付款"
												&& data[i].signstatus != "已签收") {
											$(".lg-list")
													.append(
															'<li class="lg-item">'
																	+ '<div class="item-info">'
																	+ '<a href="javascript:;">'
																	+ '<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'
																	+ data[i].picture
																	+ '">'
																	+ '</a>'
																	+

																	'</div>'
																	+ '<div class="lg-info">'
																	+ '<p>'
																	+ data[i].productname
																	+ '</p>'
																	+ '<input type = "hidden" value="'
																	+ data[i].orderid
																	+ '" name="orderid">'
																	+ '<p>'
																	+ data[i].productstatus
																	+ '</p>'
																	+ '<time>'
																	+ data[i].paymenttimeString
																	+ '</time>'
																	+

																	'<!-- <div class="lg-detail-wrap">'
																	+

																	'<div class="J_TipsCon hide">'
																	+ '<div class="s-tip-bar">中通快递&nbsp;&nbsp;&nbsp;&nbsp;运单号：373269427686</div>'
																	+ '<div class="s-tip-content">'
																	+ '<ul>'
																	+ '<li>快件已从 义乌 发出2015-12-20 17:58:05</li>'
																	+ '<li>义乌 的 义乌总部直发车 已揽件2015-12-20 17:54:49</li>'
																	+ '<li class="s-omit"><a data-spm-anchor-id="a1z02.1.1998049142.3" target="_blank" href="#">··· 查看全部</a></li>'
																	+ '<li>您的订单开始处理2015-12-20 08:13:48</li>'
																	+

																	'</ul>'
																	+ '</div>'
																	+ '</div>'
																	+ '</div> -->'
																	+

																	'</div>'
																	+ '<div class="lg-confirm">'
																	+ '<a class="i-btn-typical" href="javaxcript:;">确认收货</a>'
																	+ '</div>'
																	+ '</li>'
																	+ '<div class="clear"></div>'

													);
											/*
											 * if(data[i].signstatus == "已签收"){
											 * $(".lg-list").find('input[value='+data[i].orderid+']').next().text(data[i].signstatus); }
											 */
										}
										
									}
									//分页事件
									$(".lg-list").append('<div style="width: 100%; height: 20px; text-align: center;"><a href = "javascript:;" id = "listLoading">加载更多</a></div>');
									
									var num = 3;
									$(".lg-list li").hide();
									
									for(var i = 0 ; i < num ; i++){
										$(".lg-list li").eq(i).show();
									}
									
									$("#listLoading").click(function(){
										
										if(num >= $(".lg-list li").length){
											//更改信息框颜色
											$("#messageNotification").attr("style","background-color: red;");
											
											$("#showMessage").text("没有了哦0.0");
											$('#messageNotification').fadeIn(2000);
											getSrceenWH();
											$('#messageNotification').fadeOut(3000);
										}else{
											
											for(var i = num ; i < num + 5 ; i++){
												$(".lg-list li").eq(i).show();
											}
											num = num + 5;
										}
									});
									
									
									// 签收
									sign($(".lg-list li").find("a[class=i-btn-typical]"));

									// 签收
									/*$(".lg-list li").find(
											"a[class=i-btn-typical]").click(
											function() {
												// $(".J_TipsCon").removeClass("hide");

												sign(e,a);

											});*/
									

								}

							});
					
					function sign(e){
						
						//弹窗
						var w,h,className;
						function getSrceenWH(){
							w = $(window).width();
							h = $(window).height();
							$('#dialogBg').width(w).height(h);
						}
						
						window.onresize = function(){  
							getSrceenWH();
						};
						$(window).resize();  
						
						$(function(){
							getSrceenWH();
							
							//显示弹框
							e.click(function(){
								var a = $(this).parent().parent().find("input[type=hidden]");
								//alert(1);
								//info.articleid = $(this).prev().val();
								//$('#articleid').val($(this).prev().val());orderid
								$('#message').hide();
								$('#orderid').val(a.val());
								$('#showOrderid').text("单号： "+a.val());
								
								className = $(this).attr('class');
								$('#dialogBg').fadeIn(300);
								$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
							});
							
							//关闭弹窗
							$('.claseDialogBtn').click(function(){
								$('#dialogBg').fadeOut(300,function(){
									$('#dialog').addClass('bounceOutUp').fadeOut();
								});
							});
						});
						
						
					}
					
					
					//签收事件
					$(".submitBtn").click(function(){
						//alert(orderid)
						//var userPhone = $("#phone").val();
						var userPassword = $("#password").val();
						
						var user = new Object();
						user.password = userPassword;
						user.orderid = $("#orderid").val();
						//alert($("#orderid").val())
						//alert(user.orderid)
						$.ajax({
							
							type:"post",
							contentType:"application/json;charset=utf-8",
							url:root+"/product/productReceipt",
							data:JSON.stringify(user),
							success:function(data){
								if(data.flag){
									$('#message').hide();
									$('#dialogBg').fadeOut(300,function(){
										$('#dialog').addClass('bounceOutUp').fadeOut();
									});
								}
								else{
									$('#message').show();
								}
							}
						});
					});

				});

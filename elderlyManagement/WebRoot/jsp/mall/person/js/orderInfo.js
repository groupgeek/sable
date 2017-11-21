$(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var ordersid = val.split("=")[1];
	var orderid = new Array;
	for(var i in ordersid.split(",")){
		orderid[i] = ordersid.split(",")[i];
		//alert(orderid[i]);
	};
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/showOrders",
		data:JSON.stringify(orderid),
		success:function(data){
			
			for(var i in data){
				$(".order-infomain").append(
						/*'<!--标题 -->'+
						'<div class="am-cf am-padding">'+
							'<div class="am-fl am-cf"><strong class="am-text-danger am-text-lg">订单详情</strong></div>'+
						'</div>'+
						'<hr/>'+
						'<!--进度条-->'+
						'<div class="m-progress">'+
							'<div class="m-progress-list">'+
								'<span class="step" id = "status1">'+
                                   '<em class="u-progress-stage-bg"></em>'+
                                   '<i class="u-stage-icon-inner">1<em class="bg"></em></i>'+
                                   '<p class="stage-name">付款</p>'+
                                '</span>'+
								'<span class="step" id = "status2">'+
                                   '<em class="u-progress-stage-bg"></em>'+
                                   '<i class="u-stage-icon-inner">2<em class="bg"></em></i>'+
                                  '<p class="stage-name">卖家发货</p>'+
                                '</span>'+
								'<span class="step" id = "status3">'+
                                   '<em class="u-progress-stage-bg"></em>'+
                                   '<i class="u-stage-icon-inner">3<em class="bg"></em></i>'+
                                   '<p class="stage-name">确认收货</p>'+
                                '</span>'+
								'<span class="step" id = "status4">'+
                                   '<em class="u-progress-stage-bg"></em>'+
                                   '<i class="u-stage-icon-inner">4<em class="bg"></em></i>'+
                                   '<p class="stage-name">交易完成</p>'+
                               '</span>'+
								'<span class="u-progress-placeholder"></span>'+
							'</div>'+
							'<div class="u-progress-bar total-steps-2">'+
								'<div class="u-progress-bar-inner"></div>'+
							'</div>'+
						'</div>'+
						'<div class="order-infoaside">'+
							'<div class="order-logistics">'+
								'<!-- <a href="logistics.html">'+
									'<div class="icon-log">'+
										'<i><img src="../images/receive.png"></i>'+
									'</div>'+
									'<div class="latest-logistics">'+
										'<p class="text">已签收,签收人是青年城签收，感谢使用天天快递，期待再次为您服务</p>'+
										'<div class="time-list">'+
											'<span class="date">2015-12-19</span><span class="week">周六</span><span class="time">15:35:42</span>'+
										'</div>'+
										'<div class="inquire">'+
											'<span class="package-detail">物流：天天快递</span>'+
											'<span class="package-detail">快递单号: </span>'+
											'<span class="package-number">373269427868</span>'+
											'<a href="logistics.html">查看</a>'+
										'</div>'+
									'</div>'+
									'<span class="am-icon-angle-right icon"></span>'+
								'</a> -->'+
								'<div class="clear"></div>'+
							'</div>'+
							'<div class="order-addresslist">'+
								'<div class="order-address">'+
									'<div class="icon-add">'+
									'</div>'+
									'<p class="new-tit new-p-re">'+
										'<span class="buy-user"></span>'+
										'<span class="buy-phone"></span>'+
									'</p>'+
									'<div class="new-mu_l2a new-p-re">'+
										'<p class="new-mu_l2cw">'+
											'<span class="street"></span></p>'+
									'</div>'+
								'</div>'+
							'</div>'+
						'</div>'+
						*/
						
						
						
						
					/*'<div class="order-infomain">'+
						'<div class="order-top">'+
							'<div class="th th-item">'+
								'<td class="td-inner">商品</td>'+
							'</div>'+
							'<div class="th th-price">'+
								'<td class="td-inner">单价</td>'+
							'</div>'+
							'<div class="th th-number">'+
								'<td class="td-inner">数量</td>'+
							'</div>'+
							'<div class="th th-operation">'+
								'<td class="td-inner">商品操作</td>'+
							'</div>'+
							'<div class="th th-amount">'+
								'<td class="td-inner">合计</td>'+
							'</div>'+
							'<div class="th th-status">'+
								'<td class="td-inner">交易状态</td>'+
							'</div>'+
							'<div class="th th-change">'+
								'<td class="td-inner">交易操作</td>'+
							'</div>'+
						'</div>'+*/
						
						/*'<div class="order-main">'+*/
						'<div class="order-list">'+
							'<div class="order-status1">'+
								'<div class="order-title">'+
									'<div class="dd-num">编号：<a href="javascript:;" name="'+data[i].orderid+'">'+data[i].orderid+'</a></div>'+
									'<span>订单生成时间：'+data[i].ordertimeString+'</span>'+
									'<!--    <em>店铺：小桔灯</em>-->'+
								'</div>'+
								'<div class="order-content">'+
									'<div class="order-left">'+
									
									
										'<ul class="item-list">'+
											'<li class="td td-item">'+
												'<div class="item-pic">'+
													'<a href="#" class="J_MakePoint">'+
														'<img src="/upload/'+data[i].picture+'">'+
													'</a>'+
												'</div>'+
												'<div class="item-info">'+
													'<div class="item-basic-info">'+
														'<a href="JavaScript:;">'+
															'<p>'+data[i].productname+'</p>'+
															'<p class="info-little" name="colour">颜色： </p>'+
															'<p class="info-little" name="sizeOrTaste">型号： </p>'+
														'</a>'+
													'</div>'+
												'</div>'+
											'</li>'+
											'<li class="td td-price">'+
												'<div class="item-price">'+
													data[i].price+
												'</div>'+
											'</li>'+
											'<li class="td td-number">'+
												'<div class="item-number">'+
													'<span>×</span>'+data[i].productnumber+
												'</div>'+
											'</li>'+
											'<li class="td td-operation">'+
												'<div class="item-operation">'+

												'</div>'+
											'</li>'+
										'</ul>'+

										

										
									'</div>'+
									'<div class="order-right">'+
										'<li class="td td-amount">'+
											'<div class="item-amount">'+
												'合计：'+data[i].totalprice+
												/*'<p>含运费：<span>10.00</span></p>'+*/
											'</div>'+
										'</li>'+
										'<div class="move-right">'+
											'<li class="td td-status">'+
												'<div class="item-status">'+
													'<p class="Mystatus" id = "'+data[i].orderid+'"></p>'+
													'<p class="order-info"><a href="javascript:;"></a></p>'+
													'<input type="hidden" name="'+data[i].orderid+'">'+
												'</div>'+
											'</li>'+
											'<li class="td td-change">'+
												'<a href="javascript:;" class="operate">'+
												'<div class="am-btn am-btn-danger anniu">'+
													'</div></a>'+
											'</li>'+
										'</div>'+
									'</div>'+

								'</div>'+
							'</div>'+
						'</div>'+
					'</div>'
				/*'</div>'*/
				);
				
				
				var em = $(".order-infomain").find("a[name="+data[i].orderid+"]").parent().parent().parent().parent();
				if(data[i].colour != null){
					em.find("p[name=colour]").text("颜色： "+data[i].colour);
					em.find("p[name=sizeOrTaste]").text("型号："+data[i].size);
				}
				if(data[i].taste != null){
					em.find("p[name=colour]").remove();
					em.find("p[name=sizeOrTaste]").text("口味： "+data[i].taste);
				}
				
				if(data[i].orderstatus == "未付款"){
					em.find("p[class=Mystatus]").text(data[i].orderstatus);
					em.find("a[class=operate]").find("div").text("去支付");
					em.find("a[class=operate]").attr("href",root+"/jsp/mall/home/pay.jsp?ordersid="+data[i].orderid);
					$("#status1").removeClass("step-2");
					$("#status2").removeClass("step-2");
					$("#status3").removeClass("step-2");
					$("#status4").removeClass("step-2");
				}
				else if(data[i].productstatus == "未发货"){
					em.find("p[class=Mystatus]").text(data[i].productstatus);
					em.find("a[class=operate]").text("");
					$("#status1").addClass("step-2");
					$("#status2").removeClass("step-2");
					$("#status3").removeClass("step-2");
					$("#status4").removeClass("step-2");
					
				}
				else if(data[i].signstatus == "未签收"){
					em.find("p[class=Mystatus]").text(data[i].signstatus);
					em.find("a[class=operate]").find("div").text("去签收");
					$("#status1").addClass("step-2");
					$("#status2").addClass("step-2");
					$("#status3").removeClass("step-2");
					$("#status4").removeClass("step-2");
				}
				else if(data[i].evaluationstatus == false){
					em.find("p[class=Mystatus]").text(data[i].evaluationstatus);
					em.find("a[class=operate]").find("div").text("去评价");
					em.find("a[class=operate]").attr("href",root+'/jsp/mall/person/evaluation.jsp');
					$("#status1").addClass("step-2");
					$("#status2").addClass("step-2");
					$("#status3").addClass("step-2");
					$("#status4").removeClass("step-2");
				}else{
					em.find("p[class=Mystatus]").text("完成交易");
					em.find("a[class=operate]").find("div").text("删除");
					em.find("p[class=Mystatus]").next().text("");
					$("#status1").addClass("step-2");
					$("#status2").addClass("step-2");
					$("#status3").addClass("step-2");
					$("#status4").addClass("step-2");
				}
				
			}
			
			$(".buy-user").text(data[0].username);
			$(".buy-phone").text(data[0].phone);
			$(".street").text("地址："+data[0].resaddress);
			$("#totalprice").text(total);
			$(".pay-sum").text(total);
			
			
		}
	});
	
	
       
	
	
});

$(document).ready(function(){
	var root =  $("#root").attr("value");
	/*$("#pending-payment")*/
	function createUl(data,myself,father){
		myself.html("");
		myself.append(
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
			'</div>'
		);
		for(var i in data){
			myself.append(
					
					
					'<div class="order-main">'+
					'<div class="order-list">'+
						'<div class="order-status1">'+
							'<div class="order-title">'+
								'<div class="dd-num">编号：<a href="'+root+'/jsp/mall/person/orderinfo.jsp?ordersid='+data[i].orderid+'" name="'+data[i].orderid+'">'+data[i].orderid+'</a></div>'+
								'<span>订单生成时间：'+data[i].ordertimeString+'</span>'+
								'<!--    <em>店铺：小桔灯</em>-->'+
							'</div>'+
							'<div class="order-content">'+
								'<div class="order-left">'+
								
								
									'<ul class="item-list">'+
										'<li class="td td-item">'+
											'<div class="item-pic">'+
												'<a href="'+root+'/jsp/mall/person/orderinfo.jsp?ordersid='+data[i].orderid+'" class="J_MakePoint">'+
													'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].picture+'">'+
												'</a>'+
											'</div>'+
											'<div class="item-info">'+
												'<div class="item-basic-info">'+
													'<a href="'+root+'/jsp/mall/person/orderinfo.jsp?ordersid='+data[i].orderid+'">'+
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
			);
			//alert(myself.find("a[name="+data[i].orderid+"]").text());
		}
		
		//点击出现更多
		myself.append('<div style="width: 100%; height: 20px; text-align: center;"><a href = "javascript:;" id = "'+father.find("a").attr("name")+'Loading">加载更多</a></div>');
		//var logo = father.find("a").attr("name");
		//alert($("#allOrdersLoading").text())
		var num = 5;
		myself.find("div[class=order-main]").hide();
		
		for(var i = 0 ; i < num ; i++){
			myself.find("div[class=order-main]").eq(i).show();
		}
		
		
		$("#allOrdersLoading ,#pendingPaymentLoading ,#tobeDeliveredLoading ,#tobeReceivedLoading ,#beEvaluatedLoading").click(function(){
			
			if(num >= myself.find("div[class=order-main]").length){
				//更改信息框颜色
				$("#messageNotification").attr("style","background-color: red;");
				
				$("#showMessage").text("没有了哦0.0");
				$('#messageNotification').fadeIn(2000);
				getSrceenWH();
				$('#messageNotification').fadeOut(3000);
			}else{
				for(var i = num ; i < num + 5 ; i++){
					myself.find("div[class=order-main]").eq(i).show();
				}
				num = num + 5;
			}
			
		});
		
		
		/*$("#pendingPaymentLoading").click(function(){
			
			alert($("#pendingPaymentLoading").text())
			
		});*/
		
		
		/*$("#tobeDeliveredLoading").click(function(){
			
			alert($("#tobeDeliveredLoading").text())
			
		});*/
		
		/*
		$("#tobeReceivedLoading").click(function(){
			
			alert($("#tobeReceivedLoading").text())
			
		});*/
		
		/*$("#beEvaluatedLoading").click(function(){
			
			
			
		});*/
		//结束
		
		
		function type(){
			
		}
		
		for(var i in data){
			
			var em = myself.find("a[name="+data[i].orderid+"]").parent().parent().parent().parent();
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
				}
				else if(data[i].productstatus == "未发货"){
					em.find("p[class=Mystatus]").text(data[i].productstatus);
					em.find("a[class=operate]").text("");
				}
				else if(data[i].signstatus == "未签收"){
					em.find("p[class=Mystatus]").text(data[i].signstatus);
					em.find("a[class=operate]").find("div").text("去签收");
					sign(em.find("a[class=operate]").find("div"),myself.find("a[name="+data[i].orderid+"]"));
				}
				else if(data[i].evaluationstatus == false){
					em.find("p[class=Mystatus]").text(data[i].evaluationstatus);
					em.find("a[class=operate]").find("div").text("去评价");
					em.find("a[class=operate]").attr("href",root+'/jsp/mall/person/evaluation.jsp');
				}else{
					em.find("p[class=Mystatus]").text("完成交易");
					em.find("a[class=operate]").find("div").text("删除");
					em.find("p[class=Mystatus]").next().text("");
				}
				
		}
		
		//删除事件
		myself.find("a[class=operate]").find("div").click(function(){
			if($(this).text() == "删除"){
				var rm = $(this).parent().parent().parent().parent().parent().parent().parent().parent();
				var oid = rm.find("p[class=Mystatus]").attr("id");
				$.ajax({
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/product/deleteOrder",
					data:JSON.stringify(oid),
					success:function(data){
						if(data.flag)
						rm.remove();
					}
					
				});
			}
			
		});
	}
	
	
	
	
	//第一次进入
	var flag = 0;
	if(flag == 0){
		var myselfStart = $($("#orderMenu li").first().find("a").attr("href"));
		var logoStart = $("#orderMenu li").first().find("a").attr("name");
		
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/queryOrders",
			data:JSON.stringify(logoStart),
			success:function(data){
				createUl(data,myselfStart,$("#orderMenu li").first());
				flag++;
			}
			
		});
	}
	
	//点击事件
	$("#orderMenu li").click(function(){
		father = $(this);
		
		var myself = $($(this).find("a").attr("href"));
		
		var logo = $(this).find("a").attr("name");
		
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/queryOrders",
			data:JSON.stringify(logo),
			success:function(data){
				createUl(data,myself,father);
			}
			
		});
		
	});
	
	function sign(e,a){
			
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
				//info.articleid = $(this).prev().val();
				//$('#articleid').val($(this).prev().val());orderid
				$('#message').hide();
				$('#orderid').val(a.attr("name"));
				$('#showOrderid').text("单号： "+a.attr("name"));
				
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
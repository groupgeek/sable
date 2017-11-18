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
								'<span>成交时间：'+data[i].ordertimeString+'</span>'+
								'<!--    <em>店铺：小桔灯</em>-->'+
							'</div>'+
							'<div class="order-content">'+
								'<div class="order-left">'+
								
								
									'<ul class="item-list">'+
										'<li class="td td-item">'+
											'<div class="item-pic">'+
												'<a href="'+root+'/jsp/mall/person/orderinfo.jsp?ordersid='+data[i].orderid+'" class="J_MakePoint">'+
													'<img src="/upload/'+data[i].picture+'">'+
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
		//var logo = father.find("a").attr("name");
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
	
	
	
	
});
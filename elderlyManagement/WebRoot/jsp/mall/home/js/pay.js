$(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var ordersid = val.split("=")[1];
	var orderid = new Array;
	var updatetotal = new Array;
	updatetotal = orderid;
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
			//alert(data);
			
			var total = 0;
			for(var i in data){
				total += data[i].totalprice;
				
				$("#ordersData").append(
						'<div class="bundle-main">'+
						'<ul class="item-content clearfix">'+
							'<div class="pay-phone">'+
							'<ul>'+
								'<li class="td td-item">'+
									'<div class="item-pic">'+
										'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" class="J_MakePoint">'+
											'<img src="/upload/'+data[i].picture+'" class="itempic J_ItemImg"></a>'+
									'</div>'+
									'<div class="item-info">'+
										'<div class="item-basic-info">'+
											'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data[i].description+'</a>'+
										'</div>'+
									'</div>'+
								'</li>'+
								/*'<li class="td td-info">'+
									'<div class="item-props">'+
										'<span class="sku-line">颜色：10#蜜橘色+17#樱花粉</span>'+
										'<span class="sku-line">包装：两支手袋装（送彩带）</span>'+
									'</div>'+
								'</li>'+*/
								'<li class="td td-price">'+
									'<div class="item-price price-promo-promo">'+
										'<div class="price-content">'+
											'<em class="J_Price price-now">'+data[i].price+'</em>'+
										'</div>'+
									'</div>'+
								'</li>'+
							'</ul>'+
							'</div>'+

							'<li class="td td-amount">'+
								'<div class="amount-wrapper ">'+
									'<div class="item-amount ">'+
										'<span class="phone-title">购买数量</span>'+
										'<div class="sl">'+
											'<input id="min" class="min" name="" type="button" value="-" />'+
											'<input type="hidden" name = "orderid" value="'+data[i].orderid+'"/>'+
											'<input class="text_box" name="" type="text" value="'+data[i].productnumber+'" style="width:30px;" />'+
											'<input id="add" class="add" name="" type="button" value="+" />'+
										'</div>'+
									'</div>'+
								'</div>'+
							'</li>'+
							'<li class="td td-sum">'+
								'<div class="td-inner">'+
									'<em tabindex="0" class="J_ItemSum number">'+data[i].totalprice+'</em>'+
								'</div>'+
							'</li>'+
							'<li class="td td-oplist">'+
								'<div class="td-inner">'+
									'<span class="phone-title">操作</span>'+
									'<div class="pay-logis">'+
										'<a href="javascript:;" class = "rm" name = "rm">删除</a>'+
									'</div>'+
								'</div>'+
							'</li>'+

						'</ul>'+
						'<div class="clear"></div>'+

					'</div>'
				
				);
			}
			
			$(".buy-user").text(data[0].username);
			$(".buy-phone").text(data[0].phone);
			$(".street").text(data[0].resaddress);
			$("#totalprice").text(total);
			$(".pay-sum").text(total);
			
			function updateOrderNumber(orderid,number,totalprice){
				var orderInfo = new Object();
				orderInfo.orderid = orderid;
				orderInfo.productnumber = number;
				orderInfo.totalprice = totalprice;
				$.ajax({
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/product/updateUserOrderNumber",
					data:JSON.stringify(orderInfo),
					success:function(data){
						/*if(!data.falg){
							alert(data.message);
						}*/
						
						$.ajax({
							type:"post",
							contentType:"application/json;charset=utf-8",
							url:root+"/product/showOrders",
							data:JSON.stringify(updatetotal),
							success:function(data){
								var total = 0;
								for(var i in data){
									total += data[i].totalprice;
								}
								$("#totalprice").text(total);
								$(".pay-sum").text(total);
							}
						});
					}
				});
			}
			
			//删除
			$(".rm").click(function(){
				var father = $(this).parent().parent().parent().parent().parent();
				var oid = father.find("input[name=orderid]").val();
				
				$.ajax({
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/product/deleteOrder",
					data:JSON.stringify(oid),
					success:function(data){
						alert(data.flag)
						if(data.flag){
							father.remove();
						}
					}
				});
			});
			
			
			
			
			//产品数量的事件
			 $(".add").click(function(){
		         var t=$(this).parent().find('input[class*=text_box]');
		         t.val(parseInt(t.val())+1);
		         var x = $(this).parent().parent().parent().parent().next().find("em");
		         var y =  $(this).parent().parent().parent().parent().prev().find("em");
		         x.text(y.text()*t.val());
		         //alert($(this).parent().find("input[name=orderid]").attr("value"));
		         updateOrderNumber($(this).parent().find("input[name=orderid]").attr("value"),t.val(),x.text());
		     });
	        $(".min").click(function(){
	        	var t=$(this).parent().find('input[class*=text_box]');
		        t.val(parseInt(t.val())-1);
		        var x = $(this).parent().parent().parent().parent().next().find("em");
		        var y =  $(this).parent().parent().parent().parent().prev().find("em");
		        x.text(y.text()*t.val());
		        if(parseInt(t.val())<0){
		        	t.val(0);
		         	x.text(0);
		         }
		        //alert($(this).next().attr("value"));
		        updateOrderNumber($(this).next().attr("value"),t.val(),x.text());
	        });
	        $(".text_box").change(function(){
	        	var x = $(this).parent().parent().parent().parent().next().find("em");
		        var y =  $(this).parent().parent().parent().parent().prev().find("em");
		        x.text(y.text()*$(this).val());
		        if(parseInt($(this).val())<0){
		        	$(this).val(0);
		         	x.text(0);
		         }
	        	
		        updateOrderNumber($(this).parent().find("input[name=orderid]").attr("value"),$(this).val(),x.text());
	        });
		}
	});
	
	$("#save").click(function(){
		
		var user_name = $("#user-name").attr("value");
		var user_phone = $("#user-phone").attr("value");
		var province = $("#province").attr("value");
		var city = $("#city").attr("value");
		var county = $("#county").attr("value");
		var user_address = $("#user-address").attr("value");
		var info = new Object();
		info.username = user_name;
		info.phone = user_phone;
		info.resaddress = province + city + county + user_address;
		
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/updateUserOrderInfo",
			data:JSON.stringify(info),
			
			success:function(data){
				alert(data.message);
				if(data.flag){
					$(".buy-user").text(info.username);
					$(".buy-phone").text(info.phone);
					$(".street").text(info.resaddress);
				}
			}
		});
		
	});
	
       
	
	
});

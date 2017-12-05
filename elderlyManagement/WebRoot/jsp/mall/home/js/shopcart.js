$(document).ready(function(){
	var root = $("#root").attr("value");
	
	/*data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"activitystatus"'+':'+'"'+activitystatus+'"'+','
			+'"sort"'+':'+'"'+sort+'"'
	    			+'}',
	
	*/
	
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/queryAllShopCartByUserid",
			success:function(data){
				/*alert(1)class="itempic J_ItemImg"*/
				for(var i in data){
					if(data[i].type == 2){
						
						$("#data").append(
								
								'<ul class="item-content clearfix">'+
								'<li class="td td-chk">'+
									'<div class="cart-checkbox ">'+
										'<input checked = "checked" class="check" id="J_CheckBox_170037950254" name="items" value="'+data[i].shoppingcarid+'" type="checkbox">'+
										'<label for="J_CheckBox_170037950254"></label>'+
									'</div>'+
								'</li>'+
								'<li class="td td-item">'+
									'<div class="item-pic">'+
										'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" data-title="" class="J_MakePoint" data-point="tbcart.8.12">'+
											'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].productInfo.picture+'?x-oss-process=image/resize,m_lfit,h_80,w_80" class="itempic J_ItemImg"></a>'+
									'</div>'+
									'<div class="item-info">'+
										'<div class="item-basic-info">'+
											'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data[i].productInfo.description+'</a>'+
										'</div>'+
									'</div>'+
								'</li>'+
								
								'<li class="td td-info">'+
									'<div class="item-props item-props-can">'+
										'<span class="sku-line">颜色：'+data[i].productcolourInfo.productcolour+'</span>'+
										'<span class="sku-line">型号：'+data[i].sziestring+'</span>'+
										'<input type="hidden" name="productid" value="'+data[i].productid+'">'+
										'<span tabindex="0" class="btn-edit-sku theme-login" name = "updateOption">修改</span>'+
										'<input type="hidden" name="ptype" value="'+data[i].type+'">'+
										'<i class="theme-login am-icon-sort-desc"></i>'+
									'</div>'+
								'</li>'+
								
								'<li class="td td-price">'+
									'<div class="item-price price-promo-promo">'+
										'<div class="price-content">'+
											'<div class="price-line">'+
												'<em class="J_Price price-now" tabindex="0">'+data[i].productInfo.price+'</em>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-amount">'+
									'<div class="amount-wrapper ">'+
										'<div class="item-amount ">'+
											'<div class="sl">'+
												'<input id="min" class="min" name="" type="button" value="-" />'+
												'<input class="text_box" name="number" type="text" value="1" style="width:30px;" />'+
												'<input id="add" class="add" name="" type="button" value="+" />'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-sum">'+
									'<div class="td-inner">'+
										'<em tabindex="0" class="J_ItemSum number">'+data[i].productInfo.price+'</em>'+
									'</div>'+
								'</li>'+
								'<li class="td td-op">'+
									'<div class="td-inner">'+
										'<a href="javascript:;" data-point-url="#" class="delete">删除</a>'+
									'</div>'+
								'</li>'+
							'</ul>'
						);
					}
					if(data[i].type == 1){
						$("#data").append(
								'<ul class="item-content clearfix">'+
								'<li class="td td-chk">'+
									'<div class="cart-checkbox ">'+
										'<input checked = "checked" class="check" id="J_CheckBox_170037950254" name="items" value="'+data[i].shoppingcarid+'" type="checkbox">'+
										'<label for="J_CheckBox_170037950254"></label>'+
									'</div>'+
								'</li>'+
								'<li class="td td-item">'+
									'<div class="item-pic">'+
										'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" data-title="" class="J_MakePoint" data-point="tbcart.8.12">'+
											'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].productInfo.picture+'?x-oss-process=image/resize,m_lfit,h_80,w_80" class="itempic J_ItemImg"></a>'+
									'</div>'+
									'<div class="item-info">'+
										'<div class="item-basic-info">'+
											'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data[i].productInfo.description+'</a>'+
										'</div>'+
									'</div>'+
								'</li>'+
								
								'<li class="td td-info">'+
									'<div class="item-props item-props-can">'+
										'<span class="sku-line">口味：'+data[i].producttasteInfo.producttaste+'</span>'+
										'<input type="hidden" name="productid" value="'+data[i].productid+'">'+
										'<span tabindex="0" class="btn-edit-sku theme-login" name = "updateOption">修改</span>'+
										'<input type="hidden" name="ptype" value="'+data[i].type+'">'+
										'<i class="theme-login am-icon-sort-desc"></i>'+
									'</div>'+
								'</li>'+
								
								'<li class="td td-price">'+
									'<div class="item-price price-promo-promo">'+
										'<div class="price-content">'+
											'<div class="price-line">'+
												'<em class="J_Price price-now" tabindex="0">'+data[i].productInfo.price+'</em>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-amount">'+
									'<div class="amount-wrapper ">'+
										'<div class="item-amount ">'+
											'<div class="sl">'+
												'<input id="min" class="min" name="" type="button" value="-" />'+
												'<input class="text_box" name="number" type="text" value="1" style="width:30px;" />'+
												'<input id="add" class="add" name="" type="button" value="+" />'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-sum">'+
									'<div class="td-inner">'+
										'<em tabindex="0" class="J_ItemSum number">'+data[i].productInfo.price+'</em>'+
									'</div>'+
								'</li>'+
								'<li class="td td-op">'+
									'<div class="td-inner">'+
										'<a href="javascript:;" data-point-url="#" class="delete">删除</a>'+
									'</div>'+
								'</li>'+
							'</ul>'
						
						);
					}
					
					if(data[i].type == 0){
						$("#data").append(
								'<ul class="item-content clearfix">'+
								'<li class="td td-chk">'+
									'<div class="cart-checkbox ">'+
										'<input checked = "checked" class="check" id="J_CheckBox_170037950254" name="items" value="'+data[i].shoppingcarid+'" type="checkbox">'+
										'<label for="J_CheckBox_170037950254"></label>'+
									'</div>'+
								'</li>'+
								'<li class="td td-item">'+
									'<div class="item-pic">'+
										'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" data-title="" class="J_MakePoint" data-point="tbcart.8.12">'+
											'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].productInfo.picture+'?x-oss-process=image/resize,m_lfit,h_80,w_80" class="itempic J_ItemImg"></a>'+
									'</div>'+
									'<div class="item-info">'+
										'<div class="item-basic-info">'+
											'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data[i].productInfo.description+'</a>'+
										'</div>'+
									'</div>'+
								'</li>'+
								
								/*'<li class="td td-info">'+
									'<div class="item-props item-props-can">'+
										'<span class="sku-line"> </span>'+
										'<span tabindex="0" class="btn-edit-sku theme-login" name = "updateOption">修改</span>'+
										'<input type="hidden" name="ptype" value="'+data[i].type+'">'+
										'<i class="theme-login am-icon-sort-desc"></i>'+
									'</div>'+
								'</li>'+*/
								
								'<li class="td td-price">'+
									'<div class="item-price price-promo-promo">'+
										'<div class="price-content">'+
											'<div class="price-line">'+
												'<em class="J_Price price-now" tabindex="0">'+data[i].productInfo.price+'</em>'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-amount">'+
									'<div class="amount-wrapper ">'+
										'<div class="item-amount ">'+
											'<div class="sl">'+
												'<input id="min" class="min" name="" type="button" value="-" />'+
												'<input class="text_box" name="number" type="text" value="1" style="width:30px;" />'+
												'<input id="add" class="add" name="" type="button" value="+" />'+
											'</div>'+
										'</div>'+
									'</div>'+
								'</li>'+
								'<li class="td td-sum">'+
									'<div class="td-inner">'+
										'<em tabindex="0" class="J_ItemSum number">'+data[i].productInfo.price+'</em>'+
									'</div>'+
								'</li>'+
								'<li class="td td-op">'+
									'<div class="td-inner">'+
										'<a href="javascript:;" data-point-url="#" class="delete">删除</a>'+
									'</div>'+
								'</li>'+
							'</ul>'
						
						);
					}
						
				}	
				
				
				//删除一个
				$(".delete").click(function(){
					
					var shoppingcarid = $(this).parent().parent().parent().find("input[name=items]").attr("value");
					var option = $(this).parent().parent().parent();
					$.ajax({
						
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/deleteShop",
						data:JSON.stringify(shoppingcarid),
						success:function(data){
							if(data.flag){
								option.remove();
							}
						}
						
					});
					
					
				});
				
				
				
				
				
				 $(document).ready(function(){

				     $(function(){
				         $(".add").click(function(){
				          var t=$(this).parent().find('input[class*=text_box]');
				         t.val(parseInt(t.val())+1);
				         var x = $(this).parent().parent().parent().parent().next().find("em");
				         var y =  $(this).parent().parent().parent().parent().prev().find("em");
				         x.text(y.text()*t.val());
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
				       });
				    });

					
					/*<!--兼容IE浏览器 -->*/
					    if (!document.getElementsByClassName) {
				        document.getElementsByClassName = function (cls) {
				            var ret = [];
				            var els = document.getElementsByTagName('*');
				            for (var i = 0, len = els.length; i < len; i++) {

				                if (els[i].className.indexOf(cls + ' ') >=0 || els[i].className.indexOf(' ' + cls + ' ') >=0 || els[i].className.indexOf(' ' + cls) >=0) {
				                    ret.push(els[i]);
				                }
				            }
				            return ret;
				        };
				    }
				 //全选
					   
					
				
				
				 
				//查看商品的颜色或者口味
				 $("span[name=updateOption]").click(function(){
					 var thisItem = null;
					 thisItem = $(this);
					 //alert($(this).html());
					 //alert($(this).prev().val())
					 var productid = $(this).prev().val();
					 var ptype = $(this).next().val();
					 
					 
					$("#producttype").attr("value",ptype);
					$("#shoppingcarid").attr("value",$(this).parent().parent().parent().find("input[name=items]").val());
					
					
					 $.ajax({
							
							type:"post",
							contentType:"application/json;charset=utf-8",
							url:root+"/product/queryColourOrTaste",
							data:JSON.stringify(productid),
							success:function(result){
								///修改弹出内容
								
								
								if(ptype == 1){
									//$("#colour").parent().remove();
									//$("#size").parent().remove();
									$("#colour").parent().hide();
									$("#size").parent().hide();
									var count = 0;
									$("#tasteList").html("");
									
									for(var i in result.tasteList){
										if(count == 0){
											$("#tasteList").append(
													'<li class="sku-line selected">'+result.tasteList[i].producttaste+'<i></i></li>'+
													'<input type="hidden" name="ptype" value="'+result.tasteList[i].producttasteid+'">'
												);
										}else{
											$("#tasteList").append(
													'<li class="sku-line">'+result.tasteList[i].producttaste+'<i></i></li>'+
													'<input type="hidden" name="ptype" value="'+result.tasteList[i].producttasteid+'">'
												);
										}
										count++;
									}
									$("#taste").parent().show();
									
									
								}else if(ptype == 2){
									//$("#taste").parent().remove();
									$("#taste").parent().hide();
									var count = 0;
									$("#colourList").html("");
									$("#sizeList").html("");
									for(var i in result.colourList){
										if(count == 0){
											$("#colourList").append(
													'<li class="sku-line selected">'+result.colourList[i].productcolour+'<i></i></li>'+
													'<input type="hidden" name="ptype" value="'+result.colourList[i].productcolourid+'">'
												);
										}else{
											$("#colourList").append(
													'<li class="sku-line">'+result.colourList[i].productcolour+'<i></i></li>'+
													'<input type="hidden" name="ptype" value="'+result.colourList[i].productcolourid+'">'
												);
										}
										count++;
									}
									
									$("#sizeList").append(
											'<li class="sku-line selected" value= "xs" >xs<i></i></li>'+
											'<li class="sku-line" value= "s" >s<i></i></li>'+
											'<li class="sku-line" value= "m" >m<i></i></li>'+
											'<li class="sku-line" value= "l" >l<i></i></li>'+
											'<li class="sku-line" value= "xl" >xl<i></i></li>'+
											'<li class="sku-line" value= "xll" >xll<i></i></li>'
									);
									
									
									
									
									$("#colour").parent().show();
									$("#size").parent().show();
								}else{
									$("#taste").parent().hide();
									$("#colour").parent().hide();
									$("#size").parent().hide();
								}
								
								
								
								
								
								
								
								
								//弹出内容
								var $ww = $(window).width();
								
								//$('.theme-login').click(function() {
//									禁止遮罩层下面的内容滚动
									$(document.body).css("position","fixed");
									
									thisItem.addClass("selected");
									thisItem.parent().addClass("selected");
									var to=thisItem.prev().offset().top+30;
									var th=thisItem.offset().top;
									var tl=thisItem.offset().left-200;
									
									$('.theme-span').show();				
									$('.theme-popover-mask').show();
									$('.theme-popover-mask').height($(document).height());
									$('.theme-popover').slideDown(200);
									
							   if ($ww>640){
									$('.theme-popover').css("top",th);
									$('.theme-popover').css("left",tl);
									$('.theme-popover-mask').hide();
								 	}					
							   if ($ww>1024){				
									$('.theme-popover').css("top",to);
									$('.theme-popover').css("left",tl);
									$('.theme-popover-mask').hide();
								 	}													
									
								//});
								$('.theme-poptit .close,.btn-op .close').click(function() {
									$(document.body).css("position","static");
//									滚动条复位
									$('.theme-signin-left').scrollTop(0);					
									$('.theme-login').removeClass("selected");
									$('.item-props-can').removeClass("selected");					
									$('.theme-span').hide();
									$('.theme-popover-mask').hide();
									$('.theme-popover').slideUp(200);
								});
								
								//商品规格选择
									$(".theme-options").each(function(){
										var i=$(this);
										var p=i.find("ul>li");
										p.click(function(){
											if(!!$(this).hasClass("selected")){
												$(this).removeClass("selected");
											
											}else{
												$(this).addClass("selected").siblings("li").removeClass("selected");
												
											}
											
											$(this).parent().prev().val($(this).next().val());
											
										});
									});

								
								//保存
								$(".save").click(function(){
									var producttype = $("#producttype").val();
									var shoppingcarid = $("#shoppingcarid").val();
									var taste = $("#tasteTempId").val(); 
									var colour = $("#colourTempId").val();
									var sziestring = $("#sizeList li.selected").text();
									var info = new Object();
									info.type = producttype;
									info.shoppingcarid = shoppingcarid;
									if(producttype == 1){
										info.taste = taste;
									}
									if(producttype == 2){
										
										info.colour = colour;
										info.sziestring = sziestring;
									}
									$.ajax({
										
										type:"post",
										contentType:"application/json;charset=utf-8",
										url:root+"/product/updateColourOrTaste",
										data:JSON.stringify(info),
										success:function(data){
											//alert(data.message);
											if(producttype == 2) {
												
												thisItem.prev().prev().prev().text("颜色："+$("#colourList li.selected").text());
												thisItem.prev().prev().text("型号："+sziestring);
												thisItem = null;
											}
											if(producttype == 1){
												
												thisItem.prev().prev().text("口味："+$("#tasteList li.selected").text());
												thisItem = null;
											}
											
										}
										
									});
								});
								
								
							}
							
						});
					 
				 });
				 
				 
				 
				});
				 
				 
				
			}
		
		
		});
		
		
		
		
		
		
		//window.location.href = root+"/jsp/mall/home/shopcart.jsp";
		//结算
		$("#pay").click(function(){
			var payArr = new Array();
			var i = 0;
			$("input[name=items]").each(function(){
				
				if(this.checked){
					shoppingcaridtemp = $(this).val();
					numbertemp = $(this).parent().parent().parent().find("input[name=number]").val();
					payArr[i] = {shoppingcarid:shoppingcaridtemp,number:numbertemp};
					//alert(payArr[i].number);
					i++;
				}
				
				
			});
			//alert(payArr.length);
			
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/product/addOrders",
				data:JSON.stringify(payArr),
				success:function(data){
					//alert(data)
					if(data != null || data != "")
					window.open(root+"/jsp/mall/home/pay.jsp?ordersid="+data);
					
				}
				
			});
			
		});
		//全选
		 $("#select-all").click(function(){
			
				if(this.checked){
					$("input[name=items]").attr("checked",true);
				}else{
					$("input[name=items]").attr("checked",false);
				}
			});
		 
	
		
	
});
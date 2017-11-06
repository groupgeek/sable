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
											'<img src="/upload/'+data[i].productInfo.picture+'" class="itempic J_ItemImg"></a>'+
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
										'<span tabindex="0" class="btn-edit-sku theme-login">修改</span>'+
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
												'<input class="text_box" name="" type="text" value="1" style="width:30px;" />'+
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
											'<img src="/upload/'+data[i].productInfo.picture+'" class="itempic J_ItemImg"></a>'+
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
										'<span tabindex="0" class="btn-edit-sku theme-login">修改</span>'+
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
												'<input class="text_box" name="" type="text" value="1" style="width:30px;" />'+
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
											'<img src="/upload/'+data[i].productInfo.picture+'" class="itempic J_ItemImg"></a>'+
									'</div>'+
									'<div class="item-info">'+
										'<div class="item-basic-info">'+
											'<a href="'+root+'/product/productInfo?id='+data[i].productid+'" target="_blank" title="" class="item-title J_MakePoint" data-point="tbcart.8.11">'+data[i].productInfo.description+'</a>'+
										'</div>'+
									'</div>'+
								'</li>'+
								
								'<li class="td td-info">'+
									'<div class="item-props item-props-can">'+
										'<span class="sku-line"> </span>'+
										'<span tabindex="0" class="btn-edit-sku theme-login">修改</span>'+
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
												'<input class="text_box" name="" type="text" value="1" style="width:30px;" />'+
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
					   
					
				//商品规格选择
				$(function(){
					$(".theme-options").each(function(){
						var i=$(this);
						var p=i.find("ul>li");
						p.click(function(){
							if(!!$(this).hasClass("selected")){
								$(this).removeClass("selected");
							
							}else{
								$(this).addClass("selected").siblings("li").removeClass("selected");
								
							}

						});
					});

				});
				 
				 
				 
				 
				 
				});
				 
				// 弹出规格选择
				 
							$(document).ready(function($) {
					
								var $ww = $(window).width();
					
								$('.theme-login').click(function() {
//									禁止遮罩层下面的内容滚动
									$(document.body).css("position","fixed");
									
									$(this).addClass("selected");
									$(this).parent().addClass("selected");
									var to=$(this).prev().offset().top+30;
									var th=$(this).offset().top;
									var tl=$(this).offset().left-200;
									
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
									
								});
								/*$('.theme-poptit .close,.btn-op .close').click(function() {
									$(document.body).css("position","static");
//									滚动条复位
									$('.theme-signin-left').scrollTop(0);					
									$('.theme-login').removeClass("selected");
									$('.item-props-can').removeClass("selected");					
									$('.theme-span').hide();
									$('.theme-popover-mask').hide();
									$('.theme-popover').slideUp(200);
								});*/

								
							}); 
				 
				
			}
		
		
		});
		//window.location.href = root+"/jsp/mall/home/shopcart.jsp";
		$("#pay").click(function(){
			$("input[name=items]").each(function(){
				
				if(this.checked){
					
					alert($(this).val());
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
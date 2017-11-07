$(document).ready(function(){
	var root =  $("#root").attr("value");
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryAllAddressByUserid",
		success:function(data){
			if(data == null){
				alert("请登录");
				window.location.href = root+"/jsp/logReg/login.jsp";
			}
			
			for(var i in data.addresssList){
				if(data.addresssList[i].defaultaddress){//默认地址的加载
					$("#default-address p span").first().text(data.user.username);
					$("#default-address p span").first().next().text(data.user.phone);
					$("#default-address div").first().find("span").last().text(data.addresssList[i].shippingaddress);
					$("#default-address div").last().find("input[name=shippingaddressid]").val(data.addresssList[i].shippingaddressid);
				}else{
					$("#address-list").append(
							'<li class="user-addresslist">'+
							'<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>'+
							'<p class="new-tit new-p-re">'+
								'<span class="new-txt">'+data.user.username+'</span>'+
								'<span class="new-txt-rd2">'+data.user.phone+'</span>'+
							'</p>'+
							'<div class="new-mu_l2a new-p-re">'+
								'<p class="new-mu_l2cw">'+
									'<span class="title">地址：</span>'+
									'<span class="street">'+data.addresssList[i].shippingaddress+'</span></p>'+
							'</div>'+
							'<div class="new-addr-btn">'+
								'<a href="javascript:;" onclick="updateClick(this);"><i class="am-icon-edit"></i>编辑</a>'+
								'<span class="new-addr-bar">|</span>'+
								'<a href="javascript:void(0);" onclick="delClick(this);"><i class="am-icon-trash"></i>删除</a>'+
								'<input type="hidden" name = "shippingaddressid" value="'+data.addresssList[i].shippingaddressid+'">'+
							'</div>'+
							'</li>'
					);
				}
					
			}
			
			//地址选择事件
				$(".user-addresslist").click(function() {
					$(this).addClass("defaultAddr").siblings().removeClass("defaultAddr");
				});
				$(".logistics").each(function() {
					var i = $(this);
					var p = i.find("ul>li");
					p.click(function() {
						if (!!$(this).hasClass("selected")) {
							$(this).removeClass("selected");
						} else {
							$(this).addClass("selected").siblings("li").removeClass("selected");
						}
					});
				});
				
			//编辑地址
				/*updateClick(element){
					var address = new Object();
					address.shippingaddressid = $(element).parent().find("input[name=shippingaddressid]").val();
					address.shippingaddress = $(element)
					address.phone
					address.receiver
					
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/queryAllAddressByUserid",
						data:JSON.stringify(address),
						success:function(){
							
						}
						
					});
				};*/
			//删除地址
				function delClick(element){
					alert(1)
					var shippingaddressid = $(element).next().val();
					
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/delShippingAddress",
						data:JSON.stringify(shippingaddressid),
						success:function(data){
							if(data.falg){
								$(element).remove();
							};
						}
						
					});
				};
				
		}
	});
	
	
});
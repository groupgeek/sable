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
					$("#default-address p span").first().text(data.addresssList[i].receiver);
					$("#default-address p span").first().next().text(data.addresssList[i].phone);
					$("#default-address div").first().find("span").last().text(data.addresssList[i].shippingaddress);
					$("#default-address div").last().find("input[name=shippingaddressid]").val(data.addresssList[i].shippingaddressid);
					
				}else{
					$("#address-list").append(
							'<li class="user-addresslist" style="margin-bottom: 10px;">'+
							'<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>'+
							'<p class="new-tit new-p-re">'+
								'<span class="new-txt">'+data.addresssList[i].receiver+'</span>'+
								'<span class="new-txt-rd2">'+data.addresssList[i].phone+'</span>'+
							'</p>'+
							'<div class="new-mu_l2a new-p-re">'+
								'<p class="new-mu_l2cw">'+
									'<span class="title">地址：</span>'+
									'<span class="street">'+data.addresssList[i].shippingaddress+'</span></p>'+
							'</div>'+
							'<div class="new-addr-btn">'+
								'<a href="javascript:void(0);" name="del-address"><i class="am-icon-trash"></i>删除</a>'+
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
				$("#address-list li").find("a[name=del-address]").click(function(){
					var myself = $(this);
					
					var shippingaddressid = $(this).next().val();
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/delShippingAddress",
						data:JSON.stringify(shippingaddressid),
						success:function(data){
							if(data.flag){
								myself.parent().parent().remove();
								//显示提示信息
								$("#messageNotification").attr("style","background-color: red;");
								$("#showMessage").text("删除成功");
								$('#messageNotification').fadeIn(2000);
								getSrceenWH();
								$('#messageNotification').fadeOut(3000);
							};
						}
						
					});
				});
				
			//把地址设为默认$(".new-option-r")
				$("#address-list li").find("span[class=new-option-r]").click(function(){
					var myself = $(this);
					var father = myself.parent();
					var myselfid = father.find("input[name=shippingaddressid]").val();
					var condition = new Object();
					condition.shippingaddressid = myselfid;
					//window.location.href = root+"/jsp/mall/person/shippingAddress.jsp";
					//alert(father.parent().find("input[value="+1+"]").val());
					//father.parent().find("input[value="+1+"]").parent().parent().find("span[class=new-option-r]").text("设为默认");
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/updateDefaultAddress",
						data:JSON.stringify(condition),
						success:function(data){
							if(data != ""){
								//修改页面的默认地址
								father.parent().find("input[value="+data.shippingaddressid+"]").parent().parent().find("span[class=new-option-r]").text("设为默认");
								myself.text("默认地址");
							};
						}
						
					});
				});
		}
	});
	//以上为地址管理
	
	//新增地址
	//保存地址
	$("#save").click(function(){
		var addressInfo = new Object();
		var province = $("#province").val();
		var city = $("#city").val();
		var county = $("#county").val();
		var user_adddress_info = $("#user-adddress-info").val();
		
		addressInfo.receiver = $("#user-name").val();
		addressInfo.phone = $("#user-phone").val();
		addressInfo.shippingaddress = province + city + county + user_adddress_info;
		addressInfo.defaultaddress = false;
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/addAddress",
			data:JSON.stringify(addressInfo),
			success:function(data){
				if(data.shippingaddressid != null){
					//增加页面的地址
					$("#address-list").append(
							'<li class="user-addresslist" style="margin-bottom: 10px;">'+
							'<span class="new-option-r"><i class="am-icon-check-circle"></i>设为默认</span>'+
							'<p class="new-tit new-p-re">'+
								'<span class="new-txt">'+data.receiver+'</span>'+
								'<span class="new-txt-rd2">'+data.phone+'</span>'+
							'</p>'+
							'<div class="new-mu_l2a new-p-re">'+
								'<p class="new-mu_l2cw">'+
									'<span class="title">地址：</span>'+
									'<span class="street">'+data.shippingaddress+'</span></p>'+
							'</div>'+
							'<div class="new-addr-btn">'+
								'<a href="javascript:void(0);" name="del-address"><i class="am-icon-trash"></i>删除</a>'+
								'<input type="hidden" name = "shippingaddressid" value="'+data.shippingaddressid+'">'+
							'</div>'+
							'</li>'
					);
					//显示提示信息
					$("#messageNotification").attr("style","background-color: red;");
					$("#showMessage").text("添加成功");
					$('#messageNotification').fadeIn(2000);
					getSrceenWH();
					$('#messageNotification').fadeOut(3000);
				};
				
				
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
				
				//删除地址
				$("#address-list li").find("a[name=del-address]").click(function(){
					var myself = $(this);
					
					var shippingaddressid = $(this).next().val();
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/delShippingAddress",
						data:JSON.stringify(shippingaddressid),
						success:function(data){
							if(data.flag){
								myself.parent().parent().remove();
								//显示提示信息
								$("#messageNotification").attr("style","background-color: red;");
								$("#showMessage").text("删除成功");
								$('#messageNotification').fadeIn(2000);
								getSrceenWH();
								$('#messageNotification').fadeOut(3000);
							};
						}
						
					});
				});
				
			//把地址设为默认$(".new-option-r")
				$("#address-list li").find("span[class=new-option-r]").click(function(){
					var myself = $(this);
					var father = myself.parent();
					var myselfid = father.find("input[name=shippingaddressid]").val();
					var condition = new Object();
					condition.shippingaddressid = myselfid;
					//window.location.href = root+"/jsp/mall/person/shippingAddress.jsp";
					//alert(father.parent().find("input[value="+1+"]").val());
					//father.parent().find("input[value="+1+"]").parent().parent().find("span[class=new-option-r]").text("设为默认");
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/updateDefaultAddress",
						data:JSON.stringify(condition),
						success:function(data){
							if(data != ""){
								//修改页面的默认地址
								father.parent().find("input[value="+data.shippingaddressid+"]").parent().parent().find("span[class=new-option-r]").text("设为默认");
								myself.text("默认地址");
							};
						}
						
					});
				});
			}
			
		
		
		
			
		});
		
	});
	
	
	
});
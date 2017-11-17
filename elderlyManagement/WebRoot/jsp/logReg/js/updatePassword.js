$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var phone = val.split("=")[1];
	
	var parten = /[^a-zA-Z0-9]/;
	//第一次输入密码
	$("#user-new-password").bind("input propertychange",function(){
		$("#submit").unbind();
		if((parten.test($(this).val()))){
			
			$("#newPasswordError").text("密码只能为5-16位的字母和数字,不能含有特殊字符");
		}else{
			$("#newPasswordError").text("");
		}
		
		
		
	});
	
	//第二次输入密码
	$("#user-again-password").bind("input propertychange",function(){
		if($(this).val() != $("#user-new-password").val()){
			$("#againPasswordError").text("你两次输入的密码不同");
			$("#submit").unbind();
		}else{
			//加载事件
			$("#againPasswordError").text("");
			if(!parten.test($(this).val())){
				
				update();
			}
		}
		
		
	});
	
	//提交方法
	function update(){
		$("#submit").click(function(){
			var newPassword = $("#user-new-password").val();
			//var againPassword = $("#user-again-password").val();
			var info = new Object();
			info.newPassword = newPassword;
			info.phone = phone;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/send/retrieveThePassword",
				data:JSON.stringify(info),
				error:function(){
					alert("网络连接错误");
				},
				success:function(data){
					if(data.flag){
						alert("密码更改成功");
						
					}else{
						alert("密码更改失败");
					}
					
				}
			});
		});
	}
	
});
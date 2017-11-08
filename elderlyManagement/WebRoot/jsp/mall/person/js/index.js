$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	
	//显示当前用户如果没有就跳转到登录界面
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/getLoginUser",
		success:function(data){
			if(data != null){
				$(".s-name").text(""+data.username+"");
				$("#userAvatar img").attr("src","/upload/"+data.avatar);
			}
			else{
				alert("请登录");
				window.location.href = root+"/jsp/logReg/login.jsp";
			}
		}
	});
	
	//订单数量显示
	
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/",
			
			success:function(data){
				$("#orderMenu li")
				
			}
			
		});
		
	
	
	
	
});

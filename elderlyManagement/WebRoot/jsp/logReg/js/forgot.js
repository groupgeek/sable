$(document).ready(function(){
	var root = $("#root").attr("value");
	var vcode = "";
	var phone = "";
	
	$("#phone").bind("input propertychange",function(){
		$("#vcode").attr("disabled",null);
		$("#vcode").attr("value","发送验证码");
		if(!(/^1(3|4|5|7|8)\d{9}$/.test($(this).val()))){
			$("#vcode").unbind();
			$("#phoneError").text("手机号格式错误");
	       
	    }else{
	    	$("#phoneError").text("");
	    	//发送验证码
	    	$("#vcode").click(function(){
	    		$("#vcode").attr("value","发送中...");
	    		phone = $("#phone").val();
				$.ajax({
					
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/send/sendVCode",
					data:JSON.stringify(phone),
					success:function(data){
						if(data.flag){
							$("#vcode").attr("value","已发送");
							vcode = data.message;
							$("#vcode").attr("disabled","disabled");
							//加载方法
							send();
						}
					}
				});
				
	    	});
	    }
	});
	
	
	//提交
	function send(){
		$(".btn-primary").click(function(){
    		//验证输入框
    		var inputVcode = $("#vcodeval").val();
    		if(inputVcode == vcode){
    			//更新短信验证码状态
    			$.ajax({
    				
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/send/updateVcodeStasus",
					data:JSON.stringify(phone),
					success:function(data){
						if(data.flag){
							window.location.href = root+"/jsp/logReg/updatePassword.jsp?phone="+phone;
						}else{
							alert("网络出现错误,请检查网络");
							$("#vcode").attr("value","发送验证码");
						}
					}
    				
    			});
    			
    		}else{
    			$("#message").text("验证码错误");
    			$("#vcode").attr("value","发送验证码");
    		}
    		
    	});
	}
	
	
});
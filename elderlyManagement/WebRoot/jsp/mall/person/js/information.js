$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	
	//显示当前用户如果没有就跳转到登录界面
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/getLoginUser",
		success:function(data){
			if(data != null){
				$(".update-phone-label").hide();
				$("#userid").attr("value",data.userid);
				$(".info-m b i").text(""+data.username+"");
				$(".filePic img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.avatar);
				$(".u-level a").text(data.level.level);
				$("#user-name").attr("value",data.username);
				if(data.sex == "男"){
					$(".sex input[value=男]").attr("checked","checked");
				}else if(data.sex == "女"){
					$(".sex input[value=女]").attr("checked","checked");
				}else{
					$(".sex input[value=无]").attr("checked","checked");
				}
				$("#user-birth").attr("value",data.birthdayString.split(" ")[0]);
				$("#user-phone").attr("value",data.phone);
				$("#user-email").attr("value",data.email);
			}
			else{
				alert("请登录");
				window.location.href = root+"/jsp/logReg/login.jsp";
			}
		}
	});
	/*alert($("#showMessageInput").val())*/
	var val = window.location.href.split("?")[1];
	if(val != undefined){
		//显示弹框
		var showMessageInput = decodeURI(val.split("=")[1]);
		
		//更改信息框颜色
		$("#messageNotification").attr("style","background-color: red;");
		
		$("#showMessage").text(showMessageInput);
		$('#messageNotification').fadeIn(2000);
		getSrceenWH();
		$('#messageNotification').fadeOut(3000);
	}
	
	
	//点击事件 可修改电话号码
	$("#updatePhone").click(function(){
		$("#user-phone").attr("readonly",null);
		$(this).hide();
		$(".update-phone-label").show();
	});
	

	
	
	//保存修改的信息
	$("#save").click(function(){
		
		$('#loading').show();
		$('body').addClass("hiddenBody");
		$("#formSubmit").submit();
		
		
		
		/*var userid = $("#userid").attr("value");
		var username = $("#user-name").val();
		var birthday = $("#user-birth").val();
		var sex = $(".sex input[name=sex]:checked").attr("value");
		var phone = $("#user-phone").attr("value");
		var email = $("#user-email").attr("value");
		var userInfo = new Object();
		userInfo.userid = userid;
		userInfo.username = username;
		userInfo.birthday = birthday;
		userInfo.sex = sex;
		userInfo.phone = phone;
		userInfo.email = email;
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/updateUserInfo",
			data:JSON.stringify(userInfo),
			error:function(data){
				alert("更新失败");
			},
			success:function(data){
				//alert("更新成功");
				if(data.flag){
					$(".update-phone-label").hide();
					$("#updatePhone").show();
					
					$(".info-m b i").text(""+username+"");
					//$(".filePic img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.avatar);
					//$(".u-level a").text(data.level.level);
					$("#user-name").attr("value",username);
					if(sex == "男"){
						$(".sex input[value=男]").attr("checked","checked");
					}else if(sex == "女"){
						$(".sex input[value=女]").attr("checked","checked");
					}else{
						$(".sex input[value=无]").attr("checked","checked");
					}
					$("#user-birth").attr("value",birthday);
					$("#user-phone").attr("value",phone);
					$("#user-email").attr("value",email);
				}
				
			}
		});*/
	});
	
	
/*	//文件上传
	$('#ss-uploader').ssi_uploader({
		 url: 'path/to/upload.php',
		 responseValidation:{
		    validationKey: 'type',
		    resultKey: 'data',
		    success: 'success',
		    error: 'error'
		  },
		onUpload:function(){
		   console.log('文件上传完毕！');
		}
	
	});*/
	
	
});

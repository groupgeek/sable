$(document).ready(function(){
	var root = $("#root").attr("value");
	var allAuthority = $("#authoritylevel select");
	var allArea = $("#areaname select");
	var allLevel = $("#level select");
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addUserView",
		success:function(data){
			for(var i in data.allAuthority){
				allAuthority.append(
					'<option value ='+(data.allAuthority)[i].authorityid+' >'+(data.allAuthority)[i].authoritylevel+'</option>'
				);
			}
			for(var i in data.allArea){
				allArea.append(
					'<option value ='+(data.allArea)[i].areaid+' >'+(data.allArea)[i].areaname+'</option>'
				);
			}
			for(var i in data.allLevel){
				allLevel.append(
					'<option value ='+(data.allLevel)[i].levelid+' >'+(data.allLevel)[i].level+'</option>'
				);
			}
		}
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
	
	//js验证
	var flagName = false;
	//var flagEmail = false;
	var flagPhone = false;
	var flagPassword = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){2,20}$/;
	var emailRe = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	var phoneRe = /^1(3|4|5|7|8)\d{9}$/;
	//名字验证
	$("#username input").bind("input propertychange",function(){

		if(nameRe.test($(this).val())){
			$("#user-name-error").hide();
			flagName = true;
			addUser();
			
		}else{
			flagName = false;
			$("#user-name-error").show();
			$("#addUser").unbind();
			$("#addUser").hide();
		}
		
	});
	//邮箱验证
	$("#email input").change(function(){
		
		if(emailRe.test($(this).val())){
			//flagEmail = true;
			$("#user-email-error").hide();
			addUser();
			//save();
			
		}else{
			//flagEmail = false;
			$("#email input").val("");
			$("#user-email-error").show();
			//$("#addUser").unbind();
			//$("#addUser").hide();
		}
		
	});
	
	//手机号验证
	$("#phone input").bind("input propertychange",function(){
		
		if(phoneRe.test($(this).val())){
			flagPhone = true;
			$("#user-phone-error").hide();
			addUser();
			//save();
			
		}else{
			flagPhone = false;
			$("#user-phone-error").show();
			$("#addUser").unbind();
			$("#addUser").hide();
		}
		
	});
	//密码
	$("#password input").bind("input propertychange",function(){
		if($(this).val().length >= 6 && $(this).val().length <= 15){
			
			$("#user-password-error").hide();
			addUser();
			//save();
			
		}else{
			
			$("#user-password-error").show();
			$("#addUser").unbind();
			$("#addUser").hide();
		}
		
	});
	//第二次密码
	$("#re-password input").bind("input propertychange",function(){
		if($(this).val() == $("#password input").val()){
			flagPassword = true;
			addUser();
			//save();
			
		}else{
			flagPassword = false;
			$("#addUser").unbind();
			$("#addUser").hide();
		}
		
	});
	
	
	
	function addUser(){
		if(flagName && flagPhone && flagPassword){
			$("#addUser").show();
				
			$("#addUser").click(function(){
				$('#loading').show();
				$('body').addClass("hiddenBody");
			});
		}
	}
});
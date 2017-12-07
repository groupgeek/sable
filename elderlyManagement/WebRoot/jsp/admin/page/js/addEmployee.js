$(document).ready(function(){
	var root = $("#root").attr("value");
	
	
	var allAuthority = $("#authoritylevel select");
	var allArea = $("#areaname select");
	var allPositional = $("#positional select");
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addEmployeeView",
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
			for(var i in data.allPosittonal){
				allPositional.append(
					'<option value ='+(data.allPosittonal)[i].positionid+' >'+(data.allPosittonal)[i].positionname+'</option>'
				);
			}
		}
	});
	
	
	//js验证
	var flagName = false;
	//var flagEmail = false;
	var flagPhone = false;
	var flagPassword = false;
	var bankcardno = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){2,20}$/;
	var emailRe = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	var phoneRe = /^1(3|4|5|7|8)\d{9}$/;
	//名字验证
	
	$("#employeeame input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#employee-name-error").hide();
			flagName = true;
			addEmployee();
			
		}else{
			flagName = false;
			$("#employee-name-error").show();
			$("#addEmployee").unbind();
			$("#addEmployee").hide();
		}
		
	});
	//邮箱验证
	$("#email input").change(function(){
		
		if(emailRe.test($(this).val())){
			//flagEmail = true;
			$("#employee-email-error").hide();
			addEmployee();
			//save();
			
		}else{
			//flagEmail = false;
			$("#email input").val("");
			$("#employee-email-error").show();
			//$("#addUser").unbind();
			//$("#addUser").hide();
		}
		
	});
	
	//手机号验证
	$("#phone input").bind("input propertychange",function(){
		
		if(phoneRe.test($(this).val())){
			flagPhone = true;
			$("#employee-phone-error").hide();
			addEmployee();
			//save();
			
		}else{
			flagPhone = false;
			$("#employee-phone-error").show();
			$("#addEmployee").unbind();
			$("#addEmployee").hide();
		}
		
	});
	//密码
	$("#password input").bind("input propertychange",function(){
		if($(this).val().length >= 6 && $(this).val().length <= 15){
			
			$("#employee-password-error").hide();
			if($(this).val() == $("#re-password input").val()){
				flagPassword = true;
			}else{
				flagPassword = false;
				$("#addEmployee").hide();
			}
			addEmployee();
			//save();
			
		}else{
			
			$("#employee-password-error").show();
			$("#addEmployee").unbind();
			$("#addEmployee").hide();
		}
		
	});
	//第二次密码
	$("#re-password input").bind("input propertychange",function(){
		if($(this).val() == $("#password input").val()){
			flagPassword = true;
			addEmployee();
			//save();
			
		}else{
			flagPassword = false;
			$("#addEmployee").unbind();
			$("#addEmployee").hide();
		}
		
	});
	
	//银行卡号
	$("#bankcardno input").bind("input propertychange",function(){
		if($(this).val().length == 19){
			bankcardno = true;
			$("#employee-bankcardno-error").hide();
			addEmployee();
			//save();
			
		}else{
			bankcardno = false;
			$("#employee-bankcardno-error").show();
			$("#addEmployee").unbind();
			$("#addEmployee").hide();
		}
		
	});
	
	
	
	function addEmployee(){
		if(flagName && flagPhone && flagPassword && bankcardno){
			$("#addEmployee").show();
				
			$("#addEmployee").click(function(){
				$('#loading').show();
				$('body').addClass("hiddenBody");
			});
		}
	}
	
	
	//var message = $("#message").attr("value");
	var val = window.location.href.split("?")[1];
	var message = val.split("=")[1];
	if(message != ""){

		$("#showMessage").text(message);
		$('#messageNotification').fadeIn(2000);
		getSrceenWH();
		$('#messageNotification').fadeOut(3000);
	}
});
 $(document).ready(function(){
	var root =  $("#root").attr("value");
	
	//js验证
	var flagName = true;
	//var flagEmail = false;
	var flagPhone = true;
	
	var flagPassword = true;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){2,20}$/;
	var emailRe = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z0-9]+$/;
	var phoneRe = /^1(3|4|5|7|8)\d{9}$/;
	
	
	//名字验证
	$("#username input").bind("input propertychange",function(){

		if(nameRe.test($(this).val())){
			$("#user-name-error").hide();
			flagName = true;
			updateUser();
			
		}else{
			flagName = false;
			$("#user-name-error").show();
			$("#updateUser").unbind();
			$("#updateUser").hide();
		}
		
	});
	//邮箱验证
	$("#email input").change(function(){
		
		if(emailRe.test($(this).val())){
			//flagEmail = true;
			$("#user-email-error").hide();
			updateUser();
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
			updateUser();
			//save();
			
		}else{
			flagPhone = false;
			$("#user-phone-error").show();
			$("#updateUser").unbind();
			$("#updateUser").hide();
		}
		
	});
	
	//密码
	$("#password input").bind("input propertychange",function(){
		if($(this).val().length >= 6 && $(this).val().length <= 15){
			flagPassword = true;
			$("#user-password-error").hide();
			updateUser();
			//save();
			
		}else{
			flagPassword = false;
			$("#user-password-error").show();
			$("#updateUser").unbind();
			$("#updateUser").hide();
		}
		
	});
	

	function updateUser(){
		if(flagName && flagPhone && flagPassword){
			$("#updateUser").show();
				
			$("#updateUser").click(function(){
				$('#loading').show();
				$('body').addClass("hiddenBody");
			})
		}
	}
	
	
	
	
	
	
	
	/*var val = window.location.href.split("?")[1];
	var userid = val.split("=")[1];
	//$("#username").val(data.username);
	var userInfoData = null;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryuserInfo",
		data:'{"userid"'+':'+'"'+userid+'"'
    			+'}',
		success:function(data){
			alert(data);
			userInfoData = data;
			$("#username input").attr("value",data.username);
			
			if(data.sex == "男"){
				$("#sex_1").attr("selected","selected");
			}else if(data.sex == "女"){
				$("#sex_0").attr("selected","selected");
			}else{
				$("#sex_2").attr("selected","selected");
			}
			
			
			$("#phone input").attr("value",data.phone);
			$("#password input").attr("value",data.password);
			$("#address input").attr("value",data.address);
			$("#registrationdate input").attr("value",data.registrationdate);
			
			if(data.status){
				$("#statusNormal").attr("selected","selected");
			}else{
				$("#statusAbnormal").attr("selected","selected");
			}
			
			$("#integral input").attr("value",data.integral);
			$("#email input").attr("value",data.email);
			$("#birthday input").attr("value",data.birthday);
			$("#accountnumber input").attr("value",data.accountnumber);
			$("#healthstatus input").attr("value",data.healthstatus);
			
			$("#authoritylevel select").options[data.authoritylevel].attr("selected","selected");
			//$("#authoritylevel span").attr("value",data.authoritylevel);
			$("#level input").attr("value",data.level.level);
			
			$("#areaname span").attr("value",data.area.areaname);//
			$("#branchname span").attr("value",data.branch.branchname);//
			$("#manager span").attr("value",data.manager.employeename);//
			$("#areaaddress span").attr("value",data.area.areaaddress);//
			//$("#online span").attr("value",data.online);
			$("#nowmedicalrecords textarea").attr("value",data.med.nowmedicalrecords);
			$("#beforemedicalrecords textarea").attr("value",data.med.beforemedicalrecords);
			$("#personalrecords textarea").attr("value",data.med.personalrecords);
			$("#familyrecords textarea").attr("value",data.med.familyrecords);
		}
		
	});*/
	
	
	/*$("#updateUser").click(function(){
		alert(userInfoData);
		$.ajax({
			

			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateUserInfo",
			data:'{"userid"'+':'+'"'+userInfoData.userid+'"'+','
					+'"username"'+':'+'"'+userInfoData.username+'"'+','
					+'"sex"'+':'+'"'+userInfoData.sex+'"'+','
					+'"authority[authoritylevel]"'+':'+'"'+userInfoData.authoritylevel+'"'+','
					+'"med[personalrecords]"'+':'+'"'+userInfoData.personalrecords+'"'+','
					+'"med[familyrecords]"'+':'+'"'+userInfoData.familyrecords+'"'
	    			+'}',
	    	success:function(data){
	    		alert("update");
	    	}
		});
		
	});*/
	
	
	
	
	
	
	
	
});
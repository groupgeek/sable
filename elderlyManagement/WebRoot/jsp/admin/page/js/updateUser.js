 $(document).ready(function(){
	var root =  $("#root").attr("value");
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
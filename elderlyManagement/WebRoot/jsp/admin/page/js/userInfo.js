 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var userid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryuserInfo",
		data:'{"userid"'+':'+'"'+userid+'"'
    			+'}',
		success:function(data){
			$("#userUrl").attr("href",root+'/superAdmin/updateUserInfoView?id='+data.userid);
			$("#username span").text(data.username);
			$("#sex span").text(data.sex);
			$("#phone span").text(data.phone);
			$("#password span").text(data.password);
			$("#address span").text(data.address);
			$("#registrationdate span").text(data.registrationdate);
			$("#status span").text(data.status);
			$("#integral span").text(data.integral);
			$("#email span").text(data.email);
			$("#birthday span").text(data.birthday);
			$("#bankcardno span").text(data.bankcardno);
			$("#healthstatus span").text(data.healthstatus);
			$("#level span").text(data.level.level);
			$("#areaname span").text(data.area.areaname);
			$("#branchname span").text(data.branch.branchname);
			$("#manager span").text(data.manager.employeename);
			$("#authoritylevel span").text(data.authority.authoritylevel);
			$("#areaaddress span").text(data.area.areaaddress);
			$("#online span").text(data.online);
			
			$("#nowmedicalrecords textarea").attr("value",data.med.nowmedicalrecords);
			$("#beforemedicalrecords textarea").attr("value",data.med.beforemedicalrecords);
			$("#personalrecords textarea").attr("value",data.med.personalrecords);
			$("#familyrecords textarea").attr("value",data.med.familyrecords);
			
			$("#nowmedicalrecords textarea").attr("readonly","readonly");
			$("#beforemedicalrecords textarea").attr("readonly","readonly");
			$("#personalrecords textarea").attr("readonly","readonly");
			$("#familyrecords textarea").attr("readonly","readonly");
		}
		
	});
	
});
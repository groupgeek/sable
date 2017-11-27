 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var userid = document.getElementById("userid").value;

	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/ceo/oneuser",
		data:'{"userid"'+':'+'"'+userid+'"'
    			+'}',
		success:function(data){
			/*$("#employeeUrl").attr("href",root+'/superAdmin/updateEmployeeInfoView?id='+data.employeeid);*/
			if(data.avatar == null){
				$("#avatar div").html("暂无");
			}else{
				$("#avatar img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.avatar);
			}
			
			/*$("#employeename span").text(data.employeename);
			$("#sex span").text(data.sex);
			$("#phone span").text(data.phone);
			$("#password span").text(data.password);
			$("#address span").text(data.address);
			$("#accountnumber span").text(data.accountnumber);
			$("#entrytime span").text(data.entrytimeString);
			$("#employeestatus span").text(data.employeestatus);
			$("#email span").text(data.email);
			$("#birthday span").text(data.birthdayString);
			$("#bankcardno span").text(data.bankcardno);
			$("#positional span").text(data.positional.positionname);
			$("#totalbonus span").text(data.totalbonus);
			$("#areaname span").text(data.area.areaname);
			$("#branchname span").text(data.branch.branchname);
			$("#wage span").text(data.wage);
			$("#authoritylevel span").text(data.authority.authoritylevel);
			$("#areaaddress span").text(data.area.areaaddress);*/
			
		}
		
	});
	
});
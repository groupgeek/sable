 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var branchid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryBranchInfo",
		data:'{"branchid"'+':'+'"'+branchid+'"'
    			+'}',
		success:function(data){
			$("#branchUrl").attr("href",root+'/superAdmin/updateBranchInfoView?id='+data.branchid);
			$("#branchname span").text(data.branchname);
			$("#employeename span").text(data.employeename);
			$("#areaname span").text(data.areaname);
			$("#areaaddress span").text(data.areaaddress);
			$("#employeenum span").text(data.employeenum);
			$("#usernum span").text(data.usernum);
			
		}
		
	});
	
});
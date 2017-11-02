$(document).ready(function(){
	
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var branchid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateBranchView",
		data:'{"branchid"'+':'+'"'+branchid+'"'
    			+'}',
		success:function(data){
			$("#branchid").attr("value",data.branch.branchid);
			$("#branchname input").attr("value",data.branch.branchname);
			$("#oldemployeeid").attr("value",data.branch.employeeid);
			$("#areaid").attr("value",data.branch.areaid);
			for(var i in data.employeeList){
				if(data.branch.employeeid == data.employeeList[i].employeeid){
					$("#employeename select").append('<option value="'+data.employeeList[i].employeeid+'"selected="selected">'+data.employeeList[i].employeename+'</option>');
				}else{
					$("#employeename select").append('<option value="'+data.employeeList[i].employeeid+'">'+data.employeeList[i].employeename+'</option>');
				}
			}
		}
	});
	
	$("#updateBranch").click(function(){
		var branchid = $("#branchid").attr("value");
		var oldemployeeid = $("#oldemployeeid").attr("value");
		var areaid = $("#areaid").attr("value");
		var branchname = $("#branchname input").attr("value");
		var employeeid = $("#employeename select").attr("value");
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateBranch",
			data:'{"branchid"'+':'+'"'+branchid+'"'+','
					+'"areaid"'+':'+'"'+areaid+'"'+','
					+'"branchname"'+':'+'"'+branchname+'"'+','
					+'"oldemployeeid"'+':'+'"'+oldemployeeid+'"'+','
					+'"employeeid"'+':'+'"'+employeeid+'"'
	    			+'}',
			success:function(data){
				alert("ok");
				alert(data.message);
			}
		});
		
	});
	
});
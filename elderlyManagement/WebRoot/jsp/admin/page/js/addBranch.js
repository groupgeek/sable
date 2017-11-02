$(document).ready(function(){
	var root = $("#root").attr("value");
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addBranchView",
		success:function(data){
			
			for(var key in data.allArea){
				$("#areaname select").append('<option value ='+data.allArea[key].areaid+' >'+data.allArea[key].areaname+'</option>');
			}
			for(var key in data.employeeList){
				$("#employeename select").append('<option value ='+data.employeeList[key].employeeid+' >'+data.employeeList[key].employeename+'</option>');
			}
		}
	});
	
	$("#addBranch").click(function(){
		var areaid =$("#areaname select").attr("value");
		var employeeid =$("#employeename select").attr("value");
		var branchname =$("#branchname input").attr("value");
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/addBranch",
			data:'{"areaid"'+':'+'"'+areaid+'"'+','
				+'"employeeid"'+':'+'"'+employeeid+'"'+','
				+'"branchname"'+':'+'"'+branchname+'"'
		    			+'}',
			success:function(data){
				alert(data.message);
				
			}
		});
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
});
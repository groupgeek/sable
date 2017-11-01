$(document).ready(function(){
	
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var branchid = val.split("=")[1];
	
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/",
		data:'{"branchid"'+':'+'"'+branchid+'"'
    			+'}',
		success:function(data){
			$("#branchid input").val(data.branchid);
			$("#branchname input").val(data.branchname);
			$("#employeeid input").val(data.employeeid);
			
			
			
		}
	});
});
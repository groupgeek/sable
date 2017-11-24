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
		$('#loading').show();
		$('body').addClass("hiddenBody");
		
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
				//alert(data.message);
				//显示提示信息
				if(data.message != null && data.message != undefined){
					$("#showMessage").text(data.message);
					$('#messageNotification').fadeIn(2000);
					getSrceenWH();
					$('#messageNotification').fadeOut(3000);
					
					$('#loading').hide();
					$('body').removeClass("hiddenBody");
				}
				
			}
		});
	});
	
});
$(document).ready(function(){
	var root = $("#root").attr("value");
	
	var i = 0;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addActivityView",
		success:function(data){
			
			/*for(var key in data.allTypes){
				//alert(key);
				$("#activitytypename select").append('<optgroup label="'+ key +'"></optgroup>');
				i++;
				//var k = 0;
				alert($("#activitytypename select").eq(i).html());
				
				for(var j in data.allTypes[key]){
					//alert(data.allTypes[key][j].activitytypeid);
					$("#activitytypename select").eq(i).append(
							'<option value ='+data.allTypes[key][j].activitytypeid+' >'+data.allTypes[key][j].activitytypename+'</option>'
						);
				}
				//k++;
			}*/
			
			for(var key in data.allTypes){
				for(var j in data.allTypes[key]){
					$("#activitytypename select").append(
							'<option value ='+data.allTypes[key][j].activitytypeid+' >'+data.allTypes[key][j].activitytypename+'</option>'
						);
				}
			}
			
			for(var i in data.allBranchs){
				$("#branchname select").append(
					'<option value ='+(data.allBranchs)[i].branchid+' >'+(data.allBranchs)[i].branchname+'</option>'
				);
			}
			var dafaultBranchid = $("#branchname select").attr("value");
			//默认负责人
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllEmployeeByBranchId",
				data:JSON.stringify(dafaultBranchid),
				success:function(result){
					$("#principalname select").html("");
					for(var i in result){
						$("#principalname select").append('<option value="'+ result[i].employeeid +'">'+ result[i].employeename +'</option>');
					}
				}
			});
		}
	
	
	});
	
	//查询负责人
	$("#branchname select").change(function(){
		var branchid = $(this).val();
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllEmployeeByBranchId",
			data:JSON.stringify(branchid),
			success:function(result){
				$("#principalname select").html("");
				for(var i in result){
					$("#principalname select").append('<option value="'+ result[i].employeeid +'">'+ result[i].employeename +'</option>');
				}
			}
		});
	})
	
	//直播事件
	$("#activitytypename select").change(function(){
		if($(this).attr("value") == 6){
			$("#online select").attr("disabled","disabled");
			$("#online select").attr("value",true);
			$("#video").hide();
			$("#videoHref").show();
			$("#video input").val("");
			
		}else{
			$("#online select").attr("disabled",null);
			$("#online select").attr("value",false);
			$("#video").show();
			$("#videoHref").hide();
			$("#videoHref input").val("");
		}
	});
	
	//线上事件
	$("#online select").change(function(){
		
		if($(this).attr("value") == "true"){
			$("#video").hide();
			$("#videoHref").show();
			$("#video input").val("");
		}else{
			$("#video").show();
			$("#videoHref").hide();
			$("#videoHref input").val("");
		}
		
	});
	
	
	
	//添加
	$("#addEmployee").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	

});
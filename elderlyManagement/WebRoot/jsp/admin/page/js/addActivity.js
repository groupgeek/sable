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
	//js验证
	var flagName = false;
	var activityprice = false;
	var registeryfee = false;
	var maxnum = false;
	var activitydate = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,100}$/;
	var timeRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,100}$/;
	//名字验证
	$("#activityname input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#activity-name-error").hide();
			flagName = true;
			addActivity();
			
		}else{
			flagName = false;
			$("#activity-name-error").show();
			$("#addActivity").unbind();
			$("#addActivity").hide();
		}
		
	});
	//支出验证
	$("#activityprice input").bind("input propertychange",function(){
		if(!(/[^0-9]/).test($(this).val())){
			$("#activity-activityprice-error").hide();
			activityprice = true;
			addActivity();
			
		}else{
			activityprice = false;
			$("#activity-activityprice-error").show();
			$("#addActivity").unbind();
			$("#addActivity").hide();
		}
		
	});
	//报名验证
	$("#registeryfee input").bind("input propertychange",function(){
		if(!(/[^0-9]/).test($(this).val())){
			$("#activity-registeryfee-error").hide();
			registeryfee = true;
			addActivity();
			
		}else{
			registeryfee = false;
			$("#activity-registeryfee-error").show();
			$("#addActivity").unbind();
			$("#addActivity").hide();
		}
		
	});
	//人数验证
	$("#maxnum input").bind("input propertychange",function(){
		if(!(/[^0-9]/).test($(this).val())){
			$("#activity-maxnum-error").hide();
			maxnum = true;
			addActivity();
			
		}else{
			maxnum = false;
			$("#activity-maxnum-error").show();
			$("#addActivity").unbind();
			$("#addActivity").hide();
		}
		
	});
	
	//时间验证
	$("#activitydate input").bind("input propertychange",function(){
		
		if($(this).val().length > 0){
			$("#activity-activitydate-error").hide();
			activitydate = true;
			addActivity();
			
		}else{
			activitydate = false;
			$("#activity-activitydate-error").show();
			$("#addActivity").unbind();
			$("#addActivity").hide();
		}
		
	});
	
	function addActivity(){
		if(flagName && activityprice && registeryfee && maxnum){
			$("#addActivity").show();
				
			if($("#activitydate input").val().length > 0){
				$("#addActivity").click(function(){
					$('#loading').show();
					$('body').addClass("hiddenBody");
				});
				
			}
			
			
		}
	}
	
	
	
	

});
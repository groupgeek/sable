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
		}
	});
	$("#addActivity").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	

	/*if(data.message != null && data.message != undefined){信息展示
		$("#showMessage").text(data.message);
		$('#messageNotification').fadeIn(2000);
		getSrceenWH();
		$('#messageNotification').fadeOut(3000);
		
	}*/
});
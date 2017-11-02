$(document).ready(function(){
	var root = $("#root").attr("value");
	var allAuthority = $("#authoritylevel select");
	var allArea = $("#areaname select");
	var allLevel = $("#level select");
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addUserView",
		success:function(data){
			for(var i in data.allAuthority){
				allAuthority.append(
					'<option value ='+(data.allAuthority)[i].authorityid+' >'+(data.allAuthority)[i].authoritylevel+'</option>'
				);
			}
			for(var i in data.allArea){
				allArea.append(
					'<option value ='+(data.allArea)[i].areaid+' >'+(data.allArea)[i].areaname+'</option>'
				);
			}
			for(var i in data.allLevel){
				allLevel.append(
					'<option value ='+(data.allLevel)[i].levelid+' >'+(data.allLevel)[i].level+'</option>'
				);
			}
		}
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
});
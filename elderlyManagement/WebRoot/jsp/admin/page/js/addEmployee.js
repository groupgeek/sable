$(document).ready(function(){
	var root = $("#root").attr("value");
	var allAuthority = $("#authoritylevel select");
	var allArea = $("#areaname select");
	var allPositional = $("#positional select");
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addEmployeeView",
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
			for(var i in data.allPosittonal){
				allPositional.append(
					'<option value ='+(data.allPosittonal)[i].positionid+' >'+(data.allPosittonal)[i].positionname+'</option>'
				);
			}
		}
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
});
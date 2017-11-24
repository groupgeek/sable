$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	
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
	//var message = $("#message").attr("value");
	var message = val.split("=")[1];
	if(message != ""){

		$("#showMessage").text(message);
		$('#messageNotification').fadeIn(2000);
		getSrceenWH();
		$('#messageNotification').fadeOut(3000);
	}
	
	$("#addEmployee").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
});
$(document).ready(function(){
	
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var messageid = val.split("=")[1];
	
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryMessageInfo",
		data:'{"messageid"'+':'+'"'+messageid+'"'
    			+'}',
		success:function(data){
			$("#username input").attr("value",data.username);
			$("#messagetime input").attr("value",data.messagetimeString);
			$("#messagecontext textarea").text(data.messagecontext);
			$("#userid").attr("value",data.userid);
			$("#messageid").attr("value",data.messageid);
		}
	});
	
	$("#updateMessage").click(function(){
		var username = $("#username input").attr("value");
		var messagetime = $("#messagetime input").attr("value");
		var messagecontext = $("#messagecontext textarea").attr("value");
		var userid = $("#userid").attr("value");
		var messageid = $("#messageid").attr("value");
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateMessageInfo",
			dataType:'json',
			data:'{"messageid"'+':'+'"'+messageid+'"'+','
				+'"username"'+':'+'"'+username+'"'+','
				+'"messagetimeString"'+':'+'"'+messagetime+'"'+','
				+'"messagecontext"'+':'+'"'+messagecontext+'"'+','
				+'"userid"'+':'+'"'+userid+'"'
	    			+'}',
	    	error:function(){
	    		alert("更新失败");
	    	},
			success:function(data){
				if(data.flag){
					alert(data.message);
				}
			}
		});
		
	});
});
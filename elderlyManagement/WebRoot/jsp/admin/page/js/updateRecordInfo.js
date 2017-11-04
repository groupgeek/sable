$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var transactionid = val.split("=")[1];
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateTransationRecordView",
		data:'{"transactionid"'+':'+'"'+transactionid+'"'
    			+'}',
		success:function(data){
			$("#username input").attr("value",data.username);
			$("#cycle input").attr("value",data.cycle);
			$("#frequency input").attr("value",data.frequency);
			$("#countbuy input").attr("value",data.countbuy);
			
			$("#totalprice input").attr("value",data.totalprice);
			$("#userid").attr("value",data.userid);
			$("#transactionid").attr("value",transactionid);
			
		}
	});
	
	$("#updateRecord").click(function(){
		//var username = $("#username input").attr("value");
		var cycle = $("#cycle input").attr("value");
		var frequency = $("#frequency input").attr("value");
		var countbuy = $("#countbuy input").attr("value");
		
		var totalprice = $("#totalprice input").attr("value");
		var userid = $("#userid").attr("value");
		var transactionid = $("#transactionid").attr("value");
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateTransationRecord",
			data:'{"cycle"'+':'+'"'+cycle+'"'+','
				+'"frequency"'+':'+'"'+frequency+'"'+','
				+'"countbuy"'+':'+'"'+countbuy+'"'+','
				+'"userid"'+':'+'"'+userid+'"'+','
				+'"totalprice"'+':'+'"'+totalprice+'"'+','
				+'"transactionid"'+':'+'"'+transactionid+'"'
        		+'}',
	    	
			success:function(data){
				alert(data.message);
			}
		});
		
	});
	
});
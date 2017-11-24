$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var returnvisitid = val.split("=")[1];
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateReturnRecordView",
		data:'{"returnvisitid"'+':'+'"'+returnvisitid+'"'
    			+'}',
		success:function(data){
			$("#username input").attr("value",data.username);
			$("#address input").attr("value",data.address);
			$("#lastvisttime input").attr("value",data.lastvisttimeString);
			
			$("#countvisit input").attr("value",data.countvisit);
			$("#userid").attr("value",data.userid);
			$("#returnvisitid").attr("value",returnvisitid);
			
		}
	});
	
	$("#updateReturnvisitRecord").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
		//var username = $("#username input").attr("value");
		var address = $("#address input").attr("value");
		var lastvisttime = $("#lastvisttime input").attr("value");
		
		var countvisit = $("#countvisit input").attr("value");
		var userid = $("#userid").attr("value");
		var returnvisitid = $("#returnvisitid").attr("value");

		var info = new Object();
		info.address = address;
		info.lastvisttimeString = lastvisttime;
		info.countvisit = countvisit;
		info.userid = userid;
		info.returnvisitid = returnvisitid;
		
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateReturnRecord",
			/*data:'{"address"'+':'+'"'+address+'"'+','
				+'"lastvisttime"'+':'+'"'+lastvisttime+'"'+','
				+'"returnvisitid"'+':'+'"'+returnvisitid+'"'+','
				+'"userid"'+':'+'"'+userid+'"'+','
				+'"countvisit"'+':'+'"'+countvisit+'"'
        		+'}',
	    	*/
			data:JSON.stringify(info),
			success:function(data){
				//显示提示信息
				$("#showMessage").text(data.message);
				$('#messageNotification').fadeIn(2000);
				getSrceenWH();
				$('#messageNotification').fadeOut(3000);
				
				
				$('#loading').hide();
				$('body').removeClass("hiddenBody");
			}
		});
		
	});
	
});
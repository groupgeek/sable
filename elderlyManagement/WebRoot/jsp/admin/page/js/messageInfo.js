 $(document).ready(function(){
		var root =  $("#root").attr("value");
		var val;
		var messageid = 1;
		var message = $("#message").attr("value");
		if(message != ""){
			//alert(message);
			activityid = $("#messageid").attr("value");
		}else{
			val = window.location.href.split("?")[1];
			messageid = val.split("=")[1];
			
		}
		

	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryMessageInfo",
		data:'{"messageid"'+':'+'"'+messageid+'"'
    			+'}',
		success:function(data){
			$("#messageUrl").attr("href",root+'/jsp/admin/page/updateMessage.jsp?messageid='+data.messageid);
			$("#username span").text(data.username);
			$("#messagetime span").text(data.messagetimeString);
			$("#branchname span").text(data.branchname);
			$("#messagecontext textarea").text(data.messagecontext);
			
		}
		
	});
	
});
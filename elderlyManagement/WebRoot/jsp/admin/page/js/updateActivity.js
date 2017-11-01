$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var activityid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateActivityInfo",
		data:'{"activityid"'+':'+'"'+activityid+'"'
    			+'}',
		success:function(data){
			$("#activityname input").val();
			$("#activitytypename input").val();
			$("#fathertypename input").val();
			$("#activitystatus input").val();
			$("#activitydate input").val();
			$("#branchname input").val();
			$("#activityprice input").val();
			$("#registeryfee input").val();
			$("#maxnum input").val();
			
			//$("#online input").val();
			/*$("#activityname input").val();
			$("#activityname input").val();
			$("#activityname input").val();
			$("#activityname input").val();
			$("#activityname input").val();
			$("#activityname input").val();
			*/
		}
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
});
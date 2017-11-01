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
			$("#activityname input").val(data.activityname);
			
			
			$("#activitytypename select").val(data.activitytypename);
			$("#branchname input").val(data.branchname);
			
			if(data.activitystatus == "已开展"){
				$("#activitystatus1").attr("selected","selected");
			}else{
				$("#activitystatus2").attr("selected","selected");
			}
			if(data.online == true){
				$("#true").attr("selected","selected");
			}else{
				$("#false").attr("selected","selected");
			}
			$("#activitystatus select").val();
			$("#activitydate input").val(data.activitydate);
			
			$("#activityprice input").val(data.activityprice);
			$("#registeryfee input").val(data.registeryfee);
			$("#maxnum input").val(data.maxnum);
			$("#activitydetails input").val(data.activitydetails);//还有视频图片
			
		}
	});
	
	var message = $("#message").attr("value");
	if(message != ""){
		alert(message);
	}
});
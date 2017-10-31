 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var activityid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/",
		data:'{"employeeid"'+':'+'"'+employeeid+'"'
    			+'}',
		success:function(data){
			$("#activityUrl").attr("href",root+'/superAdmin/updateActivityInfoView?id='+data.activityid);
			$("#activityname span").text(data.activityname);
			//$("#activitytypename span").text(data.activitytypename);//类型
			$("#activitystatus span").text(data.activitystatus);
			$("#activitydate span").text(data.activitydate);
			$("#branchname span").text(data.branchname);
			$("#activityprice span").text(data.activityprice);
			$("#registeryfee span").text(data.registeryfee);
			$("#maxnum span").text(data.maxnum);
			$("#online span").text(data.online);
			$("#activitydetails p").text(data.activitydetails);
			
			//还差图片和视频
		}
		
	});
	
});
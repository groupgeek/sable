 $(document).ready(function(){
		var root =  $("#root").attr("value");
		var val;
		var activityid;
		var message = $("#message").attr("value");
		if(message != ""){
			alert(message);
			activityid = $("#activityid").attr("value");
		}else{
			val = window.location.href.split("?")[1];
			activityid = val.split("=")[1];
			
		}
		

	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryActivityInfo",
		data:'{"activityid"'+':'+'"'+activityid+'"'
    			+'}',
		success:function(data){
			$("#activityUrl").attr("href",root+'/jsp/admin/page/updateActivity.jsp?activityid='+data.activityid);
			$("#activityname span").text(data.activityname);
			$("#activitytypename span").text(data.activitytypename);//类型
			$("#fathertypename span").text(data.fathertypename);//父类类型
			$("#activitystatus span").text(data.activitystatus);
			$("#activitydate span").text(data.activitydateString);
			$("#branchname span").text(data.branchname);
			$("#activityprice span").text(data.activityprice);
			$("#registeryfee span").text(data.registeryfee);
			$("#maxnum span").text(data.maxnum);
			
			if(data.online){
				$("#online span").text("是");
			}else{
				$("#online span").text("否");
			}
			$("#activitydetails textarea").attr("value",data.activitydetails);
			$("#activitydetails textarea").attr("readonly","readonly");

			if(data.activitypicture == null){
				$("#activitypicturetemp div").html("空");
			}else{
				$("#activitypicturetemp img").attr("src","/upload/"+data.activitypicture);
			}
			if(data.video == null){
				$("#showVideo div").html("空");
			}else{
				$("#showVideo div").append(
						
						'<video width="320" height="240" controls autoplay>'+
						  '<source id = "showVideoogg" src="/upload/'+ data.video +'"type="video/ogg">'+
						  '<source id = "showVideomp4" src="/upload/'+ data.video +'"type="video/mp4">'+
						  '<source id = "showVideowebm" src="/upload/'+ data.video +'"type="video/webm">'+
						 '<object id = "showVideoobject" data="/upload/'+ data.video +'" width="320" height="240">'+
						    '<embed width="320" height="240" src="/upload/'+ data.video +'">'+
						  '</object>'+
						'</video>'
				
				);
			}
		}
		
	});
	
});
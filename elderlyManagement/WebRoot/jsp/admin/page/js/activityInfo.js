 $(document).ready(function(){
		var root =  $("#root").attr("value");
		var val;
		var activityid;
		var message = $("#message").attr("value");
		if(message != ""){
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
			
			$("#activitytypename span").text(data.activitytypename);
			$("#fathertypename span").text(data.fathertypename);
			$("#activitystatus span").text(data.activitystatus);
			$("#activitydate span").text(data.activitydateString);
			$("#branchname span").text(data.branchname);
			$("#activityprice span").text(data.activityprice);
			$("#registeryfee span").text(data.registeryfee);
			$("#maxnum span").text(data.maxnum);
			if(data.online){
				$("#online span").text("是");
				$("#showVideo").remove();
				$("#showVideoHref a").attr("href",data.video);
				$("#showVideoHref a").text(data.video);
			}else{
				$("#online span").text("否");
				$("#showVideoHref").remove();
				if(data.video == null){
					$("#showVideo div").html("空");
				}else{
					
					 var player = new Aliplayer({
				            id: 'J_prismPlayer',
				            width: '50%',
				            autoplay: false,
				            //支持播放地址播放,此播放优先级最高
				            source : 'http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.video,
				            //播放方式二：推荐
				            //vid : '07e001ab-d0e2-4ba9-be1f-4e1da1353509',
				            playauth : '',
				           /*  useH5Prism : true, */
				            cover: 'http://com-xiaohe-img.oss-cn-beijing.aliyuncs.com/videobg.jpg'
				            },function(player){
				                console.log('播放器创建好了。');
				           });
					/*$("#showVideo div").append(
							
							'<video width="320" height="240" controls autoplay>'+
							  '<source id = "showVideoogg" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.video +'"type="video/ogg">'+
							  '<source id = "showVideomp4" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.video +'"type="video/mp4">'+
							  '<source id = "showVideowebm" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.video +'"type="video/webm">'+
							 '<object id = "showVideoobject" data="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.video +'" width="320" height="240">'+
							    '<embed width="320" height="240" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.video +'">'+
							  '</object>'+
							'</video>'
					
					);*/
				}
			}
			$("#activitydetails textarea").attr("value",data.activitydetails);
			$("#activitydetails textarea").attr("readonly","readonly");

			if(data.activitypicture == null){
				$("#activitypicturetemp div").html("空");
			}else{
				$("#activitypicturetemp img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.activitypicture);
			}
			
			//
		}
		
	});
	
	//查询负责人
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryEmployeeByactivityId",
		data:JSON.stringify(activityid),
		success:function(data){
			$("#principalname span").text(data.employeename);
		}
	});
	
});
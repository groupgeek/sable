$(document).ready(function(){
	
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var activityid = val.split("=")[1];
	
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateActivityInfoView",
		data:'{"activityid"'+':'+'"'+activityid+'"'
    			+'}',
		success:function(data){
			$("#activityname input").val(data.activityInfo.activityname);
			
			if(data.activityInfo.activitytypeid == 6){
				$("#online select").attr("disabled","disabled");
				$("#online select").attr("value",true);
			}
			
			//查询负责人
			var principalid = data.activityInfo.principalid
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllEmployeeByactivityId",
				data:JSON.stringify(activityid),
				success:function(result){
					for(var i in result){
						if(result[i].employeeid == principalid){
							$("#principalname select").append('<option value="'+ result[i].employeeid +'" selected="selected">'+ result[i].employeename +'</option>');
						}else{
							$("#principalname select").append('<option value="'+ result[i].employeeid +'">'+ result[i].employeename +'</option>');
						}
					}
				}
			});
			
			for(var i in data.allActivitytype){
				if((data.allActivitytype)[i].activitytypeid == data.activityInfo.activitytypeid){
					$("#activitytypename select").append('<option value="'+ (data.allActivitytype)[i].activitytypeid +'" selected="selected">'+ (data.allActivitytype)[i].activitytypename +'</option>');
				}else{
					$("#activitytypename select").append('<option value="'+ (data.allActivitytype)[i].activitytypeid +'">'+ (data.allActivitytype)[i].activitytypename +'</option>');
				}
				
			}
			for(var i in data.allBranch){
				if((data.allBranch)[i].branchid == data.activityInfo.branchid){
					$("#branchname select").append('<option value="'+ (data.allBranch)[i].branchid +'" selected="selected">'+ (data.allBranch)[i].branchname +'</option>');
				}else{
					$("#branchname select").append('<option value="'+ (data.allBranch)[i].branchid +'">'+ (data.allBranch)[i].branchname +'</option>');
				}
				
			}
			if(data.activityInfo.activitystatus == "已开展"){
				$("#activitystatus1").attr("selected","selected");
			}else{
				$("#activitystatus2").attr("selected","selected");
			}
			if(data.activityInfo.online == true){
				$("#true").attr("selected","selected");
				$("#showVideo").remove();
				$("#video").hide();
				$("#updateVideoHref input").val(data.activityInfo.video);
				$("#showVideoHref a").attr("href",data.activityInfo.video);
				$("#showVideoHref a").text(data.activityInfo.video);
				
			}else{
				$("#false").attr("selected","selected");
				$("#showVideoHref").remove();
				$("#updateVideoHref").hide();
				
				if(data.activityInfo.video == null){
					$("#showVideo div").html("空");
				}else{
					 var player = new Aliplayer({
				            id: 'J_prismPlayer',
				            width: '50%',
				            height: '50%',
				            autoplay: false,
				            //支持播放地址播放,此播放优先级最高
				            source : 'http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.activityInfo.video,
				            //播放方式二：推荐
				            //vid : '07e001ab-d0e2-4ba9-be1f-4e1da1353509',
				            playauth : '',
				           /*  useH5Prism : true, */
				            cover: 'http://com-xiaohe-img.oss-cn-beijing.aliyuncs.com/videobg.jpg'
				            },function(player){
				                console.log('播放器创建好了。');
				           });
				}
			}
			$("#activitydate input").val(data.activityInfo.activitydateString);
			
			$("#activityprice input").val(data.activityInfo.activityprice);
			$("#registeryfee input").val(data.activityInfo.registeryfee);
			$("#maxnum input").val(data.activityInfo.maxnum);
			$("#activitydetails textarea").attr("value",data.activityInfo.activitydetails);
			
			if(data.activityInfo.activitypicture == null){
				$("#activitypicturetemp div").html("空");
			}else{
				$("#activitypicturetemp img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.activityInfo.activitypicture);
			}
			
			
			
			$("#activityid").attr("value",data.activityInfo.activityid);
			$("#activitypicturehidden").attr("value",data.activityInfo.activitypicture);
			$("#videohidden").attr("value",data.activityInfo.video);
			
		}
	});
	
	
/*	$("#updateActivity").click(function(){
		//var activitypicture = ("#activitypicture input").attr("value");
		var video = $("#video input").attr("value");
		//alert(video);
		$.ajax({
			type:"post",
			//contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/",
			//fileElementId:'video',
			data:'{"activitypicture"'+':'+'"'+activitypicture+'"'+','
					+'"video"'+':'+'"'+video+'"'+','
	    			+'}',
			data:'"video"'+':'+'"'+video+'"',
			beforeSend:function(){
            },
			success:function(data){
				alert(data);
			}
			
		});
		
	});*/
	
	
	//直播事件
	$("#activitytypename select").change(function(){
		if($(this).attr("value") == 6){
			$("#online select").attr("disabled","disabled");
			$("#online select").attr("value",true);
			$("#video").hide();
			$("#showVideoHref").show();
			$("#updateVideoHref").show();
			$("#video input").val("");
			
		}else{
			$("#online select").attr("disabled",null);
			$("#online select").attr("value",false);
			$("#video").show();
			$("#showVideoHref").hide();
			$("#updateVideoHref").hide();
			$("#updateVideoHref input").val("");
		}
	});
	
	//线上事件
	$("#online select").change(function(){
		
		if($(this).attr("value") == "true"){
			$("#video").hide();
			$("#showVideoHref").show();
			$("#updateVideoHref").show();
			$("#video input").val("");
		}else{
			$("#video").show();
			$("#showVideoHref").hide();
			$("#updateVideoHref").hide();
			$("#updateVideoHref input").val("");
		}
		
	});
	
	
	$("#updateActivity").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	
	
	
	
	
	
});
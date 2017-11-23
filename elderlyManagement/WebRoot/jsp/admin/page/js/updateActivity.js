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
			}else{
				$("#false").attr("selected","selected");
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
			
			if(data.activityInfo.video == null){
				$("#showVideo div").html("空");
			}else{
				$("#showVideo div").append(
						
						'<video width="320" height="240" controls autoplay>'+
						  '<source id = "showVideoogg" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.activityInfo.video +'"type="video/ogg">'+
						  '<source id = "showVideomp4" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.activityInfo.video +'"type="video/mp4">'+
						  '<source id = "showVideowebm" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.activityInfo.video +'"type="video/webm">'+
						 '<object id = "showVideoobject" data="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.activityInfo.video +'" width="320" height="240">'+
						    '<embed width="320" height="240" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+ data.activityInfo.video +'">'+
						  '</object>'+
						'</video>'
				
				);
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
	
	
});
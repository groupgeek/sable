 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var activityid = document.getElementById("activityid").value;

	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/ceo/readactivity",
		data:'{"activityid"'+':'+'"'+activityid+'"'
    			+'}',
		success:function(data){
			
			if(data.activitypicture == null){
				$("#activitypicture div").html("暂无");
			}else{
				$("#activitypicture img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.activitypicture);
			}
			if(data.video == null){
				$("#showVideo div").html("暂无");
			}else{

				 var player = new Aliplayer({
			            id: 'J_prismPlayer',
			            width: '100%',
			            autoplay: false,
			            //支持播放地址播放,此播放优先级最高
			            source : 'http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.video,
			            //播放方式二：推荐
			            //vid : '07e001ab-d0e2-4ba9-be1f-4e1da1353509',
			            playauth : '',
			           /*  useH5Prism : true, */
			            cover: 'http://liveroom-img.oss-cn-qingdao.aliyuncs.com/logo.png'
			            },function(player){
			                console.log('播放器创建好了。');
			           });

			}
						
		}
		
	});
	
});
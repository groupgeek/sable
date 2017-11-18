
$(document).ready(function(){
	var root =  $("#root").attr("value");
//显示当前用户
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/getLoginUser",
		success:function(data){
				$("#userid").attr("value",data.userid);
				$(".info-m b i").text(""+data.username+"");
				$(".filePic img").attr("src","/upload/"+data.avatar);
				$(".u-level a").text(data.level.level);
				$("#user-name").attr("value",data.username);
		}
	});
});
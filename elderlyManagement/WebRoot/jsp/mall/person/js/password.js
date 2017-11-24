
$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	
	
	//info.confirmPassword = confirmPassword;
	//var pattern = /^(?=.*[a-zA-Z])(?=.*\d)(?=.*[~!@#$%^&*()_+、\-={}:";'<>?,.\/]).{6,15}/;
	//var pattern = /[\w\d]+/;
	//var re = new RegExp("[\w\d]+");
	//var pattern = /[^a-zA-Z0-9]/;
	//var pattern = /([~!@#$%^&*()_+、\-={}:";'<>?,.\/]).{6,15}/;
	var pattern = /[^a-zA-Z0-9]/;
	$("#user-old-password ,#user-new-password ,#user-confirm-password").bind('input propertychange', function(){
		var oldPassword = $("#user-old-password").val();
		//$("#user-old-password").next().next().text(pattern.test($(this).val())+":::"+oldPassword);
		if(pattern.test($(this).val())){
			$(this).next().show();
			$(this).prev().val(0);
			$(".am-btn-danger").unbind();
		}else{
			if(parseInt($(this).val().length)>5 && parseInt($(this).val().length)<16){
				$(this).next().hide();
				$(this).prev().val(1);
			}else{
				$(this).next().show();
				$(this).prev().val(0);
				$(".am-btn-danger").unbind();
			}
		}
		
		if($("#old-password").val() == 1 && $("#new-password").val() == 1 && $("#confirm-password").val() == 1){
			//加载事件
			update();
		}
		
	});
	
	
	//事件
	function update(){
		$(".am-btn-danger").click(function(){
			var oldPassword = $("#user-old-password").val();
			var newPassword = $("#user-new-password").val();
			var info = new Object();
			info.oldPassword = oldPassword;
			info.newPassword = newPassword;
			
				$.ajax({
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/user/updateUserPassword",
					data:JSON.stringify(info),
					error:function(){
						$("#success").find("p").text("失败");
					},
					success:function(data){
						if(data.flag){
							$("#success").removeClass("step-2");
							$("#success").addClass("step-1");
							
						}else{
							$("#success").find("p").text("失败");
						}
						$("#user-old-password").val("");
						$("#user-new-password").val("");
						$("#user-confirm-password").val("");
						
						$("#old-password").val(0);
						$("#new-password").val(0);
						$("#confirm-password").val(0);
					}
				});
			
		});
	}
	
});
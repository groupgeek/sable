 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var userid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryuserInfo",
		data:'{"userid"'+':'+'"'+userid+'"'
    			+'}',
		success:function(data){
			$("#username span").text(data.username);
			$("#sex span").text(data.sex);
			$("#phone span").text(data.phone);
			$("#password span").text(data.password);
			$("#registrationdate span").text(data.phone);
		}
		
	});
	
});
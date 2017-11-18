$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		//url:root+"/product/",
		data:JSON.stringify(orderid),
		success:function(){
			$("#orderInfo").attr("href",root+"/jsp/mall/person/orderinfo.jsp?ordersid=");
		}
	});
});
$(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var ordersid = val.split("=")[1];
	var orderid = new Array;
	for(var i in ordersid.split(",")){
		orderid[i] = ordersid.split(",")[i];
		//alert(orderid[i]);
	};
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/showOrders",
		data:JSON.stringify(orderid),
		success:function(data){
			if(data != null || data != ""){
				var total = 0;
				for(var k in data){
					total += data[k].totalprice;
				}
				$("#total").text(total);
				$("#name").text(data[0].username);
				$("#phone").text(data[0].phone);
				$("#address").text(data[0].resaddress);
				$("#orderInfo").attr("href",root+"/jsp/mall/person/orderinfo.jsp?orderid="+orderid);
			}
			
			
		}
	});
});
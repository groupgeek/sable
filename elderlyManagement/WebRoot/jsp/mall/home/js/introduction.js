$(document).ready(function(){
	var root = $("#root").attr("value");
	
	
	var productid = $("#productid").attr("value");
	var taste = "";
	var colour = "";
	var size = "";
	
	//获取到口味或者颜色型号的值
	$("#teast li").click(function(){
		taste = $(this).attr("value");
	});
	
	$("#colour li").click(function(){
		colour = $(this).attr("value");
	});
	$("#size li").click(function(){
		size = $(this).text();
	});
	
	//alert($("#colourType").attr("value"));
	//alert($("#teastType").attr("value"));
	$("#pay li").click(function(){
		
		//alert($(this).attr("id"));
		
		//alert($(this).)
		//这里判断是否有库存 
		/*$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"activitystatus"'+':'+'"'+activitystatus+'"'+','
			+'"sort"'+':'+'"'+sort+'"'
	    			+'}',
			success:function(data){
				
			}
		});*/
		
		//跳转页面
		
		//window.location.href = root+"/jsp/mall/home/shopcart.jsp";

		if($("#teastType").attr("value") == 1){
			if(taste == ""){
				alert("请选择口味");
			}else{
				var data = "type="+1+"&productid="+productid+"&number="+$("#text_box").attr("value")+"&taste="+taste;
				if($(this).attr("id") == "shoppingCart"){
					
					$.ajax({
						
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/addShopCart",
						data:'{"type"'+':'+'"'+1+'"'+','
						+'"productid"'+':'+'"'+productid+'"'+','
						+'"number"'+':'+'"'+$("#text_box").attr("value")+'"'+','
						+'"taste"'+':'+'"'+taste+'"'
				    			+'}',
						success:function(data){
							alert(data.message);
						}
					});
					
					
				}
				if($(this).attr("id") == "buy"){
					var info = new Object();
					info.productid = productid;
					info.price = $("#price").text();
					info.productname = $("#productName").text();
					info.taste = taste;
					
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/buyNow",
						data:JSON.stringify(info),
						success:function(data){
							window.open(root+"/jsp/mall/home/pay.jsp?ordersid="+data);
						}
					});
				}
				

			}
		}
		if($("#colourType").attr("value") == 2){
			if(colour == "" || size == ""){
				alert("请选择颜色或者型号");
			}else{
				var data = "type="+2+"&productid="+productid+"&number="+$("#text_box").attr("value")+"&colour="+colour+"&size="+size;
				if($(this).attr("id") == "shoppingCart"){
					$.ajax({
						
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/addShopCart",
						data:'{"type"'+':'+'"'+2+'"'+','
						+'"productid"'+':'+'"'+productid+'"'+','
						+'"number"'+':'+'"'+$("#text_box").attr("value")+'"'+','
						+'"colour"'+':'+'"'+colour+'"'+','
						+'"sziestring"'+':'+'"'+size+'"'
				    			+'}',
					success:function(data){
						alert(data.message);
						$(".cart_num ").text(parseInt($(".cart_num ").text()) + 1);
						}
					});
				}
				if($(this).attr("id") == "buy"){
					var info = new Object();
					info.productid = productid;
					info.price = $("#price").text();
					info.productname = $("#productName").text();
					info.colour = colour;
					info.sizeString = size;
					
					$.ajax({
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/product/buyNow",
						data:JSON.stringify(info),
						success:function(data){
							window.open(root+"/jsp/mall/home/pay.jsp?ordersid="+data);
						}
					});
					
				}
				

			}
		}
		
		
	});
	
	
	
});
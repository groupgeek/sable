 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var productid = val.split("=")[1];
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryProductInfo",
		data:'{"productid"'+':'+'"'+productid+'"'
    			+'}',
		success:function(data){
			$("#productUrl").attr("href",root+'/jsp/admin/page/updateProduct.jsp?productid='+data.productid);
			$("#adminMall").append(
								'<span class="break"></span><a href="'+root+'/jsp/admin/page/employeeInfo.jsp?employeeid='+ data.employeeid +'" style="color: white; text-decoration: none;">商城管理员'+data.employeename+'</a>'
						);
			
			if(data.avatar == null){
				$("#picture div").html("空");
			}else{
				$("#picture img").attr("src","/upload/"+data.picture);
			}
			
			$("#productname span").text(data.productname);
			$("#producttypename span").text(data.producttypename);
			$("#fathertypename span").text(data.fathertype);
			$("#shelves span").text(data.shelves);
			
			
			$("#buyNo span").text(data.buyno);
			$("#price span").text(data.price);
			$("#purchaseprice span").text(data.purchaseprice);
			
			
			$("#branchname span").text(data.branchname);
			$("#instock span").text(data.instock);
			
			
			$("#discount span").text(data.discount);
			$("#origin span").text(data.origin);
			$("#productspecifications span").text(data.productspecifications);
			$("#producstandards span").text(data.producstandards);
			$("#productionlicensenumber span").text(data.productionlicensenumber);
			
			var teaste = "";
			if(data.tasteList != null || data.tasteList != ""){
				for(var i in data.tasteList){
					
					teaste += data.tasteList[i].producttaste + ",";
				}
				teaste = teaste.substring(0, teaste.length-1);
			}
			
			$("#producttaste span").text(teaste);
			$("#storagemethod span").text(data.storagemethod);
			$("#ediblemethod span").text(data.ediblemethod);
			$("#shelflife span").text(data.shelflife);
			
			var colour = "";
			if(data.tasteList != null || data.tasteList != ""){
				for(var i in data.colourList){
					colour += data.colourList[i].productcolour + ",";
				}
				colour = colour.substring(0, colour.length-1);
			}
			$("#productcolour span").text(colour);
			
			$("#description textarea").attr("value",data.description);
		}
		
	});
	
});
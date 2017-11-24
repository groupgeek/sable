 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var productid = val.split("=")[1];
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateProductView",
		data:'{"productid"'+':'+'"'+productid+'"'
    			+'}',
		success:function(data){
			$("#productid").attr("value",data.productInfo.productid);
			
			$("#productUrl").attr("href",root+'/jsp/admin/page/updateProduct.jsp?productid='+data.productInfo.productid);
			$("#adminMall").append(
								'<span class="break"></span><a href="'+root+'/jsp/admin/page/employeeInfo.jsp?employeeid='+ data.productInfo.employeeid +'" style="color: white; text-decoration: none;">商城管理员'+data.productInfo.employeename+'</a>'
						);
			
			if(data.productInfo.picture == null){
				$("#picture div").html("空");
			}else{
				$("#picture img").attr("src","http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/"+data.productInfo.picture);
			}
			
			$("#productname input").attr("value",data.productInfo.productname);
			
			for(var i in data.fatherTypeList){
				if(data.productInfo.fathertypeid == data.fatherTypeList[i].producttypeid){
					if(data.productInfo.fathertypeid == 1){
						$("#producttaste input").attr("readonly","readonly");
						$("#storagemethod input").attr("readonly","readonly");
						$("#ediblemethod input").attr("readonly","readonly");
						$("#shelflife input").attr("readonly","readonly");
						$("#productcolour input").attr("readonly",null);
						
						$("#producttaste input").attr("value","");
						$("#storagemethod input").attr("value","");
						$("#ediblemethod input").attr("value","");
						$("#shelflife input").attr("value","");
					}else if(data.productInfo.fathertypeid == 2){
						$("#productcolour input").attr("readonly","readonly");
						$("#producttaste input").attr("readonly",null);
						$("#storagemethod input").attr("readonly",null);
						$("#ediblemethod input").attr("readonly",null);
						$("#shelflife input").attr("readonly",null);
					
						$("#productcolour input").attr("value","");
					}else{
						$("#producttaste input").attr("readonly","readonly");
						$("#storagemethod input").attr("readonly","readonly");
						$("#ediblemethod input").attr("readonly","readonly");
						$("#shelflife input").attr("readonly","readonly");
						$("#productcolour input").attr("readonly","readonly");
						
						$("#producttaste input").attr("value","");
						$("#storagemethod input").attr("value","");
						$("#ediblemethod input").attr("value","");
						$("#shelflife input").attr("value","");
						$("#productcolour input").attr("value","");
					}
					$("#fathertypename select").append('<option value="'+data.fatherTypeList[i].producttypeid+'" selected="selected">'+data.fatherTypeList[i].producttypename+'</option>');
				}else{
					//readonly="readonly"
					$("#fathertypename select").append('<option value="'+data.fatherTypeList[i].producttypeid+'">'+data.fatherTypeList[i].producttypename+'</option>');
				}
			}
			
			$("#producttypename select").append('<option value="'+data.productInfo.producttypeid+'">'+data.productInfo.producttypename+'</option>');
			
			if(data.productInfo.shelves){
				$("#shelves select").append('<option value="'+data.productInfo.shelves+'" selected="selected">是</option>');
				$("#shelves select").append('<option value="'+false+'">否</option>');
			}else{
				$("#shelves select").append('<option value="'+data.productInfo.shelves+'">是</option>');
				$("#shelves select").append('<option value="'+false+'"selected="selected">否</option>');
				
			}
			$("#shelves select").attr("value",data.productInfo.shelves);
			
			
			$("#buyNo input").attr("value",data.productInfo.buyno);
			$("#price input").attr("value",data.productInfo.price);
			$("#purchaseprice input").attr("value",data.productInfo.purchaseprice);
			
			
			$("#branchname input").attr("value",data.productInfo.branchname);
			$("#instock input").attr("value",data.productInfo.instock);
			
			
			//$("#discount input").attr("value",data.productInfo.discount);
			
			
			$("#origin input").attr("value",data.productInfo.origin);
			$("#productspecifications input").attr("value",data.productInfo.productspecifications);
			$("#producstandards input").attr("value",data.productInfo.producstandards);
			$("#productionlicensenumber input").attr("value",data.productInfo.productionlicensenumber);
			
			var teaste = "";
			if(data.productInfo.tasteList != null || data.productInfo.tasteList != ""){
				for(var i in data.productInfo.tasteList){
					
					teaste += data.productInfo.tasteList[i].producttaste + " ";
				}
				teaste = teaste.substring(0, teaste.length-1);
			}
			
			$("#producttaste input").attr("value",teaste);
			$("#storagemethod input").attr("value",data.productInfo.storagemethod);
			$("#ediblemethod input").attr("value",data.productInfo.ediblemethod);
			$("#shelflife input").attr("value",data.productInfo.shelflife);
			var colour = "";
			if(data.productInfo.tasteList != null || data.productInfo.tasteList != ""){
				for(var i in data.productInfo.colourList){
					colour += data.productInfo.colourList[i].productcolour + " ";
				}
				colour = colour.substring(0, colour.length-1);
			}
			$("#productcolour input").attr("value",colour);
			
			$("#description textarea").attr("value",data.productInfo.description);
			
		}
		
	});
	
	$("#fathertypename select").change(function(){
		var fathertypeid = $(this).val();
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/updateProductType",
			data:'{"producttypeid"'+':'+'"'+fathertypeid+'"'
	    			+'}',
			success:function(data){
				$("#producttypename select").html("");
				for(var i in data){
					
					$("#producttypename select").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
				}
			}
			
		});
		
		if($(this).val() == 1){
			$("#producttaste input").attr("readonly","readonly");
			$("#storagemethod input").attr("readonly","readonly");
			$("#ediblemethod input").attr("readonly","readonly");
			$("#shelflife input").attr("readonly","readonly");
			$("#productcolour input").attr("readonly",null);
			
			$("#producttaste input").attr("value","");
			$("#storagemethod input").attr("value","");
			$("#ediblemethod input").attr("value","");
			$("#shelflife input").attr("value","");
		}else if($(this).val() == 2){
			$("#productcolour input").attr("readonly","readonly");
			$("#producttaste input").attr("readonly",null);
			$("#storagemethod input").attr("readonly",null);
			$("#ediblemethod input").attr("readonly",null);
			$("#shelflife input").attr("readonly",null);
			
			$("#productcolour input").attr("value","");
		}else{
			$("#producttaste input").attr("readonly","readonly");
			$("#storagemethod input").attr("readonly","readonly");
			$("#ediblemethod input").attr("readonly","readonly");
			$("#shelflife input").attr("readonly","readonly");
			$("#productcolour input").attr("readonly","readonly");
			
			$("#producttaste input").attr("value","");
			$("#storagemethod input").attr("value","");
			$("#ediblemethod input").attr("value","");
			$("#shelflife input").attr("value","");
			$("#productcolour input").attr("value","");
		}
	});
	
	$("#updateProduct").click(function(){
		
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	
});
 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var k = 0;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addProductView",
		success:function(data){
			
			for(var i in data){
				if(k = 0){
					if(data[i].producttypeid == 1){
						$("#producttaste input").attr("readonly","readonly");
						$("#storagemethod input").attr("readonly","readonly");
						$("#ediblemethod input").attr("readonly","readonly");
						$("#shelflife input").attr("readonly","readonly");
						$("#productcolour input").attr("readonly",null);
						
						$("#producttaste input").attr("value","");
						$("#storagemethod input").attr("value","");
						$("#ediblemethod input").attr("value","");
						$("#shelflife input").attr("value","");
					}else if(data[i].producttypeid == 2){
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
				}
					k++;
					$("#fathertypename select").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
			}
			
		}
		
	});
/*	alert($("#fathertypename select").attr("value"));
	alert($("#fathertypename select").eq(1).val());
*/	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/updateProductType",
		data:'{"producttypeid"'+':'+'"'+1+'"'
    			+'}',
		success:function(data){
			$("#producttypename select").html("");
			for(var i in data){
				
				$("#producttypename select").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
			}
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
			$("#producttaste").attr("style","display:none;");
			$("#storagemethod ").attr("style","display:none;");
			$("#ediblemethod ").attr("style","display:none;");
			$("#shelflife").attr("style","display:none;");
			$("#productcolour").attr("style",null);
			
			$("#producttaste").attr("value","");
			$("#storagemethod ").attr("value","");
			$("#ediblemethod").attr("value","");
			$("#shelflife ").attr("value","");
		}else if($(this).val() == 2){
			$("#productcolour").attr("style","display:none;");
			$("#producttaste").attr("style",null);
			$("#storagemethod ").attr("style",null);
			$("#ediblemethod").attr("style",null);
			$("#shelflife").attr("style",null);
			
			$("#productcolour ").attr("value","");
		}else{
			$("#producttaste ").attr("style","display:none;");
			$("#storagemethod").attr("style","display:none;");
			$("#ediblemethod").attr("style","display:none;");
			$("#shelflife ").attr("style","display:none;");
			$("#productcolour").attr("style","display:none;");
			
			$("#producttaste").attr("value","");
			$("#storagemethod ").attr("value","");
			$("#ediblemethod ").attr("value","");
			$("#shelflife").attr("value","");
			$("#productcolour").attr("value","");
		}
	});
	
});

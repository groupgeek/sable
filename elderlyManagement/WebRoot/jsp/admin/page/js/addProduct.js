 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var branchid = val.split("=")[1];
	$("#branchid").val(branchid);
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
	
	$("#addProduct").click(function(){
		/*//显示提示信息
		$("#showMessage").text(data.message);
		$('#messageNotification').fadeIn(2000);
		getSrceenWH();
		$('#messageNotification').fadeOut(3000);*/
		
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	
	
});
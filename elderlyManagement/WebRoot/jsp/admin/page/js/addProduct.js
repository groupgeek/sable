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
				
				if(k == 0){
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
	
	//js验证
	var flagName = false;
	var buyNo = false;
	var price = false;
	var purchaseprice = false;
	var instock = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,100}$/;
	var digitalRe = /[^0-9.]/;
	//名字验证
	$("#productname input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#product-name-error").hide();
			flagName = true;
			addProduct();
			
		}else{
			flagName = false;
			$("#product-name-error").show();
			$("#addProduct").unbind();
			$("#addProduct").hide();
		}
		
	});
	//进价验证
	$("#purchaseprice input").bind("input propertychange",function(){
		if(!digitalRe.test($(this).val())){
			$("#product-purchaseprice-error").hide();
			activityprice = true;
			addProduct();
			
		}else{
			activityprice = false;
			$("#product-purchaseprice-error").show();
			$("#addProduct").unbind();
			$("#addProduct").hide();
		}
		
	});
	//购买次数验证
	$("#buyNo input").bind("input propertychange",function(){
		if(!(/[^0-9]/).test($(this).val())){
			$("#product-buyNo-error").hide();
			registeryfee = true;
			addProduct();
			
		}else{
			registeryfee = false;
			$("#product-buyNo-error").show();
			$("#addProduct").unbind();
			$("#addProduct").hide();
		}
		
	});
	//单价验证
	$("#price input").bind("input propertychange",function(){
		if(!digitalRe.test($(this).val())){
			$("#product-price-error").hide();
			maxnum = true;
			addProduct();
			
		}else{
			maxnum = false;
			$("#product-price-error").show();
			$("#addProduct").unbind();
			$("#addProduct").hide();
		}
		
	});
	
	//库存验证
	$("#instock input").bind("input propertychange",function(){
		
		if(!(/[^0-9]/).test($(this).val())){
			$("#product-instock-error").hide();
			activitydate = true;
			addProduct();
			
		}else{
			activitydate = false;
			$("#product-instock-error").show();
			$("#addProduct").unbind();
			$("#addProduct").hide();
		}
		
	});
	
	function addProduct(){
		if(flagName && activityprice && registeryfee && maxnum){
			$("#addProduct").show();
				
				$("#addProduct").click(function(){
					$('#loading').show();
					$('body').addClass("hiddenBody");
				});
				
			
		}
	}
	
	/*$("#addProduct").click(function(){
		
		
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	*/
	
	
});
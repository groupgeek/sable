 $(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	
	
	
	var branchid = val.split("=")[1];
	
	$("#branchid").val(branchid);
	$("#mallInfoUrl").attr("href",root+"/jsp/admin/page/mallInfo.jsp?branchid="+branchid);
	
	//js验证
	var flagName = false;
	var integral = false;
	var purchaseprice = false;
	var instock = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,100}$/;
	var digitalRe = /[^0-9.]/;
	//名字验证
	$("#articlename input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#product-name-error").hide();
			flagName = true;
			addPointsProduct();
			
		}else{
			flagName = false;
			$("#product-name-error").show();
			$("#addPointsProduct").hide();
		}
		
	});
	//进价验证
	$("#purchaseprice input").bind("input propertychange",function(){
		if(!digitalRe.test($(this).val()) && $(this).val().length > 0){
			$("#product-purchaseprice-error").hide();
			purchaseprice = true;
			addPointsProduct();
			
		}else{
			purchaseprice = false;
			$("#product-purchaseprice-error").show();
			$("#addPointsProduct").hide();
		}
		
	});
	//单价验证
	$("#integral input").bind("input propertychange",function(){
		if(!(/[^0-9]/).test($(this).val()) && $(this).val().length > 0){
			$("#product-integral-error").hide();
			integral = true;
			addPointsProduct();
			
		}else{
			integral = false;
			$("#product-integral-error").show();
			$("#addPointsProduct").hide();
		}
		
	});
	
	//库存验证
	$("#instock input").bind("input propertychange",function(){
		
		if(!(/[^0-9]/).test($(this).val()) && $(this).val().length > 0){
			$("#product-instock-error").hide();
			instock = true;
			addPointsProduct();
			
		}else{
			instock = false;
			$("#product-instock-error").show();
			$("#addPointsProduct").hide();
		}
		
	});
	
	function addPointsProduct(){
		if(flagName && integral && instock && purchaseprice){
			$("#addPointsProduct").show();
				
		}
	}
	
	//表单提交
	$("#addPointsProduct").click(function(){
		$('#loading').show();
		$('body').addClass("hiddenBody");
		
		var form = new FormData(document.getElementById("pointsProductForm"));
		$.ajax({
	        url:root+"/superAdmin/addPointsProduct",
	        type:"post",
	        data:form,
	        processData:false,
	        contentType:false,
	        success:function(data){
	           $('#loading').hide();
	           $('body').removeClass("hiddenBody");
	           
	           $("#showMessage").text(data.message);
	           $('#messageNotification').fadeIn(2000);
	           getSrceenWH();
	           $('#messageNotification').fadeOut(3000);
	           
	           $("#producPpicture input").val("");
	           $("#articlename input").val("");
	           $("#integral input").val("");
	           $("#purchaseprice input").val("");
	           $("#instock input").val("");
	           $("#detail textarea").val("");
	           
	        },
	        error:function(e){
	            $('#loading').hide();
				$('body').removeClass("hiddenBody");
				alert("错误！！");
	        }
	    });
	});
	
	
	
 });
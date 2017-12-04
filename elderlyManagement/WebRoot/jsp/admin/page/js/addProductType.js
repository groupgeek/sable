 $(document).ready(function(){
	var root =  $("#root").attr("value");
	
	//选择添加事件
	$("#selectType").change(function(){
		$("#addFatherType").hide();
		$("#addFatherType").unbind();
		$("#addProductType").hide();
		$("#addProductType").unbind();
		if($(this).val() == "0"){
			$("#fatherType").show();
			$("#smallType").hide();
			$("#producttypename input").val("");
			
			
		}else if($(this).val() == "1"){
			$("#fatherType").hide();
			$("#smallType").show();
			$("#fatherType input").val("");
			
		}else{
			$("#fatherType").hide();
			$("#smallType").hide();
			$("#fatherType input").val("");
			$("#producttypename input").val("");
		}
	});
	
	//加载商品大类型
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/addProductView",
		success:function(data){
			
			for(var i in data){
				
				$("#smallFathertypename select").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
			}
			
		}
		
	});
	
	//js验证
	var flagFatherName = false;
	var flagProductTypeName = false;
	
	var nameRe = /^([\u4E00-\uFA29]|[\uE7C7-\uE7F3]|[a-zA-Z0-9_]){1,100}$/;
	var digitalRe = /[^0-9.]/;
	//父类名字验证
	$("#fatherType input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#fatherType-name-error").hide();
			flagFatherName = true;
			addFatherType();
			
		}else{
			flagFatherName = false;
			$("#fatherType-name-error").show();
			$("#addFatherType").unbind();
			$("#addFatherType").hide();
		}
		
	});
	//子类名字验证
	$("#producttypename input").bind("input propertychange",function(){
		if(nameRe.test($(this).val())){
			$("#producttype-name-error").hide();
			flagProductTypeName = true;
			addProductType();
			
		}else{
			flagProductTypeName = false;
			$("#producttype-name-error").show();
			$("#addProductType").unbind();
			$("#addProductType").hide();
		}
		
	});
	//父类
	function addFatherType(){
		if(flagFatherName){
			$("#addFatherType").show();
				
				$("#addFatherType").click(function(){
					$('#loading').show();
					$('body').addClass("hiddenBody");

					var addfatherType = $("#fathertypeid").val();
					//提交
					$.ajax({
						
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/superAdmin/addProductFather",
						data:JSON.stringify(addfatherType),
						success:function(data){
							$('#loading').hide();
							$('body').removeClass("hiddenBody");
							if(data.flag){
								//显示提示信息
									$("#showMessage").text(data.message);
									$('#messageNotification').fadeIn(2000);
									getSrceenWH();
									$('#messageNotification').fadeOut(3000);
								}
							
							
						}
					});
					
				});
				
			
		}
	}
	//子类
	function addProductType(){
		if(flagProductTypeName){
			$("#addProductType").show();
				
				$("#addProductType").click(function(){
					$('#loading').show();
					$('body').addClass("hiddenBody");
					
					var addproductType = $("#producttypename input").val();
					var addFatherType = $("#smallFathertypename select").val();
					
					var record = new Object();
					record.producttypename = addproductType;
					record.fatherid = addFatherType;
					//提交
					$.ajax({
						
						type:"post",
						contentType:"application/json;charset=utf-8",
						url:root+"/superAdmin/addProductType",
						data:JSON.stringify(record),
						success:function(data){
							
							$('#loading').hide();
							$('body').removeClass("hiddenBody");
							if(data.flag){
								//显示提示信息
								$("#showMessage").text(data.message);
								$('#messageNotification').fadeIn(2000);
								getSrceenWH();
								$('#messageNotification').fadeOut(3000);
							}
							
						}
					});
					
					
				});
				
			
		}
	}
	
	/*$("#addProduct").click(function(){
		
		
		$('#loading').show();
		$('body').addClass("hiddenBody");
	})
	*/
	
	
});
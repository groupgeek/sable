$(document).ready(function(){
	$("#js_climit_li li").mouseenter(function(){
		
		//alert($(this).attr("value"));商品类型的值
		
		var producttypeid = $(this).attr("value");
		//alert(producttypeid);
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
		/*	url:"${pageContext.request.contextPath }/branch/sendMessage.action",
			data:'{"messagecontext"'+':'+'"'+1111+'"}',*/
			url:"${pageContext.request.contextPath }/product/quereyProduct_json",
			data:'{"producttypeid"'+':'+'"'+producttypeid+'"'
				+'}',
			
			success:function(data){
				alert("ok");
			
			
			
			
			}
		});
		
		
});
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
});
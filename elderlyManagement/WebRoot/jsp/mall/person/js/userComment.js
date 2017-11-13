$(document).ready(function(){
	var root =  $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var evaluationid = val.split("=")[1];
	
	//加载数据
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryOneEvaluation",
		data:JSON.stringify(evaluationid),
		success:function(data){
			
			$(".itempic").attr("src","/upload/"+data.productpicture);
			$(".item-name").find("p").text(data.productname);
			if(data.colour != null)
			$(".item-info div").first().append('<span>颜色：'+data.colour+'</span><span></br>型号：'+data.size+'</span>');
			
			if(data.taste != null)
			$(".item-info div").first().append('<span>口味：'+data.taste+'</span>');
			
			$(".item-info div").find("strong").text(data.price+"元");
		}
	});
	
	
	
	//发表评价
	$(".info-btn").click(function(){
		
		var evaluationcontent = $(".item-comment textarea").attr("value");
		var evaluationleval = $("#evaluationOption").attr("value");
		
		var info = new Object();
		info.evaluationcontent = evaluationcontent;
		info.evaluationleval = parseInt(evaluationleval);
		info.evaluationid = evaluationid;
		$.ajax({
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/addEvaluatiao",
			data:JSON.stringify(info),
			success:function(data){
				if(data.flag == true){
					window.location.href = root+"/jsp/mall/person/evaluation.jsp";
				}
			}
		});
	});
	
	
});	
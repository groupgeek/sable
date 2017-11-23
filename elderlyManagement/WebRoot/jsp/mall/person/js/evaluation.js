$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	
	//显示当前用户如果没有就跳转到登录界面
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/getLoginUser",
		success:function(data){
			if(data == null){
				alert("请登录");
				window.location.href = root+"/jsp/logReg/login.jsp";
			}
			
		}
	});
	
	
	//创建订单的方法
	function createEvaluation(data , em){
		//创建列表
		
		em.append(
			'<li class="td td-item">'+
				'<div class="item-pic">'+
					'<a href="'+root+'/product/productInfo?id='+data.productid+'" class="J_MakePoint">'+
						'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.productpicture+'" class="itempic">'+
					'</a>'+
				'</div>'+
			'</li>'+

			'<li class="td td-comment">'+
				'<div class="item-title">'+
					'<div class="item-opinion">好评</div>'+
					'<div class="item-name">'+
						'<a href="'+root+'/product/productInfo?id='+data.productid+'">'+
							'<p class="item-basic-info">'+data.productname+'</p>'+
						'</a>'+
					'</div>'+
				'</div>'+
				'<div class="item-comment" style="min-height: 120px;">'+data.evaluationcontent+'<p class="info-time" style="color:gray;"><br/>'+data.stringDate+'</p>'+
				'</div>'+
				'<div class="item-info">'+
					'<div>'+
						'<input type = "hidden" name = "'+data.evaluationid+'">'+
						'<p class="info-little"><span>1</span> <span>1</span> </p>'+
						/*'<p class="info-time">'+data.stringDate+'</p>'+*/

					'</div>'+
				'</div>'+
			 '</li>'
			
		);
		var span = em.find('input[name='+data.evaluationid+']').next().find("span");
		var evaluationcontent = em.find('input[name='+data.evaluationid+']').parent().parent().prev();
		if(data.colour != null){
			span.first().text("颜色："+data.colour);
			span.last().text("型号："+data.size);
		}
		if(data.taste != null){
			span.first().text("口味："+data.taste);
			span.last().remove();
		}
		if(data.evaluationcontent == null){
			evaluationcontent.html("");
			evaluationcontent.append(
					'<li class="td td-change">'+
					'<a href="'+root+'/jsp/mall/person/userComment.jsp?evaluationid='+data.evaluationid+'" class="operate">'+
					'<div class="am-btn am-btn-danger anniu" style="opacity:0.9;filter:alpha(opacity=90);">'+
						'去评价</div></a>'+
						'</li>'
					);
		}
		
	}
	
	//创建订单列表的方法
	function createEvaluationHead(em){
		//创建头
		em.append(
			'<div class="comment-top">'+
				'<div class="th th-price">'+
					'<td class="td-inner">评价</td>'+
				'</div>'+
				'<div class="th th-item">'+
					'<td class="td-inner">商品</td>'+
				'</div>'+													
			'</div>'
		);
	}
	//查询全部订单
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryAllEvaluation",
		success:function(data){
			//全部评价
			//createEvaluationHead($("#allEvaluated ul"));
			for(var i in data){
				createEvaluation(data[i] , $("#allEvaluated ul"));
			}
			
			//未评价
			//createEvaluationHead($("#beEvaluated ul"));
			for(var i in data){
				if(data[i].evaluationcontent == null)
				createEvaluation(data[i] , $("#beEvaluated ul"));
			}
			
		}
	});
	
	
	
	
});
$(document).ready(function(){
	var root =  $("#root").attr("value");
	
	//查询最新记录
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryUserUpToDate",
		data:JSON.stringify(),
		success:function(data){
			if(data != null){
				$(".usable span").text(data.remainingpoints);
			}
		}
		
	});
	
	//创建列表的方法
	function createTable(data , em){
		em.append(
			'<tr>'+
				'<td class="pointType">'+data.details+'</td>'+
				'<td class="pointNum">'+data.change+'</td>'+
				'<td class="pointTime">'+data.changetimeString+'</td>'+
			'</tr>'
					
		);
	}
	
	$.ajax({
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryUserAllRecord",
		data:JSON.stringify(),
		success:function(data){
			if(data != null){
				//全部数据
				for(var i in data){
					createTable(data[i],$("#all tbody"));
				}
				
				//支出数据
				for(var i in data){
					if(data[i].change > 0)
					createTable(data[i],$("#get tbody"));
				}
				
				//获取数据
				for(var i in data){
					if(data[i].change < 0)
					createTable(data[i],$("#expenditure tbody"));
				}
			}
		}
		
	});
	
});
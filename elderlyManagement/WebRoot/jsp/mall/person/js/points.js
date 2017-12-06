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
				'<td class="pointNum">'+data.changeintegral+'</td>'+
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
					if(data[i].changeintegral > 0){
						createTable(data[i],$("#get tbody"));
					}
				}
				
				//获取数据
				for(var i in data){
					if(data[i].changeintegral < 0)
					createTable(data[i],$("#expenditure tbody"));
				}
				
				
				//分页
				//加载按钮
				$("#all").append('<div style="width: 100%; height: 20px; text-align: center;"><a href = "javascript:void(0)" id = "allLoading">加载更多</a></div>');
				$("#get").append('<div style="width: 100%; height: 20px; text-align: center;"><a href = "javascript:;" id = "getLoading">加载更多</a></div>');
				$("#expenditure").append('<div style="width: 100%; height: 20px; text-align: center;"><a href = "javascript:;" id = "expenditureLoading">加载更多</a></div>');
				
				
				
				//加载分页事件
				splitPage($("#all"));
				splitPage($("#get"));
				splitPage($("#expenditure"));
				
				//分页事件
				function splitPage(em){
					//开始显示的数据
					var num = 5;
					//隐藏数据
					em.find("tbody tr").hide();
					
					for(var i = 0 ; i < num ; i++){
						em.find("tbody tr").eq(i).show();
					}
					
					//开始分页
					em.find("a").click(function(){
						
						if(num >= em.find("tr").length){
							//更改信息框颜色
							$("#messageNotification").attr("style","background-color: red;");
							
							$("#showMessage").text("没有了哦0.0");
							$('#messageNotification').fadeIn(2000);
							getSrceenWH();
							$('#messageNotification').fadeOut(3000);
						}else{
							for(var i = num ; i < num + 5 ; i++){
								em.find("tr").eq(i).show();
							}
							num = num + 5;
						}
						
					});
				}
			}
		}
		
	});
	
});
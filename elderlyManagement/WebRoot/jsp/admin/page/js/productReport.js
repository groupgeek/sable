$(document).ready(function(){
	var val = window.location.href.split("?")[1];
	var productid = val.split("=")[1];
	
	
	//初始化报表
	var chart = echarts.init(document.getElementById('buyNoAndProfit'));
	
	//时间开始
	$("#submit").click(function(){
		
		if($("#start").val() == "" || $("#end").val() == ""){
			$("#hideDiv").show();
			
		}else{
			$("#hideDiv").hide();
			chart.showLoading();
			//查询数据
			var condition = new Object();
			condition.startDateString = $("#start").val();
			condition.endDateString = $("#end").val();
			condition.productid = productid;
			
			
			$.ajax({
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryProductReport",
				data:JSON.stringify(condition),
				error:function(){
					alert("请求出错");
				},
				success:function(result){
					if(result != " " || result != null){
						createReport(result);
						chart.setOption(option);
						chart.hideLoading();
					}else{
						chart.hideLoading();
						alert("查询错误");
					}
				}
			});
		}
		
		
	});
	
	//把数据加载到option中
	function createReport(result){
		var x = new Array();
		var yBuyNo = new Array();
		var yProfit = new Array();
		

		var i = 0;
		var y = 0;
		for(var key in result){
			x[i] = key;
//			yBuyNo[0] = 0;
//			yProfit[0] = 0;
//			if(result[key] != null){
//				for(var k in result[key]){
//					yBuyNo[y] = parseInt(result[key][k].countbuy) + 1;
//					yProfit[y] = parseInt(result[key][k].totalprice) + 1;
//					//alert(yProfit)
//					//yBuyNo[y] = parseInt(result[key][k].countbuy);
//					//yProfit[y] = parseInt(result[key][k].totalprice);
//					
//				}
//			}else{
//				yBuyNo[y] = 0;
//				yProfit[y] = 0;
//			}
			
			yBuyNo[y] = result[key][0];
			yProfit[y] = result[key][1];
			
			
			i++;
			y++;
		}
		
		//x = ['周77一','周二','周三','周四','周五','周六','周日'];
		//yBuyNo = [120, 132, 101, 134, 90, 230, 210];
		//yProfit = [220, 182, 191, 234, 290, 330, 310];
		option = {
			    title: {
			        text: '商品折线图'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['购买次数','总收入']
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    toolbox: {
			        feature: {
			            saveAsImage: {}
			        }
			    },
			    xAxis: {
			        type: 'category',
			        boundaryGap: false,
			        data: x
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [
			        {
			            name:'购买次数',
			            type:'line',
			            stack: '总量',
			            data:yBuyNo
			        },
			        {
			            name:'总收入',
			            type:'line',
			            stack: '总量',
			            data:yProfit
			        }
			    ]
			};
	}
	
	
	
});
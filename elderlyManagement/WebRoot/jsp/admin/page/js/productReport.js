$(document).ready(function(){
	var val = window.location.href.split("?")[1];
	var productid = val.split("=")[1];
	var chart = echarts.init(document.getElementById('buyNoAndProfit'));
	
	
	
	
	//查询数据
	chart.showLoading();
	$.ajax({
		
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		//url:root+"/superAdmin/",
		data:JSON.stringify(productid),
		success:function(result){
			
			
			createReport(result);
			chart.setOption(option);
			chart.hideLoading();
			
		}
	});
	
	//把数据加载到option中
	function createReport(result){
		option = {
			    title: {
			        text: '商品折线图'
			    },
			    tooltip: {
			        trigger: 'axis'
			    },
			    legend: {
			        data:['购买次数','盈利']
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
			        data: ['周一','周二','周三','周四','周五','周六','周日']
			    },
			    yAxis: {
			        type: 'value'
			    },
			    series: [
			        {
			            name:'购买次数',
			            type:'line',
			            stack: '总量',
			            data:[120, 132, 101, 134, 90, 230, 210]
			        },
			        {
			            name:'盈利',
			            type:'line',
			            stack: '总量',
			            data:[220, 182, 191, 234, 290, 330, 310]
			        }
			    ]
			};
	}
	
	
	
});
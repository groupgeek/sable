function tab(){     //柱状图
	var root = $("#root").val();
	var activityid = document.getElementById("activityid").value;
	var ActivityCustom = new Object();
	ActivityCustom.activityid = activityid;
	
	var myChart = echarts.init(document.getElementById('activity'));
	myChart.showLoading();
	$.ajax({
		type : 'post',
		url : root+'/brach/actReportCondition.action',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(ActivityCustom),
		success : function(data) {
			act(data);
			myChart.setOption(option);
			myChart.hideLoading();
			
			/*alert(data.activityname);
			alert(data.totalReg);
			alert(data.totalExpend);
			alert(data.countReg);*/
           
		},
	});
	
	function act(data){
		option = {
			    title: {
			        text: '活动收支详情'
			    },
			    tooltip: {
			        trigger: 'axis',
			        axisPointer: { // 坐标轴指示器，坐标轴触发有效
			            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
			        }
			    },
			    legend: {
			        data: ['总收入', '总支出', '报名人数'],
			        align: 'right',
			        right: 10
			    },
			    grid: {
			        left: '3%',
			        right: '4%',
			        bottom: '3%',
			        containLabel: true
			    },
			    xAxis: [{
			        type: 'category',
			        data: [data.activityname]
			    }],
			    yAxis: [{
			        type: 'value',
			        name: '总价(元)',
			        axisLabel: {
			            formatter: '{value}'
			        }
			    }],
			    series: [{
			        name: '总收入',
			        type: 'bar',
			        data: [data.totalReg]
			    }, {
			        name: '总支出',
			        type: 'bar',
			        data: [data.totalExpend]
			    }, {
			        name: '报名人数',
			        type: 'bar',
			        data: [data.countReg]
			    }]
			};
	}
}
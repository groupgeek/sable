function xixi(){
	var root = $("#root").val();
	var productid = document.getElementById("productId").value;
	var startingTime = document.getElementById("begin").value;
	var endTime = document.getElementById("end").value;
	var productTranctionReportCustom = new Object();
	productTranctionReportCustom.productid = productid;
	productTranctionReportCustom.startingTime = startingTime;
	productTranctionReportCustom.endTime = endTime;
	
	$.ajax({
		type : 'post',
		url : root+'/brach/productChart.action',
		contentType : 'application/json;charset=utf-8',
		data : JSON.stringify(productTranctionReportCustom),
		success : function(data) {
			myChart.hideLoading();      //隐藏加载动画
            myChart.setOption({ //加载数据图表
            	 xAxis: {
                     data: data.buyTime
                 },
                series: [{
                    name: '销量',
                    data: data.buyNo
                }]
            }) ;
		},
	});
	
	var myChart = echarts.init(document.getElementById('product'));
    var option = {
    		title: {
    	        text: '产品日销量统计图'
    	    },
		    color: ['#3398DB'],
		    tooltip : {
		        trigger: 'axis',
		        axisPointer : {            // 坐标轴指示器，坐标轴触发有效
		            type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
		        }
		    },
		    grid: {
		        left: '3%',
		        right: '4%',
		        bottom: '3%',
		        containLabel: true
		    },
		    xAxis : [
		        {
		            type : 'category',
		            data : [],
		            axisTick: {
		                alignWithLabel: true
		            }
		        }
		    ],
		    yAxis : [
		        {
		            type : 'value'
		        }
		    ],
		    series : [
		        {
		            name:'直接访问',
		            type:'bar',
		            barWidth: '60%',
		            data:[]
		        }
		    ]
		};	
      myChart.showLoading();
      // 使用刚指定的配置项和数据显示图表。
      myChart.setOption(option);
}
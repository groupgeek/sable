$(document).ready(function(){
var myChart = echarts.init(document.getElementById('chartmain'));
   		
   		var option = {
    		title : {
        		text: '公司年收入情况'
    		},
    		tooltip : {
        	trigger: 'axis'
    		},
    		legend: {
        		data:['总盈利','商城盈利','活动支出','活动收入']
    		},
    		toolbox: {
        		show : true,
        		feature : {
            	magicType : {show: true, type: ['line', 'bar']},
            	restore : {show: true},           
       			}
    		},
    		calculable : true,
   			xAxis : [
        		{
            		type : 'category',
            		data : [],
            		name: '月份',
            		axisLabel: {
                		formatter: '{value}月'
            		}
        		}
    		],
    		yAxis : [
        		{
            		type : 'value',
            		name: '人民币',
            		axisLabel: {
                		formatter: '￥{value}'
            		}
        		}
    		],
    		series : [
        		{
        			
            		name:'总盈利',
            		type:'bar',
            		data:[],
            		markPoint : {
                		data : [
                    		{type : 'max', name: '最大值'},
                    		{type : 'min', name: '最小值'}
                		]
            		}, 
            		markLine : {
                		data : [
                    		{type : 'average', name: '平均值'}
                		]
            		}
        		},
        		{
        			
            		name:'商城盈利',
            		type:'bar',
            		data:[],
            		markPoint : {
                		data : [
                    		{type : 'max', name : '时间段最高'},
                    		{type : 'min', name : '时间段最低'}
                		]
            		}, 
            		markLine : {
                		data : [
                    		{type : 'average', name : '平均值'}
                		]
            		}
        		},
        		{
        			
            		name:'活动支出',
            		type:'line',
            		data:[],
            		markPoint : {
                		data : [
                    		{type : 'max', name : '时间段最高'},
                    		{type : 'min', name : '时间段最低'}
                		]
            		}, 
            		markLine : {
                		data : [
                    		{type : 'average', name : '平均值'}
                		]
            		}
        		},
        		{
        			
            		name:'活动收入',
            		type:'line',
            		data:[],
            		markPoint : {
                		data : [
                    		{type : 'max', name : '时间段最高'},
                    		{type : 'min', name : '时间段最低'}
                		]
            		}, 
            		markLine : {
                		data : [
                    		{type : 'average', name : '平均值'}
                		]
            		}
        		}
    		]
		};
		myChart.showLoading();		 
     	var times=[];    //类别数组（实际用来盛放X轴坐标值）
     	var bigdecimal=[];
     	var money=[];
     	var toprices=[];
        var getprices=[];    //销量数组（实际用来盛放Y坐标值）
        var root = $("#root").val();
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/readindex.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
             		
                    for(var i=0;i<result.listStrings.length;i++){       
                       times.push(result.listStrings[i]);    
                     }                     
                    for(var i=0;i<result.listCeoTotalreports.length;i++){
             			bigdecimal.push(result.listCeoTotalreports[i]);
             		}
             		for(var i=0;i<result.listPCustoms.length;i++ ){
             			money.push(result.listPCustoms[i]);
             		}
             		for(var i=0;i<result.listActivities.length;i++){
             			toprices.push(result.listActivities[i]);
             		}
                    for(var i=0;i<result.listregisery.length;i++){       
                        getprices.push(result.listregisery[i]); 
                      }
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: times
                        },
                        series: [
                        {
                        	name: '总盈利',
                        	data : bigdecimal
                        },
                        {
                            // 根据名字对应到相应的系列
                            name: '商城盈利',
                            data: money
                        },
                        {
                        	name: '活动支出',
                        	data: toprices
                        },
                        {
                        	name: '活动收入',
                        	data: getprices
                        }
                        ]
                    });                   
             }         
        },
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
         myChart.hideLoading();
         }
    	});	 
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
});
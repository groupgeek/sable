$(document).ready(function(){
var myChart = echarts.init(document.getElementById('activitychart'));

	var option = {
	title : {
        text: '活动开展情况'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['参与人数','活动收入','活动支出']
    },
    dataZoom: [{
        type: 'slider',
        start: 80,
        end: 100
    }, {
        type: 'inside',
        start: 80,
        end: 100
    }],
    xAxis: [
            {
                type : 'category',
            	data : []           	
            }
        ],
    yAxis: [
    		{
        		type : 'value',
        		name : '人民币',
        		position : 'left',
        		axisLine: {
                    lineStyle: {
                        color: 'red'
                    }
                },
                axisLabel: {
                    formatter: '￥{value}'
                }        			
        	},
            {
        		type : 'value',
        		name : '人数',
        		position : 'right',
        		axisLine: {
                    lineStyle: {
                        color: 'blue'
                    }
                },
                axisLabel: {
                    formatter: '{value} 人'
                }
        	}       	
        ],
    	series: [
            	{        			
            		name:'参与人数',
            		type:'bar',
            		barMaxWidth:60,
            		data:[],
                    yAxisIndex: 1      		
        		},    
        		{
        			
            		name:'活动收入',
            		type:'bar',
            		barMaxWidth:60,
            		data:[]           		
        		},
        		{       			
            		name:'活动支出',
            		type:'bar',
            		barMaxWidth:60,
            		data:[]
        		}
        	]
		};
		myChart.showLoading();	
		var actname=[];    //类别数组（实际用来盛放X轴坐标值）
		var usernum=[];
     	var sumget=[];
        var sumto=[];   //销量数组（实际用来盛放Y坐标值）
        var root = $("#root").val(); 
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/allactivitychart.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
             		
                   for(var i=0;i<result.length;i++){       
                       actname.push(result[i].activityname);    
                     }                                        
                   for(var i=0;i<result.length;i++){
                   		usernum.push(result[i].averagepeople);
                   }
                   for(var i=0;i<result.length;i++){
                   		sumget.push(result[i].totalprice);
                   }
                   for(var i=0;i<result.length;i++){
                   		sumto.push(result[i].totalexpenditure);
                   }
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: actname
                        },
                        series: [
                        {
                        	name: '参与人数',
                        	data : usernum
                        },                        
                        {
                        	name: '活动收入',
                        	data: sumget
                        },
                        {
                        	name: '活动支出',
                        	data: sumto
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
    myChart.setOption(option);
    
    //===============================================
    var twoChart = echarts.init(document.getElementById("chart1"));
    var option1={
 		title : {
        		text: '活动年收入占比'
    		},
			tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'right',
		        data:['年活动收入','年活动支出']
		    },
		    series: [
		        {
		            name:'',
		            type:'pie',
		            selectedMode: 'single',
		            radius : '55%',
		            center: ['50%', '60%'],		       
		            data:[],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]   		   
    };
    twoChart.showLoading();
    
    var threeChart = echarts.init(document.getElementById("chart2"));
    var option2={
 		title : {
        		text: '活动总收入占比'
    		},
			tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'right',
		        data:['总活动收入','总活动支出']
		    },
		    series: [
		        {
		            name:'',
		            type:'pie',
		            selectedMode: 'single',
		            radius : '55%',
		            center: ['50%', '60%'],		       
		            data:[],
		            itemStyle: {
		                emphasis: {
		                    shadowBlur: 10,
		                    shadowOffsetX: 0,
		                    shadowColor: 'rgba(0, 0, 0, 0.5)'
		                }
		            }
		        }
		    ]   		   
    };
    
    $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/activitychartByYear.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                   twoChart.hideLoading();      //隐藏加载动画 
                   twoChart.setOption({        //加载数据图表
                        series: [
                        {                           	
                        	data : [{name:'年活动收入',value:result[0].sumgetprice	},
                        	        {name:'年活动支出',value:result[0].sumtoprice}]                           			
                        }
                        ]
                    });
                   threeChart.setOption({        //加载数据图表
                       series: [
                       {                           	
                       	data : [{name:'总活动收入',value:result[1].sumtotalPrice	},
                       	        {name:'总活动支出',value:result[1].sumtotalExpenditure}]                           			
                       }
                       ]
                   });
             }
        },
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
         twoChart.hideLoading();
         }
    	});
    	twoChart.setOption(option1);
    	threeChart.setOption(option2);
    	
    	//===========================================================================
    	
    	var fourChart = echarts.init(document.getElementById('activitychartLine'));

    	var option = {
    	title : {
            text: '活动盈利'
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['支出','收入','盈利']
        },
        dataZoom: [{
            type: 'slider',
            start: 80,
            end: 100
        }, {
            type: 'inside',
            start: 80,
            end: 100
        }],
        xAxis: [
                {
                    type : 'category',
                    boundaryGap: false,
                	data : []           	
                }
            ],
        yAxis: [
        		{
            		type : 'value',
            		name : '人民币',
            		position : 'left',
            		axisLine: {
                        lineStyle: {
                            color: 'red'
                        }
                    },
                    axisLabel: {
                        formatter: '￥{value}'
                    }        			
            	}  	
            ],
        	series: [
                	{        			
                		name:'支出',
                		type:'line',
                		data:[],    		
            		},    
            		{
            			
                		name:'收入',
                		type:'line',
                		data:[]           		
            		},
            		{       			
                		name:'盈利',
                		type:'line',
                		data:[],
                		markPoint: {
                            data: [
                                {type: 'max', name: '最大值'},
                                {type: 'min', name: '最小值'}
                            ]
                        },
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
            		}
            	]
    		};
    		fourChart.showLoading();	
    		var sumall=[];    //类别数组（实际用来盛放X轴坐标值）
    		var sumto=[];
         	var sumget=[];
            var time=[];   //销量数组（实际用来盛放Y坐标值）
            var root = $("#root").val(); 
            $.ajax({
            type : 'post',
            async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url : root+'/ceo/ceoActivityVo.action',    
            data : '{}',
            contentType : 'application/json;charset=utf-8',        //返回数据形式为json
            success : function(result) {
                 //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {
                 		
                       for(var i=0;i<result.listAllactivity.length;i++){       
                    	   time.push(result.listAllactivity[i].stringDate);    
                         }                                        
                       for(var i=0;i<result.listAllactivity.length;i++){
                    	   sumall.push(result.listAllactivity[i].sumAllBigDecimal);
                       }
                       for(var i=0;i<result.listAllactivity.length;i++){
                    	   sumto.push(result.listAllactivity[i].sumAlltoprice);
                       }
                       for(var i=0;i<result.listAllactivity.length;i++){
                    	   sumget.push(result.listAllactivity[i].sumAllgetprice);
                       }
                       fourChart.hideLoading();      //隐藏加载动画 
                       fourChart.setOption({        //加载数据图表
                           	xAxis: {
                                data: time
                            },
                            series: [
                            {
                            	name: '支出',
                            	data : sumto
                            },                        
                            {
                            	name: '收入',
                            	data: sumget
                            },
                            {
                            	name: '盈利',
                            	data: sumall
                            }
                            ]
                        });                      
                 }         
            },
             error : function(errorMsg) {
                 //请求失败时执行该函数
             alert("图表请求数据失败!");
             fourChart.hideLoading();
             }
        	});
            fourChart.setOption(option);
});
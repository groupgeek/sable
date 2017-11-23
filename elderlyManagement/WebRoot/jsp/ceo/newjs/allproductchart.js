$(document).ready(function(){
var myChart = echarts.init(document.getElementById('productchart'));

	var option = {
	title : {
        text: '商品报表'
    },
    tooltip: {
        trigger: 'axis'
    },
    legend: {
        data: ['销售量','总售价','总进价']
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
        		name : '销售量',
        		position : 'right',
        		axisLine: {
                    lineStyle: {
                        color: 'blue'
                    }
                },
                axisLabel: {
                    formatter: '{value} 件'
                }
        	}       	
        ],
    	series: [
            	{        			
            		name:'销售量',
            		type:'bar',
            		barMaxWidth:60,
            		data:[],
                    yAxisIndex: 1      		
        		},    
        		{
        			
            		name:'总售价',
            		type:'bar',
            		barMaxWidth:60,
            		data:[]           		
        		},
        		{       			
            		name:'总进价',
            		type:'bar',
            		barMaxWidth:60,
            		data:[]
        		}
        	]
		};
		myChart.showLoading();	
		var proname=[];    //类别数组（实际用来盛放X轴坐标值）
		var prornum=[];
     	var proget=[];
        var proto=[];   //销量数组（实际用来盛放Y坐标值）
        var root = $("#root").val(); 
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/allproductcharts.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
             		
                   for(var i=0;i<result.length;i++){       
                	   proname.push(result[i].productname);    
                     }                                        
                   for(var i=0;i<result.length;i++){
                	   prornum.push(result[i].buynum);
                   }
                   for(var i=0;i<result.length;i++){
                	   proget.push(result[i].getprice);
                   }
                   for(var i=0;i<result.length;i++){
                	   proto.push(result[i].toprice);
                   }
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: proname
                        },
                        series: [
                        {
                        	name: '销售量',
                        	data : prornum
                        },                        
                        {
                        	name: '总售价',
                        	data: proget
                        },
                        {
                        	name: '总进价',
                        	data: proto
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
        		text: '商品年收入占比'
    		},
			tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'right',
		        data:['年销售价','年进货价']
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
        		text: '商品总收入占比'
    		},
			tooltip: {
		        trigger: 'item',
		        formatter: "{a} <br/>{b}: {c} ({d}%)"
		    },
		    legend: {
		        orient: 'vertical',
		        x: 'right',
		        data:['总售价','总进价']
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
        url : root+'/ceo/productchartofyear.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                   twoChart.hideLoading();      //隐藏加载动画 
                   twoChart.setOption({        //加载数据图表
                        series: [
                        {                           	
                        	data : [{name:'年销售价',value:result[0].sumgetprice	},
                        	        {name:'年进货价',value:result[0].sumtoprice}]                           			
                        }
                        ]
                    });
                   threeChart.setOption({        //加载数据图表
                       series: [
                       {                           	
                       	data : [{name:'总售价',value:result[1].sumtotalPrice	},
                       	        {name:'总进价',value:result[1].sumtotalExpenditure}]                           			
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
});
$(document).ready(function(){
var oneChart = echarts.init(document.getElementById("oneactivity"));
    var option = {
    		title : {
    	        text: '活动收入/支出'
    	    },
    	    tooltip: {
    	        trigger: 'axis'
    	    },
    	    legend: {
   		        x: 'right',
    	        data: ['参与人数','活动收入','活动支出']
    	    },    	 
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
    	oneChart.showLoading();	
		var aname=[];
		var people=[];
		var price=[];
		var penditure=[];
		var root = $("#root").val(); 
		var activityid = document.getElementById("activityId").value;
		var ceoActivityreport = new Object();
		ceoActivityreport.activityid=activityid;
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/oneactivitychart.action',    
        data : JSON.stringify(ceoActivityreport),
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
                   for(var i=0;i<result.length;i++){       
                	   aname.push(result[i].activityname);    
                     }                                        
                   for(var i=0;i<result.length;i++){
                	   people.push(result[i].averagepeople);
                   }
                   for(var i=0;i<result.length;i++){
                	   price.push(result[i].totalprice);
                   }
                   for(var i=0;i<result.length;i++){
                	   penditure.push(result[i].totalexpenditure);
                   }
                   oneChart.hideLoading();      //隐藏加载动画 
                   oneChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: aname
                        },
                        series: [
                        {
                        	name: '参与人数',
                        	data : people
                        },                        
                        {
                        	name: '活动收入',
                        	data: price
                        },
                        {
                        	name: '活动支出',
                        	data: penditure
                        }
                        ]
                    });                      
             }         
        },
         error : function(errorMsg) {
             //请求失败时执行该函数
         alert("图表请求数据失败!");
         oneChart.hideLoading();
         }
    	});
        oneChart.setOption(option);
       //=======================================================
       var twoChart = echarts.init(document.getElementById("twoactivity"));
       var option={
    		title : {
           		text: '活动收入/支出占比'
       		},
   			tooltip: {
   		        trigger: 'item',
   		        formatter: "{a} <br/>{b}: {c} ({d}%)"
   		    },
   		    legend: {
   		        orient: 'vertical',
   		        x: 'right',
   		        data:['活动收入','活动支出']
   		    },
   		    series: [
   		        {
   		            name:'',
   		            type:'pie',
   		            selectedMode: 'single',
   		            radius: [0, '60%'],

   		            label: {
   		                normal: {
   		                    position: 'inner'
   		                }
   		            },
   		            labelLine: {
   		                normal: {
   		                    show: false
   		                }
   		            },
   		            data:[]
   		        }
   		    ]   		   
       };
       twoChart.showLoading();
       $.ajax({
           type : 'post',
           async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
           url : root+'/ceo/twoactivitychart.action',    
           data : JSON.stringify(ceoActivityreport),
           contentType : 'application/json;charset=utf-8',        //返回数据形式为json
           success : function(result) {
                //请求成功时执行该函数内容，result即为服务器返回的json对象
               if (result) {
                      twoChart.hideLoading();      //隐藏加载动画 
                      twoChart.setOption({        //加载数据图表
                           series: [
                           {                           	
                           	data : [{name:'活动收入',value:result.totalprice	},
                           	        {name:'活动支出',value:result.totalexpenditure}]                           			
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
       twoChart.setOption(option);
});
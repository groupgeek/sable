$(document).ready(function(){
	var myChart = echarts.init(document.getElementById('branchChart'));

    var option = {
    		backgroundColor: "#EDEDED",
    		title : {
        		text: '分店年收入情况'
    		},
    		tooltip : {
        	trigger: 'axis'
    		},
    		legend: {
        		data:['总收入','商城收入','教育收入','健康收入']
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
        			
            		name:'总收入',
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
        			
            		name:'商城收入',
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
        			
            		name:'教育收入',
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
        			
            		name:'健康收入',
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
     	var order=[];
     	var edu=[];
        var heal=[];
        var sumbig=[];   //销量数组（实际用来盛放Y坐标值）
        var root = $("#root").val();
        var id = document.getElementById("branchid").value;    
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : root+'/ceo/branchchart.action',    
        data : JSON.stringify(id),
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
             		
                   for(var i=0;i<result.listDate.length;i++){       
                       times.push(result.listDate[i]);    
                     }                     
                    for(var i=0;i<result.listproduct.length;i++){
                    	order.push(result.listproduct[i]);
             		}             	
             		for(var i=0;i<result.listEduIncome.length;i++){
             			edu.push(result.listEduIncome[i]);
             		}
                    for(var i=0;i<result.listHealIncome.length;i++){       
                        heal.push(result.listHealIncome[i]); 
                      }
                     for(var i=0;i<result.listSumBigdecimal.length;i++){       
                        sumbig.push(result.listSumBigdecimal[i]); 
                      }
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: times
                        },
                        series: [
                        {
                        	name: '总收入',
                        	data : sumbig
                        },
                        {
                            // 根据名字对应到相应的系列
                            name: '商城收入',
                            data: order
                        },
                        {
                        	name: '教育收入',
                        	data: edu
                        },
                        {
                        	name: '健康收入',
                        	data: heal
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
    
    //==============================================================
    
    var twoChart = echarts.init(document.getElementById('branchHotproduct'));
    
    var option = {
    		color: ['#ffffff'],
    	    tooltip : {
    	        trigger: 'axis'
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
    	            data : []
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value'
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'销售量',
    	            type:'bar',
    	            barMaxWidth: 60,
    	            data:[]
    	        }
    	    ]
    };
    var productname=[];
    var productnum=[];
    var root = $("#root").val();
    var id = document.getElementById("branchid").value;    
    $.ajax({
    type : 'post',
    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
    url : root+'/ceo/branchtwochart.action',    
    data : JSON.stringify(id),
    contentType : 'application/json;charset=utf-8',        //返回数据形式为json
    success : function(result) {
         //请求成功时执行该函数内容，result即为服务器返回的json对象
        if (result) {
         		
               for(var i=0;i<result.length;i++){       
            	   productname.push(result[i].productname);    
                 }                     
                for(var i=0;i<result.length;i++){
                	productnum.push(result[i].buyno);
         		}             	        		
                twoChart.hideLoading();      //隐藏加载动画 
                twoChart.setOption({        //加载数据图表
                   	xAxis: {
                        data: productname
                    },
                    series: [
                    {
                    	name: '销售量',
                    	data : productnum
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
    //=====================================================
    var threeChart = echarts.init(document.getElementById('branchuser'));
    
    var option = {
    		backgroundColor: "#EEC591",
    		title : {
        		text: '月注册用户情况'
    		},
    		color: ['#2894FF'],
    	    tooltip : {
    	        trigger: 'axis'
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
    	        	axisLabel: {
    	        		formatter: '{value}日'
    	        	}
    	        }
    	    ],
    	    yAxis : [
    	        {
    	            type : 'value',
    	            name: '人数',
    	        }
    	    ],
    	    series : [
    	        {
    	            name:'注册人数',
    	            type:'bar',
    	            barMaxWidth: 60,
    	            data:[]
    	        },
    	        {
    	        	name:'走势',
    	        	type:'line',
    	        	data:[]
    	        }
    	    ]
    };
    threeChart.showLoading();	
    var time=[];
    var usernum=[];
    var root = $("#root").val();
    var id = document.getElementById("branchid").value;    
    $.ajax({
    type : 'post',
    async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
    url : root+'/ceo/branchthreechart.action',    
    data : JSON.stringify(id),
    contentType : 'application/json;charset=utf-8',        //返回数据形式为json
    success : function(result) {
         //请求成功时执行该函数内容，result即为服务器返回的json对象
        if (result) {
         		
               for(var i=0;i<result.length;i++){       
            	   time.push(result[i].stringregistrationdate);    
                 }                     
                for(var i=0;i<result.length;i++){
                	usernum.push(result[i].usernumber);
         		} 
                threeChart.hideLoading();      //隐藏加载动画 
                threeChart.setOption({        //加载数据图表
                   	xAxis: {
                        data: time
                    },
                    series: [
                    {
                    	name: '注册人数',
                    	data : usernum
                    },
                    {
                    	name:'走势',
                    	data : usernum
                    }
                    ]
                });                      
         }         
    },
     error : function(errorMsg) {
         //请求失败时执行该函数
     alert("图表请求数据失败!");
     threeChart.hideLoading();
     }
	});
    threeChart.setOption(option);
});
$(document).ready(function(){
var myChart = echarts.init(document.getElementById('product'));
   		
var option = {
    	title : {
        		text: '商品收入情况'
    	},
        tooltip : {
            trigger: 'axis',
            axisPointer: {
                type: 'shadow',
                label: {
                    show: true
                }
            }
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                
                magicType: {show: true, type: ['line', 'bar']},
                restore : {show: true},                
            }
        },
        calculable : true,
        legend: {
            data:['销售量','总进价','总售价'],
            itemGap: 5
        },
        grid: {
            top: '12%',
            left: '1%',
            right: '10%',
            containLabel: true
        },
        xAxis: [
            {
                type : 'category',
            	data : [],
            	axisLabel: {
                	formatter: '{value}日'
            	}
            }
        ],
        yAxis: [
            {
                type : 'value',
            		name: '人民币',
            		axisLabel: {
                		formatter: '￥{value}'
            		}
            },
        		{
        			type : 'value',
        			name : '数量',
        			axisLabel:{
        				formatter: '{value} 件'
        			}
        		}
        ],
        dataZoom: [
            {
                show: true,
                start: 94,
                end: 100
            },
            {
                type: 'inside',
                start: 94,
                end: 100
            }
        ],
        series : [
            {
        			
            		name:'销售量',
            		type:'bar',
            		barMaxWidth:60,
            		data:[],
                    yAxisIndex: 1,
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
        			
            		name:'总进价',
            		type:'line',
            		barMaxWidth:60,
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
        			
            		name:'总售价',
            		type:'line',
            		barMaxWidth:60,
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
     	var number=[];
     	var toprices=[];
        var getprices=[];    //销量数组（实际用来盛放Y坐标值）
        var root = $("#root").val();
        var productid = document.getElementById("productId").value;
        var ceoProducttransactionreport = new Object();
        ceoProducttransactionreport.productid = productid;
        $.ajax({
        type : 'post',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        url : root+'/ceo/oneproduct.action',    
        data : JSON.stringify(ceoProducttransactionreport),
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
        	
        	
        	
        	
            if (result) {
             		
                    for(var i=0;i<result.length;i++){       
                       times.push(result[i].stringTime);    
                     }                     
                    for(var i=0;i<result.length;i++){
                    	number.push(result[i].sumBuy);
             		}             	
             		for(var i=0;i<result.length;i++){
             			toprices.push(result[i].sumtoprice);
             		}
                    for(var i=0;i<result.length;i++){       
                        getprices.push(result[i].sumgetprice); 
                      }
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	xAxis: {
                            data: times
                        },
                        series: [
                        {
                        	name: '销售量',
                        	data : number
                        },                        
                        {
                        	name: '总进价',
                        	data: toprices
                        },
                        {
                        	name: '总售价',
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
  //=======================================================================================
        	var threeChart = echarts.init(document.getElementById('onecenter'));
        	
        	var option = {
        			title : {
                		text: '商品月收入占比'
            		},
        			tooltip: {
        		        trigger: 'item',
        		        formatter: "{a} <br/>{b}: {c} ({d}%)"
        		    },
        		    legend: {
        		        orient: 'vertical',
        		        x: 'left',
        		        data:[]
        		    },
        		    series: [
        		        {
        		            name:'销售量',
        		            type:'pie',
        		            selectedMode: 'single',
        		            radius: [0, '30%'],

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
        		        },
        		        {
        		            name:'总收入',
        		            type:'pie',
        		            radius: ['40%', '55%'],
        		            label: {
        		                normal: {
        		                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
        		                    backgroundColor: '#eee',
        		                    borderColor: '#aaa',
        		                    borderWidth: 1,
        		                    borderRadius: 4,
        		                    // shadowBlur:3,
        		                    // shadowOffsetX: 2,
        		                    // shadowOffsetY: 2,
        		                    // shadowColor: '#999',
        		                    // padding: [0, 7],
        		                    rich: {
        		                        a: {
        		                            color: '#999',
        		                            lineHeight: 22,
        		                            align: 'center'
        		                        },
        		                        // abg: {
        		                        //     backgroundColor: '#333',
        		                        //     width: '100%',
        		                        //     align: 'right',
        		                        //     height: 22,
        		                        //     borderRadius: [4, 4, 0, 0]
        		                        // },
        		                        hr: {
        		                            borderColor: '#aaa',
        		                            width: '100%',
        		                            borderWidth: 0.5,
        		                            height: 0
        		                        },
        		                        b: {
        		                            fontSize: 16,
        		                            lineHeight: 33
        		                        },
        		                        per: {
        		                            color: '#eee',
        		                            backgroundColor: '#334455',
        		                            padding: [2, 4],
        		                            borderRadius: 2
        		                        }
        		                    }
        		                }
        		            },
        		            data:[]
        		        }
        		    ]
        	};
        	threeChart.showLoading();
       		var buynumber=[];
       		var pricenumber=[];
       		var root = $("#root").val();
            var productid = document.getElementById("productId").value;
            var ceoProducttransactionreport = new Object();
            ceoProducttransactionreport.productid = productid;
            $.ajax({
                type : 'post',
                contentType : 'application/json;charset=utf-8',        //返回数据形式为json
                url : root+'/ceo/threeproduct.action',    
                data : JSON.stringify(ceoProducttransactionreport),
                success : function(result) {
                     //请求成功时执行该函数内容，result即为服务器返回的json对象
                    if (result) {                 		                           
                            for(var i=0;i<result.length;i++){
                            	buynumber.push({
                            		value:result[i].buynum,
                            		name:result[i].stringDate
                            	});
                     		}                       		
                            for(var i=0;i<result.length;i++){       
                            	pricenumber.push({
                            		value:result[i].getpricenum,
                            		name:result[i].stringDate
                            	});                       	                           	
                              }
                            threeChart.hideLoading();      //隐藏加载动画 
                            threeChart.setOption({        //加载数据图表                              
                                series: [
                                {
                                	name: '销售量',
                                	data : buynumber
                                },                                                        
                                {
                                	name: '总售价',
                                	data: pricenumber
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
                // 使用刚指定的配置项和数据显示图表。
            	threeChart.setOption(option);
        	//====================================================
            	var fourChart = echarts.init(document.getElementById('twocenter'));
            	
            	var option = {
            			title : {
                    		text: '商品年收入占比'
                		},
            			tooltip: {
            		        trigger: 'item',
            		        formatter: "{a} <br/>{b}: {c} ({d}%)"
            		    },
            		    legend: {
            		        orient: 'vertical',
            		        x: 'left',
            		        data:[]
            		    },
            		    series: [
            		        {
            		            name:'销售量',
            		            type:'pie',
            		            selectedMode: 'single',
            		            radius: [0, '30%'],

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
            		        },
            		        {
            		            name:'总售价',
            		            type:'pie',
            		            radius: ['40%', '55%'],
            		            label: {
            		                normal: {
            		                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
            		                    backgroundColor: '#eee',
            		                    borderColor: '#aaa',
            		                    borderWidth: 1,
            		                    borderRadius: 4,
            		                    // shadowBlur:3,
            		                    // shadowOffsetX: 2,
            		                    // shadowOffsetY: 2,
            		                    // shadowColor: '#999',
            		                    // padding: [0, 7],
            		                    rich: {
            		                        a: {
            		                            color: '#999',
            		                            lineHeight: 22,
            		                            align: 'center'
            		                        },
            		                        // abg: {
            		                        //     backgroundColor: '#333',
            		                        //     width: '100%',
            		                        //     align: 'right',
            		                        //     height: 22,
            		                        //     borderRadius: [4, 4, 0, 0]
            		                        // },
            		                        hr: {
            		                            borderColor: '#aaa',
            		                            width: '100%',
            		                            borderWidth: 0.5,
            		                            height: 0
            		                        },
            		                        b: {
            		                            fontSize: 16,
            		                            lineHeight: 33
            		                        },
            		                        per: {
            		                            color: '#eee',
            		                            backgroundColor: '#334455',
            		                            padding: [2, 4],
            		                            borderRadius: 2
            		                        }
            		                    }
            		                }
            		            },
            		            data:[]
            		        }
            		    ]
            	};
            	fourChart.showLoading();
           		var buy=[];
           		var priceno=[];
           		var root = $("#root").val();
                var productid = document.getElementById("productId").value;
                var ceoProducttransactionreport = new Object();
                ceoProducttransactionreport.productid = productid;
                $.ajax({
                    type : 'post',
                    contentType : 'application/json;charset=utf-8',        //返回数据形式为json
                    url : root+'/ceo/fourproduct.action',    
                    data : JSON.stringify(ceoProducttransactionreport),
                    success : function(result) {
                         //请求成功时执行该函数内容，result即为服务器返回的json对象
                        if (result != 0) {                 		                               
                                for(var i=0;i<result.length;i++){
                                	buy.push({
                                		value: result[i].buyString,
                                		name: result[i].dateString
                                	});
                         		}  
                                for(var i=0;i<result.length;i++){       
                                	priceno.push({
                                		value: result[i].sumtotalPrice,
                                		name: result[i].dateString
                                	});                       	                               	
                                  }
                                fourChart.hideLoading();      //隐藏加载动画 
                                fourChart.setOption({        //加载数据图表                                   	
                                    series: [
                                    {
                                    	name: '销售量',
                                    	data : buy
                                    },                        
                                    {
                                    	name: '总售价',
                                    	data: priceno
                                    }                                   
                                    ]
                                });                   
                         }   else{
                        	 fourChart.hideLoading();      //隐藏加载动画 
                        	 alert("该商品还没有收入记录！");
                         }      
                    },
                     error : function(errorMsg) {
                         //请求失败时执行该函数
                     alert("图表请求数据失败!");
                     fourChart.hideLoading();
                     }
                	});	 
                    // 使用刚指定的配置项和数据显示图表。
                	fourChart.setOption(option);
});







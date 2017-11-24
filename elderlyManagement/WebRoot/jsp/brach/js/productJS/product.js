function sailProduct(){
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
			myChart121.hideLoading();      //隐藏加载动画
            myChart121.setOption({ //加载数据图表
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
	
	var myChart121 = echarts.init(document.getElementById('productChart'));
    var option121 = {
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
      myChart121.showLoading();
      // 使用刚指定的配置项和数据显示图表。
      myChart121.setOption(option121);
}

function line(){
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
			myChart122.hideLoading();      //隐藏加载动画
            myChart122.setOption({ //加载数据图表
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
	
	var myChart122 = echarts.init(document.getElementById('lineChart'));
	var option122 = {
		    backgroundColor: '#FFFFFF',
		    title: {
    	        text: '产品销量走势'
    	    },
		    tooltip: {
		        trigger: 'axis', //触发类型。[ default: 'item' ] :数据项图形触发，主要在散点图，饼图等无类目轴的图表中使用;'axis'坐标轴触发，主要在柱状图，折线图等会使用类目轴的图表中使用
		        axisPointer: {
		            lineStyle: {
		                color: '#57617B'
		            }
		        }
		    },
		    legend: {
		        icon: 'rect', //设置图例的图形形状，circle为圆，rect为矩形
		        itemWidth: 14, //图例标记的图形宽度[ default: 25 ] 
		        itemHeight: 5, //图例标记的图形高度。[ default: 14 ] 
		        itemGap: 13, //图例每项之间的间隔。横向布局时为水平间隔，纵向布局时为纵向间隔。[ default: 10 ] 
		        data: ['移动', '电信', '联通'],
		        right: '4%', //图例组件离容器右侧的距离
		        textStyle: {
		            fontSize: 12,
		            color: '#F1F1F3'
		        }
		    },
		    grid: {
		        left: '3%', //grid 组件离容器左侧的距离。
		        right: '4%', //grid 组件离容器右侧的距离。
		        bottom: '3%', //grid 组件离容器下侧的距离。
		        containLabel: true //grid 区域是否包含坐标轴的刻度标签[ default: false ] 
		    },
		    xAxis: [{
		        type: 'category',
		        boundaryGap: false, //坐标轴两边留白策略，类目轴和非类目轴的设置和表现不一样
		        axisLine: {
		            lineStyle: {
		                color: '#57617B' //坐标轴线线的颜色。
		            }
		        },
		        data: []   //动态传值
		    }],
		    yAxis: [{
		        type: 'value', //坐标轴类型。'value' 数值轴，适用于连续数据;'category' 类目轴，适用于离散的类目数据，为该类型时必须通过 data 设置类目数据;'time' 时间轴;'log' 对数轴.
		        name: '销量（件）', //坐标轴名称。
		        axisTick: {
		            show: false //是否显示坐标轴刻度
		        },
		        axisLine: {
		            lineStyle: {
		                color: '#57617B' //坐标轴线线的颜色
		            }
		        },
		        axisLabel: {
		            margin: 10, //刻度标签与轴线之间的距离
		            textStyle: {
		                fontSize: 14 //文字的字体大小
		            }
		        },
		        splitLine: {
		            lineStyle: {
		                color: '#57617B' //分隔线颜色设置
		            }
		        }
		    }],
		    series: [{
		        name: '联通',
		        type: 'line',
		        smooth: true,
		        symbol: 'circle',
		        symbolSize: 5,
		        showSymbol: false,
		        lineStyle: {
		            normal: {
		                width: 1
		            }
		        },
		        areaStyle: {
		            normal: {
		                color: new echarts.graphic.LinearGradient(0, 0, 0, 1, [{
		                    offset: 0,
		                    color: 'rgba(219, 50, 51, 0.3)'
		                }, {
		                    offset: 0.8,
		                    color: 'rgba(219, 50, 51, 0)'
		                }], false),
		                shadowColor: 'rgba(0, 0, 0, 0.1)',
		                shadowBlur: 10
		            }
		        },
		        itemStyle: {
		            normal: {
		                color: 'rgb(219,50,51)',
		                borderColor: 'rgba(219,50,51,0.2)',
		                borderWidth: 12
		            }
		        },
		        data: []     //动态传值
		    }, ]
		};;
		  myChart122.showLoading();
	      // 使用刚指定的配置项和数据显示图表。
	      myChart122.setOption(option122);
}

function pie(){
	
	var root = $("#root").val();
	var productid = document.getElementById("productId").value;
	var startingTime = document.getElementById("begin").value;
	var endTime = document.getElementById("end").value;
	var productTranctionReportCustom = new Object();
	productTranctionReportCustom.productid = productid;
	productTranctionReportCustom.startingTime = startingTime;
	productTranctionReportCustom.endTime = endTime;
	
	 var myChart123 = echarts.init(document.getElementById('pie1Chart'));
	 var myChart124 = echarts.init(document.getElementById('pie2Chart'));
	 myChart123.showLoading();
	 myChart124.showLoading();
	 $.ajax({
			type : 'post',
			url : root+'/brach/pie.action',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(productTranctionReportCustom),
			success : function(data) {
				/*data.oneSail;data.totalSail;*/
				haha123(data);
				myChart123.setOption(option123);
				myChart123.hideLoading();
				haha124(data);
				myChart124.setOption(option124);
				myChart124.hideLoading();
			}
	        }) ;
			}
		
	 
	
	
	 function haha123(data){
		var a= data.totalSail - data.oneSail;
	     // 使用刚指定的配置项和数据显示图表。
		 option123 = {
				    title: {
				        text: '商品销售占比',
				        subtext: '所选区间',
				        x: 'center',
				        y: '10%'
				    },
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color: ['red', 'green'],
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        y: '30%',
				        data: ['所选商品', '其他商品']
				    },
				    series: [{
				        name: '销售情况',
				        type: 'pie',
				        radius: '50%',
				        center: ['50%', '70%'],
				        data: [{
				                value: data.oneSail,
				                name: '所选商品'
				            }, {
				                value: a,
				                name: '其他商品'
				            },

				        ],
				        itemStyle: {
				            emphasis: {
				                show: true,
				                fontSize: '20',
				            }
				        },
				        label: {
				            emphasis: {
				                show: true,
				                textStyle: {
				                    fontSize: '20',
				                    fontWeight: 'bold'
				                }
				            },
				        },
				    }]
				};
	 }
	
	 
	
     function haha124(data){
 		var a= data.totalprice - data.oneSail;
 	     // 使用刚指定的配置项和数据显示图表。
 		 option124 = {
 				    title: {
 				        text: '商品销售占比',
 				        subtext: '所选商品',
 				        x: 'center',
 				        y: '10%'
 				    },
 				    tooltip: {
 				        trigger: 'item',
 				        formatter: "{a} <br/>{b} : {c} ({d}%)"
 				    },
 				    color: ['red', 'green'],
 				    legend: {
 				        orient: 'vertical',
 				        x: 'left',
 				        y: '30%',
 				        data: ['所选区间', '其他区间']
 				    },
 				    series: [{
 				        name: '销售情况',
 				        type: 'pie',
 				        radius: '50%',
 				        center: ['50%', '70%'],
 				        data: [{
 				                value: data.oneSail,
 				                name: '所选区间'
 				            }, {
 				                value: a,
 				                name: '其他区间'
 				            },

 				        ],
 				        itemStyle: {
 				            emphasis: {
 				                show: true,
 				                fontSize: '20',
 				            }
 				        },
 				        label: {
 				            emphasis: {
 				                show: true,
 				                textStyle: {
 				                    fontSize: '20',
 				                    fontWeight: 'bold'
 				                }
 				            },
 				        },
 				    }]
 				};
 	 }	


function total(){
	var all = {};
	all.product = sailProduct;
	all.line = line;
	all.pie = pie;
	
	all.line();
	all.product();
	all.pie();
	
}


function totalOrders(){
	var root = $("#root").val();
	var startingTime = document.getElementById("begin").value;
	var endTime = document.getElementById("end").value;
	var OrdersCustom = new Object();
	OrdersCustom.start = startingTime;
	OrdersCustom.end = endTime;
	
	 var myChart = echarts.init(document.getElementById('pie'));
	 myChart.showLoading();
	 
	 $.ajax({
			type : 'post',
			url : root+'/brach/orderReportCondition.action',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(OrdersCustom),
			success : function(data) {
				haha(data);
				myChart.setOption(option);
				myChart.hideLoading();
			}
	        }) ;
			}
	
	 function haha(data){
	     // 使用刚指定的配置项和数据显示图表。
		 option = {
				    title: {
				        text: '商品收支占比',
				        subtext: '所选区间',
				        x: 'center',
				        y: '10%'
				    },
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color: ['red', 'green'],
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        y: '30%',
				        data: ['商品收入（￥元）', '商品支出（￥元）']
				    },
				    series: [{
				        name: '销售情况',
				        type: 'pie',
				        radius: '50%',
				        center: ['50%', '70%'],
				        data: [{
				                value: data.totalIncome,
				                name: '商品收入（￥元）'
				            }, {
				                value: data.totalexl,
				                name: '商品支出（￥元）'
				            },

				        ],
				        itemStyle: {
				            emphasis: {
				                show: true,
				                fontSize: '20',
				            }
				        },
				        label: {
				            emphasis: {
				                show: true,
				                textStyle: {
				                    fontSize: '20',
				                    fontWeight: 'bold'
				                }
				            },
				        },
				    }]
				};
}

	 //allActReport
function allActReport(){
	var root = $("#root").val();
	var startingTime = document.getElementById("begin").value;
	var endTime = document.getElementById("end").value;
	var OrdersCustom = new Object();
	OrdersCustom.start = startingTime;
	OrdersCustom.end = endTime;
	
	 var myChart1 = echarts.init(document.getElementById('Actpie1'));
	 var myChart2 = echarts.init(document.getElementById('Actpie2'));
	 var myChart3 = echarts.init(document.getElementById('Actpie3'));
	 myChart1.showLoading();
	 myChart2.showLoading();
	 myChart3.showLoading();
	 
	 $.ajax({
			type : 'post',
			url : root+'/brach/allActReport.action',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(OrdersCustom),
			success : function(data) {
				haha1(data);
				haha2(data);
				haha3(data);
				myChart1.setOption(option1);
				myChart2.setOption(option2);
				myChart3.setOption(option3);
				myChart1.hideLoading();
				myChart2.hideLoading();
				myChart3.hideLoading();
				
			}
	        }) ;
			}
	
	 function haha1(data){      //健康总报表
	     // 使用刚指定的配置项和数据显示图表。
		 option1 = {
				    title: {
				        text: '健康模块收支占比',
				        subtext: '所选区间',
				        x: 'center',
				        y: '10%'
				    },
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color: ['red', 'green'],
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        y: '30%',
				        data: ['活动收入（￥元）', '活动支出（￥元）']
				    },
				    series: [{
				        name: '活动情况',
				        type: 'pie',
				        radius: '50%',
				        center: ['50%', '70%'],
				        data: [{
				                value: data.activityprice,
				                name: '活动收入（￥元）'
				            }, {
				                value: data.registeryfee,
				                name: '活动支出（￥元）'
				            },

				        ],
				        itemStyle: {
				            emphasis: {
				                show: true,
				                fontSize: '20',
				            }
				        },
				        label: {
				            emphasis: {
				                show: true,
				                textStyle: {
				                    fontSize: '20',
				                    fontWeight: 'bold'
				                }
				            },
				        },
				    }]
				};
}

	 function haha2(data){     //教育总报表
	     // 使用刚指定的配置项和数据显示图表。
		 option2 = {
				    title: {
				        text: '教育模块收支占比',
				        subtext: '所选区间',
				        x: 'center',
				        y: '10%'
				    },
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color: ['red', 'green'],
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        y: '30%',
				        data: ['活动收入（￥元）', '活动支出（￥元）']
				    },
				    series: [{
				        name: '活动情况',
				        type: 'pie',
				        radius: '50%',
				        center: ['50%', '70%'],
				        data: [{
				                value: data.totalReg,
				                name: '活动收入（￥元）'
				            }, {
				                value: data.totalExpend,
				                name: '活动支出（￥元）'
				            },

				        ],
				        itemStyle: {
				            emphasis: {
				                show: true,
				                fontSize: '20',
				            }
				        },
				        label: {
				            emphasis: {
				                show: true,
				                textStyle: {
				                    fontSize: '20',
				                    fontWeight: 'bold'
				                }
				            },
				        },
				    }]
				};
		 
		 
		 
}
	 
	 function haha3(data){       //总活动报表
	     // 使用刚指定的配置项和数据显示图表。
		 option3 = {
				    title: {
				        text: '活动总收支占比',
				        subtext: '所选区间',
				        x: 'center',
				        y: '10%'
				    },
				    tooltip: {
				        trigger: 'item',
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    color: ['red', 'green'],
				    legend: {
				        orient: 'vertical',
				        x: 'left',
				        y: '30%',
				        data: ['活动收入（￥元）', '活动支出（￥元）']
				    },
				    series: [{
				        name: '活动情况',
				        type: 'pie',
				        radius: '50%',
				        center: ['50%', '70%'],
				        data: [{
				                value: data.totalIncome,
				                name: '活动收入（￥元）'
				            }, {
				                value: data.totalexl,
				                name: '活动支出（￥元）'
				            },

				        ],
				        itemStyle: {
				            emphasis: {
				                show: true,
				                fontSize: '20',
				            }
				        },
				        label: {
				            emphasis: {
				                show: true,
				                textStyle: {
				                    fontSize: '20',
				                    fontWeight: 'bold'
				                }
				            },
				        },
				    }]
				};
}
	 
	 
	 
	 
function allChart(){
			var root = $("#root").val();
			var startingTime = document.getElementById("begin").value;
			var endTime = document.getElementById("end").value;
			var OrdersCustom = new Object();
			OrdersCustom.start = startingTime;
			OrdersCustom.end = endTime;
			
			 var myChart11 = echarts.init(document.getElementById('Allpie1'));
			 var myChart22 = echarts.init(document.getElementById('Allpie2'));
			 var myChart33 = echarts.init(document.getElementById('Allpie3'));
			 myChart11.showLoading();
			 myChart22.showLoading();
			 myChart33.showLoading();
			 
			 $.ajax({
					type : 'post',
					url : root+'/brach/allChart.action',
					contentType : 'application/json;charset=utf-8',
					data : JSON.stringify(OrdersCustom),
					success : function(data) {
						haha11(data);
						haha22(data);
						haha33(data);
						myChart11.setOption(option11);
						myChart22.setOption(option22);
						myChart33.setOption(option33);
						myChart11.hideLoading();
						myChart22.hideLoading();
						myChart33.hideLoading();
						
					}
			        }) ;
					}
			
			 function haha11(data){      //健康总报表
			     // 使用刚指定的配置项和数据显示图表。
				 option11 = {
						    title: {
						        text: '活动收支占比',
						        subtext: '所选区间',
						        x: 'center',
						        y: '10%'
						    },
						    tooltip: {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    color: ['red', 'green'],
						    legend: {
						        orient: 'vertical',
						        x: 'left',
						        y: '30%',
						        data: ['活动收入（￥元）', '活动支出（￥元）']
						    },
						    series: [{
						        name: '活动情况',
						        type: 'pie',
						        radius: '50%',
						        center: ['50%', '70%'],
						        data: [{
						        	value: data.totalIncome,
					                name: '活动收入（￥元）'
					            }, {
					                value: data.totalexl,
					                name: '活动支出（￥元）'
						            },

						        ],
						        itemStyle: {
						            emphasis: {
						                show: true,
						                fontSize: '20',
						            }
						        },
						        label: {
						            emphasis: {
						                show: true,
						                textStyle: {
						                    fontSize: '20',
						                    fontWeight: 'bold'
						                }
						            },
						        },
						    }]
						};
		}

			 function haha22(data){     //教育总报表
			     // 使用刚指定的配置项和数据显示图表。
				 option22 = {
						    title: {
						        text: '商城收支占比',
						        subtext: '所选区间',
						        x: 'center',
						        y: '10%'
						    },
						    tooltip: {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    color: ['red', 'green'],
						    legend: {
						        orient: 'vertical',
						        x: 'left',
						        y: '30%',
						        data: ['商城收入（￥元）', '商城支出（￥元）']
						    },
						    series: [{
						        name: '商城情况',
						        type: 'pie',
						        radius: '50%',
						        center: ['50%', '70%'],
						        data: [{
						                value: data.demo2,
						                name: '商城收入（￥元）'
						            }, {
						                value: data.demo1,
						                name: '商城支出（￥元）'
						            },

						        ],
						        itemStyle: {
						            emphasis: {
						                show: true,
						                fontSize: '20',
						            }
						        },
						        label: {
						            emphasis: {
						                show: true,
						                textStyle: {
						                    fontSize: '20',
						                    fontWeight: 'bold'
						                }
						            },
						        },
						    }]
						};
				 
				 
				 
		}
			 
			 function haha33(data){       //总活动报表
			     // 使用刚指定的配置项和数据显示图表。
				 
				 var allIncome = data.totalIncome + data.demo2;
				 var allExl = data.totalexl + data.demo1;
				 option33 = {
						    title: {
						        text: '总收支占比',
						        subtext: '所选区间',
						        x: 'center',
						        y: '10%'
						    },
						    tooltip: {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    color: ['red', 'green'],
						    legend: {
						        orient: 'vertical',
						        x: 'left',
						        y: '30%',
						        data: ['收入（￥元）', '支出（￥元）']
						    },
						    series: [{
						        name: '总情况',
						        type: 'pie',
						        radius: '50%',
						        center: ['50%', '70%'],
						        data: [{
						                value:allIncome,
						                name: '收入（￥元）'
						            }, {
						                value: allExl,
						                name: '支出（￥元）'
						            },

						        ],
						        itemStyle: {
						            emphasis: {
						                show: true,
						                fontSize: '20',
						            }
						        },
						        label: {
						            emphasis: {
						                show: true,
						                textStyle: {
						                    fontSize: '20',
						                    fontWeight: 'bold'
						                }
						            },
						        },
						    }]
						};
		}
			 
			 
		/*$("#index").click(function(){
			alert(6);
			indexChart1 = echarts.init(document.getElementById('actAndPro1'));
			index();
		});*/

function index(){
	var root = $("#root").val();
	var productTranctionReportCustom = new Object();
	var indexChart = echarts.init(document.getElementById("actAndPro"));
	indexChart.showLoading();
	 $.ajax({
			type : 'post',
			url : root+'/brach/indexChart.action',
			contentType : 'application/json;charset=utf-8',
			data : JSON.stringify(productTranctionReportCustom),
			success : function(data) {
				indexline(data);
				indexChart.setOption(indexoption);
				indexChart.hideLoading();
			}
	 });
	
}

function indexline(data){
	var all = data.oneSail+data.totalprice;
	indexoption = {
		    backgroundColor: "#404A59",
		    color: ['#ffd285', '#ff733f', '#ec4863'],

		    title: [{
		        text: '近期分店活动和商城盈利情况',
		        left: '1%',
		        top: '6%',
		        textStyle: {
		            color: '#fff'
		        }
		    }, {
		        text: '盈利占比',
		        left: '83%',
		        top: '6%',
		        textAlign: 'center',
		        textStyle: {
		            color: '#fff'
		        }
		    }],
		    tooltip: {
		        trigger: 'axis'
		    },
		    legend: {
		        x: 300,
		        top: '7%',
		        textStyle: {
		            color: '#ffd285',
		        },
		        data: ['活动盈利情况', '商城盈利情况']
		    },
		    grid: {
		        left: '1%',
		        right: '35%',
		        top: '16%',
		        bottom: '6%',
		        containLabel: true
		    },
		    toolbox: {
		        "show": false,
		        feature: {
		            saveAsImage: {}
		        }
		    },
		    xAxis: {
		        type: 'category',
		        "axisLine": {
		            lineStyle: {
		                color: '#FF4500'
		            }
		        },
		        "axisTick": {
		            "show": false
		        },
		        axisLabel: {
		            textStyle: {
		                color: '#fff'
		            }
		        },
		        boundaryGap: false,
		        data: data.buyTime
		    },
		    yAxis: {
		        "axisLine": {
		            lineStyle: {
		                color: '#fff'
		            }
		        },
		        splitLine: {
		            show: true,
		            lineStyle: {
		                color: '#fff'
		            }
		        },
		        "axisTick": {
		            "show": false
		        },
		        axisLabel: {
		            textStyle: {
		                color: '#fff'
		            }
		        },
		        type: 'value'
		    },
		    series: [{
		        name: '活动盈利情况',
		        smooth: true,
		        type: 'line',
		        symbolSize: 8,
		      	symbol: 'circle',
		        data: data.countSail
		    }, {
		        name: '商城盈利情况',
		        type: 'line',
		        symbolSize: 8,
		      	symbol: 'circle',
		        data: data.countBuy
		    }, 
		    {
	            type: 'pie',
	            center: ['83%', '35%'],
	            radius: ['25%', '30%'],
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b} : {c} ({d}%)"
	            },
	            label: {
	                normal: {
	                    position: 'center'
	                }
	            },
	            data: [{
	                value: data.oneSail,
	                name: '活动盈利占比 ',
	                itemStyle: {
	                    normal: {
	                        color: '#ffd285'
	                    }
	                },
	                label: {
	                    normal: {
	                        formatter: '{d} %',
	                        textStyle: {
	                            color: '#ffd285',
	                            fontSize: 20

	                        }
	                    }
	                }
	            }, {
	                value: data.totalprice,
	               
	                tooltip: {
	                    show: false
	                },
	                itemStyle: {
	                    normal: {
	                        color: '#404A59'
	                    }
	                },
	                label: {
	                    normal: {
	                        textStyle: {
	                            color: '#ffd285',
	                        },
	                        formatter: '\n活动盈利比例 '
	                    }
	                }
	            }]
	        }, 


	        {
	            type: 'pie',
	            center: ['83%', '75%'],
	            radius: ['25%', '30%'],
	            tooltip: {
	                trigger: 'item',
	                formatter: "{a} <br/>{b} : {c} ({d}%)"
	            },
	            label: {
	                normal: {
	                    position: 'center'
	                }
	            },
	            data: [{
	                value: data.totalprice,
	                name: '商城盈利占比 ',
	                itemStyle: {
	                    normal: {
	                        color: '#ff733f'
	                    }
	                },
	                label: {
	                    normal: {
	                        formatter: '{d} %',
	                        textStyle: {
	                            color: '#ff733f',
	                            fontSize: 20

	                        }
	                    }
	                }
	            }, {
	                value: data.oneSail,
	               
	                tooltip: {
	                    show: false
	                },
	                itemStyle: {
	                    normal: {
	                        color: '#404A59'
	                    }
	                },
	                label: {
	                    normal: {
	                        textStyle: {
	                            color: '#ff733f',
	                        },
	                        formatter: '\n商城盈利比例 '
	                    }
	                }
	            }]
	        }]
		};
}
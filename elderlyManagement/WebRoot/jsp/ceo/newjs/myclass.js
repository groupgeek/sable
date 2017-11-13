$(document).ready(function(){
var myChart = echarts.init(document.getElementById('main'));
    	
var option = {
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
            name:'',
            type:'pie',
            /*selectedMode: 'single',
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
            },*/
            data:[
                 
            ]
        },
        /*{
            name:'访问来源',
            type:'pie',
            radius: ['40%', '55%'],
            label: {
                normal: {
                    formatter: '{a|{a}}{abg|}\n{hr|}\n  {b|{b}：}{c}  {per|{d}%}  ',
                    backgroundColor: '#eee',
                    borderColor: '#aaa',
                    borderWidth: 1,
                    borderRadius: 4,
                     shadowBlur:3,
                     shadowOffsetX: 2,
                     shadowOffsetY: 2,
                     shadowColor: '#999',
                     padding: [0, 7],
                    rich: {
                        a: {
                            color: '#999',
                            lineHeight: 22,
                            align: 'center'
                        },
                         abg: {
                             backgroundColor: '#333',
                             width: '100%',
                             align: 'right',
                             height: 22,
                             borderRadius: [4, 4, 0, 0]
                         },
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
            data:[
                {value:335, name:'直达'},
                {value:310, name:'邮件营销'},
                {value:234, name:'联盟广告'},
                {value:135, name:'视频广告'},
                {value:1048, name:'百度'},
                {value:251, name:'谷歌'},
                {value:147, name:'必应'},
                {value:102, name:'其他'}
            ]
        }*/
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
url : root+'/ceo/Test.action',    
data : '{}',
contentType : 'application/json;charset=utf-8',        //返回数据形式为json
success : function(result) {
     //请求成功时执行该函数内容，result即为服务器返回的json对象
    if (result) {
     		
            for(var i=0;i<result.length;i++){       
               times.push(result[i].sumBigDecimal);    
             }                     
            for(var i=0;i<result.length;i++){
     			bigdecimal.push(result[i].branchname);
     		}
            /*for(var i=0;i<result.listPCustoms.length;i++ ){
     			money.push(result.listPCustoms[i]);
     		}
     		for(var i=0;i<result.listActivities.length;i++){
     			toprices.push(result.listActivities[i]);
     		}
            for(var i=0;i<result.listregisery.length;i++){       
                getprices.push(result.listregisery[i]); 
              }*/
            myChart.hideLoading();      //隐藏加载动画 
            myChart.setOption({        //加载数据图表
            	legend: {  
                    data: bigdecimal
                   },  
                series: {
                         name:'分店',
                         data:times
                }
               /* {
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
                }*/
                
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
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'Test.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/js/echarts.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

	<style type="text/css">
		#header{
			padding-top:20px;
			height:500px;
			width:100%;
			
		}
		#chartmain{
			
			padding:20px;
			height:100%;
			width:47%;
			float:left;
		}
		#main{
			padding:20px;
			height:100%;
			width:47%;
			float:left;
		}
		
	</style>
	
  </head>
  
  <body>
  		<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
  		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-1.9.1.min.js"></script>
    <div id="header">
    	<div id="chartmain"></div>
    	<div id="main"></div>
    </div>
    <script type="text/javascript">
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
            name:'盈利占比',
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
        } 
    ]
};
		myChart.showLoading();	
		var times=[];    //类别数组（实际用来盛放X轴坐标值）
     	/* var bigdecimal=[]; */
     	/* var money=[];
     	var toprices=[];
        var getprices=[]; */    //销量数组（实际用来盛放Y坐标值）
       /*  var root = $("#root").val(); */
        $.ajax({
        type : 'post',
        async : true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
        url : '${pageContext.request.contextPath }/ceo/Test.action',    
        data : '{}',
        contentType : 'application/json;charset=utf-8',        //返回数据形式为json
        success : function(result) {
             //请求成功时执行该函数内容，result即为服务器返回的json对象
            if (result) {
             		
                    for(var i=0;i<result.length;i++){       
                       times.push({
                       value:result[i].sumBigDecimal,
                       name:result[i].branchname                      
                       });    
                     }                                        
                    myChart.hideLoading();      //隐藏加载动画 
                    myChart.setOption({        //加载数据图表
                       	
                        series: [
                        {
                        	data:times
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
    </script>
  </body>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'GridManager.jsp' starting page</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/comm/GridManager_2.3.14/css/GridManager.min.css">
    <script src="${pageContext.request.contextPath}/jsp/comm//GridManager_2.3.14/js/GridManager.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/jsp/js/jquery-3.2.1.min.js" type="text/javascript"></script> 
	 <style>
        body{
            width: 100%;
            /*height: 100%;*/
            overflow-x:hidden;
            margin: 0px;
            padding: 0px;
        }
        .plugin-action{
            display: inline-block;
            color: steelblue;
            margin-right: 10px;
            cursor: pointer;
        }
        .plugin-action:hover{
            text-decoration:underline;
        }
        .search-area{
            padding: 10px 20px;
            border: 1px solid #ccc;
            background: #efefef;
        }
        .search-area .sa-ele{
            display: inline-block;
            margin-right: 20px;
            font-size: 12px;
        }
        .search-area .sa-ele .se-title{
            display: inline-block;
            margin-right: 10px;
        }
        .search-area .sa-ele .se-con{
            display: inline-block;
            width:180px;
            height: 24px;
            border: 1px solid #ccc;
            padding: 0px 4px;
            line-height: 24px;
        }
        .search-area .sa-ele .search-action, .search-area .sa-ele .reset-action{
            display: inline-block;
            width:80px;
            height: 26px;
            border: 1px solid #ccc;
            background: #e8e8e8;
            padding: 0px 4px;
            line-height: 26px;
            text-align: center;
            cursor: pointer;
            margin-right: 10px;
        }
        .search-area .sa-ele .search-action:hover, .search-area .sa-ele .reset-action:hover{
            opacity: 0.7;
        }
    </style>
  </head>
  
  <body>
  <div class="search-area">
		<div class="sa-ele">
			<label class="se-title">id:</label>
			<input class="se-con" name="commonsenseid">
		</div>
		<div class="sa-ele">
			<label class="se-title">标题:</label>
			<input class="se-con" name="title">
		</div>
		<div class="sa-ele">
			<label class="se-title">类别:</label>
			<input class="se-con" name="websitetype">
		</div>
		<div class="sa-ele">
			<button id="search-action">搜索</button>
			<button class="reset-action">重置</button>
		</div>
	</div>
 <br/>
   <table id ='soft_table' grid-manager="demo-baseCode" style="table-layout: auto"></table>
  
    <script type="text/javascript">
     var table = document.querySelector('table[grid-manager="demo-baseCode"]');
    var TGM = table.GM({
        supportRemind: true
        ,gridManagerName: 'test'
        ,isCombSorting: true
        ,height: '400px'
        ,supportAjaxPage:true
        ,supportSorting: true
        ,disableCache: false
        ,ajax_url: 'http://127.0.0.1:8080/elderlyManagement/Commonsense/griddemo'
        ,ajax_type: 'POST'
        ,query: {pluginId: 1}
		,textAlign: 'center'
        ,pageSize:30
        ,columnData: [
            {
                key: 'commonsenseid',
                text: '文章id',
                    sorting: 'SAC'
            },{
                key: 'title',
                text: '标题',
                    sorting: ''
            },{
                key: 'websitetype',
                text: '类别'
            },{
                key: 'context',
                text: '内容',
                 sorting: ''
            },{
                key: 'createtime',
                text: '时间'
            },{
            key: 'operation',
            text: '操作',
            template: function(title, rowObject){
                return '<a class="plugin-action edit-action" href="/elderlyManagement/Commonsense/deleteCommonsense/'+rowObject.commonsenseid+'" >删除</a>';
            }}
        ]
        // 分页前事件
        ,pagingBefore: function(query){
            console.log('pagingBefore', query);
        }
        // 分页后事件
        ,pagingAfter: function(data){
            console.log('pagingAfter', data);
        }
        // 排序前事件
        ,sortingBefore: function (data) {
            console.log('sortBefore', data);
        }
        // 排序后事件
        ,sortingAfter: function (data) {
            console.log('sortAfter', data);
        }
        // 宽度调整前事件
        ,adjustBefore: function (event) {
            console.log('adjustBefore', event);
        }
        // 宽度调整后事件
        ,adjustAfter: function (event) {
            console.log('adjustAfter', event);
        }
        // 拖拽前事件
        ,dragBefore: function (event) {
            console.log('dragBefore', event);
        }
        // 拖拽后事件
        ,dragAfter: function (event) {
            console.log('dragAfter', event);
        }
    }, function(query){
        // 渲染完成后的回调函数
        console.log(query);
    });
    console.log('GirdManger version => ', TGM.version)
    // 绑定搜索事件
    document.getElementById('search-action').addEventListener('click', function () {
        var _query = {
        		commonsenseid: document.querySelector('[name="commonsenseid"]').value,
        		title: document.querySelector('[name="title"]').value,
        		websitetype: document.querySelector('[name="websitetype"]').value,
            
        };
        table.GM('setQuery', _query).GM('refreshGrid', function () {
            console.log('搜索成功...');
        });
    });
    // 绑定重置
    document.querySelector('.reset-action').addEventListener('click', function () {
        document.querySelector('[name="commonsenseid"]').value = '';
        document.querySelector('[name="title"]').value = '';
        document.querySelector('[name="websitetype"]').value = '';
       
    });
   
</script>
  </body>
</html>

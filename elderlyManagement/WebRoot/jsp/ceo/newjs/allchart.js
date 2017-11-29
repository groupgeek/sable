$(document).ready(function(){
	var root = $("#root").val();
	var search = "";
	var searchofact = "";
	var currentPage = 1;
	var currentPageofactivity = 1;
	var pageNum = $("#selectPageNum").attr("value");
	var pageNumofact = $("#selectPageNumofactivity").attr("value");
	var sort = $("#selectSort").val();
	var sortofactivity = $("#selectSortofactivity").val();
	var branchid = $("#branchchart").val();

	function createproductTable(data) {
		if(data.lisproductchart != ""){
		for(var i=0;i<data.lisproductchart.length;i++){
			$("#box tbody").append(
				'<tr>'+
					'<td style="text-valign:center;">'+(data.lisproductchart)[i].productname+'</td>'+
					'<td class="center">'+(data.lisproductchart)[i].branchname+'</td>'+
					'<td class="center">'+(data.lisproductchart)[i].price+'</td>'+
					'<td class="center">'+(data.lisproductchart)[i].buynum+'</td>'+
					'<td class="center">'+(data.lisproductchart)[i].getprice+'</td>'+
					'<td class="center">'+										
						'<a class="btn btn-info" href="'+root+'/ceo/chart.action?id='+(data.lisproductchart)[i].productid+'">'+
						'<i class="halflings-icon white zoom-in"></i>'+
							
					'</td>'+
				'</tr>'
			);
		}
		}else{
			$("#box tbody").append(
					'<tr>'+
						'<td colspan="6">'+"没有找到数据！"+'</td>'+						
					'</tr>'
				);
		}
	}
	
	function createactivityTable(data) {
		if(data.listactivity != ""){
			for(var i = 0;i<data.listactivity.length;i++ ){	
				$("#actchart tbody").append(
					'<tr>'+
						'<td>'+data.listactivity[i].activityname+'</td>'+
						'<td class="center">'+data.listactivity[i].branchname+'</td>'+
						'<td class="center">'+data.listactivity[i].totalprice+'</td>'+
						'<td class="center">'+data.listactivity[i].totalexpenditure+'</td>'+
						'<td class="center">'+data.listactivity[i].averagepeople+'</td>'+
						'<td class="center">'+										
							'<a class="btn btn-info" href="'+root+'/ceo/activitychart.action?id='+data.listactivity[i].activityid+'">'+
							'<i class="halflings-icon white zoom-in"></i>'+
										
						'</td>'+
					'</tr>'
			
		
				);
			}
		}else{
			$("#actchart tbody").append(
				'<tr>'+
					'<td colspan="6">'+"没有找到数据！"+'</td>'+	
				'</tr>'
			);
		}
	}

	function queryData(){
		pageNum = $("#selectPageNum").attr("value");
		sort = $("#selectSort").attr("value");
		search = $("#search").val();
		currentPage = 1;
		branchid = $("#branchchart").val();
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/ceo/allchartofproduct.action",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"sort"'+':'+'"'+sort+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'
        			+'}',
			success:function(data){
				$("#box tbody").html("");
				$("#home").attr("value",1);
				$("#previousPage").attr("value",1);
				$("#nextPage").attr("value",1);
				$("#lastPage").attr("value",data.pageSum);
				$("#pageSum").text(data.pageSum);
				$("#currentPage").text(currentPage);
				createproductTable(data);
			}
		});
	}
	
	function activityData() {
		pageNumofact = $("#selectPageNumofactivity").attr("value");
		sortofactivity = $("#selectSortofactivity").val();
		searchofact = $("#searchofactivity").val();
		currentPageofactivity = 1;
		branchid = $("#branchchart").val();
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/ceo/actcharts.action",
			data:'{"searchofact"'+':'+'"'+searchofact+'"'+','
			+'"currentPageofactivity"'+':'+'"'+currentPageofactivity+'"'+','
			+'"pageNumofact"'+':'+'"'+pageNumofact+'"'+','
			+'"sortofactivity"'+':'+'"'+sortofactivity+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'
        			+'}',
			success:function(data){
				$("#actchart tbody").html("");
				$("#homeofact").attr("value",1);
				$("#previousPageofact").attr("value",1);
				$("#nextPageofact").attr("value",1);
				$("#lastPageofact").attr("value",data.pageNumofact);
				$("#pageNumofact").text(data.pageNumofact);
				$("#currentPageofactivity").text(currentPageofactivity);
				createactivityTable(data);
			}
		});
	}
	
	//第一次进入
	
	
	var condition = new Object();
	condition.search = search;
	condition.currentPage = currentPage;
	condition.pageNum = pageNum;
	condition.sort = sort;
	condition.branchid=branchid;
	$.ajax({

		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/ceo/allchartofproduct.action",
		data:JSON.stringify(condition),
		success:function(data){
			$("#box tbody").html("");
			$("#home").attr("value",1);
			$("#previousPage").attr("value",1);
			$("#nextPage").attr("value",1);
			$("#lastPage").attr("value",data.pageSum);
			$("#pageSum").text(data.pageSum);
			createproductTable(data);
		}
	});
	var ceoActivityreport = new Object();
	ceoActivityreport.searchofact = searchofact;
	ceoActivityreport.currentPageofactivity = currentPageofactivity;
	ceoActivityreport.pageNumofact = pageNumofact;
	ceoActivityreport.sortofactivity = sortofactivity;
	ceoActivityreport.branchid=branchid;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/ceo/actcharts.action",
		data:JSON.stringify(ceoActivityreport),
		success:function(data){
			$("#actchart tbody").html("");
			$("#homeofact").attr("value",1);
			$("#previousPageofact").attr("value",1);
			$("#nextPageofact").attr("value",1);
			$("#lastPageofact").attr("value",data.pageNumofact);
			$("#pageNumofact").text(data.pageNumofact);
			createactivityTable(data);
		}
	});
	
	//事件开始
	//搜索框事件
	$("#search").bind('input propertychange', function(){
		queryData();
	});
	$("#searchofactivity").bind('input propertychange', function() {
		activityData();
	});
	
	//排序
	$("#selectSort").change(function(){
		queryData();
	});
	$("#selectSortofactivity").change(function() {
		activityData();
	});
	
	//每页显示 排序 事件
	$("#selectPageNum").change(function(){
		queryData();
	});
	$("#selectPageNumofactivity").change(function() {
		activityData();
	});
	
	$("#branchchart").change(function(){
		queryData();
		activityData();
	});
	
	//分页事件
	$("#pageUl li").click(function(){
		
		if("previousPage" == $(this).attr("id")){
			if(currentPage > 1){
				$(this).attr("value",currentPage-1);
				$("#nextPage").attr("value",currentPage-1);
			}
		}
		if("nextPage" == $(this).attr("id")){
			if($(this).attr("value") < $("#lastPage").attr("value")){
				$(this).attr("value",currentPage+1);
				$("#previousPage").attr("value",currentPage+1);
			}
		}
		if("home" == $(this).attr("id")){
			$("#nextPage").attr("value",1);
			$("#previousPage").attr("value",1);
		}
		if("lastPage" == $(this).attr("id")){
			$("#nextPage").attr("value",$(this).attr("value"));
			$("#previousPage").attr("value",$(this).attr("value"));
			
		}
		currentPage = $(this).attr("value");
		//queryData();
		pageNum = $("#selectPageNum").attr("value");
		sort = $("#selectSort").attr("value");
		sortofactivity = $("#selectSortofactivity").val();
		search = $("#search").val();
		branchid = $("#branchchart").val();
		
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/ceo/allchartofproduct.action",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"sort"'+':'+'"'+sort+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'
        			+'}',
			success:function(data){
				$("#box tbody").html("");
				//$("#home").attr("value",1);
				//$("#lastPage").attr("value",data.pageSum);
				createproductTable(data);
			}
		});
		
		$("#currentPage").text(currentPage);
	});
	
	
	$("#pageofactUl li").click(function(){
		
		if("previousPageofact" == $(this).attr("id")){
			if(currentPageofactivity > 1){
				$(this).attr("value",currentPageofactivity-1);
				$("#nextPageofact").attr("value",currentPageofactivity-1);
			}
		}
		if("nextPageofact" == $(this).attr("id")){
			if($(this).attr("value") < $("#lastPageofact").attr("value")){
				$(this).attr("value",currentPageofactivity+1);
				$("#previousPageofact").attr("value",currentPageofactivity+1);
			}
		}
		if("homeofact" == $(this).attr("id")){
			$("#nextPageofact").attr("value",1);
			$("#previousPageofact").attr("value",1);
		}
		if("lastPageofact" == $(this).attr("id")){
			$("#nextPageofact").attr("value",$(this).attr("value"));
			$("#previousPageofact").attr("value",$(this).attr("value"));
			
		}
		currentPageofactivity = $(this).attr("value");
		//queryData();
		pageNumofact = $("#selectPageNumofactivity").attr("value");
		sortofactivity = $("#selectSortofactivity").val();
		searchofact = $("#searchofactivity").val();
		branchid = $("#branchchart").val();	
		
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/ceo/actcharts.action",
			data:'{"searchofact"'+':'+'"'+searchofact+'"'+','
			+'"currentPageofactivity"'+':'+'"'+currentPageofactivity+'"'+','
			+'"pageNumofact"'+':'+'"'+pageNumofact+'"'+','
			+'"sortofactivity"'+':'+'"'+sortofactivity+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'
        			+'}',
			success:function(data){
				$("#actchart tbody").html("");
				//$("#home").attr("value",1);
				//$("#lastPage").attr("value",data.pageSum);
				createactivityTable(data);
			}
		});
		$("#currentPageofactivity").text(currentPageofactivity);
	});
	
	/*$.ajax({
		type:'post',
		async : true,
		url:root+'/ceo/allchartofproduct.action',
		contentType:'application/json;charset=utf-8',
		data:'{}',
		success:function(result){
			$("#chart").html("");
			for(var i=0;i<result.length;i++){
				$("#chart").append(
					'<tr>'+
						'<td>'+result[i].productname+'</td>'+
						'<td class="center">'+result[i].branchname+'</td>'+
						'<td class="center">'+result[i].price+'</td>'+
						'<td class="center">'+result[i].buynum+'</td>'+
						'<td class="center">'+result[i].getprice+'</td>'+
						'<td class="center">'+										
							'<a class="btn btn-info" href="'+root+'/ceo/chart.action?id='+result[i].productid+'">'+
							'查看报表'+
								'<i class="halflings-icon white edit"></i></a>'+
						'</td>'+
					'</tr>'
				);
			}
		}		
	});*/
	
	
	
	
	
	/*function showchart(id){
		var branchid = id.attr("value");
	    var ceoProducttransactionreport = new Object();
	    ceoProducttransactionreport.branchid = branchid;
			$.ajax({
				type : 'post',					
				url:root+'/ceo/productchart.action',
				contentType : 'application/json;charset=utf-8',
				data:JSON.stringify(ceoProducttransactionreport),
				success:function(data){
					if(data != ""){
						$("#box tbody").html("");
						for(var i = 0;i<data.length;i++ ){	
							$("#box tbody").append(
								'<tr>'+
									'<td>'+data[i].productname+'</td>'+
									'<td class="center">'+data[i].branchname+'</td>'+
									'<td class="center">'+data[i].price+'</td>'+
									'<td class="center">'+data[i].buynum+'</td>'+
									'<td class="center">'+data[i].getprice+'</td>'+
									'<td class="center">'+										
										'<a class="btn btn-info" href="'+root+'/ceo/chart.action?id='+data[i].productid+'">'+
										'查看报表'+
											'<i class="halflings-icon white edit"></i></a>'+				
									'</td>'+
								'</tr>'					
							);
						}
					}else{
						alert("该分店还没有商品售出！");
					}					
				}				
			});*/
		/*var ceoActivityreport = new Object();
		ceoActivityreport.branchid=branchid;
			$.ajax({
				type:'post',
				url: root+'/ceo/actcharts.action',
				contentType:'application/json;charset=utf-8',
				data:JSON.stringify(ceoActivityreport),
				success:function(result){
					
				}
			});
	}	*/
	
	
	$("#branchproductcharts").click(function(){
		if($("#branchchart").attr("value") != "-1"){
			window.open(root+"/jsp/ceo/allproductchartsOfbranch.jsp?id="+$("#branchchart").attr("value"));
		}else{
			alert("请选择分店！");
		}
		
	});
	$("#branchactivitycharts").click(function(){
		if($("#branchchart").attr("value") != "-1"){
			window.open(root+"/jsp/ceo/allactivitychartsOfbranch.jsp?id="+$("#branchchart").attr("value"));
		}else{
			alert("请选择分店！");
		}
	});
	
	
	
	
});
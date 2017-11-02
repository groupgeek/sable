$(document).ready(function(){
	var root = $("#root").attr("value");
	
	//加载分店数据
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryAllBranch",
		success:function(data){
			for(var i in data){
				$("#branchid").append('<option value="'+data[i].branchid+'">'+data[i].branchname +'</option>');
			}
		}
	});
	
	//开始加载留言数据
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		var sort = $("#selectSort").val();
		var branchid = $("#branchid").attr("value");
		
		function createActivityTable(data){
			for(var i in data.allMessage){
				$("#allMessages").append(
					'<a href = "'+root+"/jsp/admin/page/messageInfo.jsp?messageid="+data.allMessage[i].messageid+'">'+ 	
						'<li>'+
							'<span class="from">'+
							'<span class="glyphicons dislikes"><i></i></span>'+data.allMessage[i].username+'</span>'+
							'<span class="title">'+data.allMessage[i].messagecontext+'</span>'+
							'<span class="date">日期<b>'+data.allMessage[i].messagetime+'</b></span>'+
						'</li>'+
					'</a>'
				);
				
			}
		}
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");
			sort = $("#selectSort").attr("value");
			search = $("#search").val();
			branchid = $("#branchid").attr("value");
			
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllMessage",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"branchid"'+':'+'"'+branchid+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+','
				+'"sort"'+':'+'"'+sort+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#allMessages").html("");
					$("#home").attr("value",1);
					$("#previousPage").attr("value",1);
					$("#nextPage").attr("value",1);
					$("#lastPage").attr("value",data.pageSum);
					$("#pageSum").text(data.pageSum);
					$("#currentPage").text(currentPage);
					createActivityTable(data);
				}
			});
		}
		
		//第一次进入
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllMessage",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'+','
			+'"sort"'+':'+'"'+sort+'"'
        			+'}',
			success:function(data){
				//alert(data.pageSum);
				//alert("ok");
				$("#allMessages").html("");
				$("#home").attr("value",1);
				$("#previousPage").attr("value",1);
				$("#nextPage").attr("value",1);
				$("#lastPage").attr("value",data.pageSum);
				$("#pageSum").text(data.pageSum);
				$("#messageSum").text(data.messageSum);
				//alert($("#previousPage").attr("value"));
				createActivityTable(data);
			}
		});
		
		//事件开始
		//搜索框事件
		$("#search").bind('input propertychange', function(){
			//alert($(this).attr("value"));
			queryData();
		});
		
		//排序
		$("#sort").change(function(){
			//alert($(this).attr("value"));
			queryData();
		});
		//状态
		$("#branchid").change(function(){
			//alert($(this).attr("value"));
			queryData();
		});
		
		//每页显示 排序 事件
		$("#selectPageNum").change(function(){
			//alert($(this).attr("value"));
			queryData();
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
			search = $("#search").val();
			branchid = $("#branchid").attr("value");
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllMessage",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"branchid"'+':'+'"'+branchid+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+','
				+'"sort"'+':'+'"'+sort+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#allMessages").html("");
					//$("#home").attr("value",1);
					//$("#lastPage").attr("value",data.pageSum);
					createActivityTable(data);
				}
			});
			$("#currentPage").text(currentPage);
		});
		
});
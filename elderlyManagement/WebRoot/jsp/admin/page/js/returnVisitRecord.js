$(document).ready(function(){
	var root = $("#root").attr("value");
	
	//加载分店
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/superAdmin/queryAllBranch",
		success:function(data){
			for(var i in data){
				
				$("#selectBranch").append('<option value="'+data[i].branchid+'" >'+data[i].branchname+'</option>');
			}
		}
	});
	
	
	
	
	
	//开始查询数据
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		var sort = $("#selectSort").val();
		var selectBranch = $("#selectBranch").attr("value");
		
		
		function createActivityTable(data){
			$("#sum").text(data.recordSum);
			for(var i in data.returnvisitList){
				$("#box tbody").append(
						'<tr>'+
							'<a href = "'+root+'/jsp/admin/page/userInfo.jsp?userid='+ (data.returnvisitList)[i].userid +'" ><td>'+ (data.returnvisitList)[i].username +'</td></a>'+
							'<td class="center">'+(data.returnvisitList)[i].address+
							'<td class="center">'+(data.returnvisitList)[i].lastvisttimeString +'</td>'+
							'<td class="center">'+(data.returnvisitList)[i].countvisit +'</td>'+
							'<td class="center">'+
								'<a class="btn btn-info" href="'+root+'/jsp/admin/page/updateReturnvisitRecordInfo.jsp?returnvisitid='+ (data.returnvisitList)[i].returnvisitid +'">'+
									'<i class="halflings-icon white edit"></i>'+  
								'</a>'+
								'<a class="btn btn-danger" href="javascript:;" name="drop">'+
									'<i class="halflings-icon white trash"></i>'+
								'</a>'+
								'<input type="hidden" value="'+ (data.returnvisitList)[i].returnvisitid +'">'+
							'</td>'+
						'</tr>'
					);
				
			}
			//添加删除事件
			$("#box tbody").find("a[name=drop]").click(function(){
				myself = $(this);
				var returnvisitid = myself.next().val();
				$.ajax({
					
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/superAdmin/deleteReturnRecord",
					data:JSON.stringify(returnvisitid),
					success:function(data){
						if(data.flag){
							myself.parent().parent().remove();
						}else{
							alert(data.message);
						}
					}
				});
				
				
			});
			
		}
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");
			sort = $("#selectSort").attr("value");
			search = $("#search").val();
			selectBranch = $("#selectBranch").attr("value");
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllReturnRecord",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"branchid"'+':'+'"'+selectBranch+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+','
				+'"sort"'+':'+'"'+sort+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#box tbody").html("");
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
			url:root+"/superAdmin/queryAllReturnRecord",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"branchid"'+':'+'"'+selectBranch+'"'+','
			+'"sort"'+':'+'"'+sort+'"'
        			+'}',
			success:function(data){
				//alert(data.pageSum);
				//alert("ok");
				$("#box tbody").html("");
				$("#home").attr("value",1);
				$("#previousPage").attr("value",1);
				$("#nextPage").attr("value",1);
				$("#lastPage").attr("value",data.pageSum);
				$("#pageSum").text(data.pageSum);
				//alert($("#previousPage").attr("value"));
				createActivityTable(data);
			}
		});
		
		//事件开始
		//搜索框事件
		$("#search").bind('input propertychange', function(){
			queryData();
		});
		
		//排序
		$("#sort").change(function(){
			queryData();
		});
		//状态
		$("#selectBranch").change(function(){
			queryData();
		});
		
		//每页显示 排序 事件
		$("#selectPageNum").change(function(){
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
			selectBranch = $("#selectBranch").attr("value");
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllReturnRecord",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"branchid"'+':'+'"'+selectBranch+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+','
				+'"sort"'+':'+'"'+sort+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#box tbody").html("");
					//$("#home").attr("value",1);
					//$("#lastPage").attr("value",data.pageSum);
					createActivityTable(data);
				}
			});
			$("#currentPage").text(currentPage);
		});
		
});
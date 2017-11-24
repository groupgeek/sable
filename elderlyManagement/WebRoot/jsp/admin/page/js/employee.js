$(document).ready(function(){
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		var sort = $("#selectSort").attr("value");
		
		function createEmployeeTable(data){
			for(var i in data.employeeList){
				$("#box tbody").append(
						'<tr>'+
							'<td>'+ (data.employeeList)[i].employeename +'</td>'+
							'<td class="center">'+(data.employeeList)[i].entrytimeString+
							'<td class="center">'+ (data.employeeList)[i].employeestatus +'</td>'+
							'<td class="center">'+
								'<span class="label label-success">'+ (data.employeeList)[i].age +'</span>'+
							'</td>'+
							'<td class="center">'+
								'<a class="btn btn-success" href="'+root+'/jsp/admin/page/employeeInfo.jsp?employeeid='+ (data.employeeList)[i].employeeid +'">'+
									'<i class="halflings-icon white zoom-in"></i>'+
								'</a>'+
								'<a class="btn btn-info" href="'+root+'/superAdmin/updateEmployeeInfoView?id='+ (data.employeeList)[i].employeeid +'">'+
									'<i class="halflings-icon white edit"></i>'+  
								'</a>'+
								'<a class="btn btn-danger" href="#" name="drop">'+
									'<i class="halflings-icon white trash"></i>'+
								'</a>'+
								'<input type="hidden" value="'+ (data.employeeList)[i].employeeid +'">'+
							'</td>'+
						'</tr>'
					);
				
			}
			
			
			//添加删除事件
			$("#box tbody td").find("a[name=drop]").click(function(){
				myself = $(this);
				var employeeid = myself.next().val();
				$.ajax({
					
					type:"post",
					contentType:"application/json;charset=utf-8",
					url:root+"/superAdmin/deleteEmployee",
					data:JSON.stringify(employeeid),
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
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllEmployee",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
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
					createEmployeeTable(data);
				}
			});
		}
		
		//第一次进入
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllEmployee",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
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
				$("#employeeSum").text(data.employeeSum);
				//alert($("#previousPage").attr("value"));
				createEmployeeTable(data);
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
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllEmployee",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'+','
				+'"sort"'+':'+'"'+sort+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#box tbody").html("");
					//$("#home").attr("value",1);
					//$("#lastPage").attr("value",data.pageSum);
					createEmployeeTable(data);
				}
			});
			$("#currentPage").text(currentPage);
		});
		
});
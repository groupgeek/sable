$(document).ready(function(){
	//alert(1);
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		var sort = "registrationdate";
		
		//${pageContext.request.contextPath }/superAdmin/updateUserInfoView?id=1
		function createUserTable(data){
			for(var i in data.userList){
				$("#box tbody").append(
						'<tr>'+
							'<td>'+ (data.userList)[i].productname +'</td>'+
							'<td class="center">'+(data.userList)[i].instock+
							'<td class="center">'+ (data.userList)[i].price +'</td>'+
						/*	'<td class="center">'+
								'<span class="label label-success">'+ (data.userList)[i].status +'</span>'+
							'</td>'+*/
							'<td class="center">'+
								'<a class="btn btn-success" href="'+root+'/jsp/admin/page/userInfo.jsp?userid='+ (data.userList)[i].userid +'">'+
									'<i class="halflings-icon white zoom-in"></i>'+
								'</a>'+
								'<a class="btn btn-info" href="'+root+'/superAdmin/updateUserInfoView?id='+ (data.userList)[i].userid +'">'+
									'<i class="halflings-icon white edit"></i>'+  
								'</a>'+
								'<a class="btn btn-danger" href="#">'+
									'<i class="halflings-icon white trash"></i>'+
								'</a>'+
							'</td>'+
						'</tr>'
					);
				
			}
		}
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");
			sort = $("#selectSort").attr("value");
			search = $("#search").val();
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/productmanage/quertyProduct",
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
					createUserTable(data);
				}
			});
		}
		
		//第一次进入
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/productmanage/quertyProduct",
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
				$("#userSum").text(data.userSum);
				//alert($("#previousPage").attr("value"));
				createUserTable(data);
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
				url:root+"/productmanage/quertyProduct",
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
					createUserTable(data);
				}
			});
			$("#currentPage").text(currentPage);
		});
		
});
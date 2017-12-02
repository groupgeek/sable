$(document).ready(function(){
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		//var sort = $("#selectSort").val();		
		/*var branchid = $("#allBranch").attr("value");*/
		/*//加载商品类型
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllProductType",
			success:function(data){
				
				for(var i in data){
					$("#producttypeid").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
				}
			}
			
		});*/
		
		//加载分店
		
		/*$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllBranch",
			success:function(data){
				
				for(var i in data){
					$("#allBranch").append('<option value="'+data[i].branchid+'">'+data[i].branchname+'</option>');
				}
			}
			
		});*/
		
		
		function createBranchTable(data){
			if(data.branchList != ""){
				for(var i in data.branchList){
					$("#box tbody").append(
							'<tr>'+
								'<td>'+ (data.branchList)[i].branchid +'</td>'+
								'<td class="center">'+ (data.branchList)[i].branchname +'</td>'+
								'<td class="center">'+(data.branchList)[i].employeename+'</td>'+
								'<td class="center">'+ (data.branchList)[i].areaaddress +'</td>'+							
								'<td class="center">'+
									'<a class="btn btn-success" href="'+root+'/jsp/admin/page/allproductReportofbranch.jsp?id='+ (data.branchList)[i].branchid +'" target="_black">'+
										'商品报表'+
									'</a>'+
									'&nbsp;'+
									'<a class="btn btn-success" href="'+root+'/jsp/admin/page/allactivityReportofbranch.jsp?id='+ (data.branchList)[i].branchid +'" target="_black">'+
										'活动报表'+
									'</a>'+
								'</td>'+
							'</tr>'
					);				
				}
			}else{
				$("#box tbody").append(
					'<tr>'+
						'<td colspan="5">'+"没有找到数据！"+'</td>'+	
					'</tr>'
				);
			}
		}
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");
			//sort = $("#selectSort").attr("value");
			search = $("#search").val();
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllbranchs",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'
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
					createBranchTable(data);
				}
			});
		}
		//第一次进入
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllbranchs",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'
        			+'}',
			success:function(data){
				//alert(data.pageSum);
				$("#box tbody").html("");
				$("#home").attr("value",1);
				$("#previousPage").attr("value",1);
				$("#nextPage").attr("value",1);
				$("#lastPage").attr("value",data.pageSum);
				$("#pageSum").text(data.pageSum);
				//$("#activitySum").text(data.activitySum);
				//alert($("#previousPage").attr("value"));
				createBranchTable(data);
			}
		});
		
		//事件开始
		//搜索框事件
		$("#search").bind('input propertychange', function(){
			queryData();
		});
		
		/*//排序
		$("#sort").change(function(){
			queryData();
		});*/
		//状态
		$("#products").click(function(){
			window.open(root+"/jsp/admin/page/allproductReport.jsp");
		});
		
		$("#activitys").click(function(){
			window.open(root+"/jsp/admin/page/allactivityReport.jsp");
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
			//sort = $("#selectSort").attr("value");
			search = $("#search").val();
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllbranchs",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'
	        			+'}',
				success:function(data){
					//alert(data.pageSum);
					//alert("ok");
					$("#box tbody").html("");
					//$("#home").attr("value",1);
					//$("#lastPage").attr("value",data.pageSum);
					createBranchTable(data);
				}
			});
			$("#currentPage").text(currentPage);
		});
		
});
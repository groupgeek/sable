$(document).ready(function(){
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		//var sort = $("#selectSort").val();
		var activitytypeid = $("#activitytypeid").attr("value");
		var branchid = $("#allBranch").attr("value");
		//加载商品类型
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllActivityType",
			success:function(data){
				
				for(var i in data){
					$("#activitytypeid").append('<option value="'+data[i].activitytypeid+'">'+data[i].activitytypename+'</option>');
				}
			}
			
		});
		
		//加载分店
		
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllBranch",
			success:function(data){
				
				for(var i in data){
					$("#allBranch").append('<option value="'+data[i].branchid+'">'+data[i].branchname+'</option>');
				}
			}
			
		});
		
		
		function createActivityTable(data){
			if(data.activityList != ""){
				for(var i in data.activityList){
					$("#box tbody").append(
							'<tr>'+
								'<td>'+ (data.activityList)[i].activityname +'</td>'+
								'<td class="center">'+ (data.activityList)[i].branchname +'</td>'+
								'<td class="center">'+(data.activityList)[i].registeryfee+'</td>'+
								'<td class="center">'+ (data.activityList)[i].activityprice +'</td>'+
								'<td class="center">'+
									'<span class="label label-success">'+ (data.activityList)[i].maxnum +'</span>'+
								'</td>'+
								'<td class="center">'+
									'<a class="btn btn-success" href="'+root+'/jsp/admin/page/oneactivityReport.jsp?id='+ (data.activityList)[i].activityid +'" target="_black">'+
										'<i class="halflings-icon white zoom-in"></i>'+
									'</a>'+
									'<input type="hidden" value="'+ (data.activityList)[i].activityid +'">'+
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
		function queryData(){
			pageNum = $("#selectPageNum").attr("value");
			//sort = $("#selectSort").attr("value");
			search = $("#search").val();
			var patt = new RegExp(/\s+/g);
			if(patt.test(search)){
				return search.replace(/\s+/g, "");
			}
			activitytypeid = $("#activitytypeid").attr("value");
			branchid = $("#allBranch").attr("value");
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllActivitys",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"activitytypeid"'+':'+'"'+activitytypeid+'"'+','
				+'"branchid"'+':'+'"'+branchid+'"'+','
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
					createActivityTable(data);
				}
			});
		}
		//第一次进入
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllActivitys",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'+','
			+'"activitytypeid"'+':'+'"'+activitytypeid+'"'
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
				createActivityTable(data);
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
		$("#activitytypeid").change(function(){
			queryData();
		});
		
		$("#allBranch").change(function(){
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
			//sort = $("#selectSort").attr("value");
			search = $("#search").val();
			branchid = $("#allBranch").attr("value");
			activitytypeid = $("#activitytypeid").attr("value");
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllActivitys",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"activitytypeid"'+':'+'"'+activitytypeid+'"'+','
				+'"branchid"'+':'+'"'+branchid+'"'+','
				+'"pageNum"'+':'+'"'+pageNum+'"'
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
$(document).ready(function(){
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = 1;
		var pageNum = $("#selectPageNum").attr("value");;
		//var sort = $("#selectSort").val();
		var producttypeid = $("#producttypeid").attr("value");
		var branchid = $("#allBranch").attr("value");
		//加载商品类型
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllProductType",
			success:function(data){
				
				for(var i in data){
					$("#producttypeid").append('<option value="'+data[i].producttypeid+'">'+data[i].producttypename+'</option>');
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
			if(data.productList != ""){
				for(var i in data.productList){
					$("#box tbody").append(
							'<tr>'+
								'<td>'+ (data.productList)[i].productname +'</td>'+
								'<td class="center">'+ (data.productList)[i].branchname +'</td>'+
								'<td class="center">'+(data.productList)[i].price+'</td>'+
								'<td class="center">'+ (data.productList)[i].buyno +'</td>'+
								'<td class="center">'+
									'<span class="label label-success">'+ (data.productList)[i].instock +'</span>'+
								'</td>'+
								'<td class="center">'+
									'<a class="btn btn-success" href="'+root+'/jsp/admin/page/oneproductReport.jsp?id='+ (data.productList)[i].productid +'" target="_black">'+
										'<i class="halflings-icon white zoom-in"></i>'+
									'</a>'+
									'<input type="hidden" value="'+ (data.productList)[i].productid +'">'+
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
			producttypeid = $("#producttypeid").attr("value");
			branchid = $("#allBranch").attr("value");
			currentPage = 1;
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllProduct",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"producttypeid"'+':'+'"'+producttypeid+'"'+','
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
			url:root+"/superAdmin/queryAllProduct",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"branchid"'+':'+'"'+branchid+'"'+','
			+'"producttypeid"'+':'+'"'+producttypeid+'"'
        			+'}',
			success:function(data){
				//alert(data.pageSum);
				$("#addProductUrl").attr("href",root+"/jsp/admin/page/addProduct.jsp?branchid="+(data.productList)[0].branchid);
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
		$("#producttypeid").change(function(){
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
			producttypeid = $("#producttypeid").attr("value");
			$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/superAdmin/queryAllProduct",
				data:'{"search"'+':'+'"'+search+'"'+','
				+'"currentPage"'+':'+'"'+currentPage+'"'+','
				+'"producttypeid"'+':'+'"'+producttypeid+'"'+','
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
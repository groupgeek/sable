$(document).ready(function(){
	//alert(1);
	var root = $("#root").attr("value");
		var search = "";
		var currentPage = "1";
		var pageNum = "5";
		var sort = "registrationdate";
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/superAdmin/queryAllUser",
			data:'{"search"'+':'+'"'+search+'"'+','
			+'"currentPage"'+':'+'"'+currentPage+'"'+','
			+'"pageNum"'+':'+'"'+pageNum+'"'+','
			+'"sort"'+':'+'"'+sort+'"'
        			+'}',
			success:function(data){
				//alert(data.pageSum);
				//alert("ok");
				for(var i in data.userList){
					$("#box tbody").append(
							'<tr>'+
								'<td>'+ (data.userList)[i].username +'</td>'+
								'<td class="center">2012/01/01</td>'+
								'<td class="center">'+ (data.userList)[i].online +'</td>'+
								'<td class="center">'+
									'<span class="label label-success">'+ (data.userList)[i].status +'</span>'+
								'</td>'+
								'<td class="center">'+
									'<a class="btn btn-success" href="#">'+
										'<i class="halflings-icon white zoom-in"></i>'+
									'</a>'+
									'<a class="btn btn-info" href="#">'+
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
		});
		
		
		//事件开始
		$("#search").bind('input propertychange', function(){
			$("#userCurrentPage strong").text($("#search").val());
			
		});
		
		$("#selectPageNum").change(function(){
			$("#userCurrentPage strong").text("5555");
		});
		
		
		
});
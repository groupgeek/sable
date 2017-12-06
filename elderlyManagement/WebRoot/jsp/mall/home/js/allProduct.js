$(document).ready(function(){
	var root = $("#root").attr("value");
	var val = window.location.href.split("?")[1];
	var producttypeid = val.split("&")[0].split("=")[1];
	
	var producttypename = decodeURI(val.split("&")[1].split("=")[1]);
	//查询这一类商品的销量前4
	var buyNo = new Object();
	buyNo.producttypeid = producttypeid;
	buyNo.currentPage = 1;
	buyNo.pageNum = 4;
	buyNo.sort = "buyNo";
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryAllProduct",
		data:JSON.stringify(buyNo),
		success:function(data){
			var index = 0;
			for(var i in data.productList){
				$(".mc ul").append(
						 '<li>'+
						 	'<input type = "hidden" value = "'+ data.productList[i].productid +'">'+
					      	'<div class="p-img">'+
					      	'<a  href="'+root+'/product/productInfo?id='+ data.productList[i].productid +'">'+
				      		'<img style="max-height: 230px;" class="" src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.productList[i].picture+'"> </a>'+  
					      	'</div>'+
					      	'<div class="p-name"><a href="#">'+
					      		data.productList[i].productname+
					      	'</a>'+
					      	'</div>'+
					      	'<div class="p-price"><strong>￥'+data.productList[i].price+'</strong></div>'+
					      	'<p class="number fl">'+
							'销量<span>'+data.productList[i].buyno+'</span>'+
							'</p>'+
					      '</li>'
				);
				if(index == 0){
					$(".mc ul").find("li").first().addClass("first");
				}
				index++;
			}
			
		}
	});
	
	
	//开始查询这一类的所有商品
	var currentPage = 1;
	var pageNum = 16;
	var condition = new Object;
	
	function createActivityTable(data){
		for(var i in data.productList){
			$(".boxes").append(
				'<li>'+
				 	'<a href ="'+root+'/product/productInfo?id='+ data.productList[i].productid +'">'+	
					'<div class="i-pic limit">'+
						'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.productList[i].picture+'" style="max-height: 230px;"/>'+
						'<p>'+data.productList[i].productname+
						'<span>'+data.productList[i].description+'</span></p>'+
						'<p class="price fl">'+
						'<b>¥</b>'+
						'<strong>'+data.productList[i].price+'</strong>'+
					'</p>'+
					'<p class="number fl">'+
					'销量<span>'+data.productList[i].buyno+'</span>'+
					'</p>'+
					'</div>'+
					'</a>'+	
				'</li>'
				/*'<li>'+
					'<a href = "'+root+'/product/productInfo?id='+ data.productList[i].productid +'">'+	
						'<div class="i-pic limit">'+
							'<img src="${pageContext.request.contextPath }/jsp/mall/images/imgsearch1.jpg" />'+
							'<p class="title fl">'+data.productList[i].productname+'</p>'+
							'<p class="price fl">'+
								'<b>¥</b>'+
								'<strong>'+data.productList[i].price+'</strong>'+
							'</p>'+
							'<p class="number fl">'+
								'销量<span>'+data.productList[i].buyno+'</span>'+
							'</p>'+
						'</div>'+
					'</a>'+	
				'</li>'*/
			);
		}
	}
	
	
	//第一次进入
	condition.producttypeid = producttypeid;
	condition.currentPage = currentPage;
	condition.pageNum = pageNum;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryAllProduct",
		data:JSON.stringify(condition),
		success:function(data){
			//alert(data.pageSum);
			//alert("ok");
			$(".boxes").html("");
			$("#home").attr("value",1);
			$("#previousPage").attr("value",1);
			$("#nextPage").attr("value",1);
			$("#lastPage").attr("value",data.pageSum);
			$("#pageSum").text(data.pageSum);
			$("#productSum").find("strong").text(data.productSum);
			$(".index-needs-dt-txt").text(producttypename);
			//alert($("#previousPage").attr("value"));
			createActivityTable(data);
		}
	});
	
	//事件开始
	
	//分页事件
	$("#ull li").click(function(){
		
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
		currentPage = parseInt($(this).attr("value"));
		condition.producttypeid = producttypeid;
		condition.currentPage = currentPage;
		condition.pageNum = pageNum;
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/queryAllProduct",
			data:JSON.stringify(condition),
			success:function(data){
				//alert(data.pageSum);
				//alert("ok");
				$(".boxes").html("");
				//$("#home").attr("value",1);
				//$("#lastPage").attr("value",data.pageSum);
				createActivityTable(data);
			}
		});
		$("#productCurrentPage").text(currentPage);
	});
	
});
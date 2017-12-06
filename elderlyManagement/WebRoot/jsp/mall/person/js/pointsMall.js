$(document).ready(function(){
	var root = $("#root").attr("value");
	//查询某一类商品的销量前4  style="text-overflow:ellipsis;white-space: nowrap;overflow: hidden;display: block;"
	var buyNo = new Object();
	var types = new Array(8,9,12,13);
	//alert((((Math.random()*10+"").substring(0, 1)/3)+"").substring(0, 1));
	producttypeid = types[(((Math.random()*10+"").substring(0, 1)/3)+"").substring(0, 1)];
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
					      	'<div class="p-name"><a href="'+root+'/product/productInfo?id='+ data.productList[i].productid +'">'+
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
	
	
	//查询积分兑换的商品
	//
	var currentPage = 1;
	var pageNum = 16;
	var condition = new Object;
	
	function createActivityTable(data){
		for(var i in data.productList){
			$(".boxes").append(
				'<li class = "box">'+
				 	/*'<a href ="'+root+'/product/productInfo?id='+ data.productList[i].articleid +'">'+	*/
					'<input type="hidden" name="articleid" value="'+data.productList[i].articleid+'"/>'+
					'<a href ="javascript:;">'+
					'<div class="i-pic limit">'+
						'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.productList[i].picture+'" style="max-height: 230px;"/>'+
						'<p>'+data.productList[i].articlename+
						'<span>'+data.productList[i].detail+'</span></p>'+
						'<p class="price fl">'+
						'<b>¥</b>'+
						'<strong>'+data.productList[i].integral+'</strong>'+
					'</p>'+
					'<p class="number fl">'+
					'库存<span>'+data.productList[i].instock+'</span>'+
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
		
		
		//值
		//var info = new Object();
		
		//弹窗
		var w,h,className;
		function getSrceenWH(){
			w = $(window).width();
			h = $(window).height();
			$('#dialogBg').width(w).height(h);
		}
		
		window.onresize = function(){  
			getSrceenWH();
		};
		$(window).resize();  
		
		$(function(){
			getSrceenWH();
			
			//显示弹框
			$('.box a').click(function(){
				//info.articleid = $(this).prev().val();
				$('#articleid').val($(this).prev().val());
				className = $(this).attr('class');
				$('#dialogBg').fadeIn(300);
				$('#dialog').removeAttr('class').addClass('animated '+className+'').fadeIn();
			});
			
			//关闭弹窗
			$('.claseDialogBtn').click(function(){
				$('#dialogBg').fadeOut(300,function(){
					$('#dialog').addClass('bounceOutUp').fadeOut();
				});
			});
		});
		//提交事件
		$(".submitBtn").click(function(){
			/*info.phone = $('#phone').val();
			info.password = $('#password').val();
			info.address = $('#address').val();*/
			
			/*$.ajax({
				
				type:"post",
				contentType:"application/json;charset=utf-8",
				url:root+"/product/",
				data:JSON.stringify(buyNo),
				success:function(data){
					
				}
			});*/
			
		});
		
		
		
		
		
		
		
		
		
		
	}
	
	
	//第一次进入
	condition.currentPage = currentPage;
	condition.pageNum = pageNum;
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/product/queryAllIntegralProduct",
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
			//alert($("#previousPage").attr("value"));
			createActivityTable(data);
		}
	});
	
	//事件开始
	
	//分页事件
	$("#ull li").click(function(){
		if("previousPage" == $(this).attr("id")){
			if(parseInt(currentPage) > 1){
				$(this).attr("value",parseInt(currentPage)-1);
				$("#nextPage").attr("value",parseInt(currentPage)-1);
			}
		}
		if("nextPage" == $(this).attr("id")){
			if($(this).attr("value") < $("#lastPage").attr("value")){
				$(this).attr("value",parseInt(currentPage)+1);
				$("#previousPage").attr("value",parseInt(currentPage)+1);
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
		
		condition.currentPage = currentPage;
		condition.pageNum = pageNum;
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/product/queryAllIntegralProduct",
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
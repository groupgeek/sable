$(document).ready(function(){
	var root = $("#root").attr("value");
	var currentPage = 1;
	var val = window.location.href.split("?")[1];
	var activitytypeid = val.split("=")[1];
	//alert(activitytypeid.substr("#"))
	activitytypeid = activitytypeid.split("#")[0];
	
	//创建数据
	function createActivityTable(data){
		for(var i in data.activityList){
			
			$(".products").append(
					'<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">'+
					'<div class="product">'+
						'<div class="image"><a href="'+root+'/edu/actInfo.action?id='+data.activityList[i].activityid+'"><img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data.activityList[i].activitypicture+'" /></a></div>'+
						'<div class="buttons">'+
							/*'<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>'+
							'<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>'+
							'<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>'+*/
						'</div>'+
						'<div class="caption">'+
							'<div class="name"><h3><a href="'+root+'/edu/actInfo.action?id='+data.activityList[i].activityid+'">'+data.activityList[i].activityname+'</a></h3></div>'+
							'<div class="price">￥'+data.activityList[i].registeryfee+'</div>'+
						'</div>'+
					'</div>'+
				'</div>'
				);
			
		}
	}
	
	
	//第一次进入
	var condition = new Object();
	condition.currentPage = currentPage;
	condition.activitytypeid = activitytypeid;
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/edu/queryAllEduActivity",
		data:JSON.stringify(condition),
		success:function(data){
			
			$(".products").html("");
			$("#home").attr("value",1);
			$("#previousPage").attr("value",1);
			$("#nextPage").attr("value",1);
			$("#lastPage").attr("value",data.pageSum);
			$("#pageSum").text(data.pageSum);
			$("#activitySum").text(data.activitySum);
			//alert($("#previousPage").attr("value"));
			createActivityTable(data);
		}
	});
	
	
	//分页事件active
	$("#pageUl li").click(function(){
		$("#previousPage").removeClass("active");
		$("#nextPage").removeClass("active");
		$("#home").removeClass("active");
		$("#lastPage").removeClass("active");
		$(this).addClass("active");
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
		//queryData();
		condition.currentPage = currentPage;
		$.ajax({
			
			type:"post",
			contentType:"application/json;charset=utf-8",
			url:root+"/edu/queryAllEduActivity",
			data:JSON.stringify(condition),
			success:function(data){
				//alert(data.pageSum);
				//alert("ok");
				$(".products").html("");
				//$("#home").attr("value",1);
				//$("#lastPage").attr("value",data.pageSum);
				createActivityTable(data);
			}
		});
		$("#currentPage").text(currentPage);
	});
	
	
});
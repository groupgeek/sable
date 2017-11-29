$(document).ready(function(){
	var root = $("#root").attr("value");
	
	
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		
		url:root+"/edu/queryAllEduRecord",
		success:function(data){
			if(data != null){
				/*for(var activitytype in data){
				    alert(activitytype.activitytypeid)
				 }*/
				
				
				for(var key in data){
					
					$("#container").append(
							'<div class="row">'+
							'<div class="col-lg-12">'+
								'<div class="heading"><h2>'+key+'</h2></div>'+
								'<div class="products" id = "'+key+'">'+
								
								'</div>'+
							'</div>'+
						'</div>'
					);
					
					
					for(var i in data[key]){
						
						$("#container").find("div[id="+key+"]").append(
								'<div class="col-lg-3 col-md-3 col-sm-6 col-xs-12">'+
								'<div class="product">'+
									'<div class="image"><a href="'+root+'/edu/actInfo?id='+data[key][i].activityid+'"><img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[key][i].activitypicture+'" /></a></div>'+
									'<div class="buttons">'+
										/*'<a class="btn cart" href="#"><span class="glyphicon glyphicon-shopping-cart"></span></a>'+
										'<a class="btn wishlist" href="#"><span class="glyphicon glyphicon-heart"></span></a>'+
										'<a class="btn compare" href="#"><span class="glyphicon glyphicon-transfer"></span></a>'+*/
									'</div>'+
									'<div class="caption">'+
										'<div class="name"><h3><a href="'+root+'/edu/actInfo?id='+data[key][i].activityid+'">'+data[key][i].activityname+'</a></h3></div>'+
										'<div class="price">￥'+data[key][i].registeryfee+'</div>'+
										/*'<div class="rating"><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star"></span><span class="glyphicon glyphicon-star-empty"></span><span class="glyphicon glyphicon-star-empty"></span></div>'+*/
									'</div>'+
								'</div>'+
							'</div>'
						);
					}
				}
				
				/*$.each(data, function(i) {
				    alert(data[i]);
				    alert(i[activitytypename]);
				});*/
				
				/*
				var map={}; var a={r:"1"}; var b={r:"2"}; 
				Object.prototype.toString=function() { return this["r"]; };
				map[a]="2"; map[b]="3"; for(var obj in map){ console.log(obj); };*/
			}
		}
	});
	
	//加载讲师
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/edu/queryAllByBranch",
		success:function(data){
			for(var i in data){

				var html = 
					'<dl>'+
						'<dt>'+
							'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].avater+'" width="66" height="66" alt="" />'+
						'</dt>'+
						'<dd>'+
							'<h4 style = "min-height:30px;">'+data[i].name+'老师'+
						'</dd>'+
						'<dd style="display:block;min-width: 110px;">'+data[i].work+'</dd>'+
						'<dd style="display:block;min-width: 150px;">'+
							'点赞:<span>'+data[i].like+'</span>'+
						'</dd>'+
					'</dl>';
				$("#lecturer").append(html);
			}
		}
		
		
	});
	
	
});
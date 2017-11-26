$(document).ready(function(){
	var root = $("#root").attr("value");
	$.ajax({
		
		type:"post",
		contentType:"application/json;charset=utf-8",
		url:root+"/edu/queryAllEduActivityReg",
		data:null,
		success:function(data){
			
			for(var i in data){
				
				var html = '<div class="row">'+
				'<div class="product well">'+
				'<div class="col-md-3">'+
					'<div class="image">'+
						'<img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/'+data[i].activitypicture+'" />'+
					'</div>'+
				'</div>'+
				'<div class="col-md-9">'+
					'<div class="caption">'+
						'<div class="name">'+
							'<h3>'+
								'<a href="'+root+'/edu/actInfo?id='+data[i].activityid+'">'+data[i].activityname+'</a>'+
							'</h3>'+
						'</div>'+
						'<div class="info">'+
							'<ul>'+
								'<li>开展时间: '+new Date(data[i].activitydate).toLocaleDateString()+'</li>'+
							'</ul>'+
						'</div>'+
						'<div class="price">'+
							'报名费用：￥'+data[i].registeryfee+
						'</div>'+
						/*'<label>Qty: </label> <input class="form-inline quantity"'+
						'type="text" value="1"><a href="#"'+
						'class="btn btn-2 ">Update</a>'+
						'<hr>'+*/
						'<input type = "hidden" value = "'+data[i].activityid+'">'+
						'</div>'+
					'</div>'+
					'<div class="clear"></div>'+
				'</div>'+
				'</div>';
				//alert(data[0].activityid)
				if(new Date(data[i].activitydate).toDateString() === new Date().toDateString() || data[i].activitystatus === "正在进行"){
					$("#ongoing").append(html);
					if(data[i].online){
						$("#ongoing").find("input[value="+data[i].activityid+"]").parent().append(
								'<a href="'+root+'/'+data[i].video+'" class="btn btn-default pull-right">去围观</a>'
						);
					}
				}
				if(new Date(data[i].activitydate).toDateString() < new Date().toDateString() || data[i].activitystatus === "未开展"){
					$("#noCarriedOut").append(html);
				}
				if(new Date(data[i].activitydate).toDateString() > new Date().toDateString() || data[i].activitystatus === "已开展"){
					$("#alreadyDone").append(html);
				}
				
				
			}
			
			
			
		}
	});
	
	
	
	
});


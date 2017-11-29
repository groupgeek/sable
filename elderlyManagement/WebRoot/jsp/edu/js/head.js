$(document).ready(function() {
	var root = $("#root").attr("value");

	// 加载导航栏
	$.ajax({

		type : "post",
		contentType : "application/json;charset=utf-8",
		url : root + "/edu/allEduType",
		
		success : function(data) {
			if (data != null) {
				for(var i in data){
					$("#navData").append(
							'<li class="dropdown"><a href="'+root+'/jsp/edu/type.jsp?activitytypeid='+data[i].activitytypeid+'" class="dropdown-toggle" target="_black">'+data[i].activitytypename+'</a>'+
								/*'<div class="dropdown-menu" style="margin-left: -203.625px;">'+
									'<div class="dropdown-inner">'+
										'<ul class="list-unstyled">'+
											'<li><a href="#">Iphone</a></li>'+
											
										'</ul>'+
										'<ul class="list-unstyled">'+
											'<li><a href="#">Nexus</a></li>'+
										'</ul>'+
										'<ul class="list-unstyled">'+
											'<li><a href="#">LG</a></li>'+
										'</ul>'+
									'</div>'+
								'</div>'+*/
							'</li>'
						
						);
				}
			}
		}
	});
	
	
	//我的课程
	

});
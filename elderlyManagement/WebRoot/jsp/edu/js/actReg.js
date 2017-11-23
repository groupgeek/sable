function actReg(){
	var activityregistery = new Object();
	var root = document.getElementById("root").value;
	var activityid = document.getElementById("regActid").value;
	activityregistery.activityid = activityid;
	$.ajax({
		type:'post',
		url: root+'/edu/regAct.action',
		contentType:"application/json;charset=utf-8",
		data:JSON.stringify(activityregistery),
		success:function(data){
			if(data==null){
				alert("报名成功！");
			}else{
				alert("报名失败！");
			}
		}
	});
}

function xixi(){
	swal({
	    title: "确定操作吗？",
	    text: "你确定要删除这篇文章吗？",
	    type: "warning",
	    showCancelButton: true,
	    confirmButtonColor: '#DD6B55',
	    confirmButtonText: 'confirm'
	  },
	  function(){
	    alert("删除成功");
	  });
}
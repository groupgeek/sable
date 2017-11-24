function actReg(){
		var obj = $("#lll");
		var ob = document.getElementById("ready");
		var activityregistery = new Object();
		var root = document.getElementById("root").value;
		var activityid = document.getElementById("regActid").value;
		var registeryfee = document.getElementById("registery").value;
		var activityname = document.getElementById("activityname").value;
		var a = document.getElementById("a").value;
		var c= parseInt(a) + parseInt(1);
		activityregistery.activityid = activityid;
		activityregistery.registeryfee = registeryfee;
		activityregistery.activityname = activityname;
		$.ajax({
			type:'post',
			url: root+'/edu/regAct.action',
			contentType:"application/json;charset=utf-8",
			data:JSON.stringify(activityregistery),
			success:function(data){
				if(data==null){
					alert("报名失败！");
					
				}else{
					alert("报名成功！");
					$("#lll").text("已经报名人数："+c);
					$("#ready").text("已报名");
					two();
				}
			}
		});
}

function xixi(){
	/*window.open("../jsp/edu/win.jsp","dd",'height=100,width=400,top=200,left=200,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no')*/
}



function one(){ 
	document.getElementById('light').style.display='block'; 
	document.getElementById('fade').style.display='block' } 
function two(){ 
	document.getElementById('light').style.display='none'; 
	document.getElementById('fade').style.display='none' } 

function haha(){
	document.getElementById("consol-1").style.background= "#3399CC";
}
function xixi(){
	document.getElementById("consol-1").style.background= "#33CCCC";
}
function haha2(){
	document.getElementById("consol-2").style.background= "#3399CC";
}
function xixi2(){
	document.getElementById("consol-2").style.background= "#33CCCC";
}


function jump(){
	var root = document.getElementById("root").value;
	var activityid = document.getElementById("regActid").value;
	var url = root+"/edu/actInfo.action?id="+activityid;
	alert(url);
	window.location.href(url);
}





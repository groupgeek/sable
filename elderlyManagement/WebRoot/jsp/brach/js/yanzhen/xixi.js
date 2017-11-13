function haha(){
	 var str = document.getElementById('str').value.trim();    
	    if(str.length!=0){    
	        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	        var r = str.match(reg);     
	        if(r==null)
	            alert('对不起，您输入的日期格式不正确!');
	        }
	        }

function haha2(){
	 var str = document.getElementById('str2').value.trim();    
	    if(str.length!=0){    
	        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	        var r = str.match(reg);     
	        if(r==null)
	            alert('对不起，您输入的日期格式不正确!');
	        }
	        }

function long()     
{     
        var str = document.getElementById('typeahead').value.trim();    
        if(str.length!=0){    
        reg=/^.{1,30}$/;    
        if(!reg.test(str)){    
            alert("输入字符过长，会导致添加失败哦");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("typeahead").value="";
        }    
        }    
}

function IsString()     
{     
        var str = document.getElementById('pass').value.trim();    
        if(str.length!=0){    
        reg=/^[a-zA-Z0-9_]+$/; 
        re=/^.{1,15}$/;
        if(!re.test(str)){    
            alert("输入密码过长");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("pass").value="";
        } 
        if(!reg.test(str)){    
            alert("密码是15位以下的数字或者英文字母");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("pass").value="";
        }    
        }    
}  


function IsEmail()     
{     
		var obj = document.getElementById('mail');
        var str = document.getElementById('email').value.trim(); 
        if(str.length!=0){
        reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        re=/^.{1,30}$/;
        if(!re.test(str)){    
            alert("邮箱太长啦！");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("email").value="";
        }
        if(!reg.test(str)){
            obj.innerText="邮箱格式错误,邮箱格式为 xxx@163.com";
        } 
        if(reg.test(str)){
        	obj.innerText="邮箱格式正确";
        }
        }    
}

function IsPhone()     
{     
	var str = document.getElementById('phone').value.trim();    
    if(str.length!=0){    
    reg=/^[0-9]+$/;
    re=/^.{1,11}$/;
    if(!re.test(str)){    
        alert("大陆电话号是11位以下的数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("phone").value="";
    } 
    if(!reg.test(str)){    
        alert("大陆电话号是11位以下的数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("phone").value="";
    }    
    }     
}

function add()     
{     
        var str = document.getElementById('addr').value.trim();    
        if(str.length!=0){    
        reg=/^.{1,30}$/;    
        if(!reg.test(str)){    
            alert("输入字符过长，会导致添加失败哦");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("addr").value="";
        }    
        }    
}

function bank(v)     
{    	var n = /^[1-9]\d*$|^0$/; 
		var obj = document.getElementById('bank');
        var str = document.getElementById('bankno').value.trim(); 
        if(!n.test(v)){
        	alert("只可以输数字哦");
        	document.getElementById("bankno").value="";
        	return false;
        	}
        if(str.length!=0){    
        reg=/^\d{19,21}$/;  
        re=/^.{1,25}$/;
        if(!re.test(str)){    
            alert("你的银行卡账号过长！");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("bankno").value="";
        } 
        if(!reg.test(str)){    
        	obj.innerText="你输入的银行卡信息有误";
        } 
        if(reg.test(str)){    
        	obj.innerText="银行卡正确！";
        }
        }    
}

function xixi(v){
    var n = /^[1-9]\d*$|^0$/;  
    var str = document.getElementById('appendedPrependedInput').value.trim();
     if(appendedPrependedInput.length!=0){    
			 reg=/^[-+]?\d*$/;     
			 if(!reg.test(appendedPrependedInput)){//判断是否为数字类型    
  		  if(str>parseInt('99999999')) //“123”为自己设定的最大值    
   			 {     
       			 alert('数值太大！');//请将“数字”改成你要验证的那个属性名称！    
       			 document.getElementById("appendedPrependedInput").value="";
    		}     
}    
}    
   if(!n.test(v)){
alert("只可以输数字哦");
document.getElementById("appendedPrependedInput").value="";
return false;

}
    }

function xixi2(v){
	  var n = /^[1-9]\d*$|^0$/;  
	        var str = document.getElementById('appendedPrependedInput2').value.trim();
	         if(appendedPrependedInput.length!=0){    
   			 reg=/^[-+]?\d*$/;     
  			 if(!reg.test(appendedPrependedInput)){//判断是否为数字类型    
      		  if(str>parseInt('99999999')) //“123”为自己设定的最大值    
       			 {     
           			 alert('数值太大！');//请将“数字”改成你要验证的那个属性名称！    
           			 document.getElementById("appendedPrependedInput2").value="";
        		}     
    }    
}    
	       if(!n.test(v)){
    alert("只可以输数字哦");
    document.getElementById("appendedPrependedInput2").value="";
    return false;

}
	        }


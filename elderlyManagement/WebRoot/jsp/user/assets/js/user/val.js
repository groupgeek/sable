function Isbank()     
{     
	var check = false;
	var str = document.getElementById('bank').value.trim();  
	var obj = document.getElementById("p-bank");
    if(str.length!=0){    
    reg=/^[0-9]+$/;
    re=/^.{1,20}$/;
    res=/^\d{20,21}$/;
    if(res.test(str)){
    	obj.innerText="OK!";
    	check = true;
    }
    else{
    	obj.innerText="例：622848 1198 xxxx 00000";
    	check = false;
    }
    if(!re.test(str)){    
        alert("银行卡号是20位数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("bank").value="";
    } else{
    	/*obj.innerText="例：139xxxx0000";*/
    }
    if(!reg.test(str)){    
        alert("银行卡号是20位数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("bank").value="";
    }
    
    } 
    return check;
}

function IsString()     
{     	var obj = document.getElementById('p-pass');
        var str = document.getElementById('password').value.trim();    
        if(str.length!=0){ 
        	 obj.innerText="密码是15位以下的英文字母或数字";
        reg=/^[a-zA-Z0-9_]+$/; 
        re=/^.{1,15}$/;
        if(!re.test(str)){    
            alert("输入密码过长");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("password").value="";
        } 
        if(!reg.test(str)){    
            alert("密码是15位以下的数字或者英文字母");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("password").value="";
        }    
        }  
        else{
        	obj.innerText="员工密码不能为空，否则导致添加失败！";
        }
}  

function IsPhone()     
{     
	var check = false;
	var str = document.getElementById('form-name').value.trim();  
	var obj = document.getElementById("p-phone");
    if(str.length!=0){    
    reg=/^[0-9]+$/;
    re=/^.{1,11}$/;
    res=/^\d{11,12}$/;
    if(res.test(str)){
    	obj.innerText="OK!";
    	check = true;
    }
    else{
    	obj.innerText="例：139xxxx0000";
    	check = false;
    }
    if(!re.test(str)){    
        alert("大陆电话号是11位以下的数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("form-name").value="";
    } else{
    	/*obj.innerText="例：139xxxx0000";*/
    }
    if(!reg.test(str)){    
        alert("大陆电话号是11位以下的数字");//请将“字符串类型”要换成你要验证的那个属性名称！    
        document.getElementById("form-name").value="";
    }
    
    } 
    return check;
}

function IsEmail()     
{     
		var check = false;
		var obj = document.getElementById('p-mail');
        var str = document.getElementById('mail').value.trim(); 
        if(str.length!=0){
        reg=/^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;
        re=/^.{1,30}$/;
        if(!re.test(str)){    
            alert("邮箱太长啦！");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("mail").value="";
        }
        if(!reg.test(str)){
            obj.innerText="邮箱格式错误,邮箱格式为 xxx@163.com";
            check = false;
        } 
        if(reg.test(str)){
        	obj.innerText="OK!";
        	check = true;
        }
        }  
        else{
        	obj.innerText="邮箱格式为xxx@163.com";
        }
        return check;
}

function haha(){
	var check = false;
	 var str = document.getElementById('birthday').value.trim();    
	    if(str.length!=0){    
	        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	        var r = str.match(reg);     
	        if(r==null)
	        alert('对不起，您输入的日期格式不正确!');
	        check = false;
	        }if(r!=null){
	        	check = true;
	        }
	        return check;
	        }

function long()     
{     
        var str = document.getElementById('name').value.trim();    
        if(str.length!=0){    
        reg=/^.{1,30}$/; 
        if(!reg.test(str)){    
            alert("输入字符过长，会导致添加失败哦");//请将“字符串类型”要换成你要验证的那个属性名称！    
            document.getElementById("name").value="";
        }    
        }    
}

function addr()
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

function change(){
	alert("修改信息!");
}

function check() {
	var check = IsPhone()&&IsEmail()&&Isbank()&&haha();
	if(check==false){
		alert("注意输入格式是否正确！");
	}else{
		alert("处理成功");
	}
	return check;
}

//--------------------------------------------------------------

//获取字符串长度（汉字算两个字符，字母数字算一个）
function getByteLen(val) {
  var len = 0;
  for (var i = 0; i < val.length; i++) {
    var a = val.charAt(i);
    if (a.match(/[^\x00-\xff]/ig) != null) {
      len += 2;
    }
    else {
      len += 1;
    }
  }
  return len;
}
// 只要键盘一抬起就验证编辑框中的文字长度，最大字符长度可以根据需要设定
function checkLength(obj) {
  var maxChars = 300;//最多字符数 
  var curr = maxChars - getByteLen(obj.value);
  if (curr > 0) {
    document.getElementById("checklen").innerHTML = curr.toString();
  } else {
    document.getElementById("checklen").innerHTML = '0';
    document.getElementById("textarea2").readOnly = true;
  }
}




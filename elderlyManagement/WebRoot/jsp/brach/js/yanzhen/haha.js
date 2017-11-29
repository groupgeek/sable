function haha(){
	 var str = document.getElementById('str').value.trim();  
	    if(str.length!=0){    
	        var reg = /^(\d{1,4})(-|\/)(\d{1,2})\2(\d{1,2})$/;     
	        var r = str.match(reg);  
	        if(r==null)
	            alert('对不起，您输入的日期格式不正确!');
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
       			 alert('价格太高了哦！');//请将“数字”改成你要验证的那个属性名称！    
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
             			 alert('价格太高了哦！');//请将“数字”改成你要验证的那个属性名称！    
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
  var maxChars = 120;//最多字符数   
  var curr = maxChars - getByteLen(obj.value);
  if (curr > 0) {
    document.getElementById("checklen").innerHTML = curr.toString();
  } else {
    document.getElementById("checklen").innerHTML = '0';
    document.getElementById("textarea2").readOnly = true;
  }
}



function hidden(){
	alert(0);
	var value = document.getElementById("selectErrors");
	var index = value.selectedIndex ;
	var val = value.options[index].value; 
	alert(val);
	
}

$('#selectErrors').mouseleave(function (){
	var value = document.getElementById("selectErrors");
	var index = value.selectedIndex ;
	var val = value.options[index].value; 
	if(val == 'true'){
		$('#film').hide();
		$('#vid').show();
	}if(val == 'false'){
		$('#film').show();
		$('#vid').hide();
	}
	
});

$('#vid').hide();
$('#line').hide();
$('#selectErro').mouseleave(function (){
	var value = document.getElementById("selectErro");
	var index = value.selectedIndex;
	var val = value.options[index].value; 
	var line = document.getElementById("actline").value;
	var video = document.getElementById("actvideo").value;
	if(val == 'true'){           	  //线上
		if(line == 'true'){
			$('#vidline').show();    //自带链接
			$('#vidfilm').hide();    //视频和添加视频
			$('#line').show();       //链接
			$('#vid').hide();        //更换视频
		}if(line == 'false'){
			$('#vid').hide();        //更换视频
			$('#vidline').hide();    //自带链接
			$('#vidfilm').hide();    //视频和添加视频
			$('#line').show();       //链接
		}
	}if(val == 'false'){                       //线下
		if(line == 'false'){
			$('#vidfilm').show();    //视频和添加视频
			$('#vidline').hide();    //自带链接
			$('#line').hide();
			$('#vid').hide();        //更换视频
		}if(line == 'true'){
			$('#vid').show();        //更换视频
			$('#vidline').hide();    //自带链接
			$('#vidfilm').hide();    //视频和添加视频
			$('#line').hide();       //链接
		}
		
		
	}
	
});



/*function videoLine(){
	
	
}*/

/**/

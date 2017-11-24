$(document).ready(function(){
	var username = document.getElementById('username');
	var email = document.getElementById("email");
	var messagetime = document.getElementById("messagetime");
	var message = document.getElementById("message");
	var root = $("#root").val();
    var messageid = document.getElementById("messageid").value;
    var messageCustom = new Object();
    messageCustom.messageid = messageid;
    $.ajax({
        type : 'post',
        contentType : 'application/json;charset=utf-8',        
        url : root+'/ceo/newmessage.action',    
        data : JSON.stringify(messageCustom),
        success : function(result) {  
        	if(result != null){
        		username.innerText=result.username;
        		email.innerText=result.email;
        		messagetime.innerText=result.stringDate;
        		message.innerText=result.messagecontext;        	
        	}
        }
    });
});
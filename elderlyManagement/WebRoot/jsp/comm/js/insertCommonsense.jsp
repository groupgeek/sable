<html>
<head>
    <meta charset="UTF-8">
    <title>wangEditor demo</title>
     <script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.min.js" type="text/javascript"></script>
		    <script type="text/javascript"  src="${pageContext.request.contextPath}/jsp/comm/wangEditor-3.0.10/release/wangEditor.min.js"></script>
		      <link rel="stylesheet" href="${pageContext.request.contextPath}/jsp/comm/wangEditor-3.0.10/release/wangEditor.min.css">
	
</head>
<body>

<form  action="${pageContext.request.contextPath }/Commonsense/insert" method="post">  
		标题：<input type="text" name="title" value="${ commonsense.title}"><br>
		类别：<input type="text" name="contexttype" value="${commonsense.contexttype} " ><br>
	
    <div id="div1"></div>
    <input type="hidden" id = "textData" name = "context" value="${commonsense.context} ">
   <input type="submit" value="保存" >
</form>

    <script type="text/javascript">
        var E = window.wangEditor;
        var editor = new E('#div1');
         var $text1 = $('#textData');
          editor.customConfig.onchange = function (text) {
           
            $text1.val(editor.txt.text());
        };
        editor.customConfig.uploadImgServer = '/elderlyManagement/Commonsense/file';
        
        editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;

        editor.customConfig.uploadImgMaxLength = 5;

        editor.customConfig.uploadFileName = 'myFileName';
        
        editor.customConfig.debug=true;editor.customConfig.debug=true;
        
        editor.customConfig.uploadImgHeaders = {

        	       'Accept' : 'multipart/form-data'

        	   };   
        editor.create();
  
    </script>
</body>
</html>
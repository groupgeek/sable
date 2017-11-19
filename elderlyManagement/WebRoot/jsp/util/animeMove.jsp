<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="UTF-8">
<style>
#oblong {
	width: 200px;
	height: 200px;
	background-image:
		url('${pageContext.request.contextPath }/jsp/util/images/65.gif');
	background-repeat: no-repeat;
	z-index: 1000;
	position: fixed;
	/* left: 1200px; */
	right: 10px;
	top: 500px;
}
</style>
</head>
<body>
	<div id="oblong"></div>
</body>
<script type="text/javascript">
	document.getElementById('oblong').onmousedown = function() {
		var oblong = document.getElementById("oblong");
		oblong.style.cursor = "pointer";
		document.onmousemove = function() {
			var x = event.clientX;
			var y = event.clientY;
			oblong.style.position = 'fixed';
			oblong.style.left = (x - 100) + 'px';
			oblong.style.top = (y - 100) + 'px';
		}
	}
	document.getElementById("oblong").onmouseup = function() {

		document.onmousemove = false;
	}
</script>
</html>

<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta charset="utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<meta name="description" content="">
<meta name="author" content="">

<title>我的活动</title>

<%-- 	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/example.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/edu/css/sweet-alert.css"> --%>

<!-- Bootstrap Core CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/bootstrap.min.css"
	type="text/css">
<script type="text/javascript"
	src="//g.alicdn.com/de/prismplayer/2.3.0/aliplayer-min.js"></script>
<link rel="stylesheet"
	href="//g.alicdn.com/de/prismplayer/2.3.0/skins/default/aliplayer-min.css" />
<!-- Custom CSS -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/css/style.css">


<!-- Custom Fonts -->
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/font-awesome/css/font-awesome.min.css"
	type="text/css">
<link rel="stylesheet"
	href="${pageContext.request.contextPath }/jsp/edu/fonts/font-slider.css"
	type="text/css">

<!-- jQuery and Modernizr-->
<script src="${pageContext.request.contextPath }/jsp/js/jquery-3.2.1.js"></script>

<!-- Core JavaScript Files -->
<script
	src="${pageContext.request.contextPath }/jsp/edu/js/bootstrap.min.js"></script>

<script
	src="${pageContext.request.contextPath }/jsp/edu/js/photo-gallery.js"></script>

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="js/html5shiv.js"></script>
        <script src="js/respond.min.js"></script>
    <![endif]-->
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jsp/edu/css/example.css">
<link rel="stylesheet" type="text/css"
	href="${pageContext.request.contextPath }/jsp/edu/css/sweet-alert.css">
</head>
<body>
	<c:import url="head.jsp"></c:import>
	<!--//////////////////////////////////////////////////-->
	<!--///////////////////Product Page///////////////////-->
	<!--//////////////////////////////////////////////////-->
	<div id="page-content" class="single-page">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<ul class="breadcrumb">
						<li><a
							href="${pageContext.request.contextPath }/jsp/edu/index.jsp">主页</a>
						</li>
						<li><a href="javascript:;">我的活动</a>
						</li>
					</ul>
				</div>
			</div>
			<div class="row">
				<div id="main-content">

						<ul class="nav nav-tabs">
							<li class="active"><a href="#ongoing">正在进行</a></li>
							<li><a href="#noCarriedOut">未开展</a></li>
							<li><a href="#alreadyDone">已开展</a></li>
						</ul>
						<div class="tab-content">
							<div id="ongoing" class="tab-pane fade in active">
							</div>
							<div id="noCarriedOut" class="tab-pane fade">
							</div>
							<div id="alreadyDone" class="tab-pane fade">
							</div>
						</div>
						<!-- 分页 -->
						<!-- <div class="row text-center">
							<div id="activityPage">
								<p>
									当前为第<strong id="currentPage">1</strong>页,共<strong id="pageSum">0</strong>页
								</p>
							</div>
							<ul class="pagination" id="pageUl">
							  <li class="active" id="home"><a href="#navData">首页</a></li>
							  <li id="previousPage"><a href="#navData">上一页</a></li>
							  <li id="nextPage"><a href="#navData">下一页</a></li>
							  <li id="lastPage"><a href="#navData">尾页</a></li>
							</ul>
						</div> -->
					</div>
				</div>
			</div>
	</div>
	<c:import url="footer.jsp"></c:import>
	<!-- IMG-thumb -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body"></div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/edu/js/actReg.js"></script>
	<script
		src="${pageContext.request.contextPath }/jsp/edu/js/sweet-alert.min.js"></script>
		
	<script type="text/javascript"
		src="${pageContext.request.contextPath }/jsp/edu/js/myActivities.js"></script>
	<script>
		$(document).ready(function() {
			$(".nav-tabs a").click(function() {
				$(this).tab('show');
			});
			$('.nav-tabs a').on('shown.bs.tab', function(event) {
				var x = $(event.target).text(); // active tab
				var y = $(event.relatedTarget).text(); // previous tab
				$(".act span").text(x);
				$(".prev span").text(y);
			});
		});
	</script>
</body>
</html>

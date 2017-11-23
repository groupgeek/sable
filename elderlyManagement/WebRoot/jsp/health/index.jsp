<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="../../docs-assets/ico/favicon.png">

    <title>健康管理 </title>

    <!-- Bootstrap core CSS -->
    <link href="${pageContext.request.contextPath }/jsp/health/assets/css/bootstrap.css" rel="stylesheet">


    <!-- Custom styles for this template -->
    <link href="${pageContext.request.contextPath }/jsp/health/assets/css/main.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/health/assets/js/hover.zoom.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/healthy/assets/js/hover.zoom.conf.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>

    <!-- Static navbar -->
    <div class="navbar navbar-inverse navbar-static-top">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="index.jsp">首页</a>
        </div>
         <div class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="work.html">食疗</a></li>
            <li><a href="about.html">活动</a></li>
            <li><a href="blog.html">健康监测</a></li>
           
          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </div>

	<!-- +++++ Welcome Section +++++ -->
	<div id="ww">
	    <div class="container">
			<div class="row">
				<div class="col-lg-8 col-lg-offset-2 centered">
					<img src="src="/upload/${activity[0].avatar}" alt="Stanley">
					<h1>尊敬的： ${mm.username }</h1>
					<p>${mm.beforemedicalrecords}</p>
					<p>${mm.personalrecords}</p>
					
				
				</div><!-- /col-lg-8 -->
			</div><!-- /row -->
	    </div> <!-- /container -->
	</div><!-- /ww -->
    <div class="copyrights">Collect from <a href="#" >xiaohe</a></div>
	
	
	<!-- +++++ Projects Section +++++ -->
	<div  style="height: 40px;width: 100%;border:1px solid #000;background-color: rgb(26,188,156);">
	<p style="font-size: 20px;padding-top: 5px;padding-left: 20px;color: #ffffff">活动推荐 </p></div>
	<div class="container pt">
	
		<div class="row mt centered">	
		
	
	
			<div class="col-lg-4" style="min-height: 300px;">
			
				<a class="zoom green" href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[0].activityid}"><img class="img-responsive"
												src="/upload/${activity[0].activitypicture }" style="width:370px;height:275px"/></a>
									
				<a href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[0].activityid}" }><p>${activity[0].activityname}</p></a>

			</div>
			<div class="col-lg-4">
				<a class="zoom green" href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[1].activityid}"><img class="img-responsive"
												src="/upload/${activity[1].activitypicture }" alt="" style="width:370px;height:275px"/></a>
				<a href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[1].activityid}" ><p>${activity[1].activityname }</p></a>

			</div>
				<div class="col-lg-4">
				<a class="zoom green" href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[2].activityid}"><img class="img-responsive"
												src="/upload/${activity[2].activitypicture }" alt="" style="width:370px;height:275px"/></a>
				<a href="${pageContext.request.contextPath }/health/activityInfo.action?activityid=${activity[2].activityid}"><p>${activity[2].activityname }</p></a>

			</div>
		</div><!-- /row -->
	</div><!-- /container -->
	
	
	<!-- +++++ Footer Section +++++ -->
		
		<div  style="height: 40px;width: 100%;border:1px solid #000;background-color: rgb(26,188,156);" >
		<p style="font-size: 20px;padding-top: 5px;padding-left: 20px;color: #ffffff">商品推荐 </p>	</div>
	<div id="footer">
		<div class="container">
				<div class="row mt centered">	
		
	
	
			<div class="col-lg-4">
					<img class="img-responsive"style="width:370px;height:150px"
												src="/upload/${recommendproduct[0].picture}" alt="" /></a>
				<p>${recommendproduct[0].productname}</p>
				</div>
				<!-- /col-lg-4 -->
				
				<div class="col-lg-4">
					<img class="img-responsive"style="width:370px;height:150px"
												src="/upload/${recommendproduct[0].picture}" alt="" /></a>
				<p>${recommendproduct[1].productname}</p>
				</div><!-- /col-lg-4 -->
				
				<div class="col-lg-4">
						<img class="img-responsive"style="width:370px;height:150px"
												src="/upload/${recommendproduct[0].picture}" alt="" /></a>
				<p>${recommendproduct[2].productname}</p>
				</div><!-- /col-lg-4 -->
			
			</div>
		
		</div>
		<div  style="height: 40px">
		<center>
		<p><bt>Client: <a href="#">BlackTie.co</a></bt> - <bt>孝和: <a href="#">Illustration</a></bt> - <bt>Date: <a href="#">January 2014</a></bt></p>
		<	</div> 
	</div>
	
	

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="${pageContext.request.contextPath }/jsp/activity/assets/js/bootstrap.min.js"></script>
  </body>
</html>

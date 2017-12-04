<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
  <head>
    <!-- start: Meta -->
	<meta charset="utf-8">
	<title>Ceo管理员系统</title>
	<meta name="description" content="Bootstrap Metro Dashboard">
	<meta name="author" content="Dennis Ji">
	<meta name="keyword" content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
	<!-- end: Meta -->
	
	<!-- start: Mobile Specific -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- end: Mobile Specific -->
	
	<!-- start: CSS -->
	<link id="bootstrap-style" href="${pageContext.request.contextPath }/jsp/ceo/css/bootstrap.min.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/jsp/ceo/css/bootstrap-responsive.min.css" rel="stylesheet">
	<link id="base-style" href="${pageContext.request.contextPath }/jsp/ceo/css/style.css" rel="stylesheet">
	<link id="base-style-responsive" href="${pageContext.request.contextPath }/jsp/ceo/css/style-responsive.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath }/jsp/ceo/newcss/table.css" rel="stylesheet">
	<link href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext' rel='stylesheet' type='text/css'>
	<!-- end: CSS -->
	
	<!-- start: Favicon -->
	<link rel="shortcut icon" href="${pageContext.request.contextPath }/jsp/ceo/img/favicon.ico">
	<!-- end: Favicon -->
	
	<script type="text/javascript" src="//g.alicdn.com/de/prismplayer/2.3.0/aliplayer-min.js"></script>
	<link rel="stylesheet" href="//g.alicdn.com/de/prismplayer/2.3.0/skins/default/aliplayer-min.css" />
	<link href="${pageContext.request.contextPath }/jsp/util/_css/wait.css" rel="stylesheet" type="text/css" />
	
	<style type="text/css">
	#header {
	height:355px;
	width:100%;
    padding-up:10px;
    padding-left:0px;
	}
	#center{
	height:300px;
	width:100%;
	}
	#nav {
   	 line-height:30px;
  	 height:100%;
  	 width:45%;
   	 float:left;
   	 padding:5px;	      
	}
	#section {
	height:100%;
   	 width:49%;
   	 float:left;
   	 padding:10px;	 	 
	}
	#section1{
	width:100%;
	height:140px;
	}
	#image1{ 
       	
        width:300px; 
        height:350px;
        float:left; 
 
    }
    #footer{
    	width:100%;
    	height:100%;	 	
    }
    .message{
    	padding-left:30%;
    	width:900px;
    	height:100px;
    }
	</style>
  </head>
  
  <body>
  	<jsp:include page="header.jsp"></jsp:include>
  	<div class="container-fluid-full">
	<div class="row-fluid">
	<jsp:include page="menu.jsp"></jsp:include>
  	<!-- start: Content -->
			<div id="content" class="span10">
			
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="${pageContext.request.contextPath }/ceo/index.action">管理员界面</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/ceo/gallery.action">活动中心</a> 	
					<i class="icon-angle-right"></i>
				</li>
				<li><a>活动详细信息</a></li>
			</ul>		
			<div class="row-fluid sortable">	
				<div class="box span12">
					<div class="box-header">
						<h2><i class="halflings-icon white align-justify"></i><span class="break"></span>活动详情</h2>
						<div class="box-icon">
							
							<a href="${pageContext.request.contextPath }/ceo/gallery.action" ><i class="halflings-icon white remove"></i></a>
						</div>
					</div>
					<div class="box-content">
					<form class="form-horizontal" action="">
							<fieldset>
							<input type="hidden" name="productid" value="${findCeoActivity.activityid }"  />
							<div style="padding-bottom: 30px">
								<div id="header">
									
									<div id="nav">
										<%
											String id = request.getParameter("activityid");
											int a = Integer.valueOf(id);
						 				%>
						 				<input type="hidden" id="activityid" value="<%=a %>">
										<input type="hidden" id = "root" value="${pageContext.request.contextPath }">
										<div class="control-group" id="activitypicture">
											<label class="control-label" for="disabledInput">活动照片</label>
											<div class="controls" id="section1">
								  				<img id="image1" src="">
											</div>
							  			</div>							
									</div>
									<div id="section">
										<div class="control-group">
											<label class="control-label" for="disabledInput">活动名称</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productname" value="${findCeoActivity.activityname }" disabled="">
											</div>
							  			</div>
							   			<div class="control-group">
							 				<label class="control-label" for="typeahead">活动类型 </label>
							  				<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="instock" value="${findCeoActivity.activitytypename }" disabled="">
							  				</div>
							  			</div>
							 			 <div class="control-group">
											<label class="control-label" for="optionsCheckbox2">开设分店</label>
											<div class="controls">
							   					<input class="input-xlarge disabled" id="disabledInput" type="text" name="price" value="${findCeoActivity.branchname }" disabled="">
							  				</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">是否线上</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="buyno" value="${findCeoActivity.stringline }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">活动状态</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="purchaseprice" value="${findCeoActivity.activitystatus }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">活动细节</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="good" value="${findCeoActivity.activitydetails }" disabled="">
											</div>
							  			</div>
							  			<div class="control-group">
											<label class="control-label" for="disabledInput">活动日期</label>
											<div class="controls">
								  				<input class="input-xlarge disabled" id="disabledInput" type="text" name="shelflife" value="${findCeoActivity.stringDate }" disabled="">
											</div>
							  			</div>
									</div>
									
								</div>
								<div id="center">
								<div id="nav">
									<div class="control-group" id = "showVideo">
										<label class="control-label">活动视频</label>
										<div class="controls">
											<div  class="prism-player" id="J_prismPlayer"></div>
										</div>								
							  		</div>							  								  		
								</div>
								<div id="section">
									<div class="control-group">
										<label class="control-label" for="disabledInput">报名费</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productionlicensenumber" value="${findCeoActivity.registeryfee }" disabled="">
							  			</div>
							  		</div>
							  		<div class="control-group">
										<label class="control-label">活动支出</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productspecifications" value="${findCeoActivity.activityprice }" disabled="">
							  			</div>
							  		</div>	
							  		<div class="control-group">
										<label class="control-label">活动人数上限</label>
										<div class="controls">
							   				<input class="input-xlarge disabled" id="disabledInput" type="text" name="productspecifications" value="${findCeoActivity.maxnum }" disabled="">
							  			</div>
							  		</div>						  
								</div>
								</div>
								<div id="footer">
									<div class="control-group">
											<label class="control-label" for="disabledInput">活动细节</label>
											<div class="controls">
												<textarea rows="4" disabled="" style="width: 700px; background-color: #FCFCFC;">${findCeoActivity.activitydetails }</textarea>
								  				
											</div>
							  		</div>
								</div>
							</div>
							</fieldset>
						  </form>
						<%-- <table class="table table-bordered table-striped table-condensed">
							  <thead>
								  <tr>
									  <th>活动属性</th>
									  <th>详细信息</th>                                        
								  </tr>
							  </thead>
							  <tbody>
								<tr>
									<td>活动名称</td>
									<td class="center">${findCeoActivity.activityname }</td>								                                    
								</tr>
								<tr>
									<td>活动类型</td>
									<td class="center">${findCeoActivity.activitytypename }</td>									                                      
								</tr>
								<tr>
									<td>开设分店</td>
									<td class="center">${findCeoActivity.branchname }</td>                                        
								</tr>
								<tr>
									<td>是否线上</td>
									<td class="center">${findCeoActivity.stringline }</td>									                                        
								</tr>
								<tr>
									<td>活动状态</td>
									<td class="center">${findCeoActivity.activitystatus }</td>								                                        
								</tr>
								<tr>
									<td>活动细节</td>
									<td class="center">${findCeoActivity.activitydetails }</td>									                                       
								</tr>								 
								<tr>
									<td>活动日期</td>
									<td class="center">${findCeoActivity.stringDate }</td>                                        
								</tr>  
								<tr>
									<td>注册费</td>
									<td class="center">${findCeoActivity.registeryfee }</td>                                        
								</tr>
								<tr>
									<td>活动支出</td>
									<td class="center">${findCeoActivity.activityprice }</td>                                        
								</tr>                  
							  </tbody>
						 </table>   --%>
						
					</div>
				</div><!--/span-->
			</div><!--/row-->
	</div><!--/.fluid-container-->
	
			<!-- end: Content -->
		</div><!--/#content.span10-->
		</div><!--/fluid-row-->
		
	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a>
			<a href="#" class="btn btn-primary">Save changes</a>
		</div>
	</div>
	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1" role="dialog" aria-hidden="true">
		<div class="modal-content">
			<ul class="list-inline item-details">
				<li><a href="#">Admin templates</a></li>
				<li><a href="http://themescloud.org">Bootstrap themes</a></li>
			</ul>
		</div>
	</div>
	<div class="clearfix"></div>
	
	<footer>
		<p>
			<span style="text-align:left;float:left">&copy; 2017 <a href="${pageContext.request.contextPath }/ceo/index.action" alt="Bootstrap_Metro_Dashboard">欢迎使用Ceo专用管理站点！</a></span>
		</p>
	</footer>
	<!-- start: JavaScript-->

		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-1.9.1.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-migrate-1.0.0.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery-ui-1.10.0.custom.min.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.ui.touch-punch.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/modernizr.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/bootstrap.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.cookie.js"></script>	
		<script src='${pageContext.request.contextPath }/jsp/ceo/js/fullcalendar.min.js'></script>	
		<script src='${pageContext.request.contextPath }/jsp/ceo/js/jquery.dataTables.min.js'></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/excanvas.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.pie.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.stack.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.flot.resize.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.chosen.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.uniform.min.js"></script>		
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.cleditor.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.noty.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.elfinder.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.raty.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.iphone.toggle.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.uploadify-3.1.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.gritter.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.imagesloaded.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.masonry.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.knob.modified.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/jquery.sparkline.min.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/counter.js"></script>	
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/retina.js"></script>
		<script src="${pageContext.request.contextPath }/jsp/ceo/js/custom.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath }/jsp/ceo/newjs/activity.js"></script>
	<!-- end: JavaScript-->
  </body>
</html>

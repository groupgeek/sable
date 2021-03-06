
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>客户管理</title>
<meta name="description" content="Bootstrap Metro Dashboard">
<meta name="author" content="Dennis Ji">
<meta name="keyword"
	content="Metro, Metro UI, Dashboard, Bootstrap, Admin, Template, Theme, Responsive, Fluid, Retina">
<!-- end: Meta -->

<!-- start: Mobile Specific -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- end: Mobile Specific -->

<link id="bootstrap-style"
	href="${pageContext.request.contextPath }/jsp/admin/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="${pageContext.request.contextPath }/jsp/admin/css/bootstrap-responsive.min.css"
	rel="stylesheet">
<link id="base-style"
	href="${pageContext.request.contextPath }/jsp/admin/css/style.css"
	rel="stylesheet">
<link id="base-style-responsive"
	href="${pageContext.request.contextPath }/jsp/admin/css/style-responsive.css"
	rel="stylesheet">
<link
	href='http://fonts.googleapis.com/css?family=Open+Sans:300italic,400italic,600italic,700italic,800italic,400,300,600,700,800&subset=latin,cyrillic-ext,latin-ext'
	rel='stylesheet' type='text/css'>
<link id="superAdmin"
	href="${pageContext.request.contextPath }/jsp/admin/page/css/user_employee.css"
	rel="stylesheet">
<!-- end: CSS -->


<!-- The HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
	  	<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>
		<link id="ie-style" href="css/ie.css" rel="stylesheet">
	<![endif]-->

<!--[if IE 9]>
		<link id="ie9style" href="css/ie9.css" rel="stylesheet">
	<![endif]-->

<!-- start: Favicon -->
<link rel="shortcut icon" href="img/favicon.ico">
<!-- end: Favicon -->
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/jsp/comm/GridManager_2.3.14/css/GridManager.min.css">
    <script src="${pageContext.request.contextPath}/jsp/comm//GridManager_2.3.14/js/GridManager.js" type="text/javascript" ></script>
    <script src="${pageContext.request.contextPath}/jsp/js/jquery-3.2.1.min.js" type="text/javascript"></script> 
 <style>
       plugin-action{
            display: inline-block;
            color: steelblue;
            margin-right: 10px;
            cursor: pointer;
        }
        .plugin-action:hover{
            text-decoration:underline;
        }
        .search-area{
            padding: 10px 20px;
            border: 1px solid #ccc;
            background: #efefef;
        }
        .search-area .sa-ele{
            display: inline-block;
            margin-right: 20px;
            font-size: 12px;
        }
        .search-area .sa-ele .se-title{
            display: inline-block;
            margin-right: 10px;
        }
        .search-area .sa-ele .se-con{
            display: inline-block;
            width:180px;
            height: 24px;
            border: 1px solid #ccc;
            padding: 0px 4px;
            line-height: 24px;
        }
        .search-area .sa-ele .search-action, .search-area .sa-ele .reset-action{
            display: inline-block;
            width:80px;
            height: 26px;
            border: 1px solid #ccc;
            background: #e8e8e8;
            padding: 0px 4px;
            line-height: 26px;
            text-align: center;
            cursor: pointer;
            margin-right: 10px;
        }
        .search-area .sa-ele .search-action:hover, .search-area .sa-ele .reset-action:hover{
            opacity: 0.7;
        }
    </style>



</head>

<body>
	<input id="root" type="hidden"
		value="${pageContext.request.contextPath }">
	<!-- start: Header -->
	<div class="navbar">
		<div class="navbar-inner">
			<div class="container-fluid">
				<a class="btn btn-navbar" data-toggle="collapse"
					data-target=".top-nav.nav-collapse,.sidebar-nav.nav-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span> </a> <a class="brand" href="index.html"><span>JANUX</span>
				</a>

				<!-- start: Header Menu -->
				<div class="nav-no-collapse header-nav">
					<ul class="nav pull-right">
						<li class="dropdown hidden-phone"><a
							class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-bell"></i> <span class="badge red"> 7 </span> </a>
							<ul class="dropdown-menu notifications">
								<li class="dropdown-menu-title"><span>You have 11
										notifications</span> <a href="#refresh"><i class="icon-repeat"></i>
								</a>
								</li>
								<li><a href="#"> <span class="icon blue"><i
											class="icon-user"></i> </span> <span class="message">New user
											registration</span> <span class="time">1 min</span> </a>
								</li>
								<li><a href="#"> <span class="icon green"><i
											class="icon-comment-alt"></i> </span> <span class="message">New
											comment</span> <span class="time">7 min</span> </a>
								</li>
								<li><a href="#"> <span class="icon green"><i
											class="icon-comment-alt"></i> </span> <span class="message">New
											comment</span> <span class="time">8 min</span> </a>
								</li>
								<li><a href="#"> <span class="icon green"><i
											class="icon-comment-alt"></i> </span> <span class="message">New
											comment</span> <span class="time">16 min</span> </a>
								</li>
								<li><a href="#"> <span class="icon blue"><i
											class="icon-user"></i> </span> <span class="message">New user
											registration</span> <span class="time">36 min</span> </a>
								</li>
								<li><a href="#"> <span class="icon yellow"><i
											class="icon-shopping-cart"></i> </span> <span class="message">2
											items sold</span> <span class="time">1 hour</span> </a>
								</li>
								<li class="warning"><a href="#"> <span class="icon red"><i
											class="icon-user"></i> </span> <span class="message">User
											deleted account</span> <span class="time">2 hour</span> </a>
								</li>
								<li class="warning"><a href="#"> <span class="icon red"><i
											class="icon-shopping-cart"></i> </span> <span class="message">New
											comment</span> <span class="time">6 hour</span> </a>
								</li>
								<li><a href="#"> <span class="icon green"><i
											class="icon-comment-alt"></i> </span> <span class="message">New
											comment</span> <span class="time">yesterday</span> </a>
								</li>
								<li><a href="#"> <span class="icon blue"><i
											class="icon-user"></i> </span> <span class="message">New user
											registration</span> <span class="time">yesterday</span> </a>
								</li>
								<li class="dropdown-menu-sub-footer"><a>View all
										notifications</a>
								</li>
							</ul>
						</li>
						<!-- start: Notifications Dropdown -->
						<li class="dropdown hidden-phone"><a
							class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-calendar"></i> <span class="badge red"> 5
							</span> </a>
							<ul class="dropdown-menu tasks">
								<li class="dropdown-menu-title"><span>You have 17
										tasks in progress</span> <a href="#refresh"><i
										class="icon-repeat"></i> </a>
								</li>
								<li><a href="#"> <span class="header"> <span
											class="title">iOS Development</span> <span class="percent"></span>
									</span>
										<div class="taskProgress progressSlim red">80</div> </a>
								</li>
								<li><a href="#"> <span class="header"> <span
											class="title">Android Development</span> <span
											class="percent"></span> </span>
										<div class="taskProgress progressSlim green">47</div> </a>
								</li>
								<li><a href="#"> <span class="header"> <span
											class="title">ARM Development</span> <span class="percent"></span>
									</span>
										<div class="taskProgress progressSlim yellow">32</div> </a>
								</li>
								<li><a href="#"> <span class="header"> <span
											class="title">ARM Development</span> <span class="percent"></span>
									</span>
										<div class="taskProgress progressSlim greenLight">63</div> </a>
								</li>
								<li><a href="#"> <span class="header"> <span
											class="title">ARM Development</span> <span class="percent"></span>
									</span>
										<div class="taskProgress progressSlim orange">80</div> </a>
								</li>
								<li><a class="dropdown-menu-sub-footer">View all tasks</a>
								</li>
							</ul>
						</li>
						<!-- end: Notifications Dropdown -->
						<!-- start: Message Dropdown -->
						<li class="dropdown hidden-phone"><a
							class="btn dropdown-toggle" data-toggle="dropdown" href="#">
								<i class="icon-envelope"></i> <span class="badge red"> 4
							</span> </a>
							<ul class="dropdown-menu messages">
								<li class="dropdown-menu-title"><span>You have 9
										messages</span> <a href="#refresh"><i class="icon-repeat"></i> </a>
								</li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar"> </span> <span
										class="header"> <span class="from"> Dennis Ji </span> <span
											class="time"> 6 min </span> </span> <span class="message">
											Lorem ipsum dolor sit amet consectetur adipiscing elit, et al
											commore </span> </a>
								</li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar"> </span> <span
										class="header"> <span class="from"> Dennis Ji </span> <span
											class="time"> 56 min </span> </span> <span class="message">
											Lorem ipsum dolor sit amet consectetur adipiscing elit, et al
											commore </span> </a>
								</li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar"> </span> <span
										class="header"> <span class="from"> Dennis Ji </span> <span
											class="time"> 3 hours </span> </span> <span class="message">
											Lorem ipsum dolor sit amet consectetur adipiscing elit, et al
											commore </span> </a>
								</li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar"> </span> <span
										class="header"> <span class="from"> Dennis Ji </span> <span
											class="time"> yesterday </span> </span> <span class="message">
											Lorem ipsum dolor sit amet consectetur adipiscing elit, et al
											commore </span> </a>
								</li>
								<li><a href="#"> <span class="avatar"><img
											src="img/avatar.jpg" alt="Avatar"> </span> <span
										class="header"> <span class="from"> Dennis Ji </span> <span
											class="time"> Jul 25, 2012 </span> </span> <span class="message">
											Lorem ipsum dolor sit amet consectetur adipiscing elit, et al
											commore </span> </a>
								</li>
								<li><a class="dropdown-menu-sub-footer">View all
										messages</a>
								</li>
							</ul>
						</li>

						<!-- start: User Dropdown -->
						<li class="dropdown"><a class="btn dropdown-toggle"
							data-toggle="dropdown" href="#"> <i
								class="halflings-icon white user"></i> Dennis Ji <span
								class="caret"></span> </a>
							<ul class="dropdown-menu">
								<li class="dropdown-menu-title"><span>Account
										Settings</span>
								</li>
								<li><a href="#"><i class="halflings-icon user"></i>
										Profile</a></li>
								<li><a href="login.html"><i class="halflings-icon off"></i>
										Logout</a></li>
							</ul>
						</li>
						<!-- end: User Dropdown -->
					</ul>
				</div>
				<!-- end: Header Menu -->

			</div>
		</div>
	</div>
	<!-- start: Header -->
	<div class="copyrights">
		Collect from <a href="http://www.cssmoban.com/">企业网站模板</a>
	</div>

	<div class="container-fluid-full">
		<div class="row-fluid">

			<!-- start: Main Menu -->
			<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
							<li id = "home"><a href="${pageContext.request.contextPath }/jsp/comm/js/indeCommonsense.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">主页</span>
						</a>
						</li>
						<li id="userInfo"><a
							href="${pageContext.request.contextPath }/Commonsense/insert"><i
								class="icon-bar-chart"></i><span class="hidden-tablet">添加信息</span>
						</a>
						</li>
						
						
						<!-- <li><a class="dropmenu" href="JavaScript:;"><i
								class="icon-folder-close-alt"></i><span class="hidden-tablet">
									活动管理</span><span class="label label-important"> 3 </span>
						</a>
							<ul>
								<li><a class="submenu" href="JavaScript:;"><i
										class="icon-file-alt"></i><span class="hidden-tablet">
											教育</span>
								</a>
								</li>
								<li><a class="submenu" href="JavaScript:;"><i
										class="icon-file-alt"></i><span class="hidden-tablet">
											健康</span>
								</a>
								</li>
							</ul>
						</li> -->

					</ul>
				</div>
			</div>

			<!-- start: Content -->
			<div id="content" class="span10">
			
			<ul class="breadcrumb">
				<li>
					<i class="icon-home"></i>
					<a href="${pageContext.request.contextPath }/jsp/admin/index.jsp">主页</a> 
					<i class="icon-angle-right"></i>
				</li>
				<li>
					<a href="${pageContext.request.contextPath }/jsp/admin/page/user.jsp">编辑管理</a>
				</li>
			</ul>
			
				<div class="row-fluid sortable">
					<div class="box span12">

						<div class="box-header" data-original-title>
							<h2>
								<i class="halflings-icon white user"></i><span class="break"></span>文章信息管理
							</h2>
							<h2>
								<span class="break"></span>文章数目<span id="userSum"></span>人
							</h2>
							<div class="box-icon">
								<a href="#" class="btn-minimize"><i
									class="halflings-icon white chevron-up"></i> </a>
							</div>
						</div>
						<div class="box-content " id="box">
							<div style="width: 100%;height: 400px">
                           <div class="search-area">
		<div class="sa-ele">
			<label class="se-title">id:</label>
			<input class="se-con" name="commonsenseid">
		</div>
		<div class="sa-ele">
			<label class="se-title">标题:</label>
			<input class="se-con" name="title">
		</div>
		<div class="sa-ele">
			<label class="se-title">类别:</label>
			<input class="se-con" name="websitetype">
		</div>
		<div class="sa-ele">
			<button id="search-action">搜索</button>
			<button class="reset-action">重置</button>
		</div>
	</div>
 <br/>
   <table id ='soft_table' grid-manager="demo-baseCode" style="table-layout: auto"></table>
  
                         
                         
                         
							</div>
							


						</div>

					</div>
				</div>
			</div>
			<!--/span-->
		</div>

	</div>

	<div class="modal hide fade" id="myModal">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal">×</button>
			<h3>Settings</h3>
		</div>
		<div class="modal-body">
			<p>Here settings can be configured...</p>
		</div>
		<div class="modal-footer">
			<a href="#" class="btn" data-dismiss="modal">Close</a> <a href="#"
				class="btn btn-primary">Save changes</a>
		</div>
	</div>

	<div class="common-modal modal fade" id="common-Modal1" tabindex="-1"
		role="dialog" aria-hidden="true">
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
		<span style="text-align:left;float:left">&copy; 2013 <a
			href="javaScript:;" alt="Bootstrap_Metro_Dashboard">哈哈哈哈哈哈哈哈哈或哈哈</a>
		</span>

	</p>

	</footer>

	<!-- start: JavaScript-->

	<script src="${pageContext.request.contextPath }/jsp/js/jquery.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery-migrate-1.0.0.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery-ui-1.10.0.custom.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.ui.touch-punch.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/modernizr.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/bootstrap.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.cookie.js"></script>

	<script
		src='${pageContext.request.contextPath }/jsp/admin/js/fullcalendar.min.js'></script>

	<script
		src='${pageContext.request.contextPath }/jsp/admin/js/jquery.dataTables.min.js'></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/excanvas.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.pie.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.stack.js"></script><br>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.flot.resize.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.chosen.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.uniform.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.cleditor.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.noty.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.elfinder.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.raty.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.iphone.toggle.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.uploadify-3.1.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.gritter.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.imagesloaded.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.masonry.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.knob.modified.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/jquery.sparkline.min.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/counter.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/retina.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/js/custom.js"></script>

	<script
		src="${pageContext.request.contextPath }/jsp/admin/page/js/user.js"></script>

	<!-- end: JavaScript-->
	   <script type="text/javascript">
     var table = document.querySelector('table[grid-manager="demo-baseCode"]');
    var TGM = table.GM({
        supportRemind: true
        ,gridManagerName: 'test'
        ,isCombSorting: true
        ,height: '400px'
        ,supportAjaxPage:true
        ,supportSorting: true
        ,disableCache: false
        ,ajax_url: 'http://127.0.0.1:8080/elderlyManagement/Commonsense/griddemo'
        ,ajax_type: 'POST'
        ,query: {pluginId: 1}
		,textAlign: 'center'
        ,pageSize:30
        ,columnData: [
            {
                key: 'commonsenseid',
                text: '文章id',
                    sorting: 'SAC'
            },{
                key: 'title',
                text: '标题',
                    sorting: ''
            },{
                key: 'websitetype',
                text: '类别'
            },{
                key: 'context1',
                text: '内容',
                template: function(title, rowObject){
                    return '<a class="plugin-action edit-action" href="/elderlyManagement/Commonsense/selOneComm/'+rowObject.commonsenseid+'" >查看</a>'+"/"+
                    '<a class="plugin-action edit-action" href="/elderlyManagement/Commonsense/update/'+rowObject.commonsenseid+'" >修改</a>';
                }
            },{
                key: 'createtime',
                text: '时间'
            },{
            key: 'operation',
            text: '操作',
            template: function(title, rowObject){
                return '<a class="plugin-action edit-action" href="/elderlyManagement/Commonsense/deleteCommonsense/'+rowObject.commonsenseid+'" >删除</a>';
            }}
        ]
        // 分页前事件
        ,pagingBefore: function(query){
            console.log('pagingBefore', query);
        }
        // 分页后事件
        ,pagingAfter: function(data){
            console.log('pagingAfter', data);
        }
        // 排序前事件
        ,sortingBefore: function (data) {
            console.log('sortBefore', data);
        }
        // 排序后事件
        ,sortingAfter: function (data) {
            console.log('sortAfter', data);
        }
        // 宽度调整前事件
        ,adjustBefore: function (event) {
            console.log('adjustBefore', event);
        }
        // 宽度调整后事件
        ,adjustAfter: function (event) {
            console.log('adjustAfter', event);
        }
        // 拖拽前事件
        ,dragBefore: function (event) {
            console.log('dragBefore', event);
        }
        // 拖拽后事件
        ,dragAfter: function (event) {
            console.log('dragAfter', event);
        }
    }, function(query){
        // 渲染完成后的回调函数
        console.log(query);
    });
    console.log('GirdManger version => ', TGM.version)
    // 绑定搜索事件
    document.getElementById('search-action').addEventListener('click', function () {
        var _query = {
        		commonsenseid: document.querySelector('[name="commonsenseid"]').value,
        		title: document.querySelector('[name="title"]').value,
        		websitetype: document.querySelector('[name="websitetype"]').value,
            
        };
        table.GM('setQuery', _query).GM('refreshGrid', function () {
            console.log('搜索成功...');
        });
    });
    // 绑定重置
    document.querySelector('.reset-action').addEventListener('click', function () {
        document.querySelector('[name="commonsenseid"]').value = '';
        document.querySelector('[name="title"]').value = '';
        document.querySelector('[name="websitetype"]').value = '';
       
    });
   
</script>

</body>
</html>

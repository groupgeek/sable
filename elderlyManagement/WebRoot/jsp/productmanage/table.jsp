﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Typography | BlueWhale Admin</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/nav.css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/ie6.css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/ie.css" media="screen" /><![endif]-->
    <link href="${pageContext.request.contextPath }/jsp/productmanage/css/table/demo_page.css" rel="stylesheet" type="text/css" />
    <!-- BEGIN: load jquery -->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.mouse.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.sortable.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/table/jquery.dataTables.min.js" type="text/javascript"></script>
    <!-- END: load jquery -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/productmanage/js/table/table.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/setup.js" type="text/javascript"></script>
    <script type="text/javascript">

        $(document).ready(function () {
            setupLeftMenu();

            $('.datatable').dataTable();
			setSidebarHeight();


        });

    </script>
    <script type="text/javascript">


</script>
</head>
<body>
 <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
              		<h3>孝和集团</h3>
                    <%-- <img src="${pageContext.request.contextPath }/jsp/productmanage/img/xiaohe.jpg" alt="Logo" /> --%></div>
                <div class="floatright">
                    <div class="floatleft">
                        <img src="img/img-profile.jpg" alt="Profile Pic" /></div>
                    <div class="floatleft marginleft10">
                        <ul class="inline-ul floatleft">
                            <li>Hello Admin</li>
                            <li><a href="#">Config</a></li>
                            <li><a href="#">Logout</a></li>
                        </ul>
                        <br />
                        <span class="small grey">Last Login: 3 hours ago</span>
                    </div>
                </div>
                <div class="clear">
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <ul class="nav main">
               <!--  <li class="ic-dashboard"><a href="dashboard.html"><span>Dashboard</span></a> </li> -->
               <!--  <li class="ic-form-style"><a href="javascript:"><span>Controls</span></a>
                    <ul>
                        <li><a href="form-controls.html">Forms</a> </li>
                        <li><a href="buttons.html">Buttons</a> </li>
                        <li><a href="form-controls.html">Full Page Example</a> </li>
                        <li><a href="table.html">Page with Sidebar Example</a> </li>
                    </ul>
                </li> -->
				<!-- <li class="ic-typography"><a href="typography.html"><span>Typography</span></a></li>
                <li class="ic-charts"><a href="charts.html"><span>Charts & Graphs</span></a></li>
                <li class="ic-grid-tables"><a href="table.html"><span>Data Table</span></a></li>
                <li class="ic-gallery dd"><a href="javascript:"><span>Image Galleries</span></a>
               		 <ul>
                        <li><a href="image-gallery.html">Pretty Photo</a> </li>
                        <li><a href="gallery-with-filter.html">Gallery with Filter</a> </li>
                    </ul> 
                </li>
                <li class="ic-notifications"><a href="notifications.html"><span>Notifications</span></a></li>

            </ul>-->
        </div>
        <div class="clear">
        </div>
        <div class="grid_2">
            <div class="box sidemenu">
                <div class="block" id="section-menu">
                    <ul class="section menu">
                        <li><a class="menuitem">Menu 1</a>
                            <ul class="submenu">
                             
                                <li><a href="${pageContext.request.contextPath }/productmanage/producttype.action">增加商品</a> </li>
                            
                                <li><a>Submenu 2</a> </li>
                                <li><a class="active">Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                        <li><a class="menuitem">Menu 2</a>
                            <ul class="submenu">
                                <li><a>Submenu 1</a> </li>
                                <li><a>Submenu 2</a> </li>
                                <li><a>Submenu 3</a> </li>
                                <li><a>Submenu 4</a> </li>
                                <li><a>Submenu 5</a> </li>
                            </ul>
                        </li>
                      
                    </ul>
                </div>
            </div>
        </div>
        <div class="grid_10">
            <div class="box round first grid">
                <h2>
                    Tables & Grids</h2>
                <div class="block">
                    <table class="data display datatable" id="example">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>图片</th>
							<th>类型(s)</th>
							<th id="2">价格</th>
							<th id="1">库存</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					  <c:forEach var="pr" items="${product}">
						<tr class="odd gradeX">
							<td> ${pr.productname}</td>
							 <td>  ${pr.instock}</td> 
							<td>      ${pr.producttypename}</td>
							<td class="center">  ${pr.price}</td>
							<td class="center">   ${pr.instock}</td>	
						
							<td ><a href="${pageContext.request.contextPath }/productmanage/selectProduct.action?productid=${pr.productid}">更新商品</a>
							<a href="${pageContext.request.contextPath }/productmanage/deleteproduct.action?productid=${pr.productid}">下架商品</a></td>
							
							
								
						</tr>
					</c:forEach>
					</tbody>
				</table>
                    
                    
                    
                </div>
            </div>
        </div>
        <div class="clear">
        </div>
    </div>
    <div class="clear">
    </div>
    <div id="site_info">
        <p>
            Copyright <a href="#">BlueWhale Admin</a>. All Rights Reserved.More Templates <a href="#" target="_blank" title="孝和集团">孝和</a> - Collect from <a href="#" title="网页模板" target="_blank"></a>
        </p>
    </div>
</body>
</html>

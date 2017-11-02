<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<head>
    <meta http-equiv="content-type" content="text/html; charset=utf-8" />
    <title>Form Controls | BlueWhale Admin</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/reset.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/text.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/grid.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/layout.css" media="screen" />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/jsp/productmanage/css/nav.css" media="screen" />
    <!--[if IE 6]><link rel="stylesheet" type="text/css" href="css/ie6.css" media="screen" /><![endif]-->
    <!--[if IE 7]><link rel="stylesheet" type="text/css" href="css/ie.css" media="screen" /><![endif]-->
    <link href="${pageContext.request.contextPath }/jsp/productmanage/css/fancy-button/fancy-button.css" rel="stylesheet" type="text/css" />
    <!--Jquery UI CSS-->
    <link href="${pageContext.request.contextPath }/jsp/productmanage/css/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
    <!-- BEGIN: load jquery -->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-1.6.4.min.js" type="text/javascript"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.core.min.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.slide.min.js" type="text/javascript"></script>
    <!-- END: load jquery -->
    <!--jQuery Date Picker-->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.widget.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.datepicker.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.progressbar.min.js" type="text/javascript"></script>
    <!-- jQuery dialog related-->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/external/jquery.bgiframe-2.1.2.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.mouse.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.draggable.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.position.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.resizable.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.dialog.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.core.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.blind.min.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.effects.explode.min.js" type="text/javascript"></script>
    <!-- jQuery dialog end here-->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/jquery-ui/jquery.ui.accordion.min.js" type="text/javascript"></script>
    <!--Fancy Button-->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/fancy-button/fancy-button.js" type="text/javascript"></script>
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/setup.js" type="text/javascript"></script>
    <!-- Load TinyMCE -->
    <script src="${pageContext.request.contextPath }/jsp/productmanage/js/tiny-mce/jquery.tinymce.js" type="text/javascript"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            setupTinyMCE();
            setupProgressbar('progress-bar');
            setDatePicker('date-picker');
            setupDialogBox('dialog', 'opener');
            $('input[type="checkbox"]').fancybutton();
            $('input[type="radio"]').fancybutton();
        });
 </script>
    <script type="text/javascript">
  function validate_required(field,alerttxt)
{
with (field)
  {
  if (value==null||value=="")
    {alert(alerttxt);return false}
  else {return true}
  }
}

function validate_form(thisform)
{
with (thisform)
  {
  if (validate_required(productname,"商品名不能为空!")==false)
    {productname.focus();return false}
  }
}
</script>
    <!-- /TinyMCE -->
    <style type="text/css">
        #progress-bar
        {
            width: 400px;
        }
    </style>
</head>
<body>
    <div class="container_12">
        <div class="grid_12 header-repeat">
            <div id="branding">
                <div class="floatleft">
                    <img src="img/logo.png" alt="Logo" /></div>
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
            <!--     <li class="ic-dashboard"><a href="dashboard.html"><span>Dashboard</span></a> </li>
            <li class="ic-form-style"><a href="javascript:"><span>Controls</span></a> -->
             <!--       <ul>
               <li><a href="form-controls.html">Forms</a> </li>
               <li><a href="buttons.html">Buttons</a> </li>
               <li><a href="form-controls.html">Full Page Example</a> </li>
               <li><a href="table.html">Page with Sidebar Example</a> </li>
                              </ul>  
                </li>-->
			<!-- 	<li class="ic-typography"><a href="typography.html"><span>Typography</span></a></li>
			                <li class="ic-charts"><a href="charts.html"><span>Charts & Graphs</span></a></li>
			                <li class="ic-grid-tables"><a href="table.html"><span>Data Table</span></a></li>
			                <li class="ic-gallery dd"><a href="javascript:"><span>Image Galleries</span></a>
			               		 <ul>
			                        <li><a href="image-gallery.html">Pretty Photo</a> </li>
			                        <li><a href="gallery-with-filter.html">Gallery with Filter</a> </li>
			                    </ul>
			                </li>
			                <li class="ic-notifications"><a href="notifications.html"><span>Notifications</span></a></li>
			
			            </ul> -->
        </div>
        <div class="clear">
        </div>
        <div class="grid_12">
            <div class="box round first fullpage">
                <h2>
                    Form Controls</h2>
                <div class="block ">
                
                    <form id="insertproduct" action="${pageContext.request.contextPath }/productmanage/insertproduct.action" onsubmit="return validate_form(this)" method="post">
                    <table class="form">
                      <input type="text" name="productid" style="visibility:hidden"/>
                        <tr>
                            <td class="col1">
                                <label>商品名</label>
                            </td>
                            <td class="col2">
                                <input type="text" id="grumble" name="productname"/>
                            </td>
                        </tr>
                      <tr>
                            <td class="col1">
                                <label>价格</label>
                            </td>
                            <td class="col2">
                                <input type="text" id="grumble" name="price"/>
                            </td>
                        </tr>
                        
                           
                      <tr>
                            <td class="col1">
                                <label>折扣</label>
                            </td>
                            <td class="col2">
                                <input type="text" id="grumble" name="discount"/>
                            </td>
                        </tr>
                            
                      <tr>
                            <td class="col1">
                                <label>进价</label>
                            </td>
                            <td class="col2">
                                <input type="text" id="grumble" name="purchaseprice"/>
                            </td>
                        </tr>
                    
                        <tr>
                            <td>
                                <label>
                                    Large Input</label>
                            </td>
                            <td>
                                <input type="text" class="large" />
                            </td>
                        </tr>
                     <!--    <tr>
                            <td>
                                <label>
                                    Error</label>
                            </td>
                            <td>
                                <input type="text" class="error" />
                                <span class="error">This is a required field.</span>
                            </td>
                        </tr> -->
                      <!--   <tr>
                            <td>
                                <label>
                                    Success</label>
                            </td>
                            <td>
                                <input type="text" class="success"  name="email"/>
                                <span class="success">Email address verfified.</span>
                            </td>
                        </tr> -->
                        <tr>
                            <td>
                                <label>
                                    库存量</label>
                            </td>
                            <td>
                                <input type="text" class="warning" name="instock" />
                            </td>
                        </tr>
                    <!--     <tr>
                            <td>
                                <label class="error">
                                    Label Error</label>
                            </td>
                            <td>
                                <input type="text" />
                            </td>
                        </tr> -->
                       <!--  <tr>
                            <td>
                                <label>
                                    Checkboxes</label>
                            </td>
                            <td>
                                <input type="checkbox" />Checkbox 1
                                <input type="checkbox" />Checkbox 2
                            </td>
                        </tr> -->
                        <tr>
                            <td>
                                <label>是否上架</label>
                            </td>
                            <td>
                                <input type="radio" value="1" name="shelves" />
                            		    上架
                                <input type="radio" value="0" name="shelves" />
      							    不上架
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <label>
                                		    商品类型</label>
                            </td>
                            <td>
                                <select id="select" name="producttypeid" >
                                <c:forEach var="type" items="${productTypes}">
                                   <option value="${type.producttypeid }">
                                   ${type.producttypename }
                                   </option>
                                   </c:forEach>  
                                </select>
                            </td>
                        </tr>
                     
                        <tr>
                            <td>
                                <label>
                                   	商品图片</label>
                            </td>
                            <td>
                                <input type="file"	name="picture" />
                            </td>
                        </tr>
                        <tr>
                            <td style="vertical-align: top; padding-top: 9px;">
                                <label>
                                		商品描述		</label>
                            </td>
                            <td>
                                <textarea class="tinymce" name="discount"></textarea>
                            </td>
                        </tr>
                        <tr>
                        <td>
                        <input type="submit"  value="提交" />
                        
                        <input type="reset" value="重置">
                        </td>
                        </tr>
                        
                    </table>
                    </form>
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
            Copyright <a href="#">BlueWhale Admin</a>. All Rights Reserved.More Templates <a href="#" target="_blank" title="孝和集团">孝和集团</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
        </p>
    </div>
</body>
</html>

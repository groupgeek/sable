<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>活动信息</title>
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
</head>
<body>
    <div id="wrapper">
        <nav class="navbar navbar-default navbar-cls-top " role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".sidebar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
               <a class="navbar-brand" href="${pageContext.request.contextPath }/branch/index.action" style="background-color:#333333;">XIAOHE</a> 
                <a class="navbar-brand" href="#" style="background-color: #696969;	">个人中心</a>
            </div>
  <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;">
  <a style="background-color: #696969;" href="${pageContext.request.contextPath }/user/logout.action" class="btn btn-danger square-btn-adjust">安全退出</a> </div>
        </nav>   
                <nav class="navbar-default navbar-side" role="navigation">
           		<div class="sidebar-collapse">
                <ul class="nav" id="main-menu">
				<li class="text-center">
                   <c:if test="${user.avatar!=null }">
                    <img src="/upload/${user.avatar }" class="user-image img-responsive"/>
                    </c:if>
                    <c:if test="${user.avatar==null }">
                     <img src="/upload/ss.jpg" class="user-image img-responsive"/>
                    </c:if>
					</li>
                    <li>
                        <a href="${pageContext.request.contextPath }/user/oneUser.action"><i class="fa fa-table fa-3x"></i>个人信息</a>
                      </li>
                    <li >
                        <a href="${pageContext.request.contextPath }/user/userMed.action"><i class="fa fa-align-left fa-3x"></i>病历信息</a>
                    </li>	
                     <li >
                        <a href="${pageContext.request.contextPath }/user/userAct.action"><i class="fa fa-list-alt fa-3x"></i>活动信息</a>
                    </li>
                    
                </ul>
               
            </div>
            
        </nav>  
        <div id="page-wrapper" >
            <div id="page-inner">
                <div class="row">
                    <div class="col-md-12">
                     <!-- <h2>活动信息</h2> -->
                         <h4>欢迎回来！</h4><h3>${user.username }</h3>
                       
                    </div>
                </div>
                 <!-- /. ROW  -->
                 <hr />
               
            <div class="row">
                <div class="col-md-12">
                    <!-- Advanced Tables -->
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            	我参加的所有活动
                        </div>
                        <div class="panel-body">
                            <div class="table-responsive">
                                <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                                    <thead>
                                    
                                        <tr>
                                            <th>活动名称</th>
                                            <th>活动状态</th>
                                            <th>活动时间</th>
                                            <th>报名状态</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                    <c:forEach items="${allActs }" var="allActs">
                                    <tr class="odd gradeX" >
                                            <td class="center" ><a href="#">${allActs.activityname }</a></td>
                                            <td class="center">${allActs.activitystatus }</td>
                                            <td class="center"><fmt:formatDate value="${allActs.activitydate }" pattern="yyyy-MM-dd"/></td>
                                            <td class="center">${allActs.registery }
                                            <c:if test="${allActs.registery!='报名' }">
                                            <a href="#">（未付款？）</a>
                                            </c:if>
                                            
                                            </td>
                                        </tr>
                                    
                                    </c:forEach>
                                        
                                        
                                    </tbody>
                                </table>
                            </div>
                            
                        </div>
                    </div>
                </div>
            </div>
               
               
            </div>
        </div>
               
    </div>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/jquery-1.10.2.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/jquery.metisMenu.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/dataTables.bootstrap.js"></script>
    <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/custom.js"></script>
    
   
</body>
</html>

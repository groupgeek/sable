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
    <title>病历信息</title>
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/bootstrap.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/font-awesome.css" rel="stylesheet" />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/css/custom.css" rel="stylesheet" />
    <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css' />
    <link href="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/dataTables.bootstrap.css" rel="stylesheet" />
	<link href="${pageContext.request.contextPath }/jsp/user/assets/css/user.css" rel="stylesheet"/>
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
                <a class="navbar-brand" href="index.html">个人中心</a> 
            </div>
  <div style="color: white;padding: 15px 50px 5px 50px;float: right;font-size: 16px;">
  <a href="${pageContext.request.contextPath }/user/logout.action" class="btn btn-danger square-btn-adjust">Logout</a> </div>
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
                    <div class="col-md-12" style="width: 500px">
                     <h2>病历信息</h2>
                        <h4>欢迎回来！</h4><h3>${user.username }</h3>
                    </div>
                    <div class="sub-changeMed" style="margin-left: 800px;margin-top: 70px">
                <a href="#" class="btn btn-primary btn-lg" id="sub-changeMeds" >修改信息</a>
           			 </div>
                    
                	</div>
                 <!-- /. ROW  -->
                 <hr />
                 <!-- ---------------------------------- -->
                 
                 <div class="panel panel-default" style="margin-top: 30px" id="med1">
                        <div class="panel-heading">
                             <h4 class="panel-title">
                                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">以往病历</a>
                             </h4>
                        </div>
                       <div id="collapseTwo" class="panel-collapse in" style="height: auto;">
                     <div class="panel-body">
                     ${med.beforemedicalrecords }
                      </div>
                    </div>
                    </div>
                    
                    <div class="panel panel-default" id="med2">
                        <div class="panel-heading">
                             <h4 class="panel-title">
                                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">近期病历</a>
                             </h4>
                        </div>
                       <div id="collapseTwo" class="panel-collapse in" style="height: auto;">
                     <div class="panel-body">
                     ${med.nowmedicalrecords }
                      </div>
                    </div>
                    </div>
                    
                    <div class="panel panel-default" id="med4">
                        <div class="panel-heading">
                             <h4 class="panel-title">
                                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">个人史（饮食习惯，爱好。。）</a>
                             </h4>
                        </div>
                       <div id="collapseTwo" class="panel-collapse in" style="height: auto;">
                     <div class="panel-body">
                     ${med.personalrecords }
                      </div>
                    </div>
                    </div>
                    
                    <div class="panel panel-default" id="med3">
                        <div class="panel-heading">
                             <h4 class="panel-title">
                                 <a data-toggle="collapse" data-parent="#accordion" href="#collapseTwo">家族病史</a>
                             </h4>
                        </div>
                       <div id="collapseTwo" class="panel-collapse in" style="height: auto;">
                     <div class="panel-body">
                     ${med.familyrecords }
                      </div>
                    </div>
                    </div>
                    
                   <div class="form-all">
                <div class="form-inner">
                 <form role="form" action="${pageContext.request.contextPath }/user/updateMed.action" method="post">
                 <input type="hidden" name="medicalrecordsid" value="${med.medicalrecordsid }">
                 <div class="control-group hidden-phone" id="meds1">
							  <label class="control-label" for="textarea2">更新以往病历</label>
							  <div class="controls">
							 	<textarea id="subject" style="width: 320px;height: 100px" name="beforemedicalrecords" maxlength="120" onkeyup="checkLength(this)" accesskey="1" tabindex="11"> ${med.beforemedicalrecords }</textarea>
								<!-- <span id="subjectchk">还可输入
  							    <strong id="checklen" style="color: #FF0000">?</strong>个字符
   								</span>
   								<span id="postNameRule" class="spn_flag_1" style="display: none"></span> -->
							  </div>
					</div>
					
					<div class="control-group hidden-phone" id="meds2">
							  <label class="control-label" for="textarea2">更新近期病历</label>
							  <div class="controls">
							 	<textarea id="subject" style="width: 320px;height: 100px" name="nowmedicalrecords" maxlength="120" onkeyup="checkLength(this)" accesskey="1" tabindex="11">${med.nowmedicalrecords }</textarea>
								<!-- <span id="subjectchk">还可输入
  							    <strong id="checklen" style="color: #FF0000">?</strong>个字符
   								</span>
   								<span id="postNameRule" class="spn_flag_1" style="display: none"></span> -->
							  </div>
					</div>
					
					<div class="control-group hidden-phone" id="meds3">
							  <label class="control-label" for="textarea2">更新个人史（饮食习惯，爱好。。）</label>
							  <div class="controls">
							 	<textarea id="subject" style="width: 320px;height: 100px" name="personalrecords" maxlength="120" onkeyup="checkLength(this)" accesskey="1" tabindex="11">${med.familyrecords }</textarea>
								<!-- <span id="subjectchk">还可输入
  							    <strong id="checklen" style="color: #FF0000">?</strong>个字符
   								</span>
   								<span id="postNameRule" class="spn_flag_1" style="display: none"></span> -->
							  </div>
					</div>
					
					<div class="control-group hidden-phone" id="meds4">
							  <label class="control-label" for="textarea2">更新家族病史</label>
							  <div class="controls">
							 	<textarea id="subject" style="width: 320px;height: 100px" name="familyrecords" maxlength="120" onkeyup="checkLength(this)" accesskey="1" tabindex="11">${med.familyrecords }</textarea>
								<!-- <span id="subjectchk">还可输入
  							    <strong id="checklen" style="color: #FF0000">?</strong>个字符
   								</span>
   								<span id="postNameRule" class="spn_flag_1" style="display: none"></span> -->
							  </div>
					</div>
					
					<div class="sub" id="btn-submit">
                	 <input class="btn btn-success btn-lg" type="submit" value="确认修改 ">
                	 </div>
                 </form>
                 </div>
                 
               
           
                    <!--  end  Context Classes  -->
                </div>
            </div>
                <!-- /. ROW  -->
        </div>
               </div>
             <!-- /. PAGE INNER  -->
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
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/user/user.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/user/val.js"></script>
    
   
</body>
</html>

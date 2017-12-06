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
    <title>个人信息</title>
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
                    <img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/${user.avatar }" class="user-image img-responsive"/>
                    </c:if>
                    <c:if test="${user.avatar==null }">
                     <img src="http://com-xiaohe-res.oss-cn-beijing.aliyuncs.com/ss.jpg" class="user-image img-responsive"/>
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
                    <!--  <h2>个人信息</h2> -->
                        <h4>欢迎回来！</h4><h3>${user.username }</h3>
                    </div>
                    
                    <div class="sub-changeMed" style="margin-left: 800px;margin-top: 70px">
                <a href="#" style="background-color:#696969;border: #696969; " class="btn btn-primary btn-lg" id="sub-changeMed" onclick="change()" >修改信息</a>
           			 </div>
                </div><hr />
               
               <div class="form-all">
            <form role="form" action="${pageContext.request.contextPath }/user/updateUser.action" onsubmit="return check()" method="post" enctype="multipart/form-data">
            <fieldset> 
            <div class="form-inner">
                 <div class="form-group" style="width: 300px">
                 <input type="hidden" name="userid" value="${user.userid }">
                  <%-- <input type="hidden" name="phone" value="${user.phone }"> --%>
                 
                 	 <div class="form-lab">
                     <label for="disabledSelect">手机号（账号）：</label>
                     </div>
                     <div class="form-text">
                     <input class="form-name" id="form-name" name="phone" onkeyup="IsPhone()"  type="text" value="${user.phone }" readonly="readonly"/>
                     <p id="p-phone" style="font-size: 3px;width: 300px"></p>
                     </div>
                 </div>
                           
                  
                                        
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">登录密码：</label>
                     </div>
                     <div class="form-text">
                     <input class="form-name" onkeyup="IsString()" id="password" name="password" type="password" value="${user.password }" readonly="readonly"/>
                     <p id="p-pass" style="font-size: 3px;width: 300px"></p>
                     </div>
                 </div>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">真实姓名：</label>
                     </div>
                     <div class="form-text">
                     <input class="form-name" id="name" onkeyup="long()" name="username" type="text" value="${user.username }" readonly="readonly"/>
                     </div><br>
                 </div>
                 
                 <div class="form-group"><div>
                 		<label>更换头像：</label></div><div class="form-text">
                             <input type="file" id="file" name="file" readonly="readonly"/></div>
                 </div><br>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                      <label for="disabledSelect">邮箱：</label>
                      </div>
                      <div class="form-text">
                      <input class="form-name" id="mail" onkeyup="IsEmail()" name="email" type="text" value="${user.email }" readonly="readonly"/>
                      <p id="p-mail" style="font-size: 3px;width: 300px"></p>
                      </div>
                  </div>
                                 
                  <div class="control-group">
                  <div>
                  <c:if test="${user.sex != null}">
						<label class="control-label" for="typeahead">性别：</label>
						<div class="form-text" id="rad-sex" readonly="readonly">
						<label class="radio-inline" >
								<input name="sex" checked="checked" type="radio" value="${user.sex}">${user.sex}</label>
								
								
								
						<c:if test="${user.sex=='男' }">
						<label class="radio-inline">
								<input name="sex" type="radio" value="女">女</label></c:if>
						<c:if test="${user.sex=='女' }">
						<label class="radio-inline">
								<input name="sex" type="radio" value="男">男</label></c:if>
								
								
								</div></c:if>
						</div>

					<div class="control-group">
						<div>
								<label class="control-label">我的生日：</label></div>
								<div class="form-text">
						<input class="form-name" id="birthday" name="birthday" onkeyup="haha()" onClick="laydate()" value=<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/> readonly="readonly"><br /><br />
						</div><br>
					</div>
                                 
                    <%--  <div class="form-group" style="width: 300px">
                     <div>
                     <label for="disabledSelect">地址：</label></div>
                     <div class="form-text">
                     <input class="form-name" id="addr" onclick="addr()" name="address" type="text" value="${user.address }" readonly="readonly"/></div>
                 </div> --%>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">积分：</label></div>
                     <div class="form-text">
                     <input class="form-name" id="indel" name="integral" type="text" value="${user.integral }" readonly="readonly"/></div>
                 </div><br>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">银行卡：</label></div>
                     <div class="form-text">
                     <input class="form-name" id="bank" onkeyup="Isbank()" name="bankcardno" type="text" value="${user.bankcardno }" readonly="readonly"/></div>
                 	<p id="p-bank" style="font-size: 3px;width: 300px"></p>
                 </div>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">健康状况：</label></div>
                     <div class="form-text">
                     <input class="form-name" id="health" name="healthstatus99" type="text" value="${user.healthstatus }" readonly="readonly"/>
                     
                     
                     <select id="health2" name="healthstatus" class="form-name">
                     <c:if test="${user.healthstatus!=null }">
                     <option value="${user.healthstatus}">${user.healthstatus}</option>
                     </c:if>
                    	 	<option value="很好">很好</option>
							<option value="好">好</option>
							<option value="一般">一般</option>
							<option value="不好">不好</option>
					 </select>
                 </div><br>
                 </div>
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">等级：</label></div>
                     <div class="form-text">
                     <input class="form-name" id="level" name="99" type="text" value="${level.level }" readonly="readonly"/></div>
                 </div>
                 
                 <div class="form-group" style="width: 300px">
                 <div>
                     <label for="disabledSelect">注册时间：</label></div> <div class="form-text">
                     <input class="form-name" id="regTime" name="registrationdate" type="text" value=<fmt:formatDate value="${user.registrationdate }" pattern="yyyy-MM-dd"/> readonly="readonly"/></div>
                 </div>
                 
                 <div class="sub">
                 <input class="btn btn-success btn-lg"  id="btn-sub" type="submit" value="确认修改 ">
                 </div>
                                            
                     </div>                       
            </fieldset>
            </form>         
            
            </div>
           
        </div>
    </div>
             <!-- /. PAGE INNER  -->
            </div>
    <!-- /. PAGE WRAPPER  -->
     <!-- /. WRAPPER  -->
    <!-- SCRIPTS -AT THE BOTOM TO REDUCE THE LOAD TIME-->
    <!-- JQUERY SCRIPTS -->
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/jquery-1.10.2.js"></script>
      <!-- BOOTSTRAP SCRIPTS -->
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/bootstrap.min.js"></script>
    <!-- METISMENU SCRIPTS -->
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/jquery.metisMenu.js"></script>
     <!-- DATA TABLE SCRIPTS -->
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/jquery.dataTables.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/dataTables/dataTables.bootstrap.js"></script>
        <script>
            $(document).ready(function () {
                $('#dataTables-example').dataTable();
            });
    </script>
         <!-- CUSTOM SCRIPTS -->
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/custom.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/laydate.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/user/user.js"></script>
    <script src="${pageContext.request.contextPath }/jsp/user/assets/js/user/val.js"></script>
    
</body>
</html>

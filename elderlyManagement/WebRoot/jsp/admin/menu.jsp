<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 5.01 Transitional//EN">
<html>
<head>

<!-- start: Meta -->
<meta charset="utf-8">
<title>head</title>
<meta name="description" content="admin">
<meta name="keyword" content="admin">
<!-- end: Meta -->

<!-- start: Mobile Specific -->


</head>

<body>
<div id="sidebar-left" class="span2">
				<div class="nav-collapse sidebar-nav">
					<ul class="nav nav-tabs nav-stacked main-menu">
						<li id = "home"><a href="${pageContext.request.contextPath }/jsp/admin/index.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">主页</span>
						</a>
						</li>
						<li id = "userInfo"><a href="${pageContext.request.contextPath }/jsp/admin/page/user.jsp"><i class="icon-bar-chart"></i><span
								class="hidden-tablet">客户信息管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/employee.jsp"><i class="icon-envelope"></i><span
								class="hidden-tablet">员工信息管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/customerRelations.jsp"><i class="icon-tasks"></i><span
								class="hidden-tablet">客户关系</span>
						</a>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/returnVisitRecord.jsp"><i class="icon-tasks"></i><span
								class="hidden-tablet">回访记录</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/activity.jsp"><i class="icon-eye-open"></i><span
								class="hidden-tablet">活动管理</span>
						</a>
						</li>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/branch.jsp"><i class="icon-dashboard"></i><span
								class="hidden-tablet">分店管理</span>
						</a>
						<li><a href="${pageContext.request.contextPath }/jsp/admin/page/message.jsp"><i class="icon-folder-open"></i><span
								class="hidden-tablet">留言管理</span>
						</a>
						</li>
						<%-- <li><a href="${pageContext.request.contextPath }/jsp/admin/page/report.jsp" id = "report"><i class="icon-calendar"></i><span
								class="hidden-tablet">报表统计</span>
						</a>
						</li> --%>
						<li>
							<a class="dropmenu" href="javascript:;"><i class="icon-folder-close-alt"></i><span class="hidden-tablet">报表统计</span><span class="label label-important"> 3 </span></a>
							<ul>
								<li>
									<a class="submenu" href="${pageContext.request.contextPath }/jsp/admin/page/mallReport.jsp"><i class="icon-file-alt"></i><span class="hidden-tablet"> 商城报表</span></a>
								</li>
								<li>
									<a class="submenu" href="${pageContext.request.contextPath }/jsp/admin/page/mallReact.jsp"><i class="icon-file-alt"></i><span class="hidden-tablet"> 活动报表</span></a>
								</li>
								<li>
									<a class="submenu" href="${pageContext.request.contextPath }/jsp/admin/page/mallRebhcrt.jsp"><i class="icon-file-alt"></i><span class="hidden-tablet"> 总报表</span></a>
								</li>
							</ul>	
						</li>

					</ul>
				</div>
			</div>

</body>
</html>

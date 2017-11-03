<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<script type="text/javascript"
    src="${pageContext.request.contextPath}/jsp/ceo/js/jquery-1.9.1.min.js"></script>

<style type="text/css">
#container {
    min-width: 310px;
    max-width: 400px;
    height: 400px;
    margin: 0 auto
}
        </style>

<script type="text/javascript">
    $(function() {
        $('#container')
                .highcharts(
                        {
                            labels : {
                                style : {
                                    color : "#ff0000"
                                },
                                items : [
                                        {
                                            style : {
                                                left : '50px',
                                                top : '100px'
                                            }
                                        },
                                        {
                                            style : {
                                                left : '50px',
                                                top : '200px',
                                                color : '#006cee',
                                                fontSize : '20px',
                                                fontWeight : 'bold',
                                                fontFamily : '微软雅黑'
                                            }
                                        } ]
                            },
                            xAxis : {
                                categories : [ 'Jan', 'Feb', 'Mar', 'Apr',
                                        'May', 'Jun', 'Jul', 'Aug', 'Sep',
                                        'Oct', 'Nov', 'Dec' ]
                            },
                            series : [ {
                                data : [ 29.9, 71.5, 106.4, 129.2, 144.0,
                                        176.0, 135.6, 148.5, 216.4, 194.1,
                                        95.6, 54.4 ]
                            } ]
                        });
    });
</script>

<!-- <c:forEach items="${menus}" var="m"> -->
<!--             {id:'${m.mid}',text:'${m.mname}',href:'${m.murl}'}, -->
<!--         </c:forEach> -->

</head>

<body>
<script type="text/javascript"
    src="${pageContext.request.contextPath}/jsp/ceo/js/highcharts.js"></script>
    
    This is my JSP page.
    <div id="container" style="min-width:50px;height:400px;"></div>
    <br>
</body>
</html>
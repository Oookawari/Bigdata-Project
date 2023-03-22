<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/20
  Time: 19:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>个人图书借阅</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js" ></script>
</head>
<body>
<div id="main2" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '图书借阅统计'
        },
        tooltip: {},
        legend: {
            data: ['借阅量']
        },
        xAxis: {
            data: [
                <c:forEach items="${userLogs}" var="userlog">
                ${userlog.month},
                </c:forEach>
            ]
        },
        yAxis: {},
        series: [
            {
                name: '借阅量',
                type: 'bar',
                data: [
                    <c:forEach items="${userLogs}" var="userlog">
                    ${userlog.getSumborrow()},
                    </c:forEach>
                ]
            }
        ]
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);
</script>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript">

</script>
</body>
</html>

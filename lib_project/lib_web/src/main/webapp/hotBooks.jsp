<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/20
  Time: 0:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>可视化</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap-4.6.1-dist/bootstrap.css">
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js" ></script>
</head>
<body>
    <div id="main" style="width: 1000px;height:500px;"></div>
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
                data: ['借阅量'],
                top:'5%'
            },
            xAxis: {
                data: [
                    <c:forEach items="${books}" var="book">
                    '${book.bname}',
                    </c:forEach>
                ]
            },
            yAxis: {},
            series: [
                {
                    name: '借阅量',
                    type: 'bar',
                    data: [
                        <c:forEach items="${books}" var="book">
                        ${book.getSumborrow()},
                        </c:forEach>
                    ],
                    itemStyle: {

                        normal:{
                            color:function (params) {
                                var colorList=['#5470c6','#91cc75','#ff850a','#ffdc60','#ee6666','#73c0de']
                                return colorList[params.dataIndex%colorList.length]
                            }
                        }
                    },
                },

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

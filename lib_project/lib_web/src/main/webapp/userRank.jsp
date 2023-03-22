<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/20
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>书籍借阅日志可视化</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/Public/img/main.css">
    <script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js"></script>
    <script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js"></script>
</head>
<body style="background: #eee3f6;">
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main1" style="width: 700px;height:500px;"></div>

<script type="text/javascript">

    var chartDom1 = document.getElementById('main1');
    var myChart1 = echarts.init(chartDom1);
    var option1;
    option1 = {
        title: {
            text: '上半年借阅书籍数量前十名',
            left: 'center'
        },
        tooltip: {
            trigger: 'axis'
        },
        toolbox: {
            show: true,
            feature: {
                dataView: { show: true, readOnly: false },
                magicType: { show: true, type: ['line', 'bar'] },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        calculable: true,
        xAxis: {
            type: 'category',
            data: [
                <c:forEach items="${userLists}" var="user">
                '${user.uname}',
                </c:forEach>
            ]
        },
        yAxis: {
            type: 'value'
        },
        series: [
            {
                data: [
                    <c:forEach items="${userLists}" var="user">
                    ${user.sumborrow},
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            var colorList=['#5470c6','#91cc75','#ff850a','#ffdc60','#ee6666','#73c0de']
                            return colorList[params.dataIndex%colorList.length]
                        }
                    }
                },

                type: 'bar'
            }
        ]
    };
    option1 && myChart1.setOption(option1);


</script>
<div  id = "div_Rank" style="">
    <iframe id = "frameRank" width = 1100 height=500 scrolling="yes" frameborder="0" style="text-align: center;alignItems:center" src="${path}/manage/showlist.do">

    </iframe>
</div>

</body>
</html>
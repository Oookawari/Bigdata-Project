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
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js" ></script>
</head>
<body>
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main5" style="width: 100%;height:100%;"></div>
<script type="text/javascript">


    var chartDom5 = document.getElementById('main5');
    var myChart5 = echarts.init(chartDom5);
    var option5;

    option5 = {
        title: {
            text: '书籍分类统计书籍',
            subtext: '各类书籍数量统计（左）及各类书籍上半年借阅次数统计（右）',
            left: 'center'
        },
        tooltip: {
            trigger: 'item',
            formatter: '{a} <br/>{b} : {c} ({d}%)'
        },
        legend: {
            left: 'center',
            top: 'bottom',

        },
        toolbox: {
            show: true,
            feature: {
                mark: { show: true },
                dataView: { show: true, readOnly: false },
                restore: { show: true },
                saveAsImage: { show: true }
            }
        },
        series: [
            {
                name: '各类书籍数量统计',
                type: 'pie',
                radius: [0, 180],
                center: ['25%', '50%'],
                itemStyle: {
                    borderRadius: 40
                },
                label: {
                    show: false

                },
                emphasis: {
                    label: {
                        show: true
                    }
                },
                data: [
                    <c:forEach items="${booksorts}" var="bc">
                    { value: ${bc.num}, name: '${bc.bcategory}:'+'${bc.num}本'},
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
            },

            {
                name: '各类书籍上半年借阅次数统计',
                type: 'pie',
                radius: [155, 180],
                center: ['75%', '50%'],

                itemStyle: {
                    borderRadius: 40
                },
                data: [
                    <c:forEach items="${bookcategories}" var="bs">
                    { value: ${bs.sumborrow}, name: '${bs.bcategory}:'+'借阅${bs.sumborrow}次'},
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
            },

        ]
    };
    option5 && myChart5.setOption(option5);

</script>

<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main4" style="width: 1200px;height:700px;"></div>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/resource/jquery/echarts.min.js"></script>
<script type="text/javascript">
</script>
</body>
</html>

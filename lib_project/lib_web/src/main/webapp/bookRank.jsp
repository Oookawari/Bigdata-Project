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
</head>
<body style="background: #eee3f6;">
<!-- 为 ECharts 准备一个定义了宽高的 DOM -->
<div id="main4" style="width: 1000px;height:500px;"></div>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js"></script>
<script type="text/javascript" src="${path}/resource/jquery/echarts.min.js"></script>
<script type="text/javascript">
    var chartDom4 = document.getElementById('main4');
    var myChart4 = echarts.init(chartDom4);
    var option4;

    option4 = {
        title: {
            text: '每月书籍借阅次数前五名',
            subtext: ''
        },
        tooltip: {
            trigger: 'axis'
        },
        legend: {
            data: ['1月', '2月', '3月','4月','5月','6月']
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
        xAxis: {
            type: 'category',
            data: [
                'No.1','No.2','No.3','No.4','No.5'
            ]
        },
        yAxis:
            {
                type: 'value'
            },
        series: [
            {
                name: '1月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists1}" var="b1">
                    '${b1.sumborrow}',
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#ee6666';
                        }
                    }
                },

                lineStyle: {
                    normal:{
                        color:function (params) {
                            return '#ee6666';
                        }
                    },
                    width: 3,

                },

            },
            {
                name: '2月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists2}" var="b2">
                    '${b2.sumborrow}',
                    </c:forEach>
                ],

                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#ffdc60';
                        }
                    }
                },
                lineStyle: {
                    color: '#ffdc60',
                    width: 3,
                },

            },
            {
                name: '3月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists3}" var="b3">
                    '${b3.sumborrow}',
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#ff850a';
                        }
                    }
                },
                lineStyle: {
                    color: '#ff850a',
                    width: 3,

                },

            },
            {
                name: '4月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists4}" var="b4">
                    '${b4.sumborrow}',
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#91cc75';
                        }
                    }
                },
                lineStyle: {
                    color: '#91cc75',
                    width: 3,

                },

            },
            {
                name: '5月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists5}" var="b5">
                    '${b5.sumborrow}',
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#5470c6';
                        }
                    }
                },
                lineStyle: {
                    color: '#5470c6',
                    width: 3,

                },

            },
            {
                name: '6月',
                type: 'bar',
                tooltip: {
                    valueFormatter: function (value) {
                        return value + 'times';
                    }
                },
                data: [
                    <c:forEach items="${bookLists6}" var="b6">
                    '${b6.sumborrow}',
                    </c:forEach>
                ],
                itemStyle:{
                    normal:{
                        color:function (params) {
                            return '#73c0de';
                        }
                    }
                },
                lineStyle: {
                    color: '#73c0de',
                    width: 3,

                },

            },]

    };

    option4 && myChart4.setOption(option4);
</script>
    </body>
</html>

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
<body>
    <div  id = "div1" style="width:700px">
        <div class="jumbotron jumbotron-fluid">
            <div class="container" style="width:700px;text-align: center;alignItems:center">
                <h2 class="display-4">借 阅 排 行 榜</h2>
            </div>
        </div>
    <div class="list-group" style="width: 700px">
        <div class="panel panel-primary">
            <div class="panel-heading"><h4 class="display-1">#1      ${userLists[0].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[0].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-info">
            <div class="panel-heading"><h4 class="display-1">#2      ${userLists[1].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[1].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-success">
            <div class="panel-heading"><h4 class="display-1">#3      ${userLists[2].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[2].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#4      ${userLists[3].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[3].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#5      ${userLists[4].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[4].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#6      ${userLists[5].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[5].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#7      ${userLists[6].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[6].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#8      ${userLists[7].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[7].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#9      ${userLists[8].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[8].sumborrow}</h5>
            </div>
        </div>
        <div class="panel panel-default">
            <div class="panel-heading"><h4 class="display-1">#10      ${userLists[9].uname}</h4></div>
            <div class="panel-body">
                <h5>借阅数量： ${userLists[9].sumborrow}</h5>
            </div>
        </div>
    </div>

</div>
</body>
</html>
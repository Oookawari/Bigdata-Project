<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/21
  Time: 0:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.css">
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js" ></script>
</head>
<body>
<table class="table table-striped">
    <thead>
    <tr>

            <h3><th>用户名</th></h3>
                <h3><th>违约次数</th></h3>
    </tr>
    </thead>
    <tbody>
<c:forEach items="${userLists}" var="user">
    <tr>

        <h3><td>${user.uname}</td></h3>
            <h3><td>${user.breakTimes}</td></h3>
    </tr>
</c:forEach>
    </tbody>
</table>
</body>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript">

</script>
</html>

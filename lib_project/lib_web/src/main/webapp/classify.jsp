<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/21
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap-4.6.1-dist/bootstrap.css">
    <script type="text/javascript" src="${path}/resource/jquery/echarts.min.js" ></script>
</head>
<body>
<div class="list-group">
<c:forEach items="${books}" var="book">
    <a href="#" class="list-group-item list-group-item-action">
        <div class="d-flex w-100 justify-content-between">
            <h5 class="mb-1">${book.bname}</h5>
            <small>${book.bid}</small>
        </div>
        <p class="mb-1">${book.bcategory}</p>
        <small>作者：${book.author}</small>
    </a>
</c:forEach>
</div>
</body>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>

<script type="text/javascript">
</script>
</html>

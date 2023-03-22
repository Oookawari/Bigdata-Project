<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/20
  Time: 14:22
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
<div class="list-group">
    <c:forEach items="${books}" var="book">

        <c:if test="${book.bname==bookname}">
            <a href="#" class="list-group-item list-group-item-action active" onclick="query_Data()">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1">${book.bname}</h5>
                    <small>#${book.bid}</small>
                </div>
                <p class="mb-1"></p>
                <small>作者：${book.author}</small>
            </a>
        </c:if>

        <c:if test="${book.bname!=bookname}">

            <a href="#" class="list-group-item list-group-item-action">
                <div class="d-flex w-100 justify-content-between">
                    <h5 class="mb-1">${book.bname}</h5>
                    <small>#${book.bid}</small>
                </div>
                <p class="mb-1"></p>
                <small>作者：${book.author}</small>
            </a>
        </c:if>
    </c:forEach>
</div>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>
<script type="text/javascript">
    function queryData_1(){
        location.href="${path}/manage/view.do?bookname="+$("#bookname").val()+"&&month="+0;
    }
</script>
</body>
</html>

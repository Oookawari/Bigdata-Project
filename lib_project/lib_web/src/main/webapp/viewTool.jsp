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
<%--按钮组待居中--%>
<div class="btn-group" role="group" aria-label="Basic example" style="text-align: center;alignItems:center">
    <button type="button" class="btn btn-outline-primary" onclick="show_classify_1()">史学</button>
    <button type="button" class="btn btn-outline-secondary" onclick="show_classify_2()">文学</button>
    <button type="button" class="btn btn-outline-success" onclick="show_classify_3()">社会学</button>
    <button type="button" class="btn btn-outline-danger" onclick="show_classify_4()">理工科</button>
    <button type="button" class="btn btn-outline-warning" onclick="show_classify_5()">哲学及美学</button>
    <button type="button" class="btn btn-outline-info" onclick="show_classify_6()">心理学</button>
</div>
<iframe id = "frameTool" width = 1200 height=900 scrolling="yes" frameborder="0" style="text-align: center;alignItems:center">

</iframe>
</body>
<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>

<script type="text/javascript">
    function show_classify_1(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=史学类";
    }
    function show_classify_2(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=文学类";
    }
    function show_classify_3(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=社会学类";
    }
    function show_classify_4(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=理工科类";
    }
    function show_classify_5(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=哲学及美学类";
    }
    function show_classify_6(){
        document.getElementById('frameTool').src = "${path}/manage/classify.do?cate=心理学类";
    }
</script>
</html>

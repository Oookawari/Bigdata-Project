<%--
  Created by IntelliJ IDEA.
  User: 17996
  Date: 2022/7/20
  Time: 9:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>借阅管理</title>
    <c:set var="path" value="${pageContext.request.contextPath}" scope="page"/>
    <link rel="stylesheet" href="${path}/resource/bootstrap/css/bootstrap.css">
    <link rel="stylesheet" href="/Public/img/main.css">
</head>
<body>
<ul id="myTab" class="nav nav-tabs" style="">
    <li class="active"><a href="#home" data-toggle="tab">主页</a></li>

    <li class="dropdown">
        <a href="#" id="myTabDrop1" class="dropdown-toggle"
           data-toggle="dropdown">借阅排行
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu" aria-labelledby="myTabDrop1">
            <li><a href="#function3" tabindex="-1" data-toggle="tab" onclick="show_user_rank()">个人借阅Top10</a></li>
            <li><a href="#function4" tabindex="-1" data-toggle="tab" onclick="show_book_rank()">热门图书Top5</a></li>
            <li><a href="#function5" tabindex="-1" data-toggle="tab" onclick="show_user_break()">违约记录公示</a></li>
        </ul>
    </li>

    <li><a href="#function1" data-toggle="tab">图书借阅次数</a></li>

    <li><a href="#function2" data-toggle="tab" onclick="show_book_sort()">借阅信息总览</a></li>

    <li><a href="#function6" data-toggle="tab" onclick="show_view_tool()">图书分类查询</a></li>


</ul>

<div id="myTabContent" class="tab-content">

    <div class="tab-pane fade in active" id="home" style="text-align: center;alignItems:center">
        <div class="jumbotron">
            <h1 class="display-4">图书馆借阅信息管理</h1>
            <p class="lead"></p>
            <hr class="my-4">
            <p>在这里，您可以通过可视化图表直观地查看图书以及借阅者的统计信息，包括每月热门图书、图书借阅总览以及借阅排行等内容

            </p>
        </div>
        <div class="container text-center">
        <div id="myCarousel" class="carousel slide" style="">
            <!-- 轮播（Carousel）指标 -->
            <ol class="carousel-indicators">
                <li data-target="#myCarousel" data-slide-to="0" class="active" ></li>
            </ol>
            <!-- 轮播（Carousel）项目 -->
            <div class="carousel-inner">
                <div class="item active">
                    <img src="${path}/resource/pic.jpg" alt="First slide" style="width: 1500px; ">
                </div>
            </div>
            <!-- 轮播（Carousel）导航 -->
            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
</div>
    <div class="tab-pane fade" id="function1">
        <div class="jumbotron">
            <h1 class="display-4">| 图书借阅统计</h1>
            <p class="lead">| 输入图书名称</p>
            <hr class="my-4">
            <p>
            <form class="form-inline">
                <div class="form-group mx-sm-3 mb-2">
                    <label for="bookname" class="sr-only">图书名称</label>
                    <input type="text" class="form-control" id="bookname" placeholder="请输入图书名称" oninput="find_book_name()">
                </div>
                <button type="button" class="btn btn-primary mb-2" onclick="queryData_1()">查询</button>
            </form>
            </p>
        </div>
        <div  id = "div1" style="text-align: center;alignItems:center">
            <iframe id = "frame1" width = 1000 height=500 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">

            </iframe>
        </div>
    </div>

    <div class="tab-pane fade" id="function2">
        <div class="jumbotron">
            <h1 class="display-4">| 借阅信息总览</h1>

            <hr class="my-4">
        </div>
        <div  id = "div2" style="text-align: center;alignItems:center">
            <iframe id = "frame2" width = 1300 height=900 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">

            </iframe>
        </div>
    </div>

    <div class="tab-pane fade" id="function3">
        <div class="jumbotron">
            <h1 class="display-4">| 个人借阅Top10</h1>

            <hr class="my-4">
            <p>
            <form class="form-inline">
            </form>
            </p>
        </div>
        <div  id = "div3" style="text-align: center;alignItems:center">
            <iframe id = "frame3" width = 700 height=1100 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">
            </iframe>
        </div>
    </div>

    <div class="tab-pane fade" id="function4" style="alignItems:center">
        <div class="jumbotron">
            <h1 class="display-4">| 热门图书Top5</h1>

            <hr class="my-4">
            <p>
            <form class="form-inline">
            </form>
                <select id="inputState" class="form-control form-control-lg" style="width:300px;" onchange="SelectChange(this)">
                    <option selected>总览</option>
                    <option>1月</option>
                    <option>2月</option>
                    <option>3月</option>
                    <option>4月</option>
                    <option>5月</option>
                    <option>6月</option>
                </select>
            </p>
        </div>
        <div  id = "div4" style="text-align: center;alignItems:center">
            <iframe id = "frame4" width = 1000 height=500 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">

            </iframe>
        </div>
    </div>

    <div class="tab-pane fade" id="function5">
        <div class="jumbotron">
            <h1 class="display-4">| 违约记录</h1>

            <hr class="my-4">
            <p>
            <form class="form-inline">
            </form>
            </p>
        </div>
        <div  id = "div5" style="text-align: center;alignItems:center">
            <iframe id = "frame5" width = 700 height=1100 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">
            </iframe>
        </div>
    </div>

    <div class="tab-pane fade" id="function6">
        <div class="jumbotron">
            <h1 class="display-4">| 图书分类查询</h1>

            <hr class="my-4">
            <p>
            <form class="form-inline">

            </form>
            </p>
        </div>
        <div  id = "div6" style="text-align: center;alignItems:center">
            <iframe id = "frame6" width = 1300 height=900 scrolling="no" frameborder="0" style="text-align: center;alignItems:center">

            </iframe>
        </div>
    </div>
</div>



<script type="text/javascript" src="${path}/resource/jquery/jquery-2.1.1.min.js" ></script>
<script type="text/javascript" src="${path}/resource/bootstrap/js/bootstrap.js" ></script>

<script type="text/javascript">

    function queryData_1(){
        document.getElementById('frame1').src = "${path}/manage/view.do?bookname="+$("#bookname").val()+"&&month="+0;
    }
    function find_book_name(){
        document.getElementById('frame1').src = "${path}/manage/booklist.do?bookname="+$("#bookname").val();
    }
    function show_book_sort(){
        document.getElementById('frame2').src = "${path}/manage/sortbooks.do";
    }
    function find_user_name(){
        document.getElementById('frame2').src = "${path}/manage/userlist.do?userid="+$("#userid").val();
    }
    function show_user_rank(){
        document.getElementById('frame3').src = "${path}/manage/userRank.do";
    }
    function show_book_rank(){
        document.getElementById('frame4').src = "${path}/manage/bookRank.do";
    }
    function show_user_break(){
        document.getElementById('frame5').src = "${path}/manage/viewOfBreak.do";
    }
    function show_view_tool(){
        document.getElementById('frame6').src = "${path}/manage/viewTool.do";
    }
    function SelectChange(obj){

        var index = obj.selectedIndex;
        if (index == 0){
            show_book_rank();
        }
        else {
            document.getElementById('frame4').src = "${path}/manage/hotBooks.do?month="+index;
        }

    }

</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2017/11/2
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>

    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <!--<link rel='stylesheet' href='http://fonts.googleapis.com/css?family=PT+Sans:400,700'>-->
    <link rel="stylesheet" href="../resource/UserLogin/assets/css/reset.css">
    <link rel="stylesheet" href="../resource/UserLogin/assets/css/supersized.css">
    <link rel="stylesheet" href="../resource/UserLogin/assets/css/style.css">

    <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
    <!--[if lt IE 9]>
        <!--<script src="http://html5shim.googlecode.com/svn/trunk/html5.js"></script>-->
    <!--<![endif]&ndash;&gt;-->

</head>

<body>

<center>
<div class="page-container">
    <h1>青鸟APP开发者平台</h1>
    <div >
       用户名: <input type="text" name="username" class="username" placeholder="Username"><br>
       密&nbsp;&nbsp;  码: <input type="password" name="password" class="password" placeholder="Password"><br>
        <button  onclick="LoginCheck()" style="width: 30%">登&nbsp; 陆</button>
        <div class="error"><span>+</span></div>
    </div>
    <div class="connect">
        <p>赞助商:</p>
        <p>
            <a class="facebook" href=""></a>
            <a class="twitter" href=""></a>
        </p>
    </div>
</div>
<div align="center">Collect from <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a></div>
</center>
<!-- Javascript -->
<script src="../resource/UserLogin/assets/js/jquery-1.8.2.min.js"></script>
<script src="../resource/UserLogin/assets/js/supersized.3.2.7.min.js"></script>
<script src="../resource/UserLogin/assets/js/supersized-init.js"></script>
<script src="../resource/UserLogin/assets/js/scripts.js"></script>
<script src="../resource/UserLogin/js/UserLogin.js"></script>

</body>

</html>

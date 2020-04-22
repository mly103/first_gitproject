<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/23
  Time: 17:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>登录</title>
    <link href="../CSS/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="./home">首页</a>
        </div>
    </div>
</nav>
<div class="container">
    <div class="row">
        <div class="col-md-4">

        </div>
        <div class="col-md-4">
            <!-- <form  action="${pageContext.request.contextPath}/jsp/loginDo" method="post"> -->
            <form  action="#" method="post">
                <h2 class="form-signin-heading">登录到个人中心</h2>
                <label for="inputUserName">用户名</label>
                <input type="text" name="username" id="inputUserName" class="form-control" placeholder="请输入用户名" required autofocus><br>
                <label for="inputPassword">密码</label>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="请输入密码" required>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="remember-me" checked="checked"> 记住密码
                    </label>
                </div>
            </form>
            <button type="submit" class="btn btn-primary" id="btn-login">登录</button>
            <a href="register" class="btn btn-default">注册</a>
            <iframe style="display: none;" name="submitFrame" src="about:blank"></iframe>
        </div>
        <div class="col-md-4">
        </div>
    </div>
    <script src="../js/jquery.min.js" type="text/javascript"></script>
</div>
<script type="text/javascript">
    $(function(){
        $("#btn-login").click(function(){
            $.post("${pageContext.request.contextPath}/jsp/loginDo", {
                    username :  $("#inputUserName").val() ,
                    password :  $("#inputPassword").val()
                }, function (data){
                if(data == "success"){
                    window.location.href = "${pageContext.request.contextPath}/jsp/home";
                }
                if(data == "usernameerror"){
                    alert("此用户不存在");
                }
                if(data == "passworderror"){
                    alert("密码不正确");
                }
                }
            );
        })
    })
</script>
</body>
</html>

<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/8/27
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>注册</title>
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

            <form class="form-signin" target="submitFrame" method="post">
                <h2 class="form-signin-heading">注册</h2>
                <div id="info">

                </div>
                <label for="inputUserName">用户名</label>
                <input type="text" id="inputUserName"  name="username" class="form-control" placeholder="请输入用户名" required autofocus><br>
                <label for="inputPassword">密码</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="请输入密码" required maxLength="16"><br>
                <label for="inputPassword">重复密码</label>
                <input type="password" id="inputPassword2" name="password2" class="form-control" placeholder="请再次输入密码" required maxLength="16"><br>
                <button type="submit" class="btn btn-primary" id="btn-reg">注册</button>
                <a href="login" class="btn btn-default" id="btn-reg">返回登录</a>
            </form>
            <iframe style="display: none;" name="submitFrame" src="about:blank"></iframe>
        </div>
    </div>
    <script src="../js/jquery.min.js"></script>
</div>
<script type="text/javascript">
    $(function(){
        $("#btn-reg").click(function(){
            $.post("${pageContext.request.contextPath}/jsp/registerDo", {
                    username :  $("#inputUserName").val() ,
                    password :  $("#inputPassword").val(),
                    repassword : $("#inputPassword2").val()
                }, function (data){
                    if(data == "success"){
                        $("#inputUserName").val("");
                         $("#inputPassword").val("");
                         $("#inputPassword2").val("");
                        alert("注册成功");
                    }
                    if(data == "usernameerror"){
                        alert("此用户已存在");
                        window.location.href = "${pageContext.request.contextPath}/jsp/register";
                    }
                    if(data == "passworderror"){
                        alert("两次密码不一致");
                        window.location.href = "${pageContext.request.contextPath}/jsp/register";
                    }
                }
            );
        })
    })
</script>
</body>
</html>
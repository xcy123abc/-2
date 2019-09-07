<%@ page import="java.net.URLDecoder" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css"  href="css/login.css">
    <title>登陆 </title>

    <script>
        //
        $(function () {

            $("#username").blur(function () {
                var username = $(this).val();
                $.get("fineUserNameServlet",{username:username},function (date) {
                    var span = $("#msg-text");
                    if (date == "true"){

                        span.text("管理员账号")
                    }else {

                        span.text("非管理员账号")
                    }
                })
            })

        })
    </script>
<%--    <script>
    $(function () {
    $("#btn_sub").click(function () {
    $.post("LoginServlet2",$("#loginForm").serialize(),function (date) {
    if (date.flag){
    location.href="information.html"
    }else{
    $("#errorMsg").html(date.false_msg);
    }

    })
    })
    })

    </script>--%>

</head>
<body>


<div class="login-box">
    <h2>欢迎访问XCY个人博客</h2>
    <h2>管理员登陆</h2>
    <form  id="loginForm" action="/LoginServlet2">
        <div class="login-field">
            <input type="text" name="username" id="username" required="">
            <label>Username</label>
        </div>
        <div class="login-field">
            <input type="password" name="password"   required="">
            <label>Password</label>
        </div>
        <button  type="submit" >登陆</button>
        <button type="button"  name=""><a href="/NoLoginServlet" value="游客访问">游客访问</a></button>
    </form>
</div>


<div class="msg">
    <%=request.getAttribute("msg") == null ? "":request.getAttribute("msg")%>
        <h3 id="msg-text"></h3>
</div>




</body>
</html>

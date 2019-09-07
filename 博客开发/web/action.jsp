<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-3.3.1.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/action.css">
    <title>动态</title>

    <script>

        /**
         * 入口函数
         */
        $(function () {

            /**
             * 点击特定按钮所执行的函数函数------排版存在问题，该函数最后没有使用
             */
            $("#ktykq").click(function() {
                setTimeout(ktShow,1000);
                setTimeout(ktHide,3400);
            })

            /**
             * 表情按钮绑定的单击事件
             * */
            $("#addExpressionBtn").click(function () {
                //点击会发送异步请求
                $.get("AddExpressionServlet",function (date) {
                    //接受servl传递回来的数据后，判断数据做出响应
                    var span = $("#ctrl-masg");
                    if (date == "true"){
                        //date为真的，表示功能未开发
                        //添加文本到操作日志，
                        span.text("该功能未开发")
                    }else {
                        //目前对应的servlet只会返回true，如果执行到这里，说明servlet传回的数据出问题了
                        span.text("服务器繁忙")
                    }
                })
            })

            //特定id的show和hide方法
            function ktShow() {
                $("#kt").slideDown("2000","linear");
            }
            function ktHide() {
                $("#kt").hide("slow");
            }
        })

    </script>

</head>

<body>
        <!--header--><!-- 无内容  -->
        <div class="container-fluid"><div class="header"><!--可把信息存在页眉里--><div class="header-msg"><p></p></div></div>
</div>

        <!--操作日志 -->
        <div class="container-fluid">
            <div class="row ">
                <div class="massage">
                    <h2>操作日志：</h2>
                    <p><%=request.getAttribute("time") == null ? "":request.getAttribute("time")%></p>
                    <p><%=request.getAttribute("send-msg") == null ? "":request.getAttribute("send-msg")%></p>
                    <p id="ctrl-masg"></p>
                </div>
            </div>
        </div>

        <!--页面内容-->
        <div class="container " style="">
            <!--导航行条-->
            <div class="row"><div class="col-md-1"></div><div class="col-md-10">
                <nav class="navbar navbar-default"><div class="container-fluid"><div class="navbar-header"><button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false"><span class="icon-bar"></span><span class="icon-bar"></span></button><div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul class="nav navbar-nav">
                        <li ><a href="information.html">个人资料</a></li>
                        <li class="active"><a href="#">个人动态<span class="sr-only">(current)</span></a></li>
                        <li><a href="study.html">相关资料</a></li>
                        <li><a href="about.html">关于</a></li>
                        <li><a href="login.jsp">登陆</a></li></ul></div></div></div></nav></div><div class="col-md-1"></div></div>
             <!--/导航条结束-->

            <!--输入框-->
            <div class="row" >
                <!-- 表单--><!-- 很多bootstrap控制样式的div被折叠-->
                <form action="/AddActionServlet" method="get"><div class="col-md-1"></div><div class="col-md-10"><div class="row"><div class="col-md-1"></div><div class="col-md-10"><div class="input-group "><span class="input-group-btn">
                    <button id="addExpressionBtn" class="btn btn-default big " type="button">添加表情</button></span>
                    <input type="text"  required="true" class="form-control big" name="pyq" placeholder="输入想说的话..."><span class="input-group-btn">
                    <button class="btn btn-default big" type="submit" >发送</button></span></div><!-- /input-group --></div><div class="col-md-1"></div></div></div><div class="col-md-1"></div>
                </form>
            </div>
            <!--/输入框结束-->


            <!--文章的容器-->
            <div class="col-md-1"></div><div class="col-md-10 ddd "><!--核心容器   存放信息-->

                    <!--容器的小版块-->
                    <div class="blocks">

                        <!--板块1-->
                        <div class="row">
                            <div class="action-block">
                                <p><%=session.getAttribute("10") == null ? "":session.getAttribute("10")%></P>
                            </div>
                        </div>

                        <!--2 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("9") == null ? "":session.getAttribute("9")%>
                            </div>
                        </div>

                        <!--3 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("8") == null ? "":session.getAttribute("8")%>
                            </div>
                        </div>

                        <!--4 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("7") == null ? "":session.getAttribute("7")%>
                            </div>
                        </div>

                        <!--5 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("6") == null ? "":session.getAttribute("6")%>
                            </div>
                        </div>

                        <!--6 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("5") == null ? "":session.getAttribute("5")%>
                            </div>
                        </div>

                        <!--7 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("4") == null ? "":session.getAttribute("4")%>
                            </div>
                        </div>

                        <!--8 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("3") == null ? "":session.getAttribute("3")%>
                            </div>
                        </div>

                        <!--9 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("2") == null ? "":session.getAttribute("2")%>
                            </div>
                        </div>

                        <!--10 -->
                        <div class="row">
                            <div class="action-block">
                                <%=session.getAttribute("1") == null ? "":session.getAttribute("1")%>
                            </div>
                        </div>

                    <!--大容器结束 -->
                    </div></div><div class="col-md-1"></div>
            <!--/文章的容器结束-->


        </div>
        <!-- 页面内容结束--><!-- 以下无内容 -->


<!--页脚填充的信息-->
<!--存放结束信息-->
<%--
<div class="container">
    <div class="col-md-1"></div><!--格式控制，无内容-->
    <div class="col-md-10"><!--格式控制，无内容-->

        <div class="row footer">
            <p class="bottom-p">没有更多内容了</p>
        </div>

        <!--存放结束信息-->
    </div>
    <div class="col-md-1"></div><!--格式控制，无内容-->
</div>
--%>
</body>
</html>
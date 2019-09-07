<%@ page import="com.main.java.dao.LoginDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form>
        <input type="text" name="username">账号
        <input type="password" name="password">
    </form>
<%
    out.println("账号为");
    out.println("密码为");
    LoginDao dao = new LoginDao();
    System.out.println(dao);
//    String uid = dao.getUid();
//    String Upassword = dao.getPassword();
/*    if (uid.equals(username) && Upassword.equals(password)){
        System.out.println("登陆成功");
    }else{
        System.out.println("登陆失败");
    }*/
%>
</body>
</html>

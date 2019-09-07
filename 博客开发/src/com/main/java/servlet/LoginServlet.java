package com.main.java.servlet;

import com.main.java.dao.LoginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 *  动态的Login登陆页面，但是由于servl存在未解决的异常，所以登陆时没有使用该servlet登陆
 *      该servlet的执行步骤：1.获取客户端提交的数据
 *                          2.获取数据库的账号密码表
 *                          3.判断是否一至  是，则登陆成功
 *                                         不是，则登陆失败
 */

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.setCharacterEncoding("utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        /**
         *    1.获取服务器端数据，username和password
         **/
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        /**
         *  2. 获取数据库数据
         */

        //创建dao对象
        LoginDao dao = new LoginDao();// 有问题
        System.out.println(dao);

        //获取数据库数据
        String uid = dao.getUid();
        String upassword = dao.getPassword();

        /**
         * 3.获取数据和判断
         */
        if (((uid).equals(username)) && ((upassword).equals(password))){
            /**
             * 一致，则登陆成功
             */
            //存储信息
            request.setAttribute("username",dao.getUserName());
            //转发到首页
            try {
                request.getRequestDispatcher("/information.html").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            /**
             * 不一致，则登陆失败
             */
            //存储信息
            //转发回登陆页面
            request.setAttribute("login-msg","账号或密码错误！");
            request.getRequestDispatcher("/login.html");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

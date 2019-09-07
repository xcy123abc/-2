package com.main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *   检查username是否为管理员账号
 *      是则写回信息（flag，值为true或false，代表是否是管理员账号）到登陆页面
 */
@WebServlet("/fineUserNameServlet")
public class fineUserNameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        //获取字节输出流，准备向页面输出数据
        ServletOutputStream ops = response.getOutputStream();

        //获取输入框的username
        String username = request.getParameter("username");
        //定义flag做为是否是管理员账号
        String flag = "false";
        //静态判断
        if("124546".equals(username)){
            //是，则为管理员账号，写回数据
            flag = "true";
            ops.write(flag.getBytes("utf-8"));
        } else{

            //不是管理员账户，也写回数据
            ops.write(flag.getBytes("utf-8"));
        }
        //关闭字节输出流
        ops.flush();
        ops.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

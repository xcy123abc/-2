package com.main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 添加标签的servlet
 *  功能还未开发，所以只写回信息，作为操作日志
 */

@WebServlet("/AddExpressionServlet")
public class AddExpressionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");

        //获取字符输出流对象
        ServletOutputStream ops = response.getOutputStream();
        //暂时写回flag，值为true，表示功能未开发，发过来的ajax会根据flag的值反馈信息到操作日志
   String flag = "true";
        ops.write(flag.getBytes("utf-8"));
        ops.flush();
        ops.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

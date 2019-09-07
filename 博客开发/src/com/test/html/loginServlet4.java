package com.test.html;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet4")
public class loginServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("111");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (("123").equals(username) && ("123").equals(password)){
            //request.getRequestDispatcher("/demo5").forward(request,response);
            System.out.println("123");
        }else{
            response.setContentType("text/html;charset=utf8");
            ServletOutputStream ops = response.getOutputStream();
            String flag = "false";
            ops.write(flag.getBytes("utf-8"));

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

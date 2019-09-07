package com.main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 *  发表文章的servlet
 */

@WebServlet("/AddActionServlet")
public class AddActionServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf8");
        //获取客户端传递过来的文章信息
        String pyq = request.getParameter("pyq");

        /* 创建session对象，用来存储文本的信息（因为在servlet上面new一些对象就会报错，所以没办法用数据库
           MySQL 和redis都试过，包括servlet创建mapper集合来存储数据，都会报错，所以这次博客主要用session来存储数据）
           */
        //获取session对象
        HttpSession session = request.getSession();
        /**
         * 用栈的思想来存储文章数据，先判断是否有头指针Top
         *  让后把文章存在键键为Top，值为文章的session对象中
         *
         */
        //判断是否是第一次存储，Top为空则是
        if (session.getAttribute("Top") == null){
            //第一次发送
            //文章存在session头为Top的位置，默认为1
            session.setAttribute("1",pyq);
            /*Top指针的值需要变为二变为2，但是Top的值是字符串类型的，相加后变成11，再加变成111，但也
            * 可以这样存在session域中，后面取出来的时候，强制转换为String类型，让后取其长度就可以
            * 巧妙的变成我们需要的int型，作为文章存储所需要的键。
            * */
            session.setAttribute("Top","11");

            //让线程睡0.3s，这样发表文章有一点动态的效果
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //存储信息作为日志信息
            request.setAttribute("time","<p>首次发表成功</p>");
            //转发为原页面
            request.getRequestDispatcher("/action.jsp").forward(request,response);

        }else{
            /**
             *  不是第一次发送，则需要获取栈顶指针的值，
             *  然后作为键来存文章的数据，记录日志信息并返回页面
             */

            //获取头指针的值，并转化为我们需要的值
            String i =(String)session.getAttribute("Top");
            int top =i.length();

            //存数据在session头为top的session中
            session.setAttribute(top+"",pyq);
            //top ++
            session.setAttribute("Top",((String)session.getAttribute("Top"))+1);

            //线程休眠
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        //记录日志信息并返回原页面
        request.setAttribute("time","<p>发表成功</p>"+top+"</p>");
        request.getRequestDispatcher("/action.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

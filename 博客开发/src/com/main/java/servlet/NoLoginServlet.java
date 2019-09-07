package com.main.java.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 游客登陆的servlet，这个servlet是登陆servlet的简化版
 *      功能是记录游客上次访问的时间，也是利用cookie来实现
 *          实现步骤与loginServlet几乎一样，少了管理员账号的判断而已
 *          时间关系下边的注释就不补充了
 */
@WebServlet("/NoLoginServlet")
public class NoLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头
        response.setContentType("text/html;charset=utf8");

        HttpSession session = request.getSession();
        session.setAttribute("login","false");

        //1获取cookie数组
        Cookie[] cookies = request.getCookies();

        //flag为lastTime这个cookie是否存在，目的是便于下面判断的if结构是否执行
        boolean flag = false;

        //判断是否有cookie
        if (cookies != null && cookies.length > 0 ) {
            //有
            //循环遍历cookies数组
            for (Cookie cookie : cookies) {
                //获取cookie头
                String name = cookie.getName();

                //判断是否是last time
                if("lastTime".equals(name)) {
                    //存在所找的cookie，则把flag设为true
                    flag = true;

                    //获取其值并解码，后面需要共享
                    String value = cookie.getValue();
                    value = URLDecoder.decode(value,"utf-8");

                    //新建日期，后重新赋值给lastTime
                    Date date = new Date();
                    //格式化日期
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                    String str_date = sdf.format(date);
                    //URL编码后，才保存到lastTime中
                    str_date = URLEncoder.encode(str_date,"utf-8");

                    //保存cookie发送cookie
                    cookie.setValue(str_date);
                    cookie.setMaxAge(60*60*24*30);
                    response.addCookie(cookie);

                    //数据共享到服务器端
                    request.setAttribute("time","游客访问成功</p><p>您上次访问时间为:"+value);
                    request.getRequestDispatcher("/action.jsp").forward(request,response);
                    break;
                }
            }
        }
        if (cookies == null || cookies.length == 0 || flag == false) {
            //
            //新建日期并格式化
            Date date = new Date();
            //格式化
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
            String str_date = sdf.format(date);

            //新建cookie
            Cookie cookie = new Cookie("lastTime", str_date);
            //编码日期
            str_date = URLEncoder.encode(str_date,"utf-8");

            //保存和发送cookie
            cookie.setValue(str_date);
            cookie.setMaxAge(60*60*24*30);
            response.addCookie(cookie);

            //数据共享
            request.setAttribute("time","游客您好，欢迎您首次访问");
            request.getRequestDispatcher("/action.jsp").forward(request,response);

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

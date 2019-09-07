package com.main.java.servlet;




import com.main.java.dao.LoginDao;
import com.main.java.service.LoginServiceImpy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 *  登陆用的servlet，作用：1.是判断客户端提交的username和password是否为管理员账号（没有访问数据库层）
 *                        2.是返回上次登陆的时间（会被操作日志捕获，并展示）
 *      代码实现步骤：1.获取客户端提交的username和password
 *                   2.判断是否为管理员的username和password（管理员的username和password内置在servlet里）
 *                         是 ：登陆成功
 *                              3.获取上次访问时间（用sCookie实现）
 *                                      获取得到 ：返回数据
 *                                      获取不到 ：用户为第一次登陆，新建session存储现在德时间
 *                        不是：登陆失败
 */
@WebServlet("/LoginServlet2")
public class LoginServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置响应头
        response.setContentType("text/html;charset=utf-8");

        /**
         *  1.获取服务器端数据，username和password
         */
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //获取数据库数据
        LoginServiceImpy loginServiceImpy = new LoginServiceImpy();
        String uid = loginServiceImpy.getUid();
        String uPassword = loginServiceImpy.getPassword();

        //获取session对象，用session来记录信息（记录登陆的状态，后面其他功能需要权限判断的时候可以用）
        HttpSession session = request.getSession();

        /**
         *  2.判断是否为管理员的username和password
         */
        if ((uid.equals(username)) && (uPassword.equals(password))){

            /**
             *  是管理员username和password，登陆成功
             */

            //设置登陆状态
            session.setAttribute("login","true");

            /**
             *  3.获取上次访问时间，获取cookie
             */
            //获取cookie数组
            Cookie[] cookies = request.getCookies();

            boolean flag = false;    //flag为mylastTime这个cookie是否存在，目的是检查if结构是否执行，flag为false表示，默认是不存在得
            //判断是否有cookie
            if (cookies != null && cookies.length > 0 ) {
                //非空则遍历
                //遍历获取cookies中的cookie
                for (Cookie cookie : cookies) {
                    //获取cookie的键
                    String name = cookie.getName();
                    //判断是否为lastTime
                    if("myLastTime".equals(name)) {
                        /**
                         *  获取到上次登陆得时间
                         */
                        flag = true;  //存在所找的cookie，则把flag设为true
                        //获取其值并解码，后面需要共享 （解码是因为首次存储在cookie的值的编码过的，编码可以防止乱码以及存储的数据可以包含空格等功能）
                        String value = cookie.getValue();
                        //解码，其值为上次的登陆时间
                        value = URLDecoder.decode(value,"utf-8");


                        //新建日期，格式化日期，然后编码
                        Date date = new Date();
                        //格式化化日期
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                        String str_date = sdf.format(date);
                        //URL编码
                        str_date = URLEncoder.encode(str_date,"utf-8");


                        //把编码后的值保存到cookie，设置存活时间，发送cookie
                        cookie.setValue(str_date);
                        cookie.setMaxAge(60*60*24*30);
                        response.addCookie(cookie);


                        //共享数据
                        request.setAttribute("time","登陆成功！上次登陆时间为：</p><p>"+value);
                        request.getRequestDispatcher("/action.jsp").forward(request,response);
                        break;
                    }
                }
            }

            if (cookies == null || cookies.length == 0 || flag == false) {
                /**
                 * 获取不到coolie数组，也就是肯定不存在lastTime这个cookie，则是首次登陆
                 */

                //新建日期，格式化，保存到mylastTime这个cookie中
                //新建日期
                Date date = new Date();
                //格式化
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");
                String str_date = sdf.format(date);
                //新建cookie，名为mylastTime
                Cookie cookie = new Cookie("myLastTime", str_date);
                //URL编码
                str_date = URLEncoder.encode(str_date,"utf-8");
                //保存cookie，设置存活时间，发送cookie
                cookie.setValue(str_date);
                cookie.setMaxAge(60*60*24*30);
                response.addCookie(cookie);

                //数据共享
                request.setAttribute("time","首次登陆成功！");
                request.getRequestDispatcher("/action.jsp").forward(request,response);

            }
        } else {
            /**
             *  username和password不是管理员账号，登陆失败
             */
            //设置登陆状态为false
            session.setAttribute("login","false");

            //共享数据
            request.setAttribute("msg", "<h3>账号或密码错误</h3>");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

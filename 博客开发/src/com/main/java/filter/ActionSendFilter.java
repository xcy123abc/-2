package com.main.java.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.http.HttpRequest;

/**
 *   过滤器功能 1.判断用户是否登陆
 *             2.判断用户发送过来的文章是否重复
 */
@WebFilter("/AddActionServlet")
public class ActionSendFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {

        //转换对象
        HttpServletRequest request = (HttpServletRequest)req;

        //获取session对象
        HttpSession session = request.getSession();
        //获取session中的login值，来判断是否登陆（登陆时存储在session中的值，true表示登陆，false表示未登陆）
        Object login = session.getAttribute("login");

        //获取上一条文章所需要的Top指针的值，类似栈的栈顶指针
        int top;

        //判断登陆与否
        if ("true".equals(login)) {

            /**
             *  登陆成功。获取上一次文章的值和本次的值对比，相同则拦截，不相同则放行
             *      由于文章的值存储在session中，并且以Top指针为索引，所以需要先获取Top的值
             */

            //获取Top的值。如果值为空。则表示本次是第一次发表，放行
            String Top = (String)session.getAttribute("Top");

            if (Top == null){
                //第一次发表，放行
                chain.doFilter(request, resp);
            }else {
                /**
                 * Top不是空，则将String类型的索引转化为便于操作和理解的int索引（session中存储的值为String类型）
                 */
                /*转化（初始化Top时，其值为String类型的1，往后加1，则其值为String类型的11，再往后为111）我们需要的时1，2，3，
                    所以取.length，刚好为我们所需要的int类型*/

                //索引为top，则上一条文章的索引为top-1，类似栈
                top = Top.length() - 1;

                //获取上一条的值 pre_pyq，将int的top转化为字符串数值获取session中的值
                String pre_pyq = (String) session.getAttribute(top + "");
                //获取这次pyq的值
                String pyq = request.getParameter("pyq");

                /**
                 *  判断两次文章  相等，则存储信息作为日志，转发回原来的页面
                 *               不相等，则放行
                 */

                //判断
                if (pyq.equals(pre_pyq)) {
                    //相等
                    //存信息
                    req.setAttribute("send-msg", "发表失败，请勿重复发表");
                    //转发回原页面
                    request.getRequestDispatcher("/action.jsp").forward(request, resp);
                }else {
                    //不相同，放行
                    chain.doFilter(request, resp);
                }
            }
        }else{
            /**
             *   未登陆 存储日志信息，放回原页面
              */

            //存信息
            req.setAttribute("send-msg","尚未登陆！无权操作限，请登陆！</p><p><a href='/login.jsp'>点我登陆</a>");
            //返回原页面
            request.getRequestDispatcher("/action.jsp").forward(request,resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

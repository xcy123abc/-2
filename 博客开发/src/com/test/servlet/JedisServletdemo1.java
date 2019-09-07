/*
package com.test.servlet;

import com.main.java.utils.JedisPoolUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/JedisServletdemo1")
public class JedisServletdemo1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //从数据库获取数据
        System.out.println("zhe?");
        Jedis jedis = JedisPoolUtils.getJedis();
        String username = jedis.get("username");
        System.out.println(username);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
*/

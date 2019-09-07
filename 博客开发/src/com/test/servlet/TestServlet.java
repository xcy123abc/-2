package com.test.servlet;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.main.java.dao.LoginDao;
import com.main.java.domain.User;
import com.main.java.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        LoginDao loginDao = new LoginDao();
        System.out.println(loginDao);

        HttpSession session = request.getSession();
        int i = 2;
        session.setAttribute(i+"","1232");


    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);

    }
}

package com.main.java.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.java.domain.Information_a_top;
import com.main.java.service.FindInformation_lei_a_topServiceImpy;
import com.mchange.util.IntObjectMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/FindInformationServlet")
public class FindInformationServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        FindInformation_lei_a_topServiceImpy sercice = new FindInformation_lei_a_topServiceImpy();
        List<Information_a_top> inf = sercice.findInformation_a_top();

        //序列化
        ObjectMapper mapper = new ObjectMapper();
        response.setContentType("application/json;charset=utf-8");
        mapper.writeValue(response.getOutputStream(),inf);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}

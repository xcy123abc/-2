package com.test;

import com.main.java.domain.Information_a_top;
import com.main.java.service.FindInformation_lei_a_topService;
import com.main.java.service.FindInformation_lei_a_topServiceImpy;
import com.main.java.servlet.FindInformationServlet;
import com.main.java.utils.JDBCUtils;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class test2 {

    //@Test
    public void text(){
        FindInformation_lei_a_topServiceImpy impy = new FindInformation_lei_a_topServiceImpy();
        List<Information_a_top> list = impy.findInformation_a_top();
        System.out.println(list);

    }

}

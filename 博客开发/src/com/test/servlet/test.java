package com.test.servlet;

import com.main.java.dao.LoginDao;
import com.main.java.domain.User;
import com.main.java.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class test {
    @Test
    public void test(){
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from user";
        List<User> list = template.query(sql, new BeanPropertyRowMapper<>(User.class));
        //list里得得数据是一个个
        User user = list.get(0);
        String passworld = user.getPassworld();
        System.out.println(passworld);
    }
}

package com.main.java.dao;

import com.main.java.domain.User;
import com.main.java.utils.JDBCUtils;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class LoginDao implements LoginDaoInterface {

    JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql = "select * from user";
    List<User> list = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
    //list里得得数据是一个个类
    User user = list.get(0);

    public String getUid() {
        return  user.getUid();
    }

    public String getPassword() {
        return user.getPassworld();
    }

    public String getUserName(){
        return user.getUname();
    }

    public int getAge() {
        return user.getAge();
    }
}

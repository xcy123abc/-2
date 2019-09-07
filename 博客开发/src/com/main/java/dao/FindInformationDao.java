package com.main.java.dao;

import com.main.java.domain.Information_a_top;
import com.main.java.domain.User;
import com.main.java.utils.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class FindInformationDao implements findInformation_a_topDao {
    @Override
    public List<Information_a_top> findInformation_a_top() {
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "select * from information_lei_a_top";
        List<Information_a_top> list = template.query(sql, new BeanPropertyRowMapper<Information_a_top>(Information_a_top.class));
        return list;
    }
}

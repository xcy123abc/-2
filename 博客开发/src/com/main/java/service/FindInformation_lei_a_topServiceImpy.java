package com.main.java.service;

import com.main.java.dao.FindInformationDao;
import com.main.java.domain.Information_a_top;

import java.util.List;

public class FindInformation_lei_a_topServiceImpy implements FindInformation_lei_a_topService {
    @Override
    public List<Information_a_top> findInformation_a_top() {
        FindInformationDao dao = new FindInformationDao();

        return dao.findInformation_a_top();
    }
}

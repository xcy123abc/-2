package com.main.java.service;

import com.main.java.dao.LoginDao;

public class LoginServiceImpy implements LoginService {

    LoginDao dao = new LoginDao();
    @Override
    public String getUid() {
        return dao.getUid();
    }

    @Override
    public String getPassword() {
        return dao.getPassword();
    }

    @Override
    public String getUserName() {
        return dao.getUserName();
    }
}

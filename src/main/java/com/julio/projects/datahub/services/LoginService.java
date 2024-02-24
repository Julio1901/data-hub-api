package com.julio.projects.datahub.services;

import com.julio.projects.datahub.models.UserModel;

import com.julio.projects.datahub.repositories.login.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    @Autowired
    private LoginRepository loginRepository;

    public boolean authenticate(String username, String password) {
        UserModel user = loginRepository.findByUserName(username);
        return user != null && user.getPassword().equals(password);
    }

}

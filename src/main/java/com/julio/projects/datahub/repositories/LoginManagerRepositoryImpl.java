package com.julio.projects.datahub.repositories;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import com.julio.projects.datahub.network.LoginManagerRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public class LoginManagerRepositoryImpl implements LoginManagerRepository {

    private final LoginManagerRestClient loginManagerRestClient;

    @Autowired
    public LoginManagerRepositoryImpl(LoginManagerRestClient loginManagerRestClient) {
        this.loginManagerRestClient = loginManagerRestClient;
    }

    @Override
    public List<LoginManagerDto> getAllLoginManagerData() {
        return loginManagerRestClient.getAllData();
    }

    @Override
    public LoginManagerDto getLoginById(UUID loginManagerID) {
        return loginManagerRestClient.getLoginById(loginManagerID);
    }


}

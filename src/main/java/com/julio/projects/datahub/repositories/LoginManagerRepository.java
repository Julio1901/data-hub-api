package com.julio.projects.datahub.repositories;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public interface LoginManagerRepository {
    List<LoginManagerDto> getAllLoginManagerData();
    LoginManagerDto getLoginById(UUID loginManagerID);

    LoginManagerDto createLogin(LoginManagerDto loginManagerDto);

    LoginManagerDto updateLogin(LoginManagerDto loginManagerDto);
}

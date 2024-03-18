package com.julio.projects.datahub.repositories;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LoginManagerRepository {
    List<LoginManagerDto> getAllLoginManagerData();
}

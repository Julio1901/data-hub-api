package com.julio.projects.datahub.services;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import com.julio.projects.datahub.network.LoginManagerRestClient;
import com.julio.projects.datahub.repositories.LoginManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoginManagerService {

    @Autowired
    LoginManagerRepository loginManagerRepository;

    public ResponseEntity<Object> getAllData() {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(loginManagerRepository.getAllLoginManagerData());
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get logins info. Error: " + e.getMessage());
        }
    }

    public ResponseEntity<Object>getLoginById(UUID loginManagerID){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(loginManagerRepository.getLoginById(loginManagerID));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get logins info. Error: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> createLogin(LoginManagerDto loginDto) {
        try{
            return ResponseEntity.status(HttpStatus.OK).body(loginManagerRepository.createLogin(loginDto));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get logins info. Error: " + e.getMessage());
        }
    }
}

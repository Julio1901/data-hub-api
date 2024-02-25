package com.julio.projects.datahub.services;

import com.julio.projects.datahub.dtos.LoginKeeperDto;
import com.julio.projects.datahub.models.LoginKeeperModel;
import com.julio.projects.datahub.repositories.LoginKeeperRepository;
import com.julio.projects.datahub.repositories.login.LoginRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class LoginKeeperService {

    @Autowired
    private LoginKeeperRepository loginKeeperRepository;

    public ResponseEntity<Object> saveLoginInfo(@Valid LoginKeeperDto loginKeeperDto) {
        var loginInfoModel = new LoginKeeperModel();
        BeanUtils.copyProperties(loginKeeperDto, loginInfoModel);
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(loginKeeperRepository.save(loginInfoModel));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Unknown error when saving login info. Error: " + e.getMessage());
        }
    }

}

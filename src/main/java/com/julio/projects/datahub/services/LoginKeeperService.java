package com.julio.projects.datahub.services;

import com.julio.projects.datahub.controllers.LoginKeeperController;
import com.julio.projects.datahub.dtos.LoginKeeperDto;
import com.julio.projects.datahub.models.LoginKeeperModel;
import com.julio.projects.datahub.repositories.LoginKeeperRepository;
import com.julio.projects.datahub.repositories.login.LoginRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class LoginKeeperService {

    @Autowired
    private LoginKeeperRepository loginKeeperRepository;

    public ResponseEntity<Object> saveLoginInfo(@Valid LoginKeeperDto loginKeeperDto) {
        var loginInfoModel = new LoginKeeperModel();
        BeanUtils.copyProperties(loginKeeperDto, loginInfoModel);

        if (loginKeeperDto.payDay() != null && (loginKeeperDto.payDay() < 1 || loginKeeperDto.payDay() > 31)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("The payment must be in the range between 1 and 31");
        }

        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(loginKeeperRepository.save(loginInfoModel));
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("Unknown error when saving login info. Error: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllLoginsInfo() {
        try{
            List<LoginKeeperModel> loginInfoList = loginKeeperRepository.findAll();
            //TODO: Implemente this before implement get login info by id
//            if(!loginInfoList.isEmpty()){
//                for(LoginKeeperModel loginInfo: loginInfoList){
//                    UUID id = loginInfo.getLoginId();
//                    loginInfo.add(linkTo(methodOn(LoginKeeperController.class)))
//                }
//            }
            return ResponseEntity.status(HttpStatus.OK).body(loginInfoList);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get logins info. Error: " + e.getMessage());
        }

    }

}

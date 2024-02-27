package com.julio.projects.datahub.services;

import com.julio.projects.datahub.dtos.loginKeeper.LoginKeeperDto;
import com.julio.projects.datahub.models.LoginKeeperModel;
import com.julio.projects.datahub.repositories.LoginKeeperRepository;
import jakarta.validation.Valid;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public ResponseEntity<Object> getByServiceNameAndOwner(String serviceName, String owner) {
       LoginKeeperModel result = loginKeeperRepository.findByServiceNameAndOwner(serviceName, owner);

       if(result != null){
           return  ResponseEntity.status(HttpStatus.OK).body(result);
       }else {
           return  ResponseEntity.status(HttpStatus.OK).body("Register not found. Check the name of the service and the owner.");
       }

    }

    public  ResponseEntity<Object> updateLoginInfo(LoginKeeperDto loginKeeperDto) {
        Optional<LoginKeeperModel> result = loginKeeperRepository.findById(loginKeeperDto.loginId());
        if(result.isPresent()){
            LoginKeeperModel loginKeeper = result.get();
            loginKeeper.setServiceName(loginKeeperDto.serviceName());
            loginKeeper.setPassword(loginKeeperDto.password());
            loginKeeper.setWebSiteLink(loginKeeperDto.webSiteLink());
            loginKeeper.setPayDay(loginKeeperDto.payDay());
            loginKeeper.setOwner(loginKeeperDto.owner());
            loginKeeper.setDescription(loginKeeperDto.description());

            return ResponseEntity.status(HttpStatus.OK).body(loginKeeperRepository.save(loginKeeper));
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Data has not been modified");
        }
    }



}

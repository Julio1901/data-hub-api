package com.julio.projects.datahub.services;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import com.julio.projects.datahub.network.LoginManagerRestClient;
import com.julio.projects.datahub.repositories.LoginManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginManagerService {



    @Autowired
    LoginManagerRepository loginManagerRepository;

    public ResponseEntity<Object> getAllLoginsInfo() {
        try{
//            List<LoginManagerDto> loginInfoList = loginManagerRepository.getAllLoginManagerData();
            //TODO: Implemente this before implement get login info by id
//            if(!loginInfoList.isEmpty()){
//                for(LoginKeeperModel loginInfo: loginInfoList){
//                    UUID id = loginInfo.getLoginId();
//                    loginInfo.add(linkTo(methodOn(LoginKeeperController.class)))
//                }
//            }
//            return ResponseEntity.status(HttpStatus.OK).body(loginInfoList);
            return ResponseEntity.status(HttpStatus.OK).body(loginManagerRepository.getAllLoginManagerData());

        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error to get logins info. Error: " + e.getMessage());
        }
    }

    public ResponseEntity<Object> getAllData() {
        // Aqui você pode implementar lógica adicional, se necessário,
        // como salvar os dados no banco de dados antes de retorná-los
        return ResponseEntity.status(HttpStatus.OK).body(loginManagerRepository.getAllLoginManagerData());
    }
}

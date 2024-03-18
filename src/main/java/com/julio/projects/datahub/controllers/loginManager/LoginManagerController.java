package com.julio.projects.datahub.controllers.loginManager;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import com.julio.projects.datahub.network.LoginManagerRestClient;
import com.julio.projects.datahub.services.LoginManagerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class LoginManagerController {

    @Autowired
    LoginManagerService loginManagerService;

    @PostMapping("/login-manager")
    public ResponseEntity<Object> saveLoginInfo (@RequestBody LoginManagerDto loginDto){
        return loginManagerService.createLogin(loginDto);
    }

    @GetMapping("/login-manager")
    public ResponseEntity<Object> getAllLogins() {
        return loginManagerService.getAllData();
    }

    @PostMapping("/login-manager/get-data/{loginId}")
    public ResponseEntity<Object> getByServiceId(@PathVariable(value ="loginId") UUID loginManagerID){
        return loginManagerService.getLoginById(loginManagerID);
    }

    @PutMapping("/login-manager")
    public ResponseEntity<Object> updateLogin(@RequestBody @Valid LoginManagerDto loginManagerDto){
        return loginManagerService.updateLogin(loginManagerDto);
    }

    @DeleteMapping("/login-manager/{loginId}")
    public ResponseEntity<Object> deleteLogin(@PathVariable (value ="loginId") UUID loginManagerID) {
        return loginManagerService.deleteLogin(loginManagerID);
    }

}

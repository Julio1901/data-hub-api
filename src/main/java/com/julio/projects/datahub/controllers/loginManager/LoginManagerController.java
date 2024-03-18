package com.julio.projects.datahub.controllers.loginManager;

import com.julio.projects.datahub.network.LoginManagerRestClient;
import com.julio.projects.datahub.services.LoginManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginManagerController {

    @Autowired
    LoginManagerService loginManagerService;

    @GetMapping("/login-manager")
    public ResponseEntity<Object> getAllLogins() {
        return loginManagerService.getAllData();
    }
}

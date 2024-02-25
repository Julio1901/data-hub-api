package com.julio.projects.datahub.controllers;

import com.julio.projects.datahub.dtos.LoginKeeperDto;
import com.julio.projects.datahub.services.LoginKeeperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login Keeper")
public class LoginKeeperController {

    @Autowired
    LoginKeeperService loginKeeperService;

    @Operation(
            description = "Post endpoint for create login keeper registers",
            summary = "This is the summary for create login keeper registers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Register created successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @PostMapping("/login-keeper")
    public ResponseEntity<Object> saveLoginInfo (@RequestBody LoginKeeperDto loginKeeperDto){
        return loginKeeperService.saveLoginInfo(loginKeeperDto);
    }

}

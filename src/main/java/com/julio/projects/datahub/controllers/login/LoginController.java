package com.julio.projects.datahub.controllers.login;

import com.julio.projects.datahub.dtos.UserDto;
import com.julio.projects.datahub.services.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Operation(
            description = "Post endpoint to make login",
            summary = "This is the summary to make login",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Login successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
            }
    )
    @PostMapping("/login")
    public ResponseEntity<Object> getUser(@RequestBody UserDto loginRequest) {
        if(loginService.authenticate(loginRequest.userName(), loginRequest.password())){
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }


}

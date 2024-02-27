package com.julio.projects.datahub.controllers;

import com.julio.projects.datahub.dtos.loginKeeper.GetLoginKeeperByNameAndOwnerDto;
import com.julio.projects.datahub.dtos.loginKeeper.LoginKeeperDto;
import com.julio.projects.datahub.services.LoginKeeperService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @Operation(
            description = "Endpoint to get saved login information",
            summary = "This is the summary for get login keeper registers",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Information obtained successfully"),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error")
            }
    )
    @GetMapping("/login-keeper")
    public ResponseEntity<Object> getAllLoginsInfo() {
        return loginKeeperService.getAllLoginsInfo();
    }

    @PostMapping("/login-keeper/get-data")
    public ResponseEntity<Object> getByServiceNameAndOwner(@RequestBody @Valid GetLoginKeeperByNameAndOwnerDto getLoginKeeperByNameAndOwnerDto){
        return loginKeeperService.getByServiceNameAndOwner(getLoginKeeperByNameAndOwnerDto.serviceName(), getLoginKeeperByNameAndOwnerDto.owner());
    }

    @PutMapping("/login-keeper")
    public ResponseEntity<Object> updateLoginKeeper(@RequestBody @Valid LoginKeeperDto loginKeeperDto){
        return loginKeeperService.updateLoginInfo(loginKeeperDto);
    }
}

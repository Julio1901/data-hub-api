package com.julio.projects.datahub.controllers;

import com.julio.projects.datahub.dtos.UserDto;
import com.julio.projects.datahub.models.UserModel;
import com.julio.projects.datahub.repositories.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Operation(
            description = "Post endpoint for create user",
            summary = "This is the summary for create user",
            responses = {
                    @ApiResponse(responseCode = "200", description = "User created successfully"),
                    @ApiResponse(responseCode = "400", description = "Failed to create user"),
                    @ApiResponse(responseCode = "409", description = "User already exists")
            }
    )

    @PostMapping("/users")
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserDto userDto){
        var userModel = new UserModel();
        BeanUtils.copyProperties(userDto, userModel);
        try{
            return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(userModel));
        }catch (DataIntegrityViolationException e)
        {
            if(e.getMessage().contains("duplicate key value violates unique constraint")){
                return ResponseEntity.status(HttpStatus.CONFLICT).body("User already exists");
            }else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unknown error when saving user");
            }
        }
    }

}

package com.julio.projects.datahub.network;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;
import java.util.UUID;

import static com.julio.projects.datahub.network.EndPoints.*;

@Component
public class LoginManagerRestClient {

    RestClient restClient = RestClient.create();

    public  List<LoginManagerDto>  getAllData() {
        return  restClient.get()
                .uri(GET_ALL_LOGIN_MANAGER_DATA_ENDPOINT)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public LoginManagerDto getLoginById(UUID loginManagerID){
        return  restClient.post()
                .uri(GET_LOGIN_DATA_BY_ID + loginManagerID.toString())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }


    public LoginManagerDto createLogin(LoginManagerDto loginManagerDto) {
        return  restClient.post()
                .uri(CREATE_LOGIN)
                .contentType(MediaType.APPLICATION_JSON)
                .body(loginManagerDto)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public LoginManagerDto updateLogin(LoginManagerDto loginManagerDto) {
        return  restClient.put()
                .uri(UPDATE_LOGIN)
                .contentType(MediaType.APPLICATION_JSON)
                .body(loginManagerDto)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

    public String deleteLogin(UUID loginManagerID) {
        return  restClient.delete()
                .uri(DELETE_LOGIN + loginManagerID.toString())
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }
}

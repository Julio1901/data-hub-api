package com.julio.projects.datahub.network;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

@Component
public class LoginManagerRestClient {

    RestClient restClient = RestClient.create();

    public  List<LoginManagerDto>  getAllData() {
        return  restClient.get()
                .uri("http://localhost:8083/login-manager")
                .retrieve()
                .body(new ParameterizedTypeReference<List<LoginManagerDto>>() {});
    }

}

package com.julio.projects.datahub.network;

import com.julio.projects.datahub.dtos.LoginManagerDto;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

import java.util.List;

import static com.julio.projects.datahub.network.EndPoints.GETA_ALL_LOGIN_MANAGER_DATA_ENDPOINT;

@Component
public class LoginManagerRestClient {

    RestClient restClient = RestClient.create();

    public  List<LoginManagerDto>  getAllData() {
        return  restClient.get()
                .uri(GETA_ALL_LOGIN_MANAGER_DATA_ENDPOINT)
                .retrieve()
                .body(new ParameterizedTypeReference<>() {
                });
    }

}

package com.julio.projects.datahub.dtos.loginKeeper;


import jakarta.validation.constraints.NotBlank;

public record GetLoginKeeperByNameAndOwnerDto(@NotBlank String serviceName,
                                              @NotBlank String owner) {

}

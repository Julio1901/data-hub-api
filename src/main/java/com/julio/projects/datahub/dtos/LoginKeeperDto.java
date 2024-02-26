package com.julio.projects.datahub.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

public record LoginKeeperDto(@NotBlank String serviceName,
                             @NotBlank String password,
                             @Nullable  @Schema(nullable = true)String webSiteLink,
                             @NotBlank String description,
                             @Nullable @Schema(nullable = true) Integer payDay
                             ) {

}

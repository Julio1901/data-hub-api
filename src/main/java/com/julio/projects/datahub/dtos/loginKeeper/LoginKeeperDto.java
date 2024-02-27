package com.julio.projects.datahub.dtos.loginKeeper;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

public record LoginKeeperDto(@Nullable @Schema(nullable = true) UUID loginId,
                             @NotBlank String serviceName,
                             @NotBlank String password,
                             @Nullable  @Schema(nullable = true)String webSiteLink,
                             @NotBlank String description,
                             @Nullable @Schema(nullable = true) Integer payDay,
                             @NotBlank String owner
                             ) {

}

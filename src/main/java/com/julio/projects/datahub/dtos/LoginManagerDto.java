package com.julio.projects.datahub.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Nullable;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;


public record LoginManagerDto( UUID loginId,
                               String serviceName,
                               String password,
                               String webSiteLink,
                               String description,
                               Integer payDay,
                               String owner) {
}

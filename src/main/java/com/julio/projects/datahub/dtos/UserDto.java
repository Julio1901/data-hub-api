package com.julio.projects.datahub.dtos;

import jakarta.validation.constraints.NotBlank;

public record UserDto(@NotBlank String userName, @NotBlank String password) {
}

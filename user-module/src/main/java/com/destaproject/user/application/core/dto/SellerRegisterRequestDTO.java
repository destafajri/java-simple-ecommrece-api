package com.destaproject.user.application.core.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SellerRegisterRequestDTO(
        @NotBlank(message = "username must not be blank")
        @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,50}[a-zA-Z0-9]$", message = "must be username format")
        String username,

        @NotBlank(message = "email must not be blank")
        @Email(message = "must be email format")
        String email,

        @NotBlank(message = "Phone number must not be blank")
        @Pattern(regexp = "^08\\d{7,15}$", message = "Must be a valid phone number format and starting with 08")
        String phoneNumber,

        @NotBlank(message = "password must not be blank")
        @Size(min = 6, max = 20, message = "Password must be between 6 and 20 characters long")
        String password,

        @NotBlank(message = "name must not be blank")
        @Size(min = 2, max = 200, message = "name must be between 2 and 200 characters long")
        String name,

        Integer regionCode
) {
}
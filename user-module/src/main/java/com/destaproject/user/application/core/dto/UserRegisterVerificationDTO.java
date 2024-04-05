package com.destaproject.user.application.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.springframework.lang.Nullable;

public record UserRegisterVerificationDTO(
        @Email @Nullable String email,
        @NotBlank @Size(min = 10, max = 200) String token,
        @NotBlank @Size(min = 6, max = 6) String otp
) {
}

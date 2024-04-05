package com.destaproject.user.application.core.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserRegistrationEmailDTO(
        @Email @NotBlank String emailSender,
        @NotBlank String senderName,
        @Email @NotBlank String emailReceipt,
        @NotBlank String recipientName,
        @NotBlank String userRequestToken,
        @NotBlank String otp
) {
}

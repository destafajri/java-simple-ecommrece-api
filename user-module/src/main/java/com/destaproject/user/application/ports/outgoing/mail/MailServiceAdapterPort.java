package com.destaproject.user.application.ports.outgoing.mail;

import com.destaproject.user.application.core.dto.UserRegistrationEmailDTO;
import jakarta.validation.Valid;

public interface MailServiceAdapterPort {
    void sendMailRegistrationVerification(@Valid UserRegistrationEmailDTO userRegistrationEmailDTO);
}

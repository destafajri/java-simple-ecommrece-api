package com.destaproject.user.infrastructure.adapters.mail;

import com.destaproject.common.infrastructure.exception.ValidationService;
import com.destaproject.common.infrastructure.utility.GetPropertiesValue;
import com.destaproject.user.application.core.dto.UserRegistrationEmailDTO;
import com.destaproject.user.application.ports.outgoing.mail.MailServiceAdapterPort;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.UnsupportedEncodingException;

@Slf4j
@Component
@AllArgsConstructor
public class MailServiceAdapter implements MailServiceAdapterPort {

    private final ValidationService validationService;
    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Override
    @Async
    public void sendMailRegistrationVerification(UserRegistrationEmailDTO userRegistrationEmailDTO) {
        validationService.validate(userRegistrationEmailDTO);
        String verifyUrl = createVerifyUrl(
                userRegistrationEmailDTO.userRequestToken(),
                userRegistrationEmailDTO.otp());
        MimeMessage message = prepareMessage(
                userRegistrationEmailDTO,
                userRegistrationEmailDTO.otp(),
                verifyUrl);
        sendMail(message);
    }

    private void sendMail(MimeMessage message) {
        mailSender.send(message);
    }

    private String createVerifyUrl(String token, String otp) {
        return String.format("%s/verify-email?t=%s&c=%s", GetPropertiesValue.getAppUrl(), token, otp);
    }

    private MimeMessage prepareMessage(UserRegistrationEmailDTO userRegistrationEmailDTO, String otp, String verifyUrl) {
        try {
            MimeMessage message = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);

            helper.setFrom(new InternetAddress(userRegistrationEmailDTO.emailSender(), "Desta Project"));
            helper.setTo(userRegistrationEmailDTO.emailReceipt());
            helper.setSubject("Otp Mail");
            helper.setText(emailContent(userRegistrationEmailDTO.recipientName(), otp, verifyUrl), true);

            return message;
        } catch (MessagingException | UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    private String emailContent(String recipientName, String otp, String verifyUrl) {
        Context context = new Context();
        context.setVariable("name", recipientName);
        context.setVariable("otp", otp);
        context.setVariable("verificationUrl", verifyUrl);

        return templateEngine.process("emails/otp.html", context);
    }
}

package com.destaproject.user.presentation.restapi;

import com.destaproject.common.infrastructure.web.presenter.ResponseData;
import com.destaproject.user.application.core.dto.SellerRegisterRequestDTO;
import com.destaproject.user.application.core.dto.UserRegisterVerificationDTO;
import com.destaproject.user.application.ports.incoming.UserAdministrationServicePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@AllArgsConstructor
public class Registration {
    private final UserAdministrationServicePort userAdministrationServicePort;

    @PostMapping(
            path = "/seller/register",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseData<String>> sellerRegister(
            @RequestBody SellerRegisterRequestDTO dto) {

        var response = userAdministrationServicePort.registerNewSeller(dto);
        log.info("registered user: {}", dto);

        return new ResponseEntity<>(ResponseData.<String>builder()
                .code(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED)
                .message("Success Request Register For New Seller")
                .token(response)
                .build(),
                HttpStatus.CREATED);
    }

    @RequestMapping(
            path = "/verify-email",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<ResponseData<String>> verifyEmail(
            @RequestBody(required = false) UserRegisterVerificationDTO dto,
            @RequestParam(name = "e", required = false) String email,
            @RequestParam(name = "t", required = false) String token,
            @RequestParam(name = "c", required = false) String otp
    ) {
        // Create a new DTO based on request parameters or request body
        UserRegisterVerificationDTO finalDto = (dto != null) ? dto :
                new UserRegisterVerificationDTO(email, token, otp);

        userAdministrationServicePort.userRegisterVerification(finalDto);

        return new ResponseEntity<>(ResponseData.<String>builder()
                .code(HttpStatus.CREATED.value())
                .status(HttpStatus.CREATED)
                .message("Success Register For New Seller")
                .build(),
                HttpStatus.OK);
    }
}

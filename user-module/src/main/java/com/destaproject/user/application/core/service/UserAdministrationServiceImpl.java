package com.destaproject.user.application.core.service;

import com.destaproject.common.infrastructure.exception.ValidationService;
import com.destaproject.common.infrastructure.utility.OtpGenerator;
import com.destaproject.common.infrastructure.utility.TimeUtility;
import com.destaproject.common.infrastructure.utility.TokenGenerator;
import com.destaproject.user.application.core.dto.SellerRegisterRequestDTO;
import com.destaproject.user.application.core.dto.UserRegisterVerificationDTO;
import com.destaproject.user.application.core.dto.UserRegistrationEmailDTO;
import com.destaproject.user.application.core.types.RoleType;
import com.destaproject.user.application.core.model.RoleDataDTO;
import com.destaproject.user.application.core.model.UserDataDTO;
import com.destaproject.user.application.ports.incoming.UserAdministrationServicePort;
import com.destaproject.user.application.ports.outgoing.mail.MailServiceAdapterPort;
import com.destaproject.user.application.ports.outgoing.persistance.UserPersistencePort;
import com.destaproject.user.application.ports.outgoing.persistance.UserRolePersistencePort;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@AllArgsConstructor
public class UserAdministrationServiceImpl implements UserAdministrationServicePort {

    private final ValidationService validationService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MailServiceAdapterPort mailServiceAdapterPort;
    private final UserPersistencePort userPersistencePort;
    private final UserRolePersistencePort userRolePersistencePort;

    @Override
    @Transactional
    public String registerNewSeller(SellerRegisterRequestDTO sellerRegisterDTO) {
        validationService.validate(sellerRegisterDTO);
        var userRequestToken = TokenGenerator.generateToken();
        var userOtp = OtpGenerator.generateNumericOTP(6);
        var user = buildUserDataDTOFromSellerDTO(sellerRegisterDTO);
        var role = buildRoleDataDTO(RoleType.SELLER);

        // TODO: add logic to validate user before request registration
        // TODO: add pending user request register logic
        // TODO: add pending user request register logic and
        //       send into redis or mongodb for verification and store pending user

        // send mail verification
        mailServiceAdapterPort.sendMailRegistrationVerification(
                new UserRegistrationEmailDTO(
                        "destafajri@gmail.com",
                        "Desta Project",
                        user.getEmail(),
                        user.getName(),
                        userRequestToken,
                        userOtp));

        return userRequestToken;
    }

    @Override
    @Transactional
    public void userRegisterVerification(UserRegisterVerificationDTO userRegisterVerificationDTO) {
        validationService.validate(userRegisterVerificationDTO);
        // TODO: add logic to verify user request register
        // TODO: add logic to get user pending request register
        // TODO: add logic to add new user register
    }

    private RoleDataDTO buildRoleDataDTO(RoleType roleType) {
        return RoleDataDTO.builder()
                .id(roleType.getId())
                .roleName(roleType)
                .createdAt(TimeUtility.getTimestampByLocalDateTime())
                .build();
    }

    private UserDataDTO buildUserDataDTOFromSellerDTO(SellerRegisterRequestDTO sellerRegisterDTO) {
        return UserDataDTO.builder()
                .email(sellerRegisterDTO.email())
                .username(sellerRegisterDTO.username())
                .phoneNumber(sellerRegisterDTO.phoneNumber())
                .password(bCryptPasswordEncoder.encode(sellerRegisterDTO.password()))
                .name(sellerRegisterDTO.name())
                .regionCode(sellerRegisterDTO.regionCode())
                .createdAt(TimeUtility.getTimestampByLocalDateTime())
                .updatedAt(TimeUtility.getTimestampByLocalDateTime())
                .build();
    }
}

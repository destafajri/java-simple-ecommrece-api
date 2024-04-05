package com.destaproject.user.application.ports.incoming;

import com.destaproject.user.application.core.dto.SellerRegisterRequestDTO;
import com.destaproject.user.application.core.dto.UserRegisterVerificationDTO;

public interface UserAdministrationServicePort {
    String registerNewSeller(SellerRegisterRequestDTO sellerRegisterDTO);
    void userRegisterVerification(UserRegisterVerificationDTO userRegisterVerificationDTO);
}

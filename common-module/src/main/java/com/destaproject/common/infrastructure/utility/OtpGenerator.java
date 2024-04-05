package com.destaproject.common.infrastructure.utility;

import java.security.SecureRandom;

public class OtpGenerator {

    public static String generateNumericOTP(int length) {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder otp = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            otp.append(secureRandom.nextInt(10));
        }
        return otp.toString();
    }
}

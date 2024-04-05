package com.destaproject.common.infrastructure.utility;

import java.math.BigInteger;
import java.security.SecureRandom;

public class TokenGenerator {
    public static String generateToken() {
        SecureRandom random = new SecureRandom();
        return new BigInteger(130, random).toString(32);
    }
}

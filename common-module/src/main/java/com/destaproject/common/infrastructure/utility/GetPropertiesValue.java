package com.destaproject.common.infrastructure.utility;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import java.util.Objects;

@Configuration
public class GetPropertiesValue {

    @Getter private static String secretKey;
    @Getter private static long jwtExpiration;
    @Getter private static long refreshExpiration;
    @Getter private static String appUrl;

    @Autowired
    private Environment env;

    @PostConstruct
    public void init() {
        secretKey = Objects.requireNonNull(env.getProperty("security.jwt.secret-key"));
        jwtExpiration = Long.parseLong(Objects.requireNonNull(env.getProperty("security.jwt.expiration")));
        refreshExpiration = Long.parseLong(Objects.requireNonNull(env.getProperty("security.jwt.refresh-token.expiration")));
        appUrl = Objects.requireNonNull(env.getProperty("application.url"));
    }
}

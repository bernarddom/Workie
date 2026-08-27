package com.deceptiveb.workie.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

public class EncoderConfig {

    @Value("${security.jwt.secret-key}")
    private String jwtKey;

}

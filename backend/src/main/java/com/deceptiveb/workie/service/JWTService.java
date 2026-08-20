package com.deceptiveb.workie.service;

import org.springframework.stereotype.Service;

@Service
public class JWTService {
    private String secretKey;


    private long jwtExpiration;
}

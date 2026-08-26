package com.deceptiveb.workie.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

public interface JWTService {
    boolean validateJwtToken(String token);
    String generateToken(String username);
    String getUserFromToken(String token);
}

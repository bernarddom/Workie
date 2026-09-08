package com.deceptiveb.workie.dto.auth;

public record AuthenticateUserDto(
        String username,
        String password
) {
}

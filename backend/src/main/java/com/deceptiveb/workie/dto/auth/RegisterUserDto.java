package com.deceptiveb.workie.dto.auth;

import com.deceptiveb.workie.model.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterUserDto(
        @NotNull(message = "Username required")
        @Size(min = 3, max = 50)
        String username,
        @NotNull(message = "Email required")
        @Email
        @Size(min = 3, max = 50)
        String email,
        @Size(min = 3, max = 50)
        @NotNull(message = "Password required")
        @NotEmpty
        String password,
        @NotNull(message = "Full name required")
        @Size(min = 3, max = 50)
        String fullName,
        @NotNull
        Role role
) {
}

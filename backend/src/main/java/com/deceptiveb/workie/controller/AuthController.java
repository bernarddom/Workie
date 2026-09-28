package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.dto.auth.AuthenticateUserDto;
import com.deceptiveb.workie.dto.auth.RegisterUserDto;
import com.deceptiveb.workie.model.AppUser;
import com.deceptiveb.workie.repository.AppUserRepo;
import com.deceptiveb.workie.service.JWTService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final AppUserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final JWTService jwtService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AppUserRepo userRepo, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody @Valid AuthenticateUserDto user) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        user.username(),
                        user.password()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            return jwtService.generateToken(userDetails.getUsername());
        }
        return null;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody @Valid RegisterUserDto appUser) {
        if (userRepo.existsByUsername(appUser.username())) {
            return "User already exists!";
        }
        final AppUser newUser = new AppUser(
                appUser.email(),
                appUser.fullName(),
                appUser.username(),
                passwordEncoder.encode(appUser.password()),
                appUser.role()
        );

        userRepo.save(newUser);
        return "User registered succesfully!";
    }
}
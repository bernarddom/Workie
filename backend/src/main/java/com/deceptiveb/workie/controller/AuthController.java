package com.deceptiveb.workie.controller;

import com.deceptiveb.workie.model.AppUser;
import com.deceptiveb.workie.repository.AppUserRepo;
import com.deceptiveb.workie.service.JWTService;
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
    private AuthenticationManager authenticationManager;
    private AppUserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private JWTService jwtService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager, AppUserRepo userRepo, PasswordEncoder passwordEncoder, JWTService jwtService) {
        this.authenticationManager = authenticationManager;
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/signin")
    public String authenticateUser(@RequestBody AppUser appUser) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        appUser.getUsername(),
                        appUser.getPassword()
                )
        );

        final UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        if (userDetails != null) {
            return jwtService.generateToken(userDetails.getUsername());
        }
        return null;
    }

    public String registerUser(@RequestBody AppUser appUser) {
        if (userRepo.existsByUsername(appUser.getUsername())) {
            return "User already exists!";
        }
        final AppUser newUser = new AppUser(
                appUser.getEmail(),
                appUser.getFullName(),
                appUser.getUsername(),
                passwordEncoder.encode(appUser.getPassword())
        );

        userRepo.save(newUser);
        return "User registered succesfully!";
    }
}
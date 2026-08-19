package com.deceptiveb.workie.service;

import com.deceptiveb.workie.model.AppUser;
import com.deceptiveb.workie.repository.AppUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Collections;

public class UserService implements UserDetailsService {
    private AppUserRepo appUserRepo;

    @Autowired
    public UserService(AppUserRepo appUserRepo) {
        this.appUserRepo = appUserRepo;
    }

    private AppUser getUserFromUsername(String username) {
        return appUserRepo
                .findByUsernameAndIsActive(username, true)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUser appUser = getUserFromUsername(username);
        return User.builder()
                .username(appUser.getUsername())
                .password(appUser.getPassword())
                .authorities(Collections.emptyList())
                .build();
    }
}

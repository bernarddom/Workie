package com.deceptiveb.workie.repository;

import com.deceptiveb.workie.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AppUserRepo extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByUsernameAndIsActive(String username, Boolean isActive);
    boolean existsByUsername(String username);
}

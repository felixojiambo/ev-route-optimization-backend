package com.ev.RouteOptimizationSystem.repositories;

import com.ev.RouteOptimizationSystem.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User>findByEmail(String email);
    boolean existsByEmail(String email);
}
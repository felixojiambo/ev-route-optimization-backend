package com.ev.RouteOptimizationSystem.repositories;
import com.ev.RouteOptimizationSystem.models.Trip;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUserId(Long userId);
}
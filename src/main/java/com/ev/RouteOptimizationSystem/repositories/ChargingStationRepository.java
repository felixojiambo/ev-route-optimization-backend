package com.ev.RouteOptimizationSystem.repositories;
import com.ev.RouteOptimizationSystem.models.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingStationRepository extends JpaRepository<ChargingStation, Long> {
}
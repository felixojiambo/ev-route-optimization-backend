package com.ev.RouteOptimizationSystem.repositories;
import com.ev.RouteOptimizationSystem.models.Waypoint;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WaypointRepository extends JpaRepository<Waypoint, Long> {
    List<Waypoint> findByTripId(Long tripId);
}
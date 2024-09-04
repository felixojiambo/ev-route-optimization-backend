package com.ev.RouteOptimizationSystem.interfaces;

import com.ev.RouteOptimizationSystem.dtos.TripDTO;
import com.ev.RouteOptimizationSystem.Request.TripRequest;
import com.ev.RouteOptimizationSystem.Response.TripResponse;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;

import java.util.List;

public interface TripService {
    TripResponse createTrip(TripRequest tripRequest);
    TripResponse updateTrip(Long tripId, TripRequest tripRequest) throws ResourceNotFoundException;
    TripDTO getTripById(Long tripId) throws ResourceNotFoundException;
    List<TripDTO> getTripsByUserId(Long userId);
    void deleteTrip(Long tripId) throws ResourceNotFoundException;
    void addWaypointToTrip(Long tripId, Long waypointId) throws ResourceNotFoundException;
    void removeWaypointFromTrip(Long tripId, Long waypointId) throws ResourceNotFoundException;
    void addChargingStationToTrip(Long tripId, Long chargingStationId) throws ResourceNotFoundException;
    void removeChargingStationFromTrip(Long tripId, Long chargingStationId) throws ResourceNotFoundException;
}

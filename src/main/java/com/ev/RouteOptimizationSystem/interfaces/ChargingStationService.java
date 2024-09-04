package com.ev.RouteOptimizationSystem.interfaces;
import com.ev.RouteOptimizationSystem.dtos.ChargingStationDTO;
import com.ev.RouteOptimizationSystem.Request.ChargingStationRequest;
import com.ev.RouteOptimizationSystem.Response.ChargingStationResponse;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;

import java.util.List;

public interface ChargingStationService {
    ChargingStationResponse createChargingStation(ChargingStationRequest chargingStationRequest);
    ChargingStationResponse updateChargingStation(Long chargingStationId, ChargingStationRequest chargingStationRequest) throws ResourceNotFoundException;
    ChargingStationDTO getChargingStationById(Long chargingStationId) throws ResourceNotFoundException;
    List<ChargingStationDTO> getAllChargingStations();
    void deleteChargingStation(Long chargingStationId) throws ResourceNotFoundException;
}

package com.ev.RouteOptimizationSystem.interfaces;
import com.ev.RouteOptimizationSystem.dtos.WaypointDTO;
import com.ev.RouteOptimizationSystem.Request.WaypointRequest;
import com.ev.RouteOptimizationSystem.Response.WaypointResponse;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;

import java.util.List;

public interface WaypointService {
    WaypointResponse createWaypoint(WaypointRequest waypointRequest);
    WaypointResponse updateWaypoint(Long waypointId, WaypointRequest waypointRequest) throws ResourceNotFoundException;
    WaypointDTO getWaypointById(Long waypointId) throws ResourceNotFoundException;
    List<WaypointDTO> getAllWaypoints();
    void deleteWaypoint(Long waypointId) throws ResourceNotFoundException;
}

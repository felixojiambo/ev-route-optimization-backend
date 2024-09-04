package com.ev.RouteOptimizationSystem.services;
import com.ev.RouteOptimizationSystem.dtos.WaypointDTO;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;
import com.ev.RouteOptimizationSystem.Request.WaypointRequest;
import com.ev.RouteOptimizationSystem.Response.WaypointResponse;
import com.ev.RouteOptimizationSystem.interfaces.WaypointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WaypointServiceImpl implements WaypointService {

    private final WaypointRepository waypointRepository;

    @Autowired
    public WaypointServiceImpl(WaypointRepository waypointRepository) {
        this.waypointRepository = waypointRepository;
    }

    @Override
    public WaypointResponse createWaypoint(WaypointRequest waypointRequest) {
        Waypoint waypoint = new Waypoint();
        waypoint.setLatitude(waypointRequest.getLatitude());
        waypoint.setLongitude(waypointRequest.getLongitude());
        waypoint.setDescription(waypointRequest.getDescription());

        Waypoint savedWaypoint = waypointRepository.save(waypoint);
        WaypointDTO waypointDTO = convertToDTO(savedWaypoint);
        return new WaypointResponse(waypointDTO);
    }

    @Override
    public WaypointResponse updateWaypoint(Long waypointId, WaypointRequest waypointRequest) throws ResourceNotFoundException {
        Waypoint waypoint = waypointRepository.findById(waypointId)
                .orElseThrow(() -> new ResourceNotFoundException("Waypoint", waypointId));

        waypoint.setLatitude(waypointRequest.getLatitude());
        waypoint.setLongitude(waypointRequest.getLongitude());
        waypoint.setDescription(waypointRequest.getDescription());

        Waypoint updatedWaypoint = waypointRepository.save(waypoint);
        WaypointDTO waypointDTO = convertToDTO(updatedWaypoint);
        return new WaypointResponse(waypointDTO);
    }

    @Override
    public WaypointDTO getWaypointById(Long waypointId) throws ResourceNotFoundException {
        Waypoint waypoint = waypointRepository.findById(waypointId)
                .orElseThrow(() -> new ResourceNotFoundException("Waypoint", waypointId));
        return convertToDTO(waypoint);
    }

    @Override
    public List<WaypointDTO> getAllWaypoints() {
        return waypointRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteWaypoint(Long waypointId) throws ResourceNotFoundException {
        if (!waypointRepository.existsById(waypointId)) {
            throw new ResourceNotFoundException("Waypoint", waypointId);
        }
        waypointRepository.deleteById(waypointId);
    }

    private WaypointDTO convertToDTO(Waypoint waypoint) {
        return WaypointDTO.builder()
                .id(waypoint.getId())
                .latitude(waypoint.getLatitude())
                .longitude(waypoint.getLongitude())
                .description(waypoint.getDescription())
                .build();
    }
}

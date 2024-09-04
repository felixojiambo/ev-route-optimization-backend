package com.ev.RouteOptimizationSystem.services;

import com.ev.RouteOptimizationSystem.dtos.TripDTO;
import com.ev.RouteOptimizationSystem.dtos.WaypointDTO;
import com.ev.RouteOptimizationSystem.dtos.ChargingStationDTO;
import com.ev.RouteOptimizationSystem.exceptions.BadRequestException;
import com.ev.RouteOptimizationSystem.exceptions.ResourceNotFoundException;
import com.ev.RouteOptimizationSystem.Request.TripRequest;
import com.ev.RouteOptimizationSystem.Response.TripResponse;
import com.ev.RouteOptimizationSystem.interfaces.TripService;
import com.ev.RouteOptimizationSystem.models.ChargingStation;
import com.ev.RouteOptimizationSystem.models.Trip;
import com.ev.RouteOptimizationSystem.models.Waypoint;
import com.ev.RouteOptimizationSystem.repositories.ChargingStationRepository;
import com.ev.RouteOptimizationSystem.repositories.TripRepository;
import com.ev.RouteOptimizationSystem.repositories.WaypointRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TripServiceImpl implements TripService {

    private final TripRepository tripRepository;
    private final WaypointRepository waypointRepository;
    private final ChargingStationRepository chargingStationRepository;

    @Autowired
    public TripServiceImpl(TripRepository tripRepository, WaypointRepository waypointRepository, ChargingStationRepository chargingStationRepository) {
        this.tripRepository = tripRepository;
        this.waypointRepository = waypointRepository;
        this.chargingStationRepository = chargingStationRepository;
    }

    @Override
    public TripResponse createTrip(TripRequest tripRequest) {
        Trip trip = new Trip();
        trip.setStartLocation(tripRequest.getStartLocation());
        trip.setEndLocation(tripRequest.getEndLocation());
        trip.setDistance(tripRequest.getDistance());
        trip.setEnergyConsumption(tripRequest.getEnergyConsumption());
        trip.setStartTime(tripRequest.getStartTime());
        trip.setEndTime(tripRequest.getEndTime());

        // Set waypoints
        List<Waypoint> waypoints = tripRequest.getWaypointIds().stream()
                .map(id -> waypointRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("Invalid Waypoint ID: " + id)))
                .collect(Collectors.toList());
        trip.setWaypoints(waypoints);

        // Set charging stations
        List<ChargingStation> chargingStations = tripRequest.getChargingStationIds().stream()
                .map(id -> chargingStationRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("Invalid Charging Station ID: " + id)))
                .collect(Collectors.toList());
        trip.setChargingStations(chargingStations);

        Trip savedTrip = tripRepository.save(trip);
        TripDTO tripDTO = convertToDTO(savedTrip);
        return new TripResponse(tripDTO);
    }

    @Override
    public TripResponse updateTrip(Long tripId, TripRequest tripRequest) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));

        trip.setStartLocation(tripRequest.getStartLocation());
        trip.setEndLocation(tripRequest.getEndLocation());
        trip.setDistance(tripRequest.getDistance());
        trip.setEnergyConsumption(tripRequest.getEnergyConsumption());
        trip.setStartTime(tripRequest.getStartTime());
        trip.setEndTime(tripRequest.getEndTime());

        // Update waypoints
        List<Waypoint> waypoints = tripRequest.getWaypointIds().stream()
                .map(id -> waypointRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("Invalid Waypoint ID: " + id)))
                .collect(Collectors.toList());
        trip.setWaypoints(waypoints);

        // Update charging stations
        List<ChargingStation> chargingStations = tripRequest.getChargingStationIds().stream()
                .map(id -> chargingStationRepository.findById(id)
                        .orElseThrow(() -> new BadRequestException("Invalid Charging Station ID: " + id)))
                .collect(Collectors.toList());
        trip.setChargingStations(chargingStations);

        Trip updatedTrip = tripRepository.save(trip);
        TripDTO tripDTO = convertToDTO(updatedTrip);
        return new TripResponse(tripDTO);
    }

    @Override
    public TripDTO getTripById(Long tripId) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));
        return convertToDTO(trip);
    }

    @Override
    public List<TripDTO> getTripsByUserId(Long userId) {
        return tripRepository.findByUserId(userId).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteTrip(Long tripId) throws ResourceNotFoundException {
        if (!tripRepository.existsById(tripId)) {
            throw new ResourceNotFoundException("Trip", tripId);
        }
        tripRepository.deleteById(tripId);
    }

    @Override
    public void addWaypointToTrip(Long tripId, Long waypointId) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));
        Waypoint waypoint = waypointRepository.findById(waypointId)
                .orElseThrow(() -> new ResourceNotFoundException("Waypoint", waypointId));
        trip.getWaypoints().add(waypoint);
        waypoint.setTrip(trip); // Ensure bidirectional consistency
        tripRepository.save(trip);
    }

    @Override
    public void removeWaypointFromTrip(Long tripId, Long waypointId) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));
        Waypoint waypoint = waypointRepository.findById(waypointId)
                .orElseThrow(() -> new ResourceNotFoundException("Waypoint", waypointId));
        trip.getWaypoints().remove(waypoint);
        waypoint.setTrip(null); // Ensure bidirectional consistency
        tripRepository.save(trip);
    }

    @Override
    public void addChargingStationToTrip(Long tripId, Long chargingStationId) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));
        ChargingStation chargingStation = chargingStationRepository.findById(chargingStationId)
                .orElseThrow(() -> new ResourceNotFoundException("Charging Station", chargingStationId));
        trip.getChargingStations().add(chargingStation);
        tripRepository.save(trip);
    }

    @Override
    public void removeChargingStationFromTrip(Long tripId, Long chargingStationId) throws ResourceNotFoundException {
        Trip trip = tripRepository.findById(tripId)
                .orElseThrow(() -> new ResourceNotFoundException("Trip", tripId));
        ChargingStation chargingStation = chargingStationRepository.findById(chargingStationId)
                .orElseThrow(() -> new ResourceNotFoundException("Charging Station", chargingStationId));
        trip.getChargingStations().remove(chargingStation);
        tripRepository.save(trip);
    }

    private TripDTO convertToDTO(Trip trip) {
        return TripDTO.builder()
                .id(trip.getId())
                .startLocation(trip.getStartLocation())
                .endLocation(trip.getEndLocation())
                .distance(trip.getDistance())
                .energyConsumption(trip.getEnergyConsumption())
                .startTime(trip.getStartTime())
                .endTime(trip.getEndTime())
                .waypoints(trip.getWaypoints().stream()
                        .map(waypoint -> WaypointDTO.builder()
                                .id(waypoint.getId())
                                .latitude(waypoint.getLatitude())
                                .longitude(waypoint.getLongitude())
                                .description(waypoint.getDescription())
                                .build())
                        .collect(Collectors.toList()))
                .chargingStations(trip.getChargingStations().stream()
                        .map(station -> ChargingStationDTO.builder()
                                .id(station.getId())
                                .name(station.getName())
                                .address(station.getAddress())
                                .latitude(station.getLatitude())
                                .longitude(station.getLongitude())
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }
}

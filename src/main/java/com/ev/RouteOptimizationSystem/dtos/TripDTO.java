package com.ev.RouteOptimizationSystem.dtos;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripDTO {
    private Long id;
    private String startLocation;
    private String endLocation;
    private double distance;
    private double energyConsumption;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<WaypointDTO> waypoints;
    private List<ChargingStationDTO> chargingStations;

   }

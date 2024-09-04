package com.ev.RouteOptimizationSystem.Request;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripRequest {
    private String startLocation;
    private String endLocation;
    private double distance;
    private double energyConsumption;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private List<Long> waypointIds;
    private List<Long> chargingStationIds;
}

package com.ev.RouteOptimizationSystem.Request;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargingStationRequest {
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}

package com.ev.RouteOptimizationSystem.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargingStationDTO {
    private Long id;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
}

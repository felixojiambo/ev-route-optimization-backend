package com.ev.RouteOptimizationSystem.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaypointDTO {
    private Long id;
    private double latitude;
    private double longitude;
    private String description;

}

package com.ev.RouteOptimizationSystem.Request;

import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WaypointRequest {
    private double latitude;
    private double longitude;
    private String description;

}

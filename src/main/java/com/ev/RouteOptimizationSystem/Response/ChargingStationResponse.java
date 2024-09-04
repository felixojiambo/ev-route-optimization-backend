package com.ev.RouteOptimizationSystem.Response;
import com.ev.RouteOptimizationSystem.dtos.ChargingStationDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChargingStationResponse {
    private ChargingStationDTO chargingStation;
}

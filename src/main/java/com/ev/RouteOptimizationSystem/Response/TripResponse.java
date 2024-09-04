package com.ev.RouteOptimizationSystem.Response;

import com.ev.RouteOptimizationSystem.dtos.TripDTO;

public class TripResponse {
    private TripDTO trip;

    public TripResponse(TripDTO trip) {
        this.trip = trip;
    }

    public TripDTO getTrip() {
        return trip;
    }

    public void setTrip(TripDTO trip) {
        this.trip = trip;
    }
}

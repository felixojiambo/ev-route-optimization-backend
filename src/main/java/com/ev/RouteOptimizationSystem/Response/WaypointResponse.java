package com.ev.RouteOptimizationSystem.Response;

import com.ev.RouteOptimizationSystem.dtos.WaypointDTO;

public class WaypointResponse {
    private WaypointDTO waypoint;

    public WaypointResponse(WaypointDTO waypoint) {
        this.waypoint = waypoint;
    }

    public WaypointDTO getWaypoint() {
        return waypoint;
    }

    public void setWaypoint(WaypointDTO waypoint) {
        this.waypoint = waypoint;
    }
}

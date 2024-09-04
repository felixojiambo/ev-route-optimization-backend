package com.ev.RouteOptimizationSystem.models;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "waypoints")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Waypoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double latitude;

    private double longitude;

    private String description;

    @ManyToOne
    @JoinColumn(name = "trip_id")
    private Trip trip;
}

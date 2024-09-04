package com.ev.RouteOptimizationSystem.exceptions;
public class ResourceNotFoundException extends CustomException {
    public ResourceNotFoundException(String resourceName, Long resourceId) {
        super(String.format("%s with ID %d not found", resourceName, resourceId), "RESOURCE_NOT_FOUND");
    }
}

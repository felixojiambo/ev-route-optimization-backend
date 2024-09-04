package com.ev.RouteOptimizationSystem.exceptions;
public class BadRequestException extends CustomException {
    public BadRequestException(String message) {
        super(message, "BAD_REQUEST");
    }
}
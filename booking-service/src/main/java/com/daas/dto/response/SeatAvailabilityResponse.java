package com.daas.dto.response;

public record SeatAvailabilityResponse(
        String showId,
        Integer availableSeats
) {}

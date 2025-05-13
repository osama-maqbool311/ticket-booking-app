package com.daas.dto.request;

public record BookingStatusUpdateRequest(
        Long bookingId,
        String status
) {}

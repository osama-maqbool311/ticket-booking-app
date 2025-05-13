package com.daas.dto.response;

import java.time.LocalDateTime;

public record BookingResponse(
        Long bookingId,
        String userId,
        String showId,
        Integer seatCount,
        String status,
        LocalDateTime bookingTime
) {}


package com.daas.translator;

import com.daas.dto.request.ShowCreateRequest;
import com.daas.entity.Seat;

public class SeatTranslator {

    public static Seat toEntity(ShowCreateRequest request) {
        Seat seat = new Seat();
        seat.setBooked(false);
        return seat;
    }
}

package com.daas.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "booking_seats")
public class BookingSeats implements Serializable {

    @EmbeddedId
    private BookingSeatId id;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Booking booking;

    @ManyToOne
    @MapsId("seatId")
    @JoinColumn(name = "seat_id", referencedColumnName = "id")
    private Seat seat;
}
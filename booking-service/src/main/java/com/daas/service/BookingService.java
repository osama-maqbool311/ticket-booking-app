package com.daas.service;

import com.daas.dto.request.BookingRequest;
import com.daas.entity.*;
import com.daas.enums.BookingStatus;
import com.daas.repository.BookingRepository;
import com.daas.repository.BookingSeatsRepository;
import com.daas.repository.SeatRepository;
import com.daas.repository.ShowRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class BookingService {

    private static final Logger log = LoggerFactory.getLogger(BookingService.class);

    private final BookingRepository bookingRepository;

    private final ShowRepository showRepository;

    private final SeatRepository seatRepository;

    private final BookingSeatsRepository bookingSeatsRepository;

    @Transactional
    public Booking createBooking(final BookingRequest req) {

        // 1) load Show
        Show show = showRepository.findByIdOptional(req.getShowId())
                .orElseThrow(() -> new NotFoundException("Show not found: " + req.getShowId()));

        // 2) load Seats
        List<Seat> seats = new ArrayList<>();
        seats = seatRepository.list("id in ?1", req.getSeatIds());
        if (seats.size() != req.getSeatIds().size()) {
            throw new NotFoundException("One or more seats not found");
        }

        // 3) create Booking
        Booking booking = new Booking();
        booking.setEmail(req.getEmail());
        booking.setMobile(req.getMobile());
        booking.setShow(show);
        booking.setSeatCount(seats.size());
        booking.setStatus(BookingStatus.CONFIRMED);
        booking.setBookingTime(LocalDateTime.now());
        bookingRepository.persist(booking);


        // 4) create join entries
        seats.forEach(seat -> {
            BookingSeatId id = new BookingSeatId(booking.getId(), seat.getId());
            BookingSeats bs = new BookingSeats();
            bs.setId(id);
            bs.setBooking(booking);
            bs.setSeat(seat);
            bookingSeatsRepository.persist(bs);
        });
        return booking;
    }

    public Booking bookingById(Long id) {
        log.info("Getting booking by id");
        return bookingRepository.listAll().getFirst();
    }
}

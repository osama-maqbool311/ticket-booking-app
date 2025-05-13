package com.daas.repository;

import com.daas.entity.BookingSeats;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookingSeatsRepository implements PanacheRepository<BookingSeats> { }
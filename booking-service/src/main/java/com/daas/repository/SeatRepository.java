package com.daas.repository;

import com.daas.entity.Seat;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SeatRepository implements PanacheRepository<Seat> {
}
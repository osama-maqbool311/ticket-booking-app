package com.daas.repository;

import com.daas.entity.Payment;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class PaymentRepository implements PanacheRepository<Payment> {
    public List<Payment> findByStatus(String status) {
        return list("status", status);
    }
}


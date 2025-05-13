package com.daas.entity;

import com.daas.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    @Column(name = "booking_id", nullable = false)
    public Long bookingId;

    @Column(nullable = false, precision = 19, scale = 4)
    public BigDecimal amount;

    @Column(name = "payment_time", nullable = false)
    public LocalDateTime paymentTime;

    @Column(name = "transaction_id", nullable = false, length = 100, unique = true)
    public String transactionId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false, length = 30)
    public PaymentStatus status;
}

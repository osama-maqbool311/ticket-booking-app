package com.daas.translator;

import com.daas.dto.request.PaymentRequest;
import com.daas.entity.Payment;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PaymentTranslator {
    public Payment toEntity(PaymentRequest dto) {
        Payment p = new Payment();
        p.setBookingId(dto.getBookingId());
        p.setAmount(dto.getAmount());
        p.setPaymentTime(dto.getPaymentTime());
        p.setTransactionId(dto.getTransactionId());
        p.setStatus(dto.getStatus());
        return p;
    }
}

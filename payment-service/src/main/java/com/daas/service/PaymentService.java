package com.daas.service;

import com.daas.client.BookingProxy;
import com.daas.dto.request.PaymentRequest;
import com.daas.dto.response.BookingResponse;
import com.daas.translator.PaymentTranslator;
import jakarta.enterprise.context.ApplicationScoped;

import com.daas.entity.Payment;
import com.daas.repository.PaymentRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class PaymentService {

    private static final Logger log = LoggerFactory.getLogger(PaymentService.class);

    @Inject
    PaymentRepository paymentRepository;

    @Inject
    PaymentTranslator paymentTranslator;


    @Transactional
    public Payment createPayment(final PaymentRequest paymentRequest) {
        log.info("Creating payment");
        Payment payment = paymentTranslator.toEntity(paymentRequest);
        paymentRepository.persist(payment);
        return payment;
    }
}

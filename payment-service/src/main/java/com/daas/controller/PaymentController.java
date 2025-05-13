package com.daas.controller;

import com.daas.client.BookingProxy;
import com.daas.dto.request.PaymentRequest;
import com.daas.service.PaymentService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/payment")
@RequiredArgsConstructor(onConstructor = @__(@Inject))
public class PaymentController {

    private final PaymentService paymentService;

    @RestClient
    BookingProxy bookingProxy;

    @POST
    public Response createPayment(final PaymentRequest paymentRequest) {
        return Response.ok(paymentService.createPayment(paymentRequest)).build();
    }

    @GET
    public Response bookingById(final PaymentRequest paymentRequest) {
        return Response.ok(bookingProxy.getClass()).build();
    }
}

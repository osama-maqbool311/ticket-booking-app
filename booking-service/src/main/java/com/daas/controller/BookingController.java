package com.daas.controller;

import com.daas.dto.request.BookingRequest;
import com.daas.entity.Booking;
import com.daas.service.BookingService;
import io.smallrye.faulttolerance.api.RateLimit;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("/booking")
public class BookingController {

    @Inject
    BookingService bookingService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RateLimit(value = 2, window = 1)
    @Fallback(fallbackMethod = "fallbackBooking")
    public Response bookSeats(final BookingRequest req) {
        Booking booking = bookingService.createBooking(req);
        return Response.status(Response.Status.CREATED)
                .entity(booking)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response bookingById(@PathParam("id") Long id) {
        Booking booking = bookingService.bookingById(id);
        return Response.status(Response.Status.CREATED)
                .entity(booking)
                .build();
    }

    public Response fallbackBooking(BookingRequest req) {
        return Response.status(Response.Status.TOO_MANY_REQUESTS)
                .entity("Too many requests - please try again later.")
                .build();
    }
}

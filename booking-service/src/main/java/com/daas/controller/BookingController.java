package com.daas.controller;

import com.daas.dto.request.BookingRequest;
import com.daas.entity.Booking;
import com.daas.service.BookingService;
import io.quarkus.security.Authenticated;
import io.smallrye.faulttolerance.api.RateLimit;
import jakarta.annotation.security.PermitAll;
import jakarta.annotation.security.RolesAllowed;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Path("/booking")
@Authenticated
public class BookingController {

    @Inject
    BookingService bookingService;

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @RolesAllowed("writer")
    public Response bookSeats(final BookingRequest req) {
        Booking booking = bookingService.createBooking(req);
        return Response.status(Response.Status.CREATED)
                .entity(booking)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @RolesAllowed("writer")
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

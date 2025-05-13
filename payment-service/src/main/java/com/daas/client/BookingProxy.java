package com.daas.client;

import com.daas.dto.response.BookingResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@RegisterRestClient(baseUri = "http://localhost:8082")
public interface BookingProxy {

    @GET
    @Path("/booking/{id}")
    BookingResponse bookingById(@PathParam("id") Long id);
}
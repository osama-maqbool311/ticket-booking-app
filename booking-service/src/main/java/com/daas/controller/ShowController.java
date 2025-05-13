package com.daas.controller;

import com.daas.dto.request.ShowCreateRequest;
import com.daas.entity.Show;
import com.daas.service.ShowService;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("shows")
public class ShowController {

    @Inject
    ShowService showService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllShows() {
        return Response.ok(showService.getAllShows()).build();  // Returns 200 OK with JSON response
    }

    @POST
    @Path("/add")
    public Response createShows(final List<ShowCreateRequest> showCreateRequests) {
        List<Show> shows = showService.createShows(showCreateRequests);
        return Response.status(Response.Status.CREATED).entity(shows).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteShow(@PathParam("id") Long id) {
        showService.deleteShow(id);  // invoke your service’s delete method
        return Response.noContent().build(); // HTTP 204
    }
}
package com.redhat.sample.ecommerce.fe.controller;

import com.redhat.sample.ecommerce.fe.service.LocationService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/v1")
public class ApiController {

    @Inject
    LocationService locationService;

    @GET
    @Path("/location")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getLocation() {
        return locationService.getLocation();
    }
}

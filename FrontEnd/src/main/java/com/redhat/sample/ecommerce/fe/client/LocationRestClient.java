package com.redhat.sample.ecommerce.fe.client;

import com.redhat.sample.ecommerce.fe.bean.Location;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.util.List;

@RegisterRestClient
public interface LocationRestClient {

    @GET
    @Path("/api/v1/locations")
    List<Location> getLocations();

}

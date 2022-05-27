package com.redhat.sample.ecommerce.fe.service;

import com.redhat.sample.ecommerce.fe.bean.Location;
import com.redhat.sample.ecommerce.fe.client.LocationRestClient;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.metrics.annotation.Timed;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@ApplicationScoped
public class LocationService {

    @Inject
    @RestClient
    LocationRestClient locationRestClient;

    @ConfigProperty(name = "com.redhat.sample.ecommerce.fe.client.LocationRestClient/mp-rest/url")
    String locationServiceEndpoint;

    private static final Logger LOG = Logger.getLogger(LocationService.class);

    @Timed
    public List<Location> getLocations( ) {
        LOG.debug("Calling Locations from "+locationServiceEndpoint);
        return locationRestClient.getLocations();
    }


}

package com.redhat.sample.ecommerce.fe.controller;

import com.redhat.sample.ecommerce.fe.service.LocationService;
import com.redhat.sample.ecommerce.fe.service.ProductService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

import org.jboss.logging.Logger;

@Path("/api/v1")
public class ApiController {

    @Inject
    LocationService locationService;

    @Inject
    ProductService productService;

    private static final Logger LOG = Logger.getLogger(ApiController.class);

    @GET
    @Path("/locations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<String> getLocations() {
        LOG.debug("Calling Locations");
        return locationService.getLocations();
    }

    @GET
    @Path("/products")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Map> getProducts() {
        LOG.debug("Calling Products");
        return productService.getProducts();
    }

    @GET
    @Path("/product")
    @Produces(MediaType.APPLICATION_JSON)
    public Map getProduct(@QueryParam("productId") Integer productId) {
        LOG.debug("Calling Product "+ productId);
        return productService.getProduct(productId);
    }
}

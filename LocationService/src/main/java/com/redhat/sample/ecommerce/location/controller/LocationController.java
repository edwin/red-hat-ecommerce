package com.redhat.sample.ecommerce.location.controller;

import com.redhat.sample.ecommerce.location.bean.Location;
import com.redhat.sample.ecommerce.location.service.LocationService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private Tracer tracer;

    private static final Logger logger = LoggerFactory.getLogger(LocationController.class);

    @GetMapping(value = "/locations")
    public List<Location> getLocations(@RequestHeader(name="uber-trace-id", required = false) String uberTraceId) {
        if(uberTraceId == null)
            uberTraceId = "";
        logger.info("requesting get location with traceid {}", uberTraceId);

        Span span = tracer.buildSpan("GET : getLocations ").start();
        span.log("requesting get location ");
        span.setTag("uberTraceId", uberTraceId);
        span.setTag("traceId", uberTraceId.split(":")[0]);
        span.finish();
        return locationService.getLocations();
    }
}
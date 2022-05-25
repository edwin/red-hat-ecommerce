package com.redhat.sample.ecommerce.fe.service;

import javax.enterprise.context.ApplicationScoped;
import java.util.*;

@ApplicationScoped
public class LocationService {

    public List<String> getLocation( ) {
        return Arrays.asList("Singapore", "Jakarta", "Kuala Lumpur");
    }

}

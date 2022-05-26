package com.redhat.sample.ecommerce.location.service;

import com.redhat.sample.ecommerce.location.bean.Location;
import com.redhat.sample.ecommerce.location.mapper.LocationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LocationService {

    @Autowired
    private LocationMapper locationMapper;

    public List<Location> getLocations( ) {
        return locationMapper.getLocations();
    }

}

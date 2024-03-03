package com.dareshuri.libralink.Service;

import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Location;

@Service()
public interface LocationService {

    // CREATE
    Location addLocation(Location location);
    
    // READ
    Iterable<Location> getAllLocations();
    Optional<Location> getLocationById(Long id);

    // UPDATE
    Location updateLocationInfoById(Long id,Map<String,String> inpMap);

    // DELETE
    String deleteLocationById(Long id);
    
}

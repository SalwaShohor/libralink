package com.dareshuri.libralink.Controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dareshuri.libralink.Model.Location;
import com.dareshuri.libralink.Service.LocationService;


@RestController
@RequestMapping("/location")
public class LocationController {
    
    @Autowired
    LocationService locationService;

    // CREATE 
    @PostMapping("/add")
    public Location addLocation(@RequestBody Location location) {
        return locationService.addLocation(location);
    }

    // READ
    @GetMapping("/get-all")
    Iterable<Location> getAllLocations(){
        return locationService.getAllLocations();
    }

    @GetMapping("/get-by-id/{id}")
    public Optional<Location> getLocationById(@PathVariable Long id) {
        return locationService.getLocationById(id);
    }

    // UPDATE
    @PutMapping("/update-location-info-by-id/{id}")
    public Location updateLocationInfoById(@PathVariable Long id, @RequestBody Map<String,String> inpMap) {
        return locationService.updateLocationInfoById(id, inpMap);
    }

    // DELETE
    @DeleteMapping("/delete-by-id/{id}")
    public String deleteLocationById(@PathVariable Long id){
        return locationService.deleteLocationById(id);
    }
    
}

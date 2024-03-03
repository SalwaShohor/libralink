package com.dareshuri.libralink.Service.Impl;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dareshuri.libralink.Model.Location;
import com.dareshuri.libralink.Repository.LocationRepo;
import com.dareshuri.libralink.Service.LocationService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LocationServiceImpl implements LocationService {

    @Autowired 
    LocationRepo locationRepo;

    // CREATE
    @Override
    public Location addLocation(Location location) {
        return locationRepo.save(location);
    }

    // READ
    @Override
    public Iterable<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @Override
    public Optional<Location> getLocationById(Long id) {
        return locationRepo.findById(id);
    }

    // UPDATE
    @Override
    public Location updateLocationInfoById(Long id, Map<String,String> inpMap) {
        Optional<Location> locationOptional = locationRepo.findById(id);
        
        if(locationOptional.isPresent()){
            Location location = locationOptional.get();
            location.setFloorNumber(inpMap.get("floorNumber"));
            location.setShelfNumber(inpMap.get("shelfNumber"));
            return locationRepo.save(location);
        }

        return null;
    }

    // DELETE
    @Override
    public String deleteLocationById(Long id) {
        Optional<Location> locationOptional = locationRepo.findById(id);
        
        if(locationOptional.isPresent()){
            Location location = locationOptional.get();
            locationRepo.delete(location);
            return String.format("Location with id %d successfully deleted!", id);
        }

        return String.format("Location with id %d not found!", id);
    }


     
}

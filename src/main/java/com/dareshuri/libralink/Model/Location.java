package com.dareshuri.libralink.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "locations")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long locationId;
    @NotBlank
    private String shelfNumber;
    @NotBlank
    private String floorNumber;

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setShelfNumber(String shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public String getShelfNumber() {
        return shelfNumber;
    }

    public void setFloorNumber(String floorNumber) {
        this.floorNumber = floorNumber;
    }

    public String getFloorNumber() {
        return floorNumber;
    }

    
}

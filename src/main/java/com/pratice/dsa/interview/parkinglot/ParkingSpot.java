package com.pratice.dsa.interview.parkinglot;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

@Data
public class ParkingSpot {

    private Integer spotNumber;
    private Boolean isOccupied = false;
    private Vehicle parkedVehicle;

    public ParkingSpot(Integer spotNumber){
        this.spotNumber = spotNumber;
        this.isOccupied = false;
    }

}

package com.pratice.dsa.interview.parkinglot;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ParkingLevel {

    private Integer levelNumber;
    private List<ParkingSpot> spots;

    public ParkingLevel(Integer levelNumber, Integer noOfSpots) {
        this.levelNumber = levelNumber;
        this.spots = new ArrayList<>();
        for (int i = 1; i <= noOfSpots; i++) {
            spots.add(new ParkingSpot(i));
        }
    }
}

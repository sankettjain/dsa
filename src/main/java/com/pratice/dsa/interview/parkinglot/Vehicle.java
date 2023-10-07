package com.pratice.dsa.interview.parkinglot;

import lombok.Data;

@Data
public class Vehicle {

    private String vehicleNo;
    private Long entryTimeInMillis;
    private VehicleType vehicleType;

    public Vehicle(String vehicleNo, VehicleType vehicleType) {
        this.entryTimeInMillis = System.currentTimeMillis();
        this.vehicleNo = vehicleNo;
        this.vehicleType = vehicleType;
    }

}

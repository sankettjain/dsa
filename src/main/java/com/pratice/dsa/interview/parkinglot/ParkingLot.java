package com.pratice.dsa.interview.parkinglot;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
public class ParkingLot {

    private List<ParkingLevel> levels;

    public ParkingLot(int numberOfLevels, int spotsPerLevel) {
        levels = new ArrayList<>();
        for (int i = 1; i <= numberOfLevels; i++) {
            levels.add(new ParkingLevel(i, spotsPerLevel));
        }
    }

    public Boolean parkVehicle(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : levels) {
            for (ParkingSpot parkingSpot : parkingLevel.getSpots()) {
                if (!parkingSpot.getIsOccupied()) {
                    parkingSpot.setIsOccupied(true);
                    parkingSpot.setParkedVehicle(vehicle);
                    return true;
                }
            }
        }
        return false;
    }

    public Map<VehicleType, Integer> parkSummary() {
        Map<VehicleType, Integer> summary = new HashMap<>();
        for (ParkingLevel parkingLevel : levels) {
            for (ParkingSpot parkingSpot : parkingLevel.getSpots()) {
                if (parkingSpot.getIsOccupied()) {
                    if (VehicleType.FOUR_WHEELER.equals(parkingSpot.getParkedVehicle().getVehicleType())) {
                        summary.put(VehicleType.FOUR_WHEELER, summary.getOrDefault(VehicleType.FOUR_WHEELER, 0) + 1);
                    } else {
                        summary.put(VehicleType.TW0_WHEELER, summary.getOrDefault(VehicleType.TW0_WHEELER, 0) + 1);
                    }
                }
            }
        }
        return summary;
    }

    public Boolean unParkVehicle(Vehicle vehicle) {
        for (ParkingLevel parkingLevel : levels) {
            for (ParkingSpot parkingSpot : parkingLevel.getSpots()) {
                if (parkingSpot.getParkedVehicle() != null && parkingSpot.getParkedVehicle().getVehicleNo().equals(vehicle.getVehicleNo())) {
                    parkingSpot.setIsOccupied(false);
                    parkingSpot.setParkedVehicle(null);
                    return true;
                }
            }
        }
        return false;
    }

    public double calculateParkingFee(Vehicle vehicle) {
        long timeSpent = System.currentTimeMillis() - vehicle.getEntryTimeInMillis();
        double rate = vehicle.getVehicleType() == VehicleType.FOUR_WHEELER ? 0.10 : 0.03;
        return timeSpent * rate;
    }

    public static void main(String[] args) {

        ParkingLot parkingLot = new ParkingLot(10, 100);

        Vehicle vehicle1 = new Vehicle("ABCD123", VehicleType.FOUR_WHEELER);
        Vehicle vehicle2 = new Vehicle("ABCD123", VehicleType.FOUR_WHEELER);

        Boolean isParkedVehicle1 = parkingLot.parkVehicle(vehicle1);
        Boolean isParkedVehicle2 = parkingLot.parkVehicle(vehicle2);

        System.out.println("isParkedVehicle1: " + isParkedVehicle1 + ", isParkedVehicle1: " + isParkedVehicle2);

        System.out.println("Park Summary: " + parkingLot.parkSummary());

        System.out.println("Fee: " + parkingLot.calculateParkingFee(vehicle1));
        parkingLot.unParkVehicle(vehicle1);

        System.out.println("Park Summary: " + parkingLot.parkSummary());


    }


}

package parking.lot;

import java.util.Arrays;

public class ParkingLotTest {

    public static void main(String[] args) {

        // number of spots of each types 20
        final int LEVEL_0_TYPE_CAP = 21;
        final int LEVEL_0_CAPACITY = 60;

        ParkingLevel level0 = new ParkingLevel(1, LEVEL_0_CAPACITY);
        ParkingLot parkingLot = new ParkingLot(Arrays.asList(level0));
        ParkingSpot spot = null;

        for (int i = 1; i <= LEVEL_0_CAPACITY; i++) {
            if (i <= 20) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.SMALL);
            } else if (i > 20 && i <= 40) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.COMPACT);
            } else if (i > 40 && i <= 60) {
                spot = new ParkingSpot(level0, i, LEVEL_0_TYPE_CAP, VehicleSize.LARGE);
            }
            level0.addSpots(spot);
        }

        System.out.println("Total # of parking Levels: " + parkingLot.getParkingLevels().size());
        System.out.println("# of parking spots: ");
        for (ParkingLevel level : parkingLot.getParkingLevels()) {
            System.out.print("Floor: " + level.getFloor() + ", Spots: " + level.getAvailableSpots().size());
        }
        System.out.println("\n==============================================================");

        Vehicle motorcycle = new MotorCycle("4H5L45");
        boolean isMCParked = parkingLot.parkVehicle(motorcycle);
        ParkingSpot parkedMCSpot = null;

        if (isMCParked) {
            System.out.println("Parked Location for Motorcycle: " + motorcycle.licencePlate);
            parkedMCSpot = motorcycle.parkedSpot;
            System.out.println("Parking Level: " + parkedMCSpot.getLevel().getFloor());
            System.out.println("Parking Row: " + parkedMCSpot.getRow());
            System.out.println("Parking Spot Number: " + parkedMCSpot.getSpotNumber());
        }

        Vehicle car = new Car("4H5L56");
        boolean isCarParked = parkingLot.parkVehicle(car);
        ParkingSpot parkedCarSpot = null;

        if (isCarParked) {
            System.out.println("Parked Location for Car: " + car.licencePlate);
            parkedCarSpot = car.parkedSpot;
            System.out.println("Parking Level: " + parkedCarSpot.getLevel().getFloor());
            System.out.println("Parking Row: " + parkedCarSpot.getRow());
            System.out.println("Parking Spot Number: " + parkedCarSpot.getSpotNumber());
        }

        Vehicle bus = new Bus("4H5L45");
        boolean isBusParked = parkingLot.parkVehicle(bus);
        ParkingSpot parkedBusSpot = null;

        if (isBusParked) {
            System.out.println("Parked Location for Bus: " + bus.licencePlate);
            parkedBusSpot = bus.parkedSpot;
            System.out.println("Parking Level: " + parkedBusSpot.getLevel().getFloor());
            System.out.println("Parking Row: " + parkedBusSpot.getRow());
            System.out.println("Parking Spot Number: " + parkedBusSpot.getSpotNumber());
        }

        System.out.println("\n==============================================================");
        System.out.println("# of parking spots: ");
        for (ParkingLevel level : parkingLot.getParkingLevels()) {
            System.out.print("Floor: " + level.getFloor() + ", Spots: " + level.getAvailableSpots().size());
        }

        System.out.println("\n=====================Motorcycle leaving========================");
        if (parkedMCSpot != null) {
            parkedMCSpot.getLevel().spotFreed(parkedMCSpot);
        }
        System.out.println("# of parking spots: ");
        for (ParkingLevel level : parkingLot.getParkingLevels()) {
            System.out.print("Floor: " + level.getFloor() + ", Spots: " + level.getAvailableSpots().size());
        }

        System.out.println("\n=====================Car leaving========================");
        if (parkedCarSpot != null) {
            parkedCarSpot.getLevel().spotFreed(parkedCarSpot);
        }
        System.out.println("# of parking spots: ");
        for (ParkingLevel level : parkingLot.getParkingLevels()) {
            System.out.print("Floor: " + level.getFloor() + ", Spots: " + level.getAvailableSpots().size());
        }

        System.out.println("\n=====================Bus leaving========================");
        if (parkedBusSpot != null) {
            parkedBusSpot.getLevel().spotFreed(parkedBusSpot);
        }
        System.out.println("# of parking spots: ");
        for (ParkingLevel level : parkingLot.getParkingLevels()) {
            System.out.print("Floor: " + level.getFloor() + ", Spots: " + level.getAvailableSpots().size());
        }
    }

}

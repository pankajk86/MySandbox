package goal.design.system.parkinglot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private int floor;
    private List<ParkingSpot> spots;
    private int availableSpots;

    public ParkingLevel(int floor, int numberOfSpots) {
        this.floor = floor;
        this.spots = new ArrayList<>(numberOfSpots);
        this.availableSpots = numberOfSpots;
    }

    public void addSpots(ParkingSpot spot) {
        this.spots.add(spot);
    }

    public int getAvailableSpots() {
        return this.availableSpots;
    }

    public boolean parkVehicle(Vehicle v) {
        // TODO
        return false;
    }

    public int findAvailableSpots(Vehicle v) {
        // TODO
        return 0;
    }

    public List<ParkingSpot> getSpots() {
        return this.spots;
    }

    public int getFloor() {
        return this.floor;
    }

    public void spotFreed() {
        availableSpots++;
    }
}

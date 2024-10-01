package OOP.parking.lot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLevel {

    private int floor;
    private List<ParkingSpot> spots;
    private List<ParkingSpot> availableSpots;

    public ParkingLevel(int floor, int numberOfSpots) {
        this.floor = floor;
        this.spots = new ArrayList<>(numberOfSpots);
        this.availableSpots = new ArrayList<>(numberOfSpots);
    }

    public void addSpots(ParkingSpot spot) {
        this.spots.add(spot);
        this.availableSpots.add(spot);
    }

    public List<ParkingSpot> getAvailableSpots() {
        return this.availableSpots;
    }

    public boolean parkVehicle(Vehicle v) {
        for (ParkingSpot spot : getAvailableSpots()) {
            if (spot.canFitVehicle(v)) {
                spot.park(v);
                v.setParkedSpot(spot);
                availableSpots.remove(spot);
                return true;
            }
        }
        return false;
    }

    public List<ParkingSpot> getSpots() {
        return this.spots;
    }

    public int getFloor() {
        return this.floor;
    }

    public void spotFreed(ParkingSpot spot) {
        spot.removeVehicle();
        availableSpots.add(spot);
    }
}

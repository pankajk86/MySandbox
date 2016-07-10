package goal.design.system.parkinglot;

import java.util.List;

public class ParkingLot {

    private List<ParkingLevel> levels;
    private int numberOfLevels;

    public ParkingLot(List<ParkingLevel> levels) {
        this.levels = levels;
        this.numberOfLevels = levels.size();
    }

    public boolean parkVehicle(Vehicle v) {
        // TODO
        return false;
    }

}

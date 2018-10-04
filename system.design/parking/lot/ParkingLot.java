package parking.lot;

import java.util.List;

public class ParkingLot {

    private List<ParkingLevel> levels;

    public ParkingLot(List<ParkingLevel> levels) {
        this.levels = levels;
    }

    public boolean parkVehicle(Vehicle v) {

        for (ParkingLevel level : levels) {
            boolean isParked = level.parkVehicle(v);
            if (isParked) {
                return true;
            }
        }
        return false;
    }

    public List<ParkingLevel> getParkingLevels() {
        return this.levels;
    }

}

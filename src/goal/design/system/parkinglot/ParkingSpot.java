package goal.design.system.parkinglot;

public class ParkingSpot {

    private Vehicle vehicle;
    private VehicleSize spotSize;
    private int spotNumber;
    private int row;
    private ParkingLevel level;

    public ParkingSpot(ParkingLevel level, int count, int capacity, VehicleSize size) {
        this.level = level;
        this.spotSize = size;
        this.row = count / capacity;
        this.spotNumber = count;
    }

    public boolean isAvailable() {
        return vehicle == null;
    }

    public boolean canFitVehicle(Vehicle v) {
        // TODO
        return false;
    }

    public boolean park(Vehicle v) {
        // TODO
        return false;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public void removeVehicle() {
        // TODO
    }
}

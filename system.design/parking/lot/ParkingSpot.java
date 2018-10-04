package parking.lot;

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
        if (v.getSize() == VehicleSize.SMALL) {
            return true;
        } else if (v.getSize() == VehicleSize.COMPACT) {
            return this.spotSize == VehicleSize.COMPACT || this.spotSize == VehicleSize.LARGE;
        } else {
            return this.spotSize == VehicleSize.LARGE;
        }
    }

    public boolean park(Vehicle v) {

        if (v.getSize() == VehicleSize.SMALL) {
            this.vehicle = v;
        }

        return false;
    }

    public ParkingLevel getLevel() {
        return this.level;
    }

    public int getRow() {
        return this.row;
    }

    public int getSpotNumber() {
        return this.spotNumber;
    }

    public void removeVehicle() {
        vehicle = null;
    }
}

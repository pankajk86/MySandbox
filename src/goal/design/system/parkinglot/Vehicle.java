package goal.design.system.parkinglot;

public abstract class Vehicle {
    protected ParkingSpot parkingSpot;
    protected String licencePlate;
    protected VehicleSize size;

    public VehicleSize getSize() {
        return size;
    }

    public void park(ParkingSpot s) {
        parkingSpot = s;
    }

    public void clear() {
        // TODO
    }

    public abstract boolean canFitInSpot(ParkingSpot s);
}

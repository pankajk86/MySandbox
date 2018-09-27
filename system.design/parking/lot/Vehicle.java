package parking.lot;

public class Vehicle {
    protected ParkingSpot parkedSpot;
    protected String licencePlate;
    protected VehicleSize size;

    public Vehicle(String licencePlate) {
        this.licencePlate = licencePlate;
    }

    public VehicleSize getSize() {
        return size;
    }

    public void setParkedSpot(ParkingSpot s) {
        parkedSpot = s;
    }

    public void clear() {
        parkedSpot = null;
    }
}

package goal.design.system.parkinglot;

public class Bus extends Vehicle {

    public Bus() {
        size = VehicleSize.LARGE;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return s.canFitVehicle(this);
    }

}

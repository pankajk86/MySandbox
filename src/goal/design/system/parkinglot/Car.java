package goal.design.system.parkinglot;

public class Car extends Vehicle {

    public Car() {
        size = VehicleSize.COMPACT;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return s.canFitVehicle(this);
    }

}

package goal.design.system.parkinglot;


public class MotorCycle extends Vehicle {

    public MotorCycle() {
        size = VehicleSize.SMALL;
    }

    @Override
    public boolean canFitInSpot(ParkingSpot s) {
        return s.canFitVehicle(this);
    }

}

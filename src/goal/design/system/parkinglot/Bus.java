package goal.design.system.parkinglot;

public class Bus extends Vehicle {

    public Bus(String licencePlate) {
        super(licencePlate);
        size = VehicleSize.LARGE;
    }
}

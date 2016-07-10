package goal.design.system.parkinglot;

public class Car extends Vehicle {

    public Car(String licencePlate) {
        super(licencePlate);
        size = VehicleSize.COMPACT;
    }
}

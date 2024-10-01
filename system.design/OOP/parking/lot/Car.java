package OOP.parking.lot;

public class Car extends Vehicle {

    public Car(String licencePlate) {
        super(licencePlate);
        size = VehicleSize.COMPACT;
    }
}

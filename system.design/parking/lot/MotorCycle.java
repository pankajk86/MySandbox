package parking.lot;


public class MotorCycle extends Vehicle {

    public MotorCycle(String licencePlate) {
        super(licencePlate);
        this.size = VehicleSize.SMALL;
    }

}

package goal.design.patterns.factory;

public class SedanCar extends Car {

    public SedanCar(String model, String color) {
        super(model, color);
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a sedan " + this.getModel() + " of " + this.getColor() + " color");
    }

}

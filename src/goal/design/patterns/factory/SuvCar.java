package goal.design.patterns.factory;

public class SuvCar extends Car {

    public SuvCar(String model, String color) {
        super(model, color);
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a SUV " + this.getModel() + " of " + this.getColor() + " color");
    }

}

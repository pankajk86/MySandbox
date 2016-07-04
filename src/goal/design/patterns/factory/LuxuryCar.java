package goal.design.patterns.factory;

public class LuxuryCar extends Car {

    public LuxuryCar(String model, String color) {
        super(model, color);
    }

    @Override
    public void displayInfo() {
        System.out.println("This is a luxury " + this.getModel() + " of " + this.getColor() + " color");
    }

}

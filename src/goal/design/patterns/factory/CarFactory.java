package goal.design.patterns.factory;

public class CarFactory {

    public static Car createCar(String type, String model, String color) {

        Car car = null;

        if (type.equals("Luxury")) {
            car = new LuxuryCar(model, color);
        } else if (type.equals("Sedan")) {
            car = new SedanCar(model, color);
        } else if (type.equals("SUV")) {
            car = new SuvCar(model, color);
        }
        return car;
    }
}

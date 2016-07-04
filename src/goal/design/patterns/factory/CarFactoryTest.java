package goal.design.patterns.factory;

public class CarFactoryTest {

    public static void main(String[] args) {

        Car luxuryCar = CarFactory.createCar("Luxury", "Mercedez-Benz E350e", "Black");
        Car sedanCar = CarFactory.createCar("Sedan", "Toyota Camry", "Grey");
        Car suvCar = CarFactory.createCar("SUV", "Jeep Cherokee", "Red");

        System.out.println("Info about luxury car");
        luxuryCar.displayInfo();

        System.out.println("Info about sedan car");
        sedanCar.displayInfo();

        System.out.println("Info about SUV car");
        suvCar.displayInfo();
    }

}

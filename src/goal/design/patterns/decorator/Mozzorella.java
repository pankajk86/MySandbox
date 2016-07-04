package goal.design.patterns.decorator;

public class Mozzorella extends ToppingDecorator {

    public Mozzorella(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", mozzorella";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.5;
    }
}

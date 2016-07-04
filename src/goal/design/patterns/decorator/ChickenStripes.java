package goal.design.patterns.decorator;

public class ChickenStripes extends ToppingDecorator {

    public ChickenStripes(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", chicken stripes";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.5;
    }

}

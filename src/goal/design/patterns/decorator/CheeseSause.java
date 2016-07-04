package goal.design.patterns.decorator;

public class CheeseSause extends ToppingDecorator {

    public CheeseSause(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", cheese sause";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.0;
    }

}

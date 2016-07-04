package goal.design.patterns.decorator;

public class Pepperoni extends ToppingDecorator {

    public Pepperoni(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", pepperoni";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 2.5;
    }

}

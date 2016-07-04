package goal.design.patterns.decorator;

public class MarinaraSauce extends ToppingDecorator {

    public MarinaraSauce(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", tomato sauce";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 1.5;
    }

}

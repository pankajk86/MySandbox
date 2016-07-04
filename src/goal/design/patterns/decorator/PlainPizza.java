package goal.design.patterns.decorator;

public class PlainPizza implements Pizza {

    @Override
    public String getDescription() {
        return "Thin dough pizza";
    }

    @Override
    public double getCost() {
        return 8.00;
    }

}

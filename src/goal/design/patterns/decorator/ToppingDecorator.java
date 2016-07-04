package goal.design.patterns.decorator;

public abstract class ToppingDecorator implements Pizza {

    Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

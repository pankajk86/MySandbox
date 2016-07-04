package goal.design.patterns.decorator;

public class PizzaMaker {

    public static void main(String[] args) {

        Pizza chickenPizza = new Mozzorella(new MarinaraSauce(new ChickenStripes(new PlainPizza())));
        System.out.println("Description: " + chickenPizza.getDescription());
        System.out.println("Cost: " + chickenPizza.getCost());

        Pizza pepperoniPizza = new CheeseSause(new Pepperoni(new PlainPizza()));
        System.out.println("Description: " + pepperoniPizza.getDescription());
        System.out.println("Cost: " + pepperoniPizza.getCost());
    }

}

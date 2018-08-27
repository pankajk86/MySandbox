package goal.design.patterns.builder;

public class CakeMaker {

    public static void main(String[] args) {
        Cake emptyCake = new Cake.Builder().build();
        System.out.println("Empty " + emptyCake);
        
        Cake eggAndFlourLessCake = new Cake.Builder()
                .sugar(2.0)
                .butter(1.0)
                .vanila(2)
                .bakingpowder(2.0)
                .milk(3.0)
                .cherry(20)
                .build();
        
        System.out.println("Egg and Flour Less " + eggAndFlourLessCake);
        
        Cake awesomeCake = new Cake.Builder()
                .sugar(2.0)
                .butter(1.0)
                .vanila(2)
                .bakingpowder(2.0)
                .milk(3.0)
                .cherry(20)
                .eggs(6)
                .flour(5)
                .build();

        System.out.println("Awesome " + awesomeCake);
    }

}

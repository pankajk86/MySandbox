package goal.design.patterns.builder;

public class Cake {

    private final double sugar; // cup
    private final double butter; // cup
    private final int eggs;
    private final int vanila; // spoon
    private final double flour; // cup
    private final double bakingpowder; // spoon
    private final double milk; // cup
    private final int cherry;

    public Cake(Builder builder) {
        this.sugar = builder.sugar;
        this.butter = builder.butter;
        this.eggs = builder.eggs;
        this.vanila = builder.vanila;
        this.flour = builder.flour;
        this.bakingpowder = builder.bakingpowder;
        this.milk = builder.milk;
        this.cherry = builder.cherry;
    }
    
    @Override
    public String toString() {
        return "Cake { " + 
                "sugar: " + sugar +  
                ", butter: " + butter + 
                ", eggs: " + eggs + 
                ", vanila: " + vanila + 
                ", flour: " + flour + 
                ", bakingpowder: " + bakingpowder + 
                ", milk: " + milk + 
                ", cherry: " + cherry + 
                " }";
    }

    public static class Builder {
        private double sugar; // cup
        private double butter; // cup
        private int eggs;
        private int vanila; // spoon
        private double flour; // cup
        private double bakingpowder; // spoon
        private double milk; // cup
        private int cherry;

        public Builder sugar(double sugar) {
            this.sugar = sugar;
            return this;
        }

        public Builder butter(double butter) {
            this.butter = butter;
            return this;
        }

        public Builder eggs(int eggs) {
            this.eggs = eggs;
            return this;
        }

        public Builder vanila(int vanila) {
            this.vanila = vanila;
            return this;
        }

        public Builder flour(double flour) {
            this.flour = flour;
            return this;
        }

        public Builder bakingpowder(double bakingpowder) {
            this.bakingpowder = bakingpowder;
            return this;
        }

        public Builder milk(double milk) {
            this.milk = milk;
            return this;
        }

        public Builder cherry(int cherry) {
            this.cherry = cherry;
            return this;
        }

        public Cake build() {
            return new Cake(this);
        }
    }
}

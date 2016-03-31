package goal.design.patterns.strategy;

public class Engineer implements Employee {

    @Override
    public double getBonus(double salary) {
        return salary * (0.04);
    }

}

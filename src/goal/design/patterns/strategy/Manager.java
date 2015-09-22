package goal.design.patterns.strategy;

public class Manager implements Employee {

	@Override
	public double getBonus(double salary) {
		return salary * (0.08);
	}

}

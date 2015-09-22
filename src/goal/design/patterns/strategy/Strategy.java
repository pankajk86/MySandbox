package goal.design.patterns.strategy;

public class Strategy {

	private static Employee employee;
	
	public static void main(String[] args) {	
		employee = new Manager();
		System.out.println(employee.getBonus(3000.00));
		
		employee = new Engineer();
		System.out.println(employee.getBonus(2000.00));
	}

}

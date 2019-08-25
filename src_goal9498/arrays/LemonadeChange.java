package arrays;

public class LemonadeChange {

	public static void main(String[] args) {
		int[] a = { 5, 5, 5, 10, 20 };
		boolean result = lemonadeChange(a);
		System.out.println(result);
	}

	private static boolean lemonadeChange(int[] a) {
		if(a == null || a.length == 0) return false;
		
		int five = 0, ten = 0;
		
		for(int i: a) {
			if(i == 5) five++;
			else if(i == 10) {
				five--; ten++;
			} else if(i == 20 && ten > 0) {
				ten--; five--;
			} else five -= 3; // if i = 20, ten = 0
			
			if(five < 0) return false;
		}
		
		return true;
	}

}

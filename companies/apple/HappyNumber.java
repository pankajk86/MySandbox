package apple;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {

	public static void main(String[] args) {
		int n = 29;
		boolean result = isHappy(n);
		System.out.println(result);
	}

	private static boolean isHappy(int n) {
		
		Set<Integer> set = new HashSet<>();
		set.add(n);
		
		while(n != 1) {
			n = transform(n);
			if(set.contains(n))
				return false;
			set.add(n);
		}
		
		return true;
	}

	private static int transform(int n) {

		int value = 0;
		
		while(n > 0) {
			int t = n % 10;
			n /= 10;
			value += Math.pow(t, 2);
		}
		
		return value;
	}

}

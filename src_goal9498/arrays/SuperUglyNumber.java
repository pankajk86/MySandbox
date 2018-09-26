package arrays;

import java.util.Set;

/*
 * TODO
 */
public class SuperUglyNumber {

	public static void main(String[] args) {
		int[] primes = {2, 7, 13, 19};
		int n = 7;
		
		int result = getNthSuperUglyNumber(n, primes);
		System.out.println(result);
	}

	private static int getNthSuperUglyNumber(int n, int[] primes) {

		int count = 1, l = 2;
		
		while(count <= n) {
			Set<Integer> factors = getFactors(l);
		}
		
		
		return 0;
	}

	private static Set<Integer> getFactors(int l) {

		
		return null;
	}

}

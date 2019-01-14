package arrays;

import java.util.ArrayList;
import java.util.List;

public class CountPrimeNumbers {

	public static void main(String[] args) {
		int n = 2;
		int result = countPrimes(n);
		System.out.println(result);
	}

	private static int countPrimes(int n) {
		
		int result = 0;
		if(n <= 2) return result;
		
		List<Integer> primes = new ArrayList<>();
		boolean isPrime = true;

		for (int i = 2; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) {
				primes.add(i);
				result++;
			}
			isPrime = true;
		}
		System.out.println(primes);
		return result;
	}

}

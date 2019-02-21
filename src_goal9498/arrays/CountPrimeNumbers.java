package arrays;

import java.util.ArrayList;
import java.util.List;

public class CountPrimeNumbers {

	public static void main(String[] args) {
		int n = 499979;
		long start = System.currentTimeMillis();
		int result = countPrimes(n);
		long end = System.currentTimeMillis();
		System.out.println(result + ": " + (end - start));

//		start = System.currentTimeMillis();
//		result = countPrimes2(n);
//		end = System.currentTimeMillis();
//		System.out.println(result + ": " + (end - start));
	}
	

	private static int countPrimes(int n) {
		boolean[] notPrime = new boolean[n];
		int result = 0;
		
		for(int i = 2; i < n; i++) {
			if(!notPrime[i]) {
				result++;
				for(int j = 2; i * j < n; j++)
					notPrime[i * j] = true;
			}
		}
		return result;
	}


	@SuppressWarnings("unused")
	private static int countPrimes2(int n) {
		
		int result = 0;
		if(n <= 2) return result;
		
		List<Integer> primes = new ArrayList<>();
		boolean isPrime = true;

		for (int i = 2; i < n; i++) {
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

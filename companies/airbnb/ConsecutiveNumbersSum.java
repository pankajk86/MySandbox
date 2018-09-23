package airbnb;

public class ConsecutiveNumbersSum {

	public static void main(String[] args) {
		int N = 15;
		int result = consecutiveNumbersSum(N);
		System.out.println(result);
	}

	private static int consecutiveNumbersSum(int N) {

		int count = 1;
		
		/*
		 * x + (x+1) + (x+2)+...+ k terms = N
		 * 
		 * For finding the range of k:
		 * 
		 * N - k * (k - 1) / 2 > 0
		 * => k * (k - 1) < 2N
		 * => k < sqrt(2N)
		 */
		for(int k = 2; k < Math.sqrt(2 * N); k++) {
			
			/* With AP sum formula: 
			 * kx + k * (k - 1) / 2 = N
			 * => x = (N - (k * (k - 1) / 2)) / k
			 */
			if((N - (k * (k - 1) / 2)) % k == 0)
				count++;
		}
		
		return count;
	}

}

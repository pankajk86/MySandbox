package google;

public class SubarraySumsDivisbleByK {

	public static void main(String[] args) {
		int[] a = {4, 5, 0, -2, -3, 1};
		int k = 5;
		
		long start = System.currentTimeMillis();
		int result = subarraysDivByK(a, k);
		System.out.println("Time taken: " + (System.currentTimeMillis() - start) + ", result: " + result);
	}
	
	private static int subarraysDivByK(int[] a, int k) {
		int[] map = new int[k];
		map[0] = 1;
		
		int result = 0, sum = 0;
		for(int i: a) {
			sum = (sum + i) % k;
			if(sum < 0) sum += k;
			result += map[sum];
			map[sum]++;
		}
		
		return result;
	}

	/**
	 * O(n^2)
	 * 
	 * @param a
	 * @param k
	 * @return
	 */
	@SuppressWarnings("unused")
	private static int subarraysDivByK_Quadratic(int[] a, int k) {
		if(a == null || a.length == 0) return 0;
		
		int result = 0;
		
		for(int i = 0; i < a.length; i++) {
			int sum = 0;
			for(int j = i; j < a.length; j++) {
				sum += a[j];
				if(sum % k == 0)
					result++;
			}
		}
		
		return result;
	}

}

package linkedin;

public class SubarrayProductLessThanK {

	public static void main(String[] args) {
		int[] a = {10, 5, 2, 6};
		int k = 100;
		
		int result = numSubarrayProductLessThanK(a, k);
		System.out.println(result);
	}

	private static int numSubarrayProductLessThanK(int[] a, int k) {
		
		if(k == 0) return 0;
		int result = 0, prod = 1;
		
		for(int i = 0, j = 0; j < a.length; j++) {
			prod *= a[j];
			while (i <= j && prod >= k)
				prod /= a[i++];
			result += j - i + 1;
		}
		return result;
	}

}

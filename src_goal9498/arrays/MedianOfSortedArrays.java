package arrays;

public class MedianOfSortedArrays {

	public static void main(String[] args) {
		int[] a = {1, 3, 8, 9, 15}; // {1, 2, 3, 4, 10}; // {1, 2}; // { 23, 26, 31, 35 }; // 
		int[] b = {7, 11, 18, 19, 21, 25}; // {}; // {3, 4}; //{ 3, 5, 7, 9, 11, 16 }; // 
		
		double result = getMedian(a, b);
		System.out.println(result);
	}

	private static double getMedian(int[] a, int[] b) {
		int m = a.length, n = b.length, len = m + n;
		if(len % 2 == 0) {
			double left = (double) helper(a, 0, b, 0, len / 2);
			double right = (double) helper(a, 0, b, 0, len / 2 + 1);
			return (left + right) / 2;
		} else return (double) helper(a, 0, b, 0, len / 2 + 1);
	}

	private static int helper(int[] a, int aStart, int[] b, int bStart, int k) {
		if(aStart >= a.length) return b[bStart + k - 1];
		if(bStart >= b.length) return a[aStart + k - 1];
		if(k == 1) return Math.min(a[aStart], b[bStart]);
		
		int aMid = aStart + k/2 - 1;
		int bMid = bStart + k/2 - 1;
		int aVal = aMid >= a.length ? Integer.MAX_VALUE : a[aMid];
		int bVal = bMid >= b.length ? Integer.MAX_VALUE : b[bMid];
		
		if(aVal <= bVal) return helper(a, aMid + 1, b, bStart, k - k/2);
		else return helper(a, aStart, b, bMid + 1, k - k/2);
	}

}

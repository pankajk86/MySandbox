package facebook;

public class LongestContinuousIncreasingSubsequence {

	public static void main(String[] args) {
		int[] a = { 1, 3, 5, 4, 7 };
		int result = findLengthOfLCIS(a);
		System.out.println(result);
	}

	private static int findLengthOfLCIS(int[] a) {
		if(a == null || a.length == 0) return 0;
		int result = 0, count = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(i == 0 || (a[i] > a[i - 1])) result = Math.max(result, ++count);
			else count = 1;
		}
		return result;
	}

}

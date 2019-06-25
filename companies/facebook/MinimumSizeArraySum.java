package facebook;

public class MinimumSizeArraySum {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 2, 4, 4 };
		int sum = 7;
		
		int result = minSubArrayLen(a, sum);
		System.out.println(result);
	}

	private static int minSubArrayLen(int[] a, int s) {
		int sum = 0, result = Integer.MAX_VALUE;
		
		for(int i = 0, j = 0; j < a.length; ) {
			sum += a[j++];
			
			while(sum >= s) {
				result = Math.min(result, j - i);
				sum -= a[i++];
			}
		}
		
		return result;
	}

}

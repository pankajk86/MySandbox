package google;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;
		int result = longestOnes(a, k);
		System.out.println(result);
	}

	private static int longestOnes(int[] a, int k) {
		int start = 0, count = 0, result = 0;

		for (int end = 0; end < a.length; end++) {
			if (a[end] == 0) count++;
			while (count > k) {
				if (a[start] == 0) count--;
				start++;
			}
			result = Math.max(result, end - start + 1);
		}
		return result;
	}

}

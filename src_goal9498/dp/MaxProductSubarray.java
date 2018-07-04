package dp;

public class MaxProductSubarray {

	public static void main(String[] args) {
		int[] a = { 2, 3, 0, 5, 6 };
		int result = maxProduct(a);
		System.out.println(result);
	}

	private static int maxProduct(int[] a) {

		int result = a[0];

		for (int i = 1, imax = result, imin = result; i < a.length; i++) {

			if (a[i] < 0) {
				int temp = imax;
				imax = imin;
				imin = temp;
			}

			imax = Math.max(a[i], a[i] * imax);
			imin = Math.min(a[i], a[i] * imin);

			result = Math.max(result, imax);
		}

		return result;
	}

}

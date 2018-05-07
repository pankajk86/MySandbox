package dp;

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		int[] a = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1}; // { 10, 15, 20 };

		System.out.println(minCost(a));
	}

	private static int minCost(int[] a) {

		int n = a.length;
		int[] f = new int[n];

		f[0] = a[0];
		f[1] = a[1];

		for (int i = 2; i < n; i++) {
			f[i] = a[i] + Math.min(f[i - 1], f[i - 2]);
		}

		return Math.min(f[n - 1], f[n - 2]);
	}

}

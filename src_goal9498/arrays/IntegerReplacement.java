package arrays;

public class IntegerReplacement {

	public static void main(String[] args) {
		int n = 100000000;
		int result = countReplacement(n);
		System.out.println(result);
	}

	private static int countReplacement(int n) {

		int[] a = new int[n + 2];

		for (int i = 2; i <= n; i++) {
			if (i % 2 == 0) {
				a[i] = a[i / 2] + 1;
			} else {
				a[i + 1] = a[(i + 1) / 2] + 1;
				a[i] = Math.min(a[i-1] + 1, a[i + 1] + 1);
			}
		}

		return a[n];
	}
}

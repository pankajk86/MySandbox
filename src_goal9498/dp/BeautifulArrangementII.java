package dp;

public class BeautifulArrangementII {

	public static void main(String[] args) {
		int n = 6, k = 3;
		int[] result = constructArray(n, k);

		for (int i : result) {
			System.out.print(i + ", ");
		}
	}

	private static int[] constructArray(int n, int k) {
		int[] result = new int[n];
		int c = 0;

		for (int i = 1; i < n - k; i++) {
			result[c++] = i;
		}

		for (int i = 0; i <= k; i++) {
			if (i % 2 == 0) {
				result[c++] = n - k + i / 2;
			} else {
				result[c++] = n - i / 2;
			}
		}

		return result;
	}

}

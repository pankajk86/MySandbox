package google;

public class KthSmallestInSortedMatrix {

	public static void main(String[] args) {
		int[][] a = {
				{ 1,  5,  9 },
				{ 10, 11, 13 },
				{ 12, 13, 15 }
		};
		int k = 8;
		int result = kthMinimum(a, k);
		System.out.println(result);
	}

	private static int kthMinimum(int[][] a, int k) {
		int n = a.length;
		int left = a[0][0], right = a[n - 1][n - 1];

		while (left < right) {
			int mid = left + (right - left) / 2;
			int count = getLessOrEqual(a, mid);
			if (count < k) left = mid + 1;
			else right = mid;
		}
		return left;
	}

	private static int getLessOrEqual(int[][] a, int mid) {
		int count = 0, col = a[0].length - 1;
		for (int[] row : a) {
			while (col >= 0 && row[col] > mid) col--;
			count += col + 1;
		}
		return count;
	}

}

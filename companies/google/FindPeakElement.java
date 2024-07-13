package google;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] a = { 6, 1, 2, 3, 1 }; // { 1, 2, 1, 3, 5, 6, 4 };
		int result = findPeak(a);
		System.out.println(result);
	}

	private static int findPeak(int[] a) {
		int left = 0, right = a.length - 1;

		while (left < right) {
			int mid = left + (right - left) / 2;
			if (a[mid] < a[mid + 1]) left = mid + 1;
			else right = mid;
		}

		return right;
	}

}

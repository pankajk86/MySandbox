package google;

public class FindPeakElement {

	public static void main(String[] args) {
		int[] a = { 6, 1, 2, 3, 1 }; // { 1, 2, 1, 3, 5, 6, 4 };
		int result = findPeak(a);
		System.out.println(result);
	}

	private static int findPeak(int[] a) {

		int result = 0;
		
		if(a.length == 1) return 0;

		for (int i = 0; i < a.length; i++) {

			if (i == 0) {
				if (a[i] > a[i + 1]) {
					result = a[result] > a[i] ? result : i;
				}
			} else if (i == a.length - 1) {
				if (a[i] > a[i - 1]) {
					result = a[result] > a[i] ? result : i;
				}
			} else {
				if (a[i] > a[i - 1] && a[i] > a[i + 1]) {
					result = a[result] > a[i] ? result : i;
				}
			}
		}

		return result;
	}

}

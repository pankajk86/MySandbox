package google;

public class SingleElementInSortedArray {

	public static void main(String[] args) {
		int[] a = { 3, 3, 7, 7, 10, 11, 11 };
		int result = singleElement(a);
		System.out.println(result);
	}

	private static int singleElement(int[] a) {
		int n = a.length, left = 0, right = n / 2;
		
		while(left < right) {
			int mid = (left + right) / 2;
			if(a[2 * mid] != a[2 * mid + 1])
				right = mid;
			else left = mid + 1;
		}
		return a[2 * left];
	}

}

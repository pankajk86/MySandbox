package google;

public class VerifyPreorderSequenceInBST {

	public static void main(String[] args) {
		int[] a = { 5, 2, 1, 3, 6 };
		boolean result = verifyPreorder(a);
		System.out.println(result);
	}

	private static boolean verifyPreorder(int[] a) {
		return verify(a, 0, a.length - 1, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean verify(int[] a, int start, int end, int min, int max) {
		if (start > end)
			return true;

		int root = a[start];
		if (root > max || root < min)
			return false;
		int right = start;

		while (right <= end && a[right] <= root)
			right++;

		return verify(a, start + 1, right - 1, min, root) && verify(a, right, end, root, max);
	}
}

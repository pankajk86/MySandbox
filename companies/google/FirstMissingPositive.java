package google;

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] a = { 3, 4, -1, 1 };
		int result = firstMissingPositiveI(a);
		System.out.println(result);
		
		result = firstMissingPositiveII(a);
		System.out.println(result);
	}

	// Time: O(n), Space: O(1)
	private static int firstMissingPositiveII(int[] a) {
		int n = a.length;
		boolean contains1 = false;

		for (int i = 0; i < n; i++) {
			if (a[i] == 1) contains1 = true;

			// solution exists in range : [1, n]
			if (a[i] <= 0 || a[i] > n) a[i] = 1;
		}

		if (!contains1) return 1;

		for (int i = 0; i < n; i++) {
			int num = Math.abs(a[i]);
			int index = num - 1;

			// if it is positive, it means that number is being seen first time,
			// and mark it as negative (as seen).
			if (a[index] > 0) a[index] *= -1;
		}

		for (int i = 0; i < n; i++) {
			// if the number is positive, it means that has not been updated before.
			// it means that number is not present in the array.
			// hence it is our result.
			if (a[i] > 0) return i + 1;
		}

		// if all number is negative, it means they have been seen before.
		// all are present.
		// hence we will return the next number (beyond the size of array) as result.
		return n + 1;
	}



	// Time: O(n), Space: O(n)
	private static int firstMissingPositiveI(int[] a) {
		int n = 0;

        for (int j : a) {
            if (j > 0) n = Math.max(j, n);
        }

		int[] cache = new int[n + 1];
        for (int j : a) {
            if (j > 0) cache[j] = 1;
        }

		for (int i = 1; i < cache.length; i++) {
			if (cache[i] == 0) return i;
		}

		return n + 1;
	}

}

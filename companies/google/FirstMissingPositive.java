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
		int i = 0;
		
		while(i < a.length) {
			if(a[i] == i + 1 || a[i] <= 0 || a[i] >= a.length) 
				i++;
			else if(a[a[i] - 1] != a[i])
				swap(a, i, a[i] - 1);
			else i++;
		}
		
		i = 0;
		while(i < a.length && a[i] == i + 1)
			i++;
		return i + 1;
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	// Time: O(n), Space: O(n)
	private static int firstMissingPositiveI(int[] a) {
		int n = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) n = Math.max(a[i], n);
		}

		int[] cache = new int[n + 1];
		for (int i = 0; i < a.length; i++) {
			if (a[i] > 0) cache[a[i]] = 1;
		}

		for (int i = 1; i < cache.length; i++) {
			if (cache[i] == 0) return i;
		}

		return n + 1;
	}

}

package arrays;

public class ScratchBook {

	public static void main(String[] args) {
		numberPalindrome();
	}

	private static void numberPalindrome() {
		int n = 12321;
		int p = n, m = 0;

		while (n > 0) {
			int r = n % 10;
			n /= 10;
			m = 10 * m + r;
		}

		System.out.println(m == p);
	}

}

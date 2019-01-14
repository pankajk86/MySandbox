package linkedin;

public class ValidPerfectSquare {

	public static void main(String[] args) {
		int n = 16;
		boolean result = isPerfectSquare(n);
		System.out.println(result);
	}

	private static boolean isPerfectSquare(int n) {
		long x = n;
		while (x * x > n)
			x = (x + n / x) / 2;
		return x * x == n;
	}

}

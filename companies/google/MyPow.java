package google;

public class MyPow {

	public static void main(String[] args) {
		double x = 2.00000;
		int n = 10;

		double result = myPow(x, n);
		System.out.println(result);
	}

	private static double myPow(double x, int n) {
		double result = helper(x, Math.abs(n));
		return n < 0 ? 1 / result : result;
	}

	private static double helper(double x, int n) {
		if (x == 0) return 0;
		if (n == 0) return 1;
		double result = helper(x, n / 2);
		result *= result;

		return n % 2 == 0 ? result : x * result;
	}

}

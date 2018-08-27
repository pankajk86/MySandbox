package google;

public class MyPow {

	public static void main(String[] args) {
		double x = 0.00001D;
		int n = 2147483647;

		long start = System.currentTimeMillis();
		double result = myPow(x, n);
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(result);

		start = System.currentTimeMillis();
		result = myPow2(x, n);
		System.out.println(System.currentTimeMillis() - start);
		System.out.println(result);
	}

	public static double myPow2(double x, int n) {

		double temp = x;
		if (n == 0)
			return 1;
		temp = myPow2(x, n / 2);
		if (n % 2 == 0)
			return temp * temp;
		else {
			if (n > 0)
				return x * temp * temp;
			else
				return (temp * temp) / x;
		}
	}

	private static double myPow(double x, int n) {

		if (n == 0)
			return 1D;

		double result = x;

		for (int i = 1; i < Math.abs(n); i++) {
			result *= x;
		}

		if (n < 0) {
			result = 1 / result;
		}

		result = (double) Math.round(result * 100000D) / 100000D;
		return result;
	}

}

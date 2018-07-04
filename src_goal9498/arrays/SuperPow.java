package arrays;

public class SuperPow {

	public static void main(String[] args) {
		int a = 2;
		int[] b = { 3 };

		int result = superPow(a, b);
		System.out.println(result);
	}

	private static int superPow(int a, int[] b) {
		int result = 1;

		for (int i = 0; i < b.length; i++) {
			result = pow(result, 10) * pow(a, b[i]) % 1337;
		}
		return result;
	}

	private static int pow(int result, int i) {

		if (i == 0)
			return 1;
		if (i == 1)
			return result % 1337;
		return pow(result % 1337, i / 2) * pow(result % 1337, i - i / 2) % 1337;
	}

}

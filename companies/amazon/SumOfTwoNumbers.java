package amazon;

public class SumOfTwoNumbers {

	public static void main(String[] args) {
		int a = 5, b = 4;
		System.out.println(Integer.toBinaryString(a) + "+" + Integer.toBinaryString(b));
		int result = sum(a, b);
		System.out.println(Integer.toBinaryString(result));
	}

	private static int sum(int a, int b) {
		int c;
		while (b != 0) {
			c = (a & b);
			a = a ^ b;
			b = (c) << 1;
		}
		return a;
	}

}

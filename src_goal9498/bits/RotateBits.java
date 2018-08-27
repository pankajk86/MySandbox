package bits;

public class RotateBits {

	public static void main(String[] args) {
		int n = 9, d = 3;
		int result = rotateBits(n, d);
		System.out.println(result);
	}

	private static int rotateBits(int n, int d) {

		int part1 = n << d;
		System.out.println(System.getProperty("sun.arch.data.model"));
		int part2 = n >> (32 - d);
		int result = part1 | part2;
		return result;
	}

}

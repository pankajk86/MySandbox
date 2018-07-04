package arrays;

public class WaterAndJugs {

	public static void main(String[] args) {
		int x = 3, y = 5, z = 5;

		boolean result = canMeasureWater(x, y, z);
		System.out.println(result);
	}

	private static boolean canMeasureWater(int x, int y, int z) {
		return z == 0 || ((z <= x + y) && (z % gcd(x, y) == 0));
	}

	private static int gcd(int x, int y) {
		return y == 0 ? x : gcd(y, x % y);
	}

}

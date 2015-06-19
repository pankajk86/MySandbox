package goal.algorithms.dnc;

public class Karatsuba {

	public static void main(String[] args) {
		int x = 1234;
		int y = 5678;
		int result = karatsubaMultiplication(x,y);
		System.out.println("Karatsuba Multiplication of " + x + " and " + y + ": " + result);
	}

	public static int karatsubaMultiplication(int x, int y) {
		if(x < 10 || y < 10){
			return (x*y);
		}
		
		int m = max_length(x,y);
		int half_m = m/2;
		int[] x_split = split_num(x, half_m); 
		int[] y_split = split_num(y, half_m);
		int z0 = karatsubaMultiplication(x_split[0], y_split[0]);
		int z1 = karatsubaMultiplication(x_split[0] + x_split[1], y_split[0] + y_split[1]);
		int z2 = karatsubaMultiplication(x_split[1], y_split[1]);
		
		int first = z0 * (int) Math.pow(10, 2 * half_m);
		int second = (z1-z0-z2) * (int) Math.pow(10, half_m);
		int third = z2;

		return (first + second + third);
	}

	private static int[] split_num(int x, int i) {
		int divisor = (int) Math.pow(10, i);
		int[] result = {x/divisor, x%divisor};
		return result;
	}

	private static int max_length(int x, int y) {
		int x_length = String.valueOf(x).length();
		int y_length = String.valueOf(y).length();
		return (x_length >= y_length ? x_length : y_length);
	}

}

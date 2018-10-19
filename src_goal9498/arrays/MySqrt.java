package arrays;

public class MySqrt {

	public static void main(String[] args) {
		int result = sqrt(8);
		System.out.println(result);
	}

	private static int sqrt(int n) {
		long r = n;
		
		while(r * r > n)
			r = (r + n / r) / 2;
		return (int) r;
	}

}

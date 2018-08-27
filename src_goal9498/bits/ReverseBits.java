package bits;

public class ReverseBits {

	public static void main(String[] args) {
		int n = 4;
		int result = reverseBits(n);
		System.out.println(result);
	}

	private static int reverseBits(int n) {

		int reverse = 0;
		
		for(int i = 0; i < 32; i++) {
			reverse = reverse << 1 | (n & 1);
			n >>>= 1;
		}
		
		return reverse;
	}

}

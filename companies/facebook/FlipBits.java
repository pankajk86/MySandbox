package facebook;

public class FlipBits {

	public static void main(String[] args) {
		int n = 10;
		int result = flipBits(n);
		System.out.println(result);
	}

	private static int flipBits(int n) {
		int x = (int) (Math.log(n) / Math.log(2) + 1);
		
		for(int i = 0; i < x; i++) {
			n = n ^ (1 << i);
		}
		return n;
	}
}

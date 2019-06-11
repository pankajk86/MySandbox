package expedia;

public class FourthBit {

	public static void main(String[] args) {
		int n = 138;

		int t = 0;
		for(int i = 1; i <= 4; i++) {
			t = n & 1;
			n >>= 1;
		}
		
		System.out.println(t);
	}

}

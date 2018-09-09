package airbnb;

public class GCDofNPositiveIntegers_AMZN {

	public static void main(String[] args) {
		int n = 8;
		int[] a = {2, 3, 4, 5, 6};
		int result = findGCD(a, n);
		System.out.println(result);
	}

	private static int findGCD(int[] a, int n) {
		int gcd = a[0];
		
		for(int i = 1; i < a.length; i++)
			gcd = gcdOfTwo(gcd, a[i]);
		
		return gcd;
	}
	
	private static int gcdOfTwo(int a, int b) {
		
		int gcd = 1;
		
		for(int i = 1; i <= a && i <= b; i++) {
			if(a % i == 0 && b % i == 0)
				gcd = i;
		}
		return gcd;
	}

}

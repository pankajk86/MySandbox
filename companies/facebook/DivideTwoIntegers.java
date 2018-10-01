package facebook;

public class DivideTwoIntegers {

	public static void main(String[] args) {
		int dividend = -2147483648, divisor = -1;
		int result = divide(dividend, divisor);
		System.out.println(result);
	}

	private static int divide(int dividend, int divisor) {

		boolean isNeg = (dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0);
		
		long ldividend = Math.abs((long) dividend), ldivisor = Math.abs((long) divisor);
		long result = 0, curr = 1, sub = ldivisor;
		
		while(ldividend >= ldivisor) {
			if(ldividend >= sub) {
				result += curr;
				ldividend -= sub;
				sub <<= 1; // sub = sub * 2
				curr <<= 1; // curr = curr * 2
			} else {
				sub >>= 1; // sub = sub / 2
				curr >>= 1; // curr = curr / 2
			}
		}
		
		result = isNeg ? -result : result;
		result = result < Integer.MIN_VALUE || result > Integer.MAX_VALUE ? Integer.MAX_VALUE : result;
		return (int) result;
	}

}

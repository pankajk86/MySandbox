package goal.algorithms.bit.manipulation;

public class BinaryNumbersSum {

	// NEEDS TO BE IMPLEMENTED
	public static void main(String[] args) {
		//String b1 = "1010", b2 = "1011";
		long binary1 = 1010, binary2 = 1011;
		
		int[] result = sumBinary(binary1, binary2);
		
		for(int i = result.length-1; i>=0; i--) {
			System.out.print(result[i] + " ");
		}
		
	}

	private static int[] sumBinary(long binary1, long binary2) {
		
		int sum[] = new int[8];
		int remainder = 0, i = 0;
		
		while (binary1 != 0 || binary2 != 0)
	    {
	        sum[i++] =(int) ((binary1 % 10 + binary2 % 10 + remainder) % 2);
	        remainder =(int) ((binary1 % 10 + binary2 % 10 + remainder) / 2);
	        binary1 = binary1 / 10;
	        binary2 = binary2 / 10;
	    }
		
	    if (remainder != 0)
	        sum[i++] = remainder;
		
		return sum;
	}

	@SuppressWarnings("unused")
	private static int[] sumBinary(int[] a, int[] b) {
		
		int result[] = new int[4];
		int c = 0, i;
		
		for(i=0; i<3; i++) {
			result[i] = ((a[i] ^ b[i]) ^ c);
			c = ((a[i] & b[i]) | (b[i] & c)) | (c & a[i]);
		}
		
		result[i] = c;
		
		return result;
	}

}

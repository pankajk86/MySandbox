package arrays;

public class ScratchPad {

	public static void main(String[] args) {
		numberPalindrome();
		initializeTwoDimArray();
		mathCeiling();
	}

	private static void mathCeiling() {
		int n = 5;
        double result = Math.ceil((double) n / 2);
        System.out.println(result);
	}

	private static void initializeTwoDimArray() {
		int[][] result = new int[3][2];
		int[] a = {1, 2};
        result[0] = a;
        result[1] = a;
        result[2] = new int[] {1, 2};
        
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 2; j++)
               System.out.print(result[i][j]);
           System.out.println();
        }
	}

	private static void numberPalindrome() {
		int n = 12321;
		int p = n, m = 0;

		while (n > 0) {
			int r = n % 10;
			n /= 10;
			m = 10 * m + r;
		}

		System.out.println(m == p);
	}

}

package google;

public class GuessNumberHighOrLow {

	public static void main(String[] args) {
		int n = 20;
		int result = getMoneyCount(n);
		System.out.println(result);
	}

	// INCORRECT
	private static int getMoneyCount(int n) {

		int result = 0;

		for(int i = 1, j = n; Math.abs(j - i) != 1;) {
			int slice = i + (j - i) / 2;
			result += slice;
			i = slice;
		}
		
		return result;
	}

}

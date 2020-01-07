package uber;

public class IsKPalindrome {

	public static void main(String[] args) {
		String str = "abracadabra";
		int k = 3;
		boolean result = isKPalindrome(str, k);
		System.out.println(result);
	}
	
	// Function to check if the given string is K-Palindrome or not
	public static boolean isKPalindrome(String X, int K) {
			// Y is reverse of X
		String Y = new StringBuilder(X).reverse().toString();

		int n = X.length();

		// lookup table to store solution of already computed sub-problems
		int[][] T = new int[n + 1][n + 1];

		// fill the lookup table T[][] in bottom-up manner
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= n; j++) {
				// if either string is empty, remove all characters from
				// other string
				if (i == 0 || j == 0) {
					T[i][j] = i + j;
				}

				// ignore last characters of both strings if they are same
				// and process remaining characters
				else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
					T[i][j] = T[i - 1][j - 1];
				}

				// if last character of both strings is different, consider
				// minimum by removing last character from the X and Y
				else {
					T[i][j] = 1 + Integer.min(T[i - 1][j], T[i][j - 1]);
				}
			}
		}

		return (T[n][n] <= 2 * K);
		}
}

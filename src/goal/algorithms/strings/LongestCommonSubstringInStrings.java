package goal.algorithms.strings;


public class LongestCommonSubstringInStrings {

	public static void main(String[] args) {
		String s1 = "a";
		String s2 = "world";

		String result = commonSubstringPresent(s1, s2);
		System.out.println("Common substring: " + result);
	}

	private static String commonSubstringPresent(String s1, String s2) {
		// THIS IS A DYANMIC PROGRAMMING PROBLEM.

		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int l1 = c1.length;
		int l2 = c2.length;

		int maxLength = Integer.MIN_VALUE;
		int maxI = 0;

		int[][] T = new int[l1 + 1][l2 + 1];

		for (int i = 0; i < (l1 + 1); i++) {
			T[i][0] = 0;
		}

		for (int j = 0; j < (l2 + 1); j++) {
			T[0][j] = 0;
		}

		for (int i = 1; i < l1 + 1; i++) {
			for (int j = 1; j < l2 + 1; j++) {
				if (c1[i - 1] == c2[j - 1]) {
					T[i][j] = T[i - 1][j - 1] + 1;
				} else {
					T[i][j] = 0;
				}

				if (T[i][j] > maxLength) {
					maxLength = T[i][j];
					maxI = i;
				}
			}
		}

		// for (int i = 0; i < l1 + 1; i++) {
		// for (int j = 0; j < l2 + 1; j++) {
		// System.out.print(T[i][j] + " ");
		// }
		// System.out.println();
		// }
		//
		// System.out.println(maxLength + ", " + maxI + ", " + maxJ);

		// for (int i = maxI; i > 0; i--) {
		// System.out.print(c1[i]);
		// }

		char[] result = new char[maxLength];

		for (int i = (maxI - maxLength), j = 0; i < maxI; i++, j++) {
			result[j] = c1[i];
		}
		
		return (maxLength >0) ? String.valueOf(result) : null;
	}

}

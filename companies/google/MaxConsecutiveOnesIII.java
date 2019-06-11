package google;

public class MaxConsecutiveOnesIII {

	public static void main(String[] args) {
		int[] a = { 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1 };
		int k = 3;
		int result = longestOnes(a, k);
		System.out.println(result);
	}

	private static int longestOnes(int[] a, int k) {
		int i = 0, n = 0, result = 0;
		
		for(int j = 0; j < a.length; j++) {
			if(a[j] == 0) n++;
			while(n > k) {
				if(a[i] == 0) n--;
				i++;
			}
			result = Math.max(result, j - i + 1);
		}
		return result;
	}

}

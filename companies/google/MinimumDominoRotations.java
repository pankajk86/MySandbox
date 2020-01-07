package google;

public class MinimumDominoRotations {

	public static void main(String[] args) {
		int[] a = { 2, 3, 2, 1, 1, 1, 2, 2 };
		int[] b = { 2, 1, 2, 1, 1, 3, 1, 1 };
		
		int result = minimumRotation(a, b);
		System.out.println(result);
	}

	private static int minimumRotation(int[] a, int[] b) {
		if(a == null || a.length == 0 || b == null || b.length == 0 || a.length != b.length)
			return -1;
		
		int[] count1 = new int[7], count2 = new int[7], same = new int[7];
		int n = a.length;
		
		for(int i = 0; i < n; i++) {
			count1[a[i]]++; count2[b[i]]++;
			if(a[i] == b[i]) same[a[i]]++;
		}
		
		for(int i = 1; i < 7; i++) {
			if(count1[i] + count2[i] - same[i] == n)
				return n - Math.max(count1[i], count2[i]);
		}
		
		return -1;
	}

}

package google;

public class MaxChunksToMakeSorted {

	public static void main(String[] args) {
		int[] a = {0, 2, 1, 4, 3, 5, 7, 6};
		int result = maxChunks(a);
		System.out.println(result);
	}

	private static int maxChunks(int[] a) {
		if(a == null || a.length == 0) return 0;
		
		int result = 0, max = 0;
		for(int i = 0; i < a.length; i++) {
			max = Math.max(max, a[i]);
			if(max == i)
				result++;
		}
		return result;
	}

}

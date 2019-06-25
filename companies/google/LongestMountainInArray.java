package google;

public class LongestMountainInArray {

	public static void main(String[] args) {
		int[] a = { 2, 3, 3, 2, 0, 2 };
		int result = longestMountain(a);
		System.out.println(result);
	}

	private static int longestMountain(int[] a) {
		int result = 0, up = 0, down = 0;
		
		for(int i = 1; i < a.length; i++) {
			if(down > 0 && a[i - 1] < a[i] || a[i - 1] == a[i])
				up = down = 0;
			if(a[i - 1] < a[i]) up++;
			if(a[i - 1] > a[i]) down++;
			if(up > 0 && down > 0)
				result = Math.max(result, up + down + 1);
		}
		
		return result;
	}
}

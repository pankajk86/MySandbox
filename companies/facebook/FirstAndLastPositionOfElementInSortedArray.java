package facebook;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		int[] a = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		
		int[] result = searchRange(a, target);
		System.out.println(result[0] + ", " + result[1]);
	}

	private static int[] searchRange(int[] a, int target) {
		if(a == null || a.length == 0) return new int[] {-1, -1};
		
		int index = Arrays.binarySearch(a, target);
		if(index < 0) return new int[] {-1, -1};
		
		int low, high;
		for(low = index - 1; low >= 0 && a[low] == target; low--) {}
		for(high = index + 1; high < a.length && a[high] == target; high++) {}
		
		low++; high--;
		return new int[] {low, high};
	}

}

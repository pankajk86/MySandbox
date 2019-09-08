package facebook;

import java.util.Arrays;

public class FirstAndLastPositionOfElementInSortedArray {

	public static void main(String[] args) {
		int[] a = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		
		int[] result = searchRange(a, target);
		System.out.println(result[0] + ", " + result[1]);
		
		result = searchRange2(a, target);
		System.out.println(result[0] + ", " + result[1]);
	}
	
	private static int[] searchRange2(int[] a, int target) {
		if(a == null || a.length == 0) return new int[] {-1, -1};
		return new int[] {findLeft(a, target), findRight(a, target)};
	}

	private static int findLeft(int[] a, int target) {
		int index = -1, left = 0, right = a.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(a[mid] >= target) right = mid - 1;
			else left = mid + 1;
			if(a[mid] == target) index = mid; 
		}
		return index;
	}

	private static int findRight(int[] a, int target) {
		int index = -1, left = 0, right = a.length - 1;
		while(left <= right) {
			int mid = (left + right) / 2;
			if(a[mid] <= target) left = mid + 1;
			else right = mid - 1;
			if(a[mid] == target) index = mid; 
		}
		return index;
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

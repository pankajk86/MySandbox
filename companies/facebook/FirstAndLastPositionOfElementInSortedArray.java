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
		int left = find(a, target, true);
		int right = find(a, target, false);
		return new int[]{left, right};
	}

	private static int find(int[] a, int target, boolean leftBias) {
		int left = 0, right = a.length - 1;
		int index =-1;

		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (a[mid] < target) {
				left = mid + 1;
			} else if (a[mid] > target) {
				right = mid - 1;
			} else {
				index = mid;
				if (leftBias) right = mid - 1;
				else left = mid + 1;
			}
		}
		return index;
	}

}

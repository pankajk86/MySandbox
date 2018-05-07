package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		int[] a = { 12, 13, 23, 28, 43, 44, 59, 60, 61, 68, 70, 86, 88, 92, 124, 125, 136, 168, 173, 173, 180, 199, 212,
				221, 227, 230, 277, 282, 306, 314, 316, 321 }; // { 2, 7, 11, 15 };
		int target = 542; // 9
		int[] result = twoSum(a, target);
		System.out.println(result[0] + ", " + result[1]);
	}

	private static int[] twoSum(int[] a, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int start = -1, end = -1;

		for (int i = 0; i < a.length; i++) {
			if(!map.values().contains(a[i])) {
				map.put(a[i], target - a[i]);
			} else {
				end = i;
				break;
			}
		}

		for (int i = 0; i < end; i++) {
			if (a[i] == target - a[end]) {
				start = i;
				break;
			}
		}

		return new int[] { start + 1, end + 1 };
	}

}

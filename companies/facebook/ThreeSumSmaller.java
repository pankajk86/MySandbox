package facebook;

import java.util.Arrays;

public class ThreeSumSmaller {

	public static void main(String[] args) {
		int[] a = { -4, 2, 3, 8, 10 }; // { -2, 0, 1, 3 };
		int target = 15;
		int result = get3SumSmaller(a, target);
		System.out.println(result);
	}

	private static int get3SumSmaller(int[] a, int target) {

		int result = 0;
		Arrays.sort(a);

		for (int i = 0; i < a.length - 2; i++) {
			int left = i + 1, right = a.length - 1;

			while (left < right) {
				if (a[i] + a[left] + a[right] < target) {
					result += right - left;
					left++;
				} else
					right--;
			}
		}
		return result;
	}

}

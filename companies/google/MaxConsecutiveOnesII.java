package google;

import java.util.ArrayList;
import java.util.List;

public class MaxConsecutiveOnesII {

	public static void main(String[] args) {
		int[] a = { 1, 0, 1, 1, 0, 0, 1, 1, 1, 1 };
		int result = findMaxConsecutiveOnes(a);
		System.out.println(result);
	}

	private static int findMaxConsecutiveOnes(int[] a) {

		List<Integer> list = new ArrayList<>();
		int count = 0, result = 0;

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1)
				count++;
			else {
				list.add(count);
				if (count > 0)
					list.add(0);
				count = 0;
			}
		}

		if (count > 0)
			list.add(count);

		for (int i = 0; i < list.size(); i++) {
			int current = list.get(i);

			if (current == 0) {
				int temp = (i > 0 ? list.get(i - 1) : 0) + 1 + (i < list.size() - 1 ? list.get(i + 1) : 0);
				result = Math.max(result, temp);
			} else {
				result = Math.max(result, current);
			}
		}

		return result;
	}

}

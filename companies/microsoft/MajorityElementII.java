package microsoft;

import java.util.ArrayList;
import java.util.List;

public class MajorityElementII {

	public static void main(String[] args) {
		int[] a = { 8, 8, 7, 7, 7 }; // { 1, 1, 1, 3, 3, 2, 2, 2 };
		List<Integer> result = findMajority(a);
		System.out.println(result);
	}

	private static List<Integer> findMajority(int[] a) {
		int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;

		for (int i : a) {
			if (i == candidate1)
				count1++;
			else if (i == candidate2)
				count2++;
			else if (count1 == 0) {
				candidate1 = i;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = i;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		int freq1 = 0, freq2 = 0, n = a.length;

		for (int i : a) {
			if (i == candidate1) freq1++;
			else if (i == candidate2) freq2++;
		}

		List<Integer> result = new ArrayList<>();

		if (freq1 > (n / 3)) result.add(candidate1);
		if (freq2 > (n / 3)) result.add(candidate2);

		return result;
	}

}

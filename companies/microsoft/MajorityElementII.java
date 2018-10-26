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

		List<Integer> result = new ArrayList<>();
		int candidate1 = 0, candidate2 = 1, count1 = 0, count2 = 0;

		for (int n : a) {
			if (n == candidate1)
				count1++;
			else if (n == candidate2)
				count2++;
			else if (count1 == 0) {
				candidate1 = n;
				count1 = 1;
			} else if (count2 == 0) {
				candidate2 = n;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		count1 = 0;
		count2 = 0;

		for (int n : a) {
			if (n == candidate1)
				count1 += 2;
			else
				count1--;
			if (n == candidate2)
				count2 += 2;
			else
				count2--;
		}

		if (count1 > 0)
			result.add(candidate1);
		if (count2 > 0)
			result.add(candidate2);

		return result;
	}

}

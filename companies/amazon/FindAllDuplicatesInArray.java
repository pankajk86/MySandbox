package amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> result = findDuplicates(a);
		System.out.println(result);
	}

	private static List<Integer> findDuplicates(int[] a) {
		List<Integer> result = new ArrayList<>();

		for (int curr : a) {
			int index = Math.abs(curr) - 1;
			if (a[index] < 0) result.add(Math.abs(curr));
			else a[index] = -a[index];
		}
		
		return result;
	}

}

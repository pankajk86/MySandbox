package goal9498.array;

import java.util.ArrayList;
import java.util.List;

public class AllDisappearedNumbersInArray {

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> list = getMissingNumbers(a);
		
		for(Integer i: list) {
			System.out.println(i);
		}
	}

	private static List<Integer> getMissingNumbers(int[] nums) {
		List<Integer> list = new ArrayList<>();

		for (int i = 0; i < nums.length; i++) {
			int index = Math.abs(nums[i]) - 1;
			if (nums[index] > 0) {
				nums[index] = -nums[index];
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0) {
				list.add(i + 1);
			}
		}

		return list;
	}

}

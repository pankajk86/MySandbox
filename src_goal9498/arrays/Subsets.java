package arrays;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 32, 50, 70, 100, 500, 3000, 1000000 };
		
		long start = System.currentTimeMillis();
		List<List<Integer>> result = subsets(nums);
		System.out.println(result.size());
		System.out.println(System.currentTimeMillis() - start);

		start = System.currentTimeMillis();
		result = subsetsBM(nums);
		System.out.println(result.size());
		System.out.println(System.currentTimeMillis() - start);
	}

	private static List<List<Integer>> subsetsBM(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();

		if(nums.length == 0)
				return result;

		int max = (1 << nums.length) - 1;
		while(max >= 0) {
			result.add(generate(nums, max--));
		}

		return result;
	}

	private static List<Integer> generate(int[] nums, int num) {

		List<Integer> list = new ArrayList<>();

		for(int i = 0; num > 0; i++) {
			if((num & 1) == 1) {
				list.add(nums[i]);
			}
			num = num >> 1;
		}

		return list;
	}

	private static List<List<Integer>> subsets(int[] nums) {

		List<List<Integer>> result = new ArrayList<>();
		helper(result, new ArrayList<>(), nums, 0);
		return result;
	}

	private static void helper(List<List<Integer>> result, List<Integer> list, int[] nums, int start) {
		
		result.add(new ArrayList<>(list));

		for (int i = start; i < nums.length; i++) {
			if(list.contains(nums[i]))
				continue;
			
			list.add(nums[i]);
			helper(result, list, nums, i);
			list.remove(list.size() - 1);
		}
	}

}

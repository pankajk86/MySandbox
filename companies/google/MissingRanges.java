package google;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

	public static void main(String[] args) {
		int[] nums = {-2147483648, -2147483648, 0, 2147483647, 2147483647};
		int lower = -2147483648, upper = 2147483647;
		List<String> result = getMissingRanges(nums, lower, upper);
		
		for(String s: result) {
			System.out.print(s + ", ");
		}
	}

	private static List<String> getMissingRanges(int[] nums, int lower, int upper) {

		List<String> result = new ArrayList<>();

		if(nums.length == 0) {
			result.add(getRange(lower, upper));
			return result;
		}
		
		if(nums[0] > lower) {
			result.add(getRange(lower, nums[0] - 1));
		}
		
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] != nums[i + 1] && nums[i] + 1 != nums[i + 1]) {
				String range = getRange(nums[i] + 1, nums[i + 1] - 1); 
				if(range != null)
					result.add(range);
			}
		}

		if(nums[nums.length - 1] < upper) {
			result.add(getRange(nums[nums.length - 1] + 1, upper));
		}
		
		
		return result;
	}

	private static String getRange(int start, int end) {
		
		if(start > end)
			return null;
		
		if(start == end) {
			return String.valueOf(start);
		} else {
			StringBuilder sb = new StringBuilder();
			sb.append(start).append("->").append(end);
			return sb.toString();
		}
	}

}

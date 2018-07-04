package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumTrianglePathSum {

	public static void main(String[] args) {
		List<List<Integer>> list = new ArrayList<>();

		List<Integer> list1 = Arrays.asList(2);
		List<Integer> list2 = Arrays.asList(10, 13);
		List<Integer> list3 = Arrays.asList(6, 10, 2);
		List<Integer> list4 = Arrays.asList(4, 9, 8, 3);
		
		list.add(list1);
		list.add(list2);
		list.add(list3);
		list.add(list4);
		
		int result  = minimumTotal(list);
		System.out.println(result);
	}

	private static int minimumTotal(List<List<Integer>> list) {

		int size = list.size();
		int[] dp = new int[size + 1];
		
		for(int i = size - 1; i >=0; i--) {
			for(int j = 0; j < list.get(i).size(); j++) {
				dp[j] = Math.min(dp[j], dp[j+1]) + list.get(i).get(j);
			}
		}
		
		return dp[0];
		
	}


}



package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OptimalAccountBalancing {

	public static void main(String[] args) {
		int[][] a = {
			{0, 1, 10},
			{2, 0, 5}
		};
		
		int result = minTransfers(a);
		System.out.println(result);
	}

	private static int minTransfers(int[][] a) {
		if(a == null || a.length == 0) return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int[] t: a) {
			map.put(t[0], map.getOrDefault(t[0], 0) - t[2]); // t[0] is owed t[2] amount of money
			map.put(t[1], map.getOrDefault(t[1], 0) + t[2]); // t[1] owes t[2] amount of money
		}
		
		return settle(0, new ArrayList<>(map.values()));
	}

	private static int settle(int start, List<Integer> debt) {
		while(start < debt.size() && debt.get(start) == 0)
			start++;
		
		if(start == debt.size()) return 0;
		int result = Integer.MAX_VALUE;
		
		// for "start", we try to minimize the debt from start + 1 till end.
		for(int i = start + 1; i < debt.size(); i++) {
			if(debt.get(i) * debt.get(start) < 0) {
				debt.set(i, debt.get(i) + debt.get(start));
				result = Math.min(result, 1 + settle(start + 1, debt));
				debt.set(i, debt.get(i) - debt.get(start));
			}
		}
		return result;
	}

}

package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindTheTownJudge {

	public static void main(String[] args) {
//		int n = 4;
//		int[][] trust = { { 1, 3 }, { 1, 4 }, { 2, 3 }, { 2, 4 }, { 4, 3 } };
		
		int n = 3;
		int[][] trust = { { 1, 3 }, { 2, 3 } };
		
		int result = findJudge(n, trust);
		System.out.println(result);
	}

	private static int findJudge(int n, int[][] trust) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		for(int[] t: trust) {
			List<Integer> list = map.getOrDefault(t[1], new ArrayList<>());
			list.add(t[0]);
			map.put(t[1], list);
		}
		
		Map.Entry<Integer, List<Integer>> pair = null;
		int count = 0;
		
		for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
			if(entry.getValue().size() == n - 1) {
				pair = entry;
				count++;
				
				if(count > 1) return -1;
			}
		}
		
		if(pair != null) {
			for(Map.Entry<Integer, List<Integer>> entry: map.entrySet()) {
				if(entry.getValue().contains(pair.getKey())) return -1;
			}
			return pair.getKey();
		} else return -1;
	}

}

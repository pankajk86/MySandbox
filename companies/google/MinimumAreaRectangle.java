package google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MinimumAreaRectangle {

	public static void main(String[] args) {
		int[][] points = { { 1, 1 }, { 1, 3 }, { 3, 1 }, { 3, 3 }, { 2, 2 } };
		int result = getMinAreaRectangle(points);
		System.out.println(result);
	}

	private static int getMinAreaRectangle(int[][] points) {

		int result = Integer.MAX_VALUE;
		Map<Integer, Set<Integer>> map = new HashMap<>();

		
		for(int[] p: points) {
			Set<Integer> set = map.getOrDefault(p[0], new HashSet<>());
			set.add(p[1]); 
			map.put(p[0], set);
		}
		
		for(int[] p1: points) {
			for(int[] p2: points) {
				if(p1[0] == p2[0] || p1[1] == p2[1])
					continue;
				if(map.get(p1[0]).contains(p2[1]) && map.get(p2[0]).contains(p1[1])) {
					int temp = Math.abs((p1[0] - p2[0]) * (p1[1] - p2[1]));
					result = Math.min(result, temp);
				}
			}
		}
		
		return result == Integer.MAX_VALUE ? 0 : result;
	}

}

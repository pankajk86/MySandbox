package google;

import java.util.HashMap;
import java.util.Map;

public class MostStonesRemoved {

	private static int count = 0;

	public static void main(String[] args) {
		int[][] stones = { {0, 0}, {0, 1}, {1, 0}, {1, 2}, {2, 1}, {2, 2} };
		int result = mostStonesRemoved(stones);
		System.out.println(result);
	}

	private static int mostStonesRemoved(int[][] stones) {
		Map<String, String> map = new HashMap<>();
		count = stones.length;
		
		for(int[] stone: stones) {
			String s = stone[0] + " " + stone[1];
			map.put(s, s);
		}
		
		for(int[] s1: stones) {
			String ss1 = s1[0] + " " + s1[1];
			for(int[] s2: stones) {
				if(s1[0] == s2[0] || s1[1] == s2[1]) {
					String ss2 = s2[0] + " " + s2[1];
					union(map, ss1, ss2);
				}
			}
		}
		return stones.length - count;
	}

	private static void union(Map<String, String> map, String ss1, String ss2) {
		String r1 = find(map, ss1), r2 = find(map, ss2);
		if(!r1.equals(r2)) {
			map.put(r1, r2);
			count--;
		}
	}

	private static String find(Map<String, String> map, String s) {
		if(!map.get(s).equals(s))
			map.put(s, find(map, map.get(s)));
		
		return map.get(s);
	}
}

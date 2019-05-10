package google;

import java.util.HashSet;

public class MinGeneticMutation {

	private static int count = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		String start = "AACCGGTT", end = "AAACGGTA";
		String[] bank = { "AACCGGTA", "AACCGCTA", "AAACGGTA" };
		
		int result = minMutation(start, end, bank);
		System.out.println(result);
	}

	private static int minMutation(String start, String end, String[] bank) {
		dfs(start, end, bank, 0, new HashSet<String>());
		return count == Integer.MAX_VALUE ? -1 : count;
	}

	private static void dfs(String s, String e, String[] bank, int soFar, HashSet<String> visited) {
		if(s.equals(e))
			count = Math.min(count, soFar);
		
		for(String ss: bank) {
			int diff = 0;
			for(int i = 0; i < ss.length(); i++) {
				if(s.charAt(i) != ss.charAt(i)) {
					diff++;
					if(diff > 1) break;
				}
			}
			
			if(diff == 1 && !visited.contains(ss)) {
				visited.add(ss);
				dfs(ss, e, bank, soFar + 1, visited);
				visited.remove(ss);
			}
		}
	}

}

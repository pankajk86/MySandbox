package amazon;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> result = partitionLabels(s);
		System.out.println(result);
	}

	private static List<Integer> partitionLabels(String s) {

		if(s == null || s.length() == 0) return null;
		
		List<Integer> result = new ArrayList<>();
		int[] map = new int[26];
		
		for(int i = 0; i < s.length(); i++)
			map[s.charAt(i) - 'a'] = i;
		
		int start = 0, last = 0;
		
		for(int i = 0; i < s.length(); i++) {
			last = Math.max(last, map[s.charAt(i) - 'a']);
			if(last == i) {
				result.add(last - start + 1);
				start = last + 1;
			}
		}
		
		return result;
	}

}

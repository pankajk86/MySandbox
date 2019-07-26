package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KLengthSubstringsNoRepeatChars {

	public static void main(String[] args) {
		String s = "havefunonleetcode";
		int k = 5;
		
		int result = numKLenSubstrNoRepeats(s, k);
		System.out.println(result);
	}

	private static int numKLenSubstrNoRepeats(String s, int k) {
		if(s == null || s.isEmpty() || k > s.length()) return 0;
		
		StringBuilder sb = new StringBuilder();
		Map<Character, List<Integer>> map = new HashMap<>();
		int result = 0;
		
		for(int i = 0; i < k; i++) {
			char c = s.charAt(i);
			sb.append(c);
			List<Integer> list = map.getOrDefault(c, new ArrayList<>());
			list.add(i);
			map.put(c, list);
		}
		
		if(map.size() == k) result++;
		
		for(int i = k; i < s.length(); i++) {
			char c = sb.charAt(0), newC = s.charAt(i);
			List<Integer> list = map.get(c);
			
			sb.deleteCharAt(0);
			list.remove(0);
			if(list.size() == 0) map.remove(c);
			
			sb.append(newC);
			List<Integer> newList = map.getOrDefault(newC, new ArrayList<>());
			newList.add(i);
			map.put(newC, newList);
			
			if(map.size() == k) result++;
		}
		
		return result;
	}

}

package goal.arrays;

import java.util.HashMap;
import java.util.Map;

public class FindSubstring {

	public static void main(String[] args) {
		String s = "abcdefcdfg", t = "cdf";
		int index = findSubstring(s, t);
		System.out.println(index);
	}

	private static int findSubstring(String s, String t) {
		Map<Character, Integer> map = new HashMap<>();
		for(char c: t.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
		int count = map.size();
		
		for(int i = 0, j = 0; j < s.length(); j++) {
			char r = s.charAt(j);
			if(map.containsKey(r)) {
				map.put(r, map.get(r) - 1);
				if(map.get(r) == 0) count--;
				
				if(count == 0) {
					if(j - i == t.length()) return i;
					else {
						while(i < j) {
							char l = s.charAt(i);
							if(map.containsKey(l)) {
								map.put(l, map.get(l) + 1);
								if(map.size() > 0) count++;
							}
							i++;
						}
					}
				}
			} else {
				while(i < j) {
					char l = s.charAt(i);
					if(map.containsKey(l)) {
						map.put(l, map.get(l) + 1);
						if(map.size() > 0) count++;
					}
					i++;
				}
				i++;
			}
		}
		
		return -1;
	}

}

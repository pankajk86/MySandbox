package maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharacterByFrequency {

	public static void main(String[] args) {
		String s = "Aabb";
		String result = frequencySort(s);
		System.out.println(result);
	}

	private static String frequencySort(String s) {

		Map<Character, Integer> map1 = new HashMap<>();
		Map<Integer, List<Character>> map2 = new HashMap<>();
		int maxFreq = 0;
		StringBuilder sb = new StringBuilder();
		
		for(char c: s.toCharArray()) {
			if(!map1.containsKey(c)) {
				map1.put(c, 1);
			} else {
				map1.put(c, map1.get(c) + 1);
			}
		}
		
		for(Map.Entry<Character, Integer> entry: map1.entrySet()) {
			List<Character> list = null;
			int freq = entry.getValue();
			
			if(!map2.containsKey(freq)) {
				list = new ArrayList<>();
			} else {
				list = map2.get(freq);
			}
			list.add(entry.getKey());
			map2.put(freq, list);
			
			maxFreq = (freq > maxFreq) ? freq : maxFreq;
		}
		
		for(int i = maxFreq; i > 0; i--) {
			List<Character> list = map2.get(i);
			if(list != null) {
				for(char c: list) {
					for(int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}
		
		return sb.toString();
	}

}

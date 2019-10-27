package facebook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllAnagramsInString {

	public static void main(String[] args) {
		//String s = "eklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmoueklpyqrbgjdwtcaxzsnifvhmou", p = "yqrbg";
		String s = "acbaebabacd", p = "aabc";
		List<Integer> result = findAnagrams(s, p);
		System.out.println(result);
	}

	private static List<Integer> findAnagrams(String s, String p) {
		if(s == null || s.isEmpty() || p == null || p.isEmpty())
			return null;
		
		Map<Character, Integer> map = new HashMap<>();
		for(char c: p.toCharArray())
			map.put(c, map.getOrDefault(c, 0) + 1);
		
		int left = 0, count = map.size();
		List<Integer> result = new ArrayList<>();
		
		for(int right = 0; right < s.length(); right++) {
			char r = s.charAt(right);
			
			if(map.containsKey(r)) {
				map.put(r, map.get(r) - 1);
				if(map.get(r) == 0) count--;
			}
			
			while(count == 0) {
				char l = s.charAt(left);
				
				if(map.containsKey(l)) {
					map.put(l, map.getOrDefault(l, 0) + 1);
					if(map.get(l) > 0) count++;
				}
				
				if(right - left + 1 == p.length())
					result.add(left);
				
				left++;
			}
		}
		return result;
	}
}

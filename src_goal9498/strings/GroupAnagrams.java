package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

	public static void main(String[] args) {
		String[] s = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> result = groupAnagrams(s);
		
		for(List<String> group: result) {
			System.out.println(group);
		}
	}

	private static List<List<String>> groupAnagrams(String[] words) {

		List<List<String>> result = new ArrayList<>();
		Map<String, List<String>> map = new HashMap<>();
		
		for(String s: words) {
			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String temp = String.valueOf(arr);
			
			List<String> list = new ArrayList<>();
			
			if(map.containsKey(temp)) {
				list = map.get(temp);
			}
			
			list.add(s);
			map.put(temp, list);
		}
		
		for(List<String> group: map.values()) {
			result.add(group);
		}
		
		return result;
	}

}

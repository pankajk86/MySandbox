package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {

	public static void main(String[] args) {
		String[] s = {"abc", "bcd", "acef", "xyz", "azc", "bad", "a", "z"};
		List<List<String>> result = groupStrings(s);
		
		for(List<String> list: result) {
			for(String ss: list)
				System.out.print(ss + ", ");
			System.out.println();
		}
	}

	private static List<List<String>> groupStrings(String[] strings) {

		Map<String, List<String>> map = new HashMap<>();
		List<List<String>> result = new ArrayList<>();

		for(String s: strings) {
			List<Integer> temp = new ArrayList<>();
			
			if(s.length() > 1) {
				for(int i = 0; i < s.length() - 1; i++) {
					char current = s.charAt(i), next = s.charAt(i + 1);
					if(current <= next) {
						temp.add(next - current);
					} else {
						int part1 = 'z' - current;
						int part2 = next - 'a' + 1;
						temp.add(part1 + part2);
					}
				}
			}
			addToMap(map, temp, s);
		}
		
		for(List<String> group: map.values()) {
			result.add(group);
		}
		
		return result;
	}
	
	private static void addToMap(Map<String, List<String>> map, List<Integer> temp, String s) {
		String key = encode(temp);
		List<String> list = null;

		if(!map.containsKey(key)) {
			list = new ArrayList<>();
		} else {
			list = map.get(key);
		}
		
		list.add(s);
		map.put(key, list);
	}

	private static String encode(List<Integer> temp) {

		StringBuilder key = new StringBuilder();
		
		for(Integer i: temp) {
			key.append(i).append('-');
		}
		
		return key.length() > 0 ? key.substring(0, key.length() - 1) : "single";
	}

}

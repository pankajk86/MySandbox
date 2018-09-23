package linkedin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RepeatedDNASequences {

	public static void main(String[] args) {
		String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
		List<String> result = findRepeatedSequences(s);
		System.out.println(result);
	}

	private static List<String> findRepeatedSequences(String s) {
		List<String> result = new ArrayList<>();
		
		if(s == null || s.isEmpty()) return result;
		
		String temp = "";
		Map<String, Integer> map = new HashMap<>();
		
		for(int i = 0; i <= s.length() - 10; i++) {
			if(i == 0) {
				temp = s.substring(0, 10);
				map.put(temp, 1);
			} else {
				temp = s.substring(i, i + 10);
				map.put(temp, map.getOrDefault(temp, 0) + 1);
			}
		}
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			if(entry.getValue() > 1)
				result.add(entry.getKey());
		}
		
		return result;
	}

}

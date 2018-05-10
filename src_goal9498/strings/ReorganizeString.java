package strings;

import java.util.HashMap;
import java.util.Map;

public class ReorganizeString {

	public static void main(String[] args) {
		String s = "aab";
		String result = reorganizeString(s);
		System.out.println(result);
	}

	private static String reorganizeString(String s) {

		Map<Character, Integer> map = new HashMap<>();
		String result = null;
		
		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		int maxFreq = -1;
		char maxFreqChar = '\0';
		
		for(Map.Entry<Character, Integer> entry: map.entrySet()) {
			if(entry.getValue() > maxFreq) {
				maxFreqChar = entry.getKey();
				maxFreq = entry.getValue();
			}
		}
		
		int totalOthers = s.length() - maxFreq;
		
		if(maxFreq - totalOthers >= 2) {
			result = "";
		} else {
			result = generateString(s, map, maxFreqChar);
		}
		
		return result;
	}

	private static String generateString(String s, Map<Character, Integer> map, char maxFreqChar) {
		
		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();
		
		for(char c: s.toCharArray()) {
			if(c != maxFreqChar) {
				temp.append(c);
			}
		}
		
		for(int i=0; i < temp.length(); i++) {
			sb.append(maxFreqChar);
			sb.append(temp.charAt(i));
		}
		
		sb.append(maxFreqChar);
		return sb.toString();
	}

}

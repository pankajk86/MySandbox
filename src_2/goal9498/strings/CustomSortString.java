package goal9498.strings;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {

	public static void main(String[] args) {
		String s = "kqep";
		String t = "pekeq";
		
		String result = getCustomSortString(s, t);
		System.out.println(result);
	}

	private static String getCustomSortString(String s, String t) {

		Map<Character, Integer> map = new HashMap<>();
		StringBuilder sb1 = new StringBuilder();
		StringBuilder sb2 = new StringBuilder();
		
		for(char c: t.toCharArray()) {
			if(map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		
		for(char c: s.toCharArray()) {
			if(map.containsKey(c)) {
				for(int i=0; i< map.get(c); i++) {
					sb1.append(c);
				}
			}
		}
		
		for(char c: t.toCharArray()) {
			if(s.indexOf(c) == -1) {
				sb1.append(c);
			}
		}
		
		return sb2.append(sb1).toString();
	}

}

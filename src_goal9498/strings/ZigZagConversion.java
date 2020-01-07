package strings;

import java.util.HashMap;
import java.util.Map;

public class ZigZagConversion {

	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int rows = 4;
		String result = convert(s, rows);
		System.out.println(result);
	}

	private static String convert(String s, int n) {
		if(s == null || s.isEmpty()) return s;
		Map<Integer, StringBuilder> map = new HashMap<>();
		int pos = 0;
		boolean incr = true;
		
		for(char c: s.toCharArray()) {
			if(pos == n) incr = false;
			if(pos == 1) incr = true;
			pos = incr ? pos + 1 : pos - 1;
			
			StringBuilder sb = map.getOrDefault(pos, new StringBuilder());
			sb.append(c);
			map.put(pos, sb);
		}
		
		StringBuilder result = new StringBuilder();
		for(StringBuilder sb: map.values()) result.append(sb);
		
		return result.toString();
	}
}

package facebook;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public static void main(String[] args) {
		String roman = "MCMXCIVI";
		int result = convert(roman);
		System.out.println(result);
	}

	private static int convert(String roman) {

		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1); map.put('V', 5); map.put('X', 10);
		map.put('L', 50); map.put('C', 100); map.put('D', 500);
		map.put('M', 1000);
		
		int result = 0, size = roman.length();
		
		for(int i = 0; i < size; i++) {
			if(roman.charAt(i) == 'I') {
				if(i < size - 1 && (roman.charAt(i + 1) == 'V' || roman.charAt(i + 1) == 'X')) {
					result += (map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i)));
					i++;
				} else {
					result += map.get(roman.charAt(i));
				}
			} else if(roman.charAt(i) == 'X') {
				if(i < size - 1 && (roman.charAt(i + 1) == 'L' || roman.charAt(i + 1) == 'C')) {
					result += (map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i)));
					i++;
				} else {
					result += map.get(roman.charAt(i));
				}
			} else if(roman.charAt(i) == 'C') {
				if(i < size - 1 && (roman.charAt(i + 1) == 'D' || roman.charAt(i + 1) == 'M')) {
					result += (map.get(roman.charAt(i + 1)) - map.get(roman.charAt(i)));
					i++;
				} else {
					result += map.get(roman.charAt(i));
				}
			} else {
				result += map.get(roman.charAt(i));
			}
		}
		
		return result;
	}

}

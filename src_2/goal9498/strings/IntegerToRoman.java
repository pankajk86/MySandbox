package goal9498.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegerToRoman {

	public static void main(String[] args) {
		int num = 58;
		String roman = convertIntegerToRoman(num);
		System.out.println(roman);
	}

	private static String convertIntegerToRoman(int num) {

		Map<Integer, String> map = new HashMap<>();
		map.put(1, "I"); map.put(4, "IV"); map.put(5, "V"); map.put(9, "IX"); map.put(10, "X");
		map.put(40, "XL"); map.put(50, "L"); map.put(90, "XC"); map.put(100, "C");
		map.put(400, "CD"); map.put(500, "D"); map.put(900, "CM"); map.put(1000, "M");
		
		int[] keys = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		
		List<Integer> numParts = getNumParts(num);
		String[] romanParts = getRomanParts(numParts, map, keys);
		
		StringBuilder sb = new StringBuilder();
		
		for(String s: romanParts) {
			sb.append(s);
		}
		
		return sb.toString();
	}

	private static String[] getRomanParts(List<Integer> numParts, Map<Integer, String> map, int[] keys) {
		
		String[] romanParts = new String[numParts.size()];
		int i = 0;
		
		for(Integer num: numParts) {
			StringBuilder sb = new StringBuilder();
			
			while(num > 0) {
				int n = getMax(num, keys);
				sb.append(map.get(n));
				num -= n;
			}
			romanParts[i] = sb.toString();
			i++;
		}
		
		return romanParts;
	}

	private static int getMax(Integer num, int[] keys) {
		
		int i;
		
		for(i=0; i< keys.length; i++) {
			if(num < keys[i]) {
				break;
			}
		}
		
		return keys[i-1];
	}

	private static List<Integer> getNumParts(int num) {
		
		List<Integer> list = new ArrayList<>();
		int count = 1;
		
		while(num > 0) {
			int temp =  num % ((int) Math.pow(10, count));
			list.add(temp);
			num = num - temp;
			count++;
		}
		
		Collections.reverse(list);
		
		return list;
	}

}

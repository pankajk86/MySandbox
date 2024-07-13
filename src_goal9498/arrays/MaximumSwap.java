package arrays;

import java.util.HashMap;
import java.util.Map;

public class MaximumSwap {

	public static void main(String[] args) {

		int n = 999101;
		int max = maxSwap(n);
		System.out.println(max);
	}

	private static int maxSwap(int n) {
		String s = String.valueOf(n);
		char[] carr = s.toCharArray();

		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < carr.length; i++) {
			map.put(carr[i] - '0', i);
		}

		for (int i = 0; i < carr.length; i++) {
			int temp = carr[i] - '0';
			int index = getLargest(map, temp, i);
			
			if(index != -1 && index > i) {
				char t = carr[index];
				carr[index] = carr[i];
				carr[i] = t;
				break;
			}
		}
		
		return Integer.parseInt(String.valueOf(carr));
	}

	private static int getLargest(Map<Integer, Integer> map, int temp, int loc) {

		for(int i=9; i>=0; i--) {
			if(map.containsKey(i) && i > temp && loc < map.get(i)) {
				return map.get(i);
			}
		}
		
		return -1;
	}

}

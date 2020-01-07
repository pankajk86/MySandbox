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


	@SuppressWarnings("unused")
	private static int maxSwap2(int n) {

		String s = String.valueOf(n);
		int[] a = new int[s.length()];

		int i = 0;

		for (char c : s.toCharArray()) {
			a[i] = Integer.parseInt(String.valueOf(c));
			i++;
		}

		int max = Integer.MIN_VALUE, maxIndex = 0;
		int min = Integer.MAX_VALUE, minIndex = 0;

		for (i = 1; i < a.length; i++) {
			if (a[i] >= max) {
				max = a[i];
				maxIndex = i;
			}
		}

		for (i = 0; i < maxIndex; i++) {
			if (a[i] < max) {
				min = a[i];
				minIndex = i;
				break;
			}
		}

		if (min < max) {
			int temp = a[maxIndex];
			a[maxIndex] = a[minIndex];
			a[minIndex] = temp;

			int result = 0, j = 0;
			i = 0;

			for (i = a.length - 1, j = 0; i >= 0; i--, j++) {
				result += a[i] * (int) Math.pow(10, j);
			}
			return result;
		} else {
			return n;
		}

	}

}

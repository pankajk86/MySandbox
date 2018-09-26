package arrays;

import java.util.HashMap;
import java.util.Map;

public class RabbitsInForest {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0, 2, 0, 1, 0, 2, 1, 1 };
		int count = numRabbits(a);
		System.out.println(count);
	}

	private static int numRabbits(int[] a) {

		int sum = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i : a) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			int key = entry.getKey();
			int value = entry.getValue();

			if (key + 1 < value) {
				sum += key;
			} else if (key > value) {
				sum += key + 1 - value;
			}
		}

		return sum + a.length;
	}

}

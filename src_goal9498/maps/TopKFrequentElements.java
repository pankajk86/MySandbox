package maps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {

	public static void main(String[] args) {

		// 1 = 4, 2 = 3, 3 = 6, 4 = 2, 5 = 3
		int[] a = { -5, -9, 67, -10, 4, -57, 47, 13, -67, -26, -57, 63, 38, -68, 62, -45, -37, 95, 49, -91, -53, -42,
				-33, 80, 78, -30, -36, 22, 9, -86, 79, -1, 44, -92, 30, -68, -94, 58, -51, -26, -38, 5, -74, 25, 71,
				-93, 52, -12, -86, 7, -86, 53, 78, -31, -5, -87, 88, -98, -39, 9, 99, 23, 96, -90, 51, -64, 35, -73, 9,
				60, -78, 70, 99, 14, 70, 71 };
		int k = 7;

		int[] result = topKFrequent(a, k);
		for (int i : result) {
			System.out.print(i + ", ");
		}
	}

	private static int[] topKFrequent(int[] a, int k) {
		int n = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) map.put(i, map.getOrDefault(i, 0) + 1);

		List<Integer>[] buckets = new ArrayList[n + 1];
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			int elem = e.getKey(), freq = e.getValue();
			if (buckets[freq] == null) buckets[freq] = new ArrayList<>();
			buckets[freq].add(elem);
		}

		int[] result = new int[k];
		int index = 0;

		for (int freq = n; freq >= 0; freq--) {
			if (buckets[freq] != null) {
				for (int val : buckets[freq]) {
					result[index++] = val;
					if (index == k) return result;
				}
			}
		}
		return result;

	}

}

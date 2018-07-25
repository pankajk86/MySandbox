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

		List<Integer> result = topKFrequent2(a, k);
		for (int i : result) {
			System.out.print(i + ", ");
		}
	}

	@SuppressWarnings("unused")
	private static List<Integer> topKFrequent(int[] a, int k) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		Map<Integer, List<Integer>> map2 = new HashMap<>();

		int maxFreq = 0;

		for (int i : a) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			List<Integer> list = null;
			if (!map2.containsKey(entry.getValue())) {
				list = new ArrayList<>();
			} else {
				list = map2.get(entry.getValue());
			}
			list.add(entry.getKey());
			map2.put(entry.getValue(), list);

			maxFreq = maxFreq < entry.getValue() ? entry.getValue() : maxFreq;
		}

		while (maxFreq > 0) {
			List<Integer> list = map2.get(maxFreq);

			if (list != null) {
				if (list.size() >= k) {
					for (int i = 0; i < k; i++) {
						result.add(list.get(i));
					}
					return result;
				} else {
					result.addAll(list);
					k -= list.size();
					maxFreq--;
				}
			} else {
				maxFreq--;
			}
		}

		return result;
	}

	private static List<Integer> topKFrequent2(int[] a, int k) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		PriorityQueue<Element> pq = new PriorityQueue<>(new ElementComparator());

		for (int i : a) {
			if (!map.containsKey(i)) {
				map.put(i, 1);
			} else {
				map.put(i, map.get(i) + 1);
			}
		}

		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			Element e = new Element(entry.getKey(), entry.getValue());
			if (pq.size() == k) {
				if (pq.peek().freq <= entry.getValue()) {
					pq.poll();
					pq.add(e);
				}
			} else {
				pq.add(e);
			}
		}

		Element e = null;

		while ((e = pq.poll()) != null) {
			result.add(e.value);
		}

		return result;
	}

}

class ElementComparator implements Comparator<Element> {

	@Override
	public int compare(Element e1, Element e2) {

		if (e1.freq < e2.freq) {
			return -1;
		} else if (e1.freq > e2.freq) {
			return 1;
		}
		return 0;
	}
}

class Element {
	int value;
	int freq;

	public Element(int value, int freq) {
		this.value = value;
		this.freq = freq;
	}
}

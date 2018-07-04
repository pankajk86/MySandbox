package maps;

import java.util.Map.Entry;
import java.util.TreeMap;

public class UnderstandingTreeMap {

	public static void main(String[] args) {
		TreeMap<Integer, String> map = new TreeMap<>();
		
		map.put(5, "abc");
		map.put(10, "def");
		map.put(3, "ghi");
		map.put(7, "jkl");
		map.put(1, "mno");
		map.put(6, "pqrs");
		map.put(9, "tuv");
		
		System.out.println(map);
		
		Entry<Integer, String> entry = map.floorEntry(8);
		System.out.println(entry.getKey() + ", " + entry.getValue());
		System.out.println("Floor(4): " + map.floorKey(4));
		System.out.println("Ceiling(5): " + map.ceilingKey(5));
		System.out.println("Higher(5): " + map.higherKey(5));
	}

}

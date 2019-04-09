package google;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DesignRangeModule {

	public static void main(String[] args) {
		test1();
		System.out.println("----");
		test2();
	}

	private static void test2() {
		
		//["addRange","removeRange","removeRange","addRange","removeRange","addRange","queryRange","queryRange","queryRange"]
		//[[6,8],      [7,8],       [8,9],        [8,9],      [1,3],       [1,8],     [2,4],       [2,9],        [4,6]]
		
		RangeModule rm = new RangeModule();
		
		rm.addRange(6, 8);
		rm.removeRange(7, 8);
		rm.removeRange(8, 9);
		rm.addRange(8, 9);
		rm.removeRange(1, 3);
		rm.addRange(1, 8);
		System.out.println(rm.queryRange(2, 4));
		System.out.println(rm.queryRange(2, 9));
		System.out.println(rm.queryRange(4, 6));
	}

	private static void test1() {
		RangeModule rm = new RangeModule();
		rm.addRange(10, 20);
		rm.removeRange(14, 16);
		System.out.println(rm.queryRange(10, 14));
		System.out.println(rm.queryRange(13, 15));
		System.out.println(rm.queryRange(16, 17));		
	}

}

class RangeModule {
	
	private TreeMap<Integer, Integer> map = null;
	
	public RangeModule() {
		map = new TreeMap<>();
	}

	public void addRange(int left, int right) {
		Map<Integer, Integer> tailMap = map.tailMap(left);
		List<Integer> toRemove = new ArrayList<>();
		
		for(Map.Entry<Integer, Integer> entry: tailMap.entrySet()) {
			if(entry.getKey() >= right) {
				if(entry.getKey() == right) {
					right = entry.getValue();
					toRemove.add(entry.getKey());
				}
				break;
			}
			if(entry.getKey() >= left && entry.getValue() <= right)
				toRemove.add(entry.getKey());
		}
		
		for(int key: toRemove)
			map.remove(key);
		
		Integer key = map.floorKey(left);
		
		if(key == null || map.get(key) < left)
			map.put(left, right);
		else map.put(key, Math.max(map.get(key), right));
	}

	public boolean queryRange(int left, int right) {
		Integer key = map.floorKey(left);
		return key != null && right <= map.get(key);
	}

	public void removeRange(int left, int right) {
		Integer key = map.floorKey(left);

		if(key != null) {
			Integer value = map.get(key);
			if(value < left) return;
			map.remove(key);
			
			if(key == left) {
				if(right < value)
					map.put(right, value);
			} else {
				map.put(key, left);
				if(right < value) {
					map.put(right, value);
				}
			}
		}
	}
}

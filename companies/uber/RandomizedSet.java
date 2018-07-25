package uber;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RandomizedSet {
	
	List<Integer> list;
	Map<Integer, Integer> map;
	
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public boolean insert(int val) {
		
		if(map.containsKey(val)) {
			return false;
		}
		
		list.add(val);
		map.put(val, list.size() - 1);
		return true;
	}
	
	public boolean remove(int val) {
		int index = map.getOrDefault(val, -1);
		if(index == -1) {
			return false;
		}
		
		Collections.swap(list, index, list.size() - 1);
		int swappedWith = list.get(index);
		map.put(swappedWith, index);
		
		list.remove(list.size() - 1);
		map.remove(val);
		return true;
	}

	public int getRandom() {
		int min = 0, max = list.size();
		int index = (int)(Math.random() * (max - min) + min);
		return list.get(index);
	}
	
	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		
		// insert
		set.insert(2);
		set.insert(4);
		set.insert(1);
		set.insert(5);
		set.insert(3);
		
		// getRandom
		System.out.println(set.getRandom());
		System.out.println(set.getRandom());
		
		// remove
		set.remove(5);
		
		// getRandom
		System.out.println(set.getRandom());
		
		// remove
		set.remove(1);
				
		// getRandom
		System.out.println(set.getRandom());
	}

}

package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class RandomizedSet {
	
	private List<Integer> list;
	private Map<Integer, Integer> map;
	private Random rand;
	
	public RandomizedSet() {
		list = new ArrayList<>();
		map = new HashMap<>();
		rand = new Random();
	}
	
	public boolean insert(int val) {
		if(map.containsKey(val)) return false;
		
		map.put(val, list.size());
		list.add(val);
		return true;
	}
	
	public boolean remove(int val) {
		Integer index = map.get(val);
		if(index == null) return false;
		
		int temp = list.get(list.size() - 1);
		list.set(index, temp);
		map.put(temp, index);
		map.remove(val);
		list.remove(list.size() - 1);
		
		return true;
	}

	public int getRandom() {
		return list.get(rand.nextInt(list.size()));
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

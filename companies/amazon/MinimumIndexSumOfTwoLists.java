package amazon;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MinimumIndexSumOfTwoLists {

	public static void main(String[] args) {
		String[] l1 = { "Shogun", "Tapioca Express", "Burger King", "KFC" };
		String[] l2 = { "Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun" };
		
		String[] result = findRestaurant(l1, l2);
		for(String s: result) System.out.print(s + " ");
	}

	private static String[] findRestaurant(String[] l1, String[] l2) {
		Map<String, Integer> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		
		// l1 is always the smaller list
		if(l1.length > l2.length) {
			String[] temp = l1;
			l1 = l2;
			l2 = temp;
		}
		
		for(int i = 0; i < l1.length; i++)
			map.put(l1[i], i);
		
		for(int i = 0; i < l2.length; i++) {
			if(map.containsKey(l2[i])) {
				set.add(l2[i]);
				map.put(l2[i], map.get(l2[i]) + i);
			}
		}
		
		int minIndex = Integer.MAX_VALUE;
		List<String> list = new ArrayList<>();
		
		for(Map.Entry<String, Integer> entry: map.entrySet()) {
			String key = entry.getKey();
			int index = entry.getValue();
			
			if(set.contains(key)) {
				if(index < minIndex) {
					minIndex = index;
					list = new ArrayList<>();
					list.add(key);
				} else if(index == minIndex) {
					list.add(key);
				}
			}
		}
		
		return list.toArray(new String[list.size()]);
	}

}

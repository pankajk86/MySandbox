package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PowersetFrequency {

	public static void main(String[] args) {
		List<List<String>> baskets = createBasket();
		Map<Set<String>, Integer> result = getPowersetFrequency(baskets);
		System.out.println(result.size());
	}

	private static Map<Set<String>, Integer> getPowersetFrequency(List<List<String>> baskets) {
		
		Map<Set<String>, Integer> map = new HashMap<>();
		Set<String> items = new HashSet<>();
		
		for(List<String> basket: baskets) {
			items.addAll(basket);
		}
		
		Set<Set<String>> powerset = getPowerset(items);
		
		for(Set<String> pset: powerset) {
			if(!pset.isEmpty()) {
				int i = 0;
				for(List<String> basket: baskets) {
					if(basket.containsAll(pset)) {
						i++;
					}
				}
				if(i > 0)
					map.put(pset, i);
			}
		}
		
		return map;
	}
	
	private static Set<Set<String>> getPowerset(Set<String> items) {

		Set<Set<String>> result = new HashSet<>();
		
		if(items.isEmpty()) {
			result.add(new HashSet<>());
			return result;
		}
		
		List<String> list = new ArrayList<>(items);
		String head = list.get(0);
		Set<String> rest = new HashSet<>(list.subList(1, list.size()));
		
		for(Set<String> set: getPowerset(rest)) {
			Set<String> newSet = new HashSet<>();
			newSet.add(head);
			newSet.addAll(set);
			
			result.add(newSet);
			result.add(set);
		}
		
		return result;
	}

	private static List<List<String>> createBasket() {

		List<List<String>> baskets = new ArrayList<>();
		
		List<String> basket1 = new ArrayList<>();
		basket1.addAll(Arrays.asList("apple", "banana", "lemon"));
		
		List<String> basket2 = new ArrayList<>();
		basket2.addAll(Arrays.asList("banana", "berry", "lemon", "orange"));
		
		List<String> basket3 = new ArrayList<>();
		basket3.addAll(Arrays.asList("banana", "berry", "lemon"));
		
		baskets.addAll(Arrays.asList(basket1, basket2, basket3));
		return baskets;
	}

}

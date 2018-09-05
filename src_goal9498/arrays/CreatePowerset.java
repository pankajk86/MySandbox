package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreatePowerset {

	public static void main(String[] args) {
		Set<String> items = new HashSet<>();
		items.addAll(Arrays.asList("a", "b", "c", "d"));
		Set<Set<String>> result = getPowerset(items);
		
		for(Set<String> set: result) {
			for(String s: set) System.out.print(s + " ");
			System.out.println();
		}
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

}

package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReconstructItinerary {

	public static void main(String[] args) {
		String[][] tickets = {
				{"JFK","SFO"},{"JFK","ATL"},
				{"SFO","ATL"},
				{"ATL","JFK"},{"ATL","SFO"}
			};
		
		List<String> result = findItinerary(tickets);
		System.out.println(result);
	}

	private static List<String> findItinerary(String[][] tickets) {
		Map<String, List<String>> map = new HashMap<>();
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < tickets.length; i++) {
			List<String> list = map.getOrDefault(tickets[i][0], new ArrayList<>());
			list.add(tickets[i][1]);
			map.put(tickets[i][0], list);
		}
		
		for(List<String> list: map.values()) {
			if(list.size() > 1) {
				Collections.sort(list, new Comparator<String>() {
					@Override
					public int compare(String s1, String s2) {
						return s1.compareTo(s2);
					}
				});
			}
		}
		
		String current = "JFK";
		result.add(current);
		
		while(!map.isEmpty()) {
			List<String> des = map.get(current);
			if(des.size() > 0) {
				String next = des.get(0);
				result.add(next);
				des.remove(0);
				
				if(des.size() == 0)
					map.remove(current);
				
				current = next;				
			}
		}
		
		return result;
	}

}

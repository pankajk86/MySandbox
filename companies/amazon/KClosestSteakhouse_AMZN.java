package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestSteakhouse_AMZN {

	public static void main(String[] args) {
		List<List<Integer>> locations = createLocations();
		List<List<Integer>> result = findKNearest(6, locations, 3);
		System.out.println(result);
	}

	private static List<List<Integer>> findKNearest(int total, List<List<Integer>> locations, int k) {
		
		List<Location> locList = new ArrayList<>();
		for(List<Integer> location: locations) {
			locList.add(new Location(location.get(0), location.get(1)));
		}
		
		PriorityQueue<Location> pq = new PriorityQueue<>(k, new Comparator<Location>() {

			@Override
			public int compare(Location p1, Location p2) {
				int d1 = (p1.x * p1.x) + (p1.y *p1.y);
	            int d2 = (p2.x * p2.x) + (p2.y *p2.y);
	            return d2 - d1;
			}
		});
		
		for(Location loc: locList) {
			pq.add(loc);
			if(pq.size() > k) {
				pq.poll();
			}
		}
		
		List<List<Integer>> result = new ArrayList<>();
		
		while(!pq.isEmpty()) {
			List<Integer> point = new ArrayList<>();
			Location loc = pq.poll();
			point.addAll(Arrays.asList(loc.x, loc.y));
			result.add(point);
		}
		
		return result;
	}

	private static List<List<Integer>> createLocations() {
		List<List<Integer>> locations = new ArrayList<>();
		
		List<Integer> l1 = new ArrayList<>(Arrays.asList(3, 6));
		List<Integer> l2 = new ArrayList<>(Arrays.asList(2, 4));
		List<Integer> l3 = new ArrayList<>(Arrays.asList(5, 3));
		List<Integer> l4 = new ArrayList<>(Arrays.asList(2, 7));
		List<Integer> l5 = new ArrayList<>(Arrays.asList(1, 8));
		List<Integer> l6 = new ArrayList<>(Arrays.asList(7, 9));
		
		locations.addAll(Arrays.asList(l1, l2, l3, l4, l5, l6));
		
		return locations;
	}

}

class Location {
	int x, y;
	
	public Location(int x, int y) {
		this.x = x; this.y = y;
	}
}


package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BusRoutes {

	public static void main(String[] args) {
		int[][] routes = {{1,2,7},{2,4},{4,5,6}};
		int s = 1, t = 5;
		int result = minBuses(routes, s, t);
		System.out.println(result);
	}

	private static int minBuses(int[][] routes, int s, int t) {

		Set<Integer> visited = new HashSet<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		Queue<Integer> q = new LinkedList<>();
		int result = 0;
		
		if(s == t) return result;
		
		for(int i = 0; i < routes.length; i++) {
			for(int j = 0; j < routes[i].length; j++) {
				List<Integer> buses = map.getOrDefault(routes[i][j], new ArrayList<>());
				buses.add(i);
				map.put(routes[i][j], buses);
			}
		}
		
		q.add(s);
		
		while(!q.isEmpty()) {
			int len = q.size(); result++;
			
			for(int i = 0; i < len; i++) {
				int curr = q.poll();
				List<Integer> buses = map.get(curr);
				for(int bus: buses) {
					if(!visited.contains(bus)) {
						for(int j = 0; j < routes[bus].length; j++) {
							if(routes[bus][j] == t) return result;
							q.add(routes[bus][j]);
						}
					}
 				}
			}
		}
		return -1;
	}

}

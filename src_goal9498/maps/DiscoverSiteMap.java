package maps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiscoverSiteMap {

	public static void main(String[] args) {
		List<Log> logs = createLog();
		Map<Integer, List<Integer>> result = createSiteMap(logs);
		System.out.println(result);
	}

	private static Map<Integer, List<Integer>> createSiteMap(List<Log> logs) {
		Map<String, List<Integer>> map = new HashMap<>();
		Map<Integer, List<Integer>> result = new HashMap<>();
		
		for(Log log: logs) {
			List<Integer> pages = map.getOrDefault(log.user, new ArrayList<>());
			pages.add(log.page);
			map.put(log.user, pages);
		}
		
		for(List<Integer> pages: map.values()) {
			for(int i = 0; i < pages.size() - 1; i++) {
				int origin = pages.get(i);
				List<Integer> list = result.getOrDefault(origin, new ArrayList<>());
				list.add(pages.get(i + 1));
				result.put(origin, list);
			}
		}
		
		return result;
	}

	private static List<Log> createLog() {
		Log l1 = new Log("A", 1);
		Log l2 = new Log("B", 5);
		Log l3 = new Log("A", 2);
		Log l4 = new Log("A", 1);
		Log l5 = new Log("B", 2);
		Log l6 = new Log("C", 7);
		Log l7 = new Log("C", 3);
		Log l8 = new Log("A", 3);
		Log l9 = new Log("C", 1);
		
		return Arrays.asList(l1, l2, l3, l4, l5, l6, l7, l8, l9);
	}

}

class Log {
	String user;
	int page;
	
	Log(String user, int page) {
		this.user = user;
		this.page = page;
	}
}
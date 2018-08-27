package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KillProcess {

	public static void main(String[] args) {
		List<Integer> pid = new ArrayList<>();
//		pid.addAll(Arrays.asList(1, 3, 5, 10, 20, 30, 40));
		pid.addAll(Arrays.asList(1, 3, 10, 5));
		
		List<Integer> ppid = new ArrayList<>();
//		ppid.addAll(Arrays.asList(3, 0, 3, 5, 5, 5, 20));
		ppid.addAll(Arrays.asList(3, 0, 5, 3));
		
		int kill = 5;
		
		List<Integer> result = killProcess(pid, ppid, kill);
		for(int i: result)
			System.out.print(i + " ");
	}
	
	private static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {

		List<Integer> result = new ArrayList<>();
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		for(int i = 0; i < ppid.size(); i++) {
			List<Integer> list = map.getOrDefault(ppid.get(i), new ArrayList<>());
			list.add(pid.get(i));
			map.put(ppid.get(i), list);
		}
		
		int i = 0;
		result.add(kill);
		
		while(i < result.size()) {
			if(map.containsKey(result.get(i)))
				result.addAll(map.get(result.get(i)));
			i++;
		}
		
		return result;
	}

}

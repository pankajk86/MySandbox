package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int n = 2;

		int result = leastIntervalCorrect(tasks, n);
		System.out.println(result);
		
		result = leastInterval(tasks, n);
		System.out.println(result);
	}
	
	private static int leastInterval(char[] tasks, int n) {
		if(tasks == null || tasks.length == 0) return 0;
		
		Map<Character, Integer> map = new HashMap<>();
		for(char c: tasks) map.put(c, map.getOrDefault(c, 0) + 1);
		
		PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
		pq.addAll(map.values());
		int result = 0;
		
		while(!pq.isEmpty()) {
			int time = 0;
			List<Integer> temp = new ArrayList<>();
			for(int i = 0; i < n + 1; i++) {
				if(!pq.isEmpty()) {
					temp.add(pq.poll());
					time++;
				}
			}
			
			for(int t: temp) {
				if(--t > 0) pq.add(t);
			}
			
			result += pq.isEmpty() ? time : n + 1;
		}
		return result;
	}

	private static int leastIntervalCorrect(char[] tasks, int n) {
		int[] c = new int[26];

		for (char t : tasks) {
			c[t - 'A']++;
		}

		Arrays.sort(c);

		int i = 25;
		while (i >= 0 && c[i] == c[25]) {
			i--;
		}

		int interval = Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
		return interval;
	}

	

}


package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskScheduler {

	public static void main(String[] args) {
		char[] tasks = { 'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G' };
		int n = 2;

		int result = leastIntervalConstant(tasks, n);
		System.out.println(result);
		
		result = leastInterval(tasks, n);
		System.out.println(result);
	}

	private static int leastIntervalConstant(char[] tasks, int n) {

		/**
		A A A, n = 2
		A I I A I I A , maxFreq = 3, total = 7

		A A A B, n = 2
		A B I A B I A, total = 7
		**/

		int[] map = new int[26];
		int maxFreq = 0, maxFreqCount = 0;

		for(char c: tasks) map[c - 'A']++;
		for (int i : map) maxFreq = Math.max(maxFreq, i);

		for (int i : map) {
			if (i == maxFreq) maxFreqCount++;
		}

		int intervals = (maxFreq - 1) * (n + 1) + maxFreqCount;
		return Math.max(intervals, tasks.length);
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
}


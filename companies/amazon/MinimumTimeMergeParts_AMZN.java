package amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MinimumTimeMergeParts_AMZN {

	public static void main(String[] args) {
		int numOfParts = 4;
		List<Integer> parts = new ArrayList<>();
		parts.addAll(Arrays.asList(8, 4, 6, 12));
		
		int result = minimumTime(numOfParts, parts);
		System.out.println(result);
	}

	private static int minimumTime(int numOfParts, List<Integer> parts) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int result = 0;
		
		for(int part: parts)
			pq.add(part);
		
		while(pq.size() > 1) {
			int part1 = pq.poll();
			int part2 = pq.poll();
			int sum = part1 + part2;
			result += sum;
			pq.add(sum);
		}
		
		return result;
	}

}

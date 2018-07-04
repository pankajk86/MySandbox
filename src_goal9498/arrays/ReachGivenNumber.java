package arrays;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class ReachGivenNumber {

	public static void main(String[] args) {
		int target = -1000000;
		int result = reachNumber(target);
		System.out.println(result);
	}
	
	/**
	 * TODO : Need to revisit, as the performance is exponential.
	 * 
	 * @param target
	 * @return
	 */
	private static int reachNumber(int target) {

		int n = 1;

		Queue<Integer> q = new ArrayDeque<>();
		q.add(0);
		
		while(!q.isEmpty()) {
			List<Integer> list = new ArrayList<>();
			while(!q.isEmpty()) {
				list.add(q.poll());
			}
			
			for(Integer data: list) {
				int current = data;
				if(current + n == target || current - n == target) {
					return n;
				}

				q.add(current - n);
				q.add(current + n);
			}
			n++;
		}
		
		return -1;
	}
}


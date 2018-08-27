package google;

import java.util.ArrayList;
import java.util.List;

public class MaximizeSeatDistance {

	public static void main(String[] args) {
		int[] a = { 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0 };
		int result = maxDistToClosest(a);
		System.out.println(result);
	}

	private static int maxDistToClosest(int[] a) {

		List<Integer> occupied = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1)
				occupied.add(i);
		}

		int maxRange = 0, left = -1, right = -1;

		for (int i = 0; i < occupied.size(); i++) {
			if (i == 0) {
				maxRange = occupied.get(0);
				left = 0; right = maxRange;
			} else {
				int currRange = occupied.get(i) - occupied.get(i - 1) - 1;
				maxRange = Math.max(maxRange, currRange);
				
				if(currRange == maxRange) {
					left = occupied.get(i-1);
					right = occupied.get(i);
				}
			}
		}

		int endRange = a.length - 1 - occupied.get(occupied.size() - 1);
		maxRange = Math.max(maxRange, endRange);
		
		if(endRange == maxRange) {
			left = occupied.get(occupied.size() - 1);
			right = a.length - 1;
		}

		int result = 0;
		
//		if(left == 0)
//			result = right;
//		else if(right == a.length - 1)
//			result
			
		
		return result;
	}

}

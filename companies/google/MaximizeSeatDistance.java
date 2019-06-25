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

		int result = Integer.MIN_VALUE;
		List<Integer> occupied = new ArrayList<>();

		for (int i = 0; i < a.length; i++) {
			if (a[i] == 1)
				occupied.add(i);
		}
		
		int size = occupied.size();
		for(int i = 0, j = 0; i < a.length; i++) {
			if(a[i] == 0) {
				if(i < occupied.get(0))
					result = Math.max(result, occupied.get(0) - i);
				else if(i > occupied.get(size - 1))
					result = Math.max(result,  i - occupied.get(size - 1));
				else 
					result = Math.max(result, Math.min(i - occupied.get(j - 1), occupied.get(j) - i));
			} else j++;
		}

		return result;
	}

}

package google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinTimeDifference {

	public static void main(String[] args) {
		List<String> times = new ArrayList<>();
//		times.addAll(Arrays.asList("23:59", "22:45", "23:21"));
		times.addAll(Arrays.asList("01:01","02:02"));
		int result = getMinDifference(times);
		System.out.println(result);
	}
	
	private static int getMinDifference(List<String> times) {
		
		int size = times.size(), result = Integer.MAX_VALUE;
		int[] tArr = new int[size];
		
		for(int i = 0; i < size; i++) {
			String[] parts = times.get(i).split(":");
			tArr[i] = Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
		}
		
		Arrays.sort(tArr);

		for(int i = 0; i < size - 1; i++) {
			result = Math.min(result, tArr[i + 1] - tArr[i]);
		}
		
		result = Math.min(result, (24 * 60) - (tArr[size - 1] - tArr[0]));
		return result;
	}

}

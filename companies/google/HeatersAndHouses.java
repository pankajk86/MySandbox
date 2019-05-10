package google;

import java.util.Arrays;

public class HeatersAndHouses {

	public static void main(String[] args) {
		int[] houses = { 1, 2, 3, 4, 5, 6 };
		int[] heaters = { 1, 4 };
		int result = minRadius(houses, heaters);
		System.out.println(result);
	}

	private static int minRadius(int[] houses, int[] heaters) {

		Arrays.sort(heaters);
		int result = -1;
		
		for(int house: houses) {
			int index = Arrays.binarySearch(heaters, house);
			if(index < 0)
				index = - (index + 1);
			int dist1 = index - 1 >= 0 ? house - heaters[index - 1] : Integer.MAX_VALUE;
			int dist2 = index < heaters.length ? heaters[index] - house : Integer.MAX_VALUE;
			result = Math.max(result, Math.min(dist1, dist2));
		}
		return result;
	}
}

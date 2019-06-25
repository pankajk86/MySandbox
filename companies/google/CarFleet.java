package google;

import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

	public static void main(String[] args) {
		int target = 12;
		int[] position = { 10, 8, 0, 5, 3 };
		int[] speed = { 2, 4, 1, 1, 3 };
		
		int result = countFleet(target, position, speed);
		System.out.println(result);
	}

	private static int countFleet(int target, int[] position, int[] speed) {

		TreeMap<Integer, Integer> map = new TreeMap<>();
		int result = 0;
		
		for(int i = 0; i < position.length; i++) {
			map.put(target - position[i], speed[i]);
		}
		
		double temp = -1.0D;
		
		for(Map.Entry<Integer, Integer> entry: map.entrySet()) {
			int d = entry.getKey(), s = entry.getValue();
			double time = 1.0 * d/s;
			if(time > temp) {
				result++;
				temp = time;
			}
		}
		
		return result;
	}

}

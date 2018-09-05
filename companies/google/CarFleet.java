package google;

import java.util.Arrays;

public class CarFleet {

	public static void main(String[] args) {
		int target = 12;
		int[] position = { 10, 8, 0, 5, 3 };
		int[] speed = { 2, 4, 1, 1, 3 };
		
		int result = countFleet(target, position, speed);
		System.out.println(result);
	}

	private static int countFleet(int target, int[] position, int[] speed) {

		int fleet = 0;
		double max = -1D;
		double[] distribution = new double[target + 1];
		
		Arrays.fill(distribution, -1D);
		
		for(int i = 0; i < position.length; i++) {
			distribution[position[i]] = (target - position[i]) / speed[i];
		}
		
		for(int i = distribution.length - 1; i >= 0; i--) {
			if(distribution[i] > max) {
				max = distribution[i];
				fleet++;
			}
		}
		
		return fleet;
	}

}

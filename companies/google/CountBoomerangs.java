package google;

import java.util.HashMap;
import java.util.Map;

public class CountBoomerangs {

	public static void main(String[] args) {
		int[][] a = {
				{0,0},
				{1,0},
				{2,0},
				{2,1},
				{2,2}
		};
		
		int result = countBoomerangs(a);
		System.out.println(result);
	}

	private static int countBoomerangs(int[][] a) {

		Map<Integer, Integer> map = new HashMap<>();
		int result = 0;
		
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length; j++) {
				if(i != j) {
					int dist = getDistance(a[i], a[j]);
					map.put(dist, map.getOrDefault(dist, 0) + 1);
				}
			}
			
			for(int val: map.values()) {
				result += val * (val - 1);
			}
			
			map.clear();
		}
		
		return result;
	}

	private static int getDistance(int[] a, int[] b) {

		int dx = a[0] - b[0];
		int dy = a[1] - b[1];
		
		return dx * dx + dy * dy;
	}

}

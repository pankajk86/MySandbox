package uber;

public class CarPooling {

	public static void main(String[] args) {
		int[][] trips = { { 3, 2, 7 }, { 3, 7, 9 }, { 8, 3, 9 } };
		int capacity = 11;
		
		boolean result = carPooling(trips, capacity);
		System.out.println(result);
	}

	private static boolean carPooling(int[][] trips, int capacity) {
		int maxEnd = 0;
		
		for(int i = 0; i < trips.length; i++)
			maxEnd = Math.max(maxEnd, trips[i][2]);
		
		int[] cache = new int[maxEnd + 1];
		
		for(int i = 0; i < trips.length; i++) {
			int p = trips[i][0], s = trips[i][1], e = trips[i][2];
			for(int j = s + 1; j <= e; j++) {
				cache[j] += p;
				if(cache[j] > capacity) return false;
			}
		}
		
		return true;
	}

}

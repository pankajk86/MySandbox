package google;

public class CampusBikesII {

	private static int result = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		int[][] workers = { { 0, 0 }, { 1, 1 }, { 2, 0 } };
		int[][] bikes = { { 1, 0 }, { 2, 2 }, { 2, 1 } };
		
		int result = assignBikes(workers, bikes);
		System.out.println(result);
	}

	private static int assignBikes(int[][] workers, int[][] bikes) {
		dfs(workers, 0, bikes, new boolean[bikes.length], 0);
		return result;
	}

	private static void dfs(int[][] workers, int i, int[][] bikes, boolean[] assigned, int sum) {
		if(i == workers.length) {
			result = Math.min(result, sum);
			return;
		}
		
		if(sum > result) return;
		
		for(int j = 0; j < bikes.length; j++) {
			if(!assigned[j]) {
				assigned[j] = true;
				int distance = Math.abs(workers[i][0] - bikes[j][0]) + Math.abs(workers[i][1] - bikes[j][1]);
				dfs(workers, i + 1, bikes, assigned, sum + distance);
				assigned[j] = false;
			}
		}
	}

}

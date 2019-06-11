package google;

import java.util.Arrays;

public class NetworkDelayTime {

	public static void main(String[] args) {
		int[][] a = { 
				{ 2, 1, 5 }, 
				{ 2, 3, 1 }, 
				{ 3, 4, 1 }, 
				{ 3, 5, 3 }, 
				{ 4, 1, 1 }
			};
		int n = 5, k = 2;
		
		int result = networkDelay(a, n, k);
		System.out.println(result);
	}

	private static int networkDelay(int[][] a, int n, int k) {
		int[] delay = new int[n + 1];
		Arrays.fill(delay, Integer.MAX_VALUE);
		delay[0] = delay[k] = 0;
		
		for(int i = 0; i < n; i++) {
			for(int[] d: a) {
				int u = d[0], v = d[1], w = d[2];
				if(delay[u] != Integer.MAX_VALUE && delay[v] > delay[u] + w) {
					delay[u] = delay[v] + w;
				}
			}
		}
		
		int result = 0;
		for(int d: delay) result = Math.max(result, d);
		return result == Integer.MAX_VALUE ? -1 : result;
	}

}

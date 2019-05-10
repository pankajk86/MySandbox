package google;

import java.util.HashMap;
import java.util.Map;

public class FrogJump {

	public static void main(String[] args) {
		int[] a = { 0, 1, 3, 5, 6, 8, 12, 17 };
		boolean result = canJump(a);
		System.out.println(result);
	}

	private static boolean canJump(int[] a) {
		if(a == null || a.length == 0) return false;
		
		int size = a.length;
		Map<Integer, Integer> map = new HashMap<>();
		boolean[][] dp = new boolean[size][size];
		
		for(int i = 0; i < size; i++)
			map.put(a[i], i);
		
		dp[0][0] = true;
		
		for(int j = 1; j < size; j++) {
			for(int i = 1; i < size; i++) {
				int key = a[j] - i;
				if(map.containsKey(key)) {
					int val = map.get(key);
					dp[i][j] = dp[i - 1][val] || dp[i][val];
					
					if(i + 1 < size)
						dp[i][j] |= dp[i + 1][val];
				}
			}
 		}
		
		for(int i = 0; i < size; i++) {
			if(dp[i][size - 1]) return true;
		}
		
		return false;
	}

}

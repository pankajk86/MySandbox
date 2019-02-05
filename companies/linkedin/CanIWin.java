package linkedin;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CanIWin {

	private static Map<String, Boolean> map = new HashMap<>();
	
	public static void main(String[] args) {
		int maxChoosableInteger = 15, desiredTotal = 100;
		boolean result = canIWin(maxChoosableInteger, desiredTotal);
		System.out.println(result);
	}

	private static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
		
		if(desiredTotal <= maxChoosableInteger)
			return true;
		int sum = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
		if(sum < desiredTotal) return false;
		
		return helper(maxChoosableInteger, desiredTotal, new boolean[maxChoosableInteger + 1]);
	}

	private static boolean helper(int limit, int target, boolean[] chosen) {
		if(target <= 0) return false;
		
		String key = Arrays.toString(chosen);
		if(map.containsKey(key))
			return map.get(key);
		
		for(int i = 1; i <= limit; i++) {
			if(chosen[i]) continue;
			chosen[i] = true;
			if(!helper(limit, target - i, chosen)) {
				map.put(key, true);
				chosen[i] = false;
				return true;
			}
			chosen[i] = false;
		}
		map.put(key, false);
		return false;
	}

}

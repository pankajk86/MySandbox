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
		
		result = canIWin2(maxChoosableInteger, desiredTotal);
		System.out.println(result);
		
		result = canIWin2Better(maxChoosableInteger, desiredTotal);
		System.out.println(result);
	}
	
	private static boolean canIWin2Better(int maxInt, int desiredTotal) {
		if(desiredTotal <= 0) return true;
		if(maxInt * (maxInt + 1) / 2 < desiredTotal) return false;
		
		return dfs(desiredTotal, maxInt, 0, new HashMap<>());
	}
	
	private static boolean dfs(int sum, int n, int state, HashMap<Integer, Boolean> map) {
		if(map.containsKey(state)) return map.get(state);
		
		for(int i = 0; i < n; i++) {
			if((state & (1 << i)) == 0) {
				if(sum <= i + 1 || !dfs(sum - (i + 1), n, state | (1 << i), map)) {
					map.put(state, true);
					return true;
				}
			}
		}
		map.put(state, false);
		return false;
	}

	private static boolean canIWin2(int maxInt, int desiredTotal) {
		if(desiredTotal <= 0) return true;
		if(maxInt * (maxInt + 1) / 2 < desiredTotal) return false;
		
		return dfs(desiredTotal, new int[maxInt], new HashMap<>());
	}

	private static boolean dfs(int total, int[] state, HashMap<String, Boolean> map) {
		String curr = Arrays.toString(state);
		if(map.containsKey(curr)) return map.get(curr);
		
		for(int i = 0; i < state.length; i++) {
			if(state[i] == 0) {
				state[i] = 1;
				if(total <= i + 1 || !dfs(total - (i + 1), state, map)) {
					map.put(curr, true);
					state[i] = 0;
					return true;
				}
				state[i] = 0;
			}
		}
		map.put(curr, false);
		return false;
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

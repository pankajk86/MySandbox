package amazon;

public class HouseRobberII {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1 };
		int result = robMax(a);
		System.out.println(result);
		
		// prefer this one: more intuitive
		result = robMax2(a);
		System.out.println(result);
	}

	private static int robMax(int[] a) {
		int n = a.length;
		if(a == null || n == 0) return 0;
		if(n == 1) return a[0];
		
		return Math.max(rob(a, 0, n - 2), rob(a, 1, n - 1));
	}
	
	private static int rob(int[] a, int low, int high) {
		int pre = 0, curr = 0;
		
		for(int i = low; i <= high; i++) {
			int next = Math.max(pre + a[i], curr);
			pre = curr;
			curr = next;
		}
		return curr;
	}
	
	
	private static int robMax2(int[] a) {
		
		if(a == null || a.length == 0) return 0;
		
		int n = a.length;
		if(n == 1) return a[0];
		
		int robWithFirst = robHouse(a, 0, n - 2);
		int robWithoutFirst = robHouse(a, 1, n - 1);
		int result = Math.max(robWithFirst, robWithoutFirst);
		
		return result;
	}

	private static int robHouse(int[] a, int low, int high) {

		int n = high - low + 1;
		if(n == 1) return a[low];
		if(n == 2) return Math.max(a[low], a[high]);
		
		int[] dp = new int[n + 1];
		dp[low] = a[low]; dp[low + 1] = Math.max(a[low], a[low + 1]);
		
		for(int i = low + 2; i <= high; i++)
			dp[i] = Math.max(dp[i - 1], a[i] + dp[i - 2]);
		
		return dp[n - 1];
	}

}

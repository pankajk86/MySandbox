package amazon;

public class HouseRobberII {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 1 };
		int result = robMax(a);
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

}

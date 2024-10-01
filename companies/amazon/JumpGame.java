package amazon;

public class JumpGame {

	public static void main(String[] args) {
		int[] a = { 2, 3, 1, 1, 4 };
		boolean result = canJump(a);
		System.out.println(result);
		
		int[] b = {3,2,1,0,4};
		result = canJump(b);
		System.out.println(result);

		result = canJumpReverse(b);
		System.out.println(result);
	}

	private static boolean canJumpReverse(int[] a) {
		int n = a.length, goal = n - 1;

		for (int i = n - 2; i >= 0; i--) {
			if (i + a[i] >= goal) goal = i;
		}
		return goal == 0;
	}

	private static boolean canJump(int[] a) {
		int reachable = 0;
		
		for(int i = 0; i < a.length; i++) {
			if(i > reachable) return false;
			reachable = Math.max(reachable, i + a[i]);
		}
		return true;
	}

}

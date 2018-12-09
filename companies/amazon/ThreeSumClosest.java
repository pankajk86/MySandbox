package amazon;

import java.util.Arrays;

public class ThreeSumClosest {

	public static void main(String[] args) {
		int[] a = {-3, -2, -5, 3, -4};//{-3, -2, -5, 3, -4}; //{-1, 2, 1, -4};
		
		int n = Integer.MAX_VALUE + 2;
		System.out.println(n);
		System.out.println(Integer.MIN_VALUE);
		
		int result = threeSumClosest(a, -1);
		System.out.println(result);
	}

	private static int threeSumClosest(int[] a, int target) {

		int result = Integer.MAX_VALUE;
		Arrays.sort(a);
		
		for(int i = 0; i < a.length - 2; i++) {
			for(int j = i+1, k = a.length - 1; j < k; ) {
				int sum = a[i] + a[j] + a[k];
				
				if(sum == target) return sum;
				else {
					int diff = Math.abs(sum - target);
					int curr = result - target;
					if(diff < Math.abs(curr) || curr == Integer.MIN_VALUE)
						result = sum;
					if(sum > target) 
						k--;
					else 
						j++;
				}
			}
		}
		return result;
	}

	
}

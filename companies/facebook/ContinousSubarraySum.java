package facebook;

import java.util.HashSet;
import java.util.Set;

public class ContinousSubarraySum {

	public static void main(String[] args) {
		int[] a = {23, 2, 4, 6, 8};
		int k = 6;
		
		long start = System.currentTimeMillis();
		boolean result = checkSubarraySum(a, k);
		System.out.println("Time Taken: " + (System.currentTimeMillis() - start));
		System.out.println(result);
		
		start = System.currentTimeMillis();
		result = checkSubarraySumII(a, k);
		System.out.println("Time Taken: " + (System.currentTimeMillis() - start));
		System.out.println(result);
	}

	private static boolean checkSubarraySumII(int[] a, int k) {
		Set<Integer> set = new HashSet<>();
        k = k == 0 ? Integer.MAX_VALUE : (k < 0 ? -k : k); 
        int last = 0; // the prefix sum one element earlier
        
        for (int num : a) {
            int cur = (last + num) % k; // get newest prefix sum mod k
            if (set.contains(cur)) return true;
            set.add(last); // add old prefix sum into HashSet
            last = cur; // update old prefix sum
        }
        return false;
	}
	
	private static boolean checkSubarraySum(int[] a, int k) {
		
		if(k == 0) {
            int zeros = 0;
            for(int i = 0; i < a.length; i++) {
                if(a[i] == 0) zeros++;
            }
            
            return zeros > 1 ? true : false;
        }

		int size = a.length;
		int[] dp = new int[size];
		dp[0] = a[0];
		
		for(int i = 1; i < size; i++)
			dp[i] = dp[i - 1] + a[i];
		
		for(int i = 0; i < size - 1; i++) {
			for(int j = i + 1; j < size; j++) {
				if(i == 0) {
					if(dp[j] % k == 0) 
						return true;
				} else {
					int val = dp[j] - dp[i - 1];
					if(val % k == 0)
						return true;
				}
			}
		}
		
		return false;
	}

}

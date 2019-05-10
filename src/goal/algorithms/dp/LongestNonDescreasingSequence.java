package goal.algorithms.dp;

import java.util.Arrays;

public class LongestNonDescreasingSequence {

    public static void main(String[] args) {

        int arr[] = { 1, 0, 3, 5, 3, 4, 8, 6, 5 };

        int result = getLongestNonDescreasingSequence(arr);
        System.out.println("# of longest non-decreasing sequence: " + result);
        
        result = getLIS(arr);
        System.out.println(result);
    }
    
    private static int getLIS(int[] a) {
    	
    	int[] dp = new int[a.length];
    	int len = 0;
    	
    	for(int x: a) {
    		int i = Arrays.binarySearch(dp, 0, len, x);
    		if(i < 0) i = - (i + 1);
    		dp[i] = x;
    		if(i == len) len++;
    	}
    	
    	return len;
    }

    /**
     * Time Complexity: O(n^2)
     * 
     * @param arr
     * @return
     */
    private static int getLongestNonDescreasingSequence(int[] arr) {

        int size = arr.length;
        int[] result = new int[size];
        int max = 0;
        
        Arrays.fill(result, 1);

        for (int i = 1; i < size; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] <= arr[i] && result[j] + 1 > result[i]) {
                    result[i] = result[j] + 1;
                    max = Math.max(max, result[i]);
                }
            }
        }

        return max;
    }

}

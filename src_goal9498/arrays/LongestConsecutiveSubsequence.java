package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        int arr[] = { 36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42 };
        List<Integer> result = getLongestConsecutiveSubsequenceWithSorting(arr);

        for (int n : result) {
            System.out.print(n + ", ");
        }
        
        int count = getLongestConsecutiveSubsequence(arr);
        System.out.println("\n" + count);
        
        count = getLongestConsecutiveSubsequenceLinear(arr);
        System.out.println(count);
    }
    
    private static int getLongestConsecutiveSubsequenceLinear(int[] a) {
    	
    	int result = 0;
    	Map<Integer, Integer> map = new HashMap<>();
    	
    	for(int n: a) {
    		if(!map.containsKey(n)) {
    			int left = map.containsKey(n - 1) ? map.get(n - 1) : 0;
    			int right = map.containsKey(n + 1) ? map.get(n + 1) : 0;
    			int sum = left + right + 1;
    			
    			map.put(n, sum);
    			result = Math.max(result, sum);
    			
    			map.put(n - left, sum);
    			map.put(n + right, sum);
    		}
    	}
    	
    	return result;
    }

    private static List<Integer> getLongestConsecutiveSubsequenceWithSorting(int[] arr) {

        Arrays.sort(arr);
        int index = 0, localIndex = 0, count = 0, localCount = 0;
        List<Integer> list = new LinkedList<Integer>();

        for (int i = 0; i < arr.length - 1; i++) {
            localIndex = i;
            localCount = 1;

            while (arr[i + 1] - arr[i] == 1) {
                localCount++;
                i++;
            }

            if (localCount > count) {
                count = localCount;
                index = localIndex;
            }
        }

        for (int i = index; count > 0; i++, count--) {
            list.add(arr[i]);
        }

        return list;
    }
    
    private static int getLongestConsecutiveSubsequence(int[] arr) {

        Set<Integer> set = new HashSet<Integer>();
        int max = 1;

        for (int i : arr) {
            set.add(i);
        }

        for (int i : arr) {
            int left = i - 1;
            int right = i + 1;
            int count = 1;

            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }

            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }

            max = Math.max(max, count);
        }

        return max;
    }

}

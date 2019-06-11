package expedia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KSubsequences {

	public static void main(String[] args) {
		List<Integer> nums = new ArrayList<>();
		nums.addAll(Arrays.asList(5, 10, 11, 9, 5));
		
		int k = 5;
		
		int[] mod = new int[k];
		int sum = 0;
		
		for(int i = 0; i < nums.size(); i++) {
			sum += nums.get(i);
			mod[((sum % k) + k) % k]++; 
		}
		
		
		int result = 0; 
		  
        for (int i = 0; i < k; i++) 
            if (mod[i] > 1) 
                result += (mod[i] * (mod[i] - 1)) / 2; 
        result += mod[0]; 
		
        System.out.println(result);
	}

}

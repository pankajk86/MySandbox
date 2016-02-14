package goal.algorithms.hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class RemoveDuplicatesInArray {

	public static void main(String[] args) {
		int arr[] = {2, 1, 5, 4, 3, 1, 5, 6};
		arr = removeDuplicates(arr);
		
		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	private static int[] removeDuplicates(int[] arr) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int i=0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], 1);
			}
		}
		
		arr = new int[map.size()]; int j = 0;
		for(Entry<Integer, Integer> e: map.entrySet()) {
			arr[j] = e.getKey();
			j++;
		}
		
		return arr;
	}

}

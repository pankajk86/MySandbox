package amazon;

import java.util.ArrayList;
import java.util.List;

public class FindAllDuplicatesInArray {

	public static void main(String[] args) {
		int[] a = { 4, 3, 2, 7, 8, 2, 3, 1 };
		List<Integer> result = findDuplicates(a);
		System.out.println(result);
	}

	private static List<Integer> findDuplicates(int[] a) {
		List<Integer> result = new ArrayList<>();
		if(a == null || a.length == 0) return result;
		
		for(int i = 0; i < a.length; i++) {
			int index = Math.abs(a[i]) - 1;
			if(a[index] < 0)
				result.add(Math.abs(index + 1));
			a[index] = -a[index];
		}
		
		return result;
	}

}

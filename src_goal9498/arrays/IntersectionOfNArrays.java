package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IntersectionOfNArrays {

	public static void main(String[] args) {
		List<int[]> arrays = new ArrayList<>();
		int[] a1 = { 2, 3, 4, 7, 7, 1 };
		int[] a2 = { 4, 1, 3, 5 };
		int[] a3 = { 8, 4, 6, 2, 1 };
		int[] a4 = { 9, 4, 1 };
		arrays.addAll(Arrays.asList(a1, a2, a3, a4));
		
		List<Integer> result = intersection(arrays);
		System.out.println(result);
	}

	private static List<Integer> intersection(List<int[]> arrays) {
		Set<Integer> set  = new HashSet<>();
		List<Integer> result = new ArrayList<>();
		
		for(int[] a: arrays) {
			Arrays.sort(a);
			for(int i = 0; i < a.length; i++) {
				if(i > 0 && a[i] == a[i - 1]) continue;
				if(set.contains(a[i]) && !result.contains(a[i])) {
					result.add(a[i]);
				}
				set.add(a[i]);
			}
		}
		return result;
	}

}

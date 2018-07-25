package goal.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class ThreeSum {

	public static void main(String[] args) {

		int arr[] = { -4, -2, -2, -2, 0, 1, 2, 2, 2, 3, 3, 4, 4, 6, 6 };
		List<List<Integer>> list = getThreeSum3(arr);

		for (List<Integer> triplet : list) {
			for (int n : triplet) {
				System.out.print(n + " ");
			}
			System.out.println();
		}
	}
	
	private static List<List<Integer>> getThreeSum3(int[] a) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Arrays.sort(a);
		
		for(int i = 0; i < a.length - 2; i++) {
			if(i != 0 && a[i] == a[i-1]) {
				continue;
			}
			
			for(int j = i+1, k = a.length - 1; j < k; ) {
				
				int sum = a[i] + a[j] + a[k];
				
				if(sum == 0) {
					result.add(Arrays.asList(a[i], a[j], a[k]));
					j++; k--;
					
					while((j < k) && (a[j] == a[j-1])) {
						j++;
					}
					
					while((j < k) && (a[k] == a[k+1])) {
						k--;
					}
				} else if (sum > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		
		return result;
	}

	@SuppressWarnings("unused")
	private static List<List<Integer>> getThreeSum2(int[] a) {

		List<List<Integer>> result = new ArrayList<List<Integer>>();
		Set<String> exist = new HashSet<>();
		Arrays.sort(a);

		int[] req = new int[a.length];

		for (int i = 0; i < a.length; i++) {
			req[i] = a[i] * -1;
		}

		for (int i = 0; i < req.length; i++) {

			int[] cache = new int[req.length - 1];
			int required = req[i];

			for (int j = 0, k = 0; j < a.length; j++) {
				if (j != i) {
					cache[k] = a[j];
					k++;
				}
			}

			List<Integer> list = getTwoSum(cache, required, exist);
			if (list.size() == 2) {
				list.add(a[i]);
				String triplet = getTripletString(list);
				if (!exist.contains(triplet)) {
					result.add(list);
					exist.add(triplet);
				}
			}
		}

		return result;
	}

	private static List<Integer> getTwoSum(int[] cache, int target, Set<String> set) {

		int left = 0, right = cache.length - 1;
		List<Integer> list = new ArrayList<>();

 		while (left < right) {
			int sum = cache[left] + cache[right];
			if (sum == target) {
				list.add(cache[left]);
				list.add(cache[right]);
				return list;
			} else if (sum > target) {
				right--;
			} else {
				left++;
			}
		}

		return list;
	}

	private static String getTripletString(List<Integer> list) {
		Collections.sort(list);
		int first = list.get(0), second = list.get(1), third = list.get(2);
		String s = (first < 0 ? "" + first : "+" + first) + (second < 0 ? "" + second : "+" + second)
				+ (third < 0 ? "" + third : "+" + third);

		return s;
	}

	@SuppressWarnings("unused")
	private static List<List<Integer>> getThreeSum1(int[] arr) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();

		Arrays.sort(arr);
		int size = arr.length;

		for (int i = 0; i < size - 2; i++) {

			if (i == 0 || arr[i] > arr[i - 1]) {
				int a = arr[i];
				int start = i + 1;
				int end = size - 1;

				while (start < end) {
					int b = arr[start];
					int c = arr[end];

					if (a + b + c == 0) {
						List<Integer> triplet = new LinkedList<Integer>();
						triplet.add(a);
						triplet.add(b);
						triplet.add(c);
						list.add(triplet);
						end--;
					} else if (a + b + c > 0) {
						end--;
					} else {
						start++;
					}
				}
			}
		}

		return list;
	}

}

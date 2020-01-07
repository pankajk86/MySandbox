package microsoft;

import java.util.Arrays;

public class SortColors {

	public static void main(String[] args) {
		int[] a = {1,2,0};//{ 2, 0, 2, 1, 1, 0 };
		sort(a);
		System.out.println(Arrays.toString(a));
	}

	private static void sort(int[] a) {
		if(a == null || a.length == 0) return;
		int left = 0, mid = 0, right = a.length - 1;

		while(mid <= right) {
			if(a[mid] == 0) {
				swap(a, left, mid);
				left++; mid++;
			} else if(a[mid] == 2 && mid != right) {
				swap(a, mid, right);
				right--;
			} else mid++;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}

}

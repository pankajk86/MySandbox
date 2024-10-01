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
		int left = 0, i = 0, right = a.length - 1;

		while(i <= right) {
			if(a[i] == 0) {
				swap(a, left, i);
				left++; i++;
			} else if(a[i] == 2 && i != right) {
				swap(a, i, right);
				right--;
			} else i++;
		}
	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i]; a[i] = a[j]; a[j] = temp;
	}

}

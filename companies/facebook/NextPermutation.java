package facebook;

public class NextPermutation {

	public static void main(String[] args) {
		int[] a = { 2, 1, 3 };
		nextPermutation(a);
		
		for(int i: a) System.out.print(i + " ");
	}

	private static void nextPermutation(int[] a) {
		if(a == null || a.length == 0) return;
		
		int i = a.length - 1;
		
		for(; i >= 1; i--) {
			if(a[i] > a[i - 1])
				break;
		}
		
		if(i != 0)
			swap(a, i - 1);
		
		reserve(a, i);
	}

	private static void swap(int[] a, int i) {
		for(int j = a.length - 1; j > i; j--) {
			if(a[j] > a[i]) {
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				break;
			}
		}
	}

	private static void reserve(int[] a, int i) {
		int start = i, end = a.length - 1;
		while(start < end) {
			int temp = a[start];
			a[start] = a[end];
			a[end] = temp;
			start++; end--;
		}
	}

}

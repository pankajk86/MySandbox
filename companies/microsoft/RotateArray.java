package microsoft;

public class RotateArray {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7 };
		int k = 3;
		int[] rotate = rotate(a, k);
		
		for(int i: rotate)
			System.out.print(i + " ");
		
		rotateInSpace(a, k);
		System.out.println();
		
		for(int i: a)
			System.out.print(i + " ");
	}
	
	/**
	 * O(1) Space, O(n) Time
	 */
	private static void rotateInSpace(int[] a, int k) {
		if(k > a.length) k %= a.length;
		
		// find the partition
		int partition = a.length - k;
		
		// rotate the first part
		reverse(a, 0, partition - 1);
		
		// rotate the second part
		reverse(a, partition, a.length - 1);
		
		// rotate the whole array
		reverse(a, 0, a.length - 1);
	}

	private static void reverse(int[] a, int start, int end) {
		if(a == null || a.length == 1) return;
		
		for(int i = start, j = end; i < j; i++, j--) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
		}
	}

	/**
	 * O(n) - Time and Space
	 * @return
	 */
	private static int[] rotate(int[] a, int k) {
		if(k > a.length)
			k %= a.length;
		
		int[] result = new int[a.length];
		for(int i = 0; i < k; i++)
			result[i] = a[a.length - k + i];
		
		for(int i = k, j = 0; i < a.length; i++, j++)
			result[i] = a[j];
		
		return result;
	}

}

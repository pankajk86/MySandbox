package arrays;

public class NestedArray {
	
	public static void main(String[] args) {
		int[] a = { 5, 4, 0, 3, 1, 6, 2 };
		int maxLength = getMaxLength(a);
		System.out.println(maxLength);
	}

	private static int getMaxLength(int[] a) {

		int max = -1;
		
		for(int i=0; i<a.length; i++) {
			max = Math.max(max, nest(a, i, i, 1));
		}
		
		return max;
	}

	private static int nest(int[] a, int current, int original, int sum) {
		
		if(a[current] == original) {
			return sum;
		} else {
			return nest(a, a[current], original, ++sum);
		}
	}

}

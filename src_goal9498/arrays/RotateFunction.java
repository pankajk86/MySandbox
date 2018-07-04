package arrays;

public class RotateFunction {

	public static void main(String[] args) {
		int[] a = {5, 6, 1, 4, 7, -5, 9};
		int result = maxValue(a);
		System.out.println(result);
	}

	private static int maxValue(int[] a) {

		 int n = a.length;
		 int result = 0;
		 
		 // F(0)
		 for(int i = 1; i < n; i++) {
			 result += i * a[i]; 
		 }
		 
		for(int i = 1; i < n; i++) {
			int start1 = i, end1 = n;
			int start2 = 0, end2 = start1;
			int k = 0, val = 0;
			
			
			for(int j = start1; j < end1; j++, k++) {
				val += a[k] * j;
			}
			
			for(int j = start2; j < end2; j++, k++) {
				val += a[k] * j;
			}
			
			result = (val > result) ? val : result;
		}

		return result;
	}

}

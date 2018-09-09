package linkedin;

import java.util.Arrays;

public class ValidTriangleCount {

	public static void main(String[] args) {
		int[] a = {2, 2, 3, 4};
		int result = countTriangles(a);
		System.out.println(result);
	}

	private static int countTriangles(int[] a) {

		Arrays.sort(a);
		
		int count = 0, n = a.length;
		
		for(int i = n - 1; i >= 2; i--) {
			int left = 0, right = i - 1;
			while(left < right) {
				if(a[left] + a[right] > a[i]) {
					count += right - left;
					right--;
				} else left++;
			}
		}
		
 		return count;
	}

}

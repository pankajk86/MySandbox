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
		
		int result = 0, n = a.length;
		
		for(int k = n - 1; k >= 2; k--) {
            for(int i = 0, j = k - 1; i < j; ){
                if(a[i] + a[j] > a[k]) {
                    result += j - i;
                    j--;
                } else i++;
            }
        }
		
 		return result;
	}

}

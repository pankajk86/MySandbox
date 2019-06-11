package google;

public class NonDecreasingArray {

	public static void main(String[] args) {
		int[] a = { 3, 4, 2, 3 };
		boolean result = hasPossibility(a);
		System.out.println(result);
	}

	private static boolean hasPossibility(int[] a) {
		int count = 0;
		
		for(int i = 1; i < a.length && count <= 1; i++) {
			if(a[i - 1] > a[i]) {
				count++;
				if(i - 2 < 0 || a[i - 2] <= a[i]) a[i - 1] = a[i];
				else a[i] = a[i - 1];
			}
		}
		return count <= 1;
	}

}

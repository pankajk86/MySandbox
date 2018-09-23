package linkedin;

public class CanPlaceFlowers {

	public static void main(String[] args) {
		int[] a = { 0, 1, 0 }; // { 0, 0, 1, 0, 0, 0, 0, 1, 0 };
		int n = 1;

		boolean result = canPlaceFlowers(a, n);
		System.out.println(result);
	}

	private static boolean canPlaceFlowers(int[] a, int n) {

		if(n == 0) return true;
		
		if (a == null || a.length == 0 || n > a.length)
			return false;
		
		int count = 0, size = a.length;

		for (int i = 0; i < size; i++) {
			if (a[i] == 0) {
				if (i == 0) {
					if(a[i + 1] == 0) {
						a[i] = 1;
						count++;
					}
				} else if (i == size - 1) {
					if(a[i - 1] == 0) {
						a[i] = 1;
						count++;
					}
				} else {
					if (a[i - 1] == 0 && a[i + 1] == 0) {
						a[i] = 1;
						count++;
					}
				}
			}
		}

		return (count >= n);
	}

}

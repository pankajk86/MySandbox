package facebook;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4 };
		int[] result = productExceptSelf(a);
		for(int i: result)
			System.out.print(i + " ");
	}

	private static int[] productExceptSelf(int[] a) {

		int[] t1 = new int[a.length];
		int[] t2 = new int[a.length];
		t1[0] = 1;
		t2[a.length - 1] = 1;
		
		for(int i = 0; i < a.length - 1; i++)
			t1[i + 1] = t1[i] * a[i];
		
		for(int i = a.length - 1; i > 0; i--)
			t2[i - 1] = t2[i] * a[i];
		
		for(int i = 0; i < a.length; i++)
			a[i] = t1[i] * t2[i];
		
		return a;
	}

}

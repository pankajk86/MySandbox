package arrays;

public class AddOne {

	public static void main(String[] args) {
		int[] a = { 9, 0, 9, 0, 9 };
		int[] result = addOne(a);
		
		for(int i: result) {
			System.out.print(i + ", ");
		}
	}

	private static int[] addOne(int[] a) {

		int carry = 1;

		for (int i = a.length - 1; i >= 0; i--) {
			int sum = a[i] + carry;

			if (sum > 9) {
				a[i] = sum % 10;
				carry = 1;
			} else {
				a[i] = sum;
				carry = 0;
			}
		}

		if (carry == 1) {
			int[] result = new int[a.length + 1];
			result[0] = carry;
			for (int i = 1; i < result.length; i++) {
				result[i] = a[i - 1];
			}
			return result;
		}

		return a;
	}

}

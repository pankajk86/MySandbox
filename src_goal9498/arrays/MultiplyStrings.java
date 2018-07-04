package arrays;

public class MultiplyStrings {

	public static void main(String[] args) {
		String s1 = "9133", s2 = "0";
		String result = multiply(s1, s2);
		System.out.println(result);
	}

	private static String multiply(String s1, String s2) {
		
		if(s1.equals("0") || s2.equals("0")) {
			return "0";
		}

		String result = null;
		int begin = 0, count = 1;

		for (int i = s2.length() - 1; i >= 0; i--) {
			int a = Integer.parseInt(String.valueOf(s2.charAt(i)));

			int carry = 0;
			StringBuilder temp = new StringBuilder();

			for (int j = s1.length() - 1; j >= 0; j--) {
				int b = Integer.parseInt(String.valueOf(s1.charAt(j)));

				int val = a * b + carry;
				if (val >= 10) {
					carry = val / 10;
					val = val % 10;
				} else {
					carry = 0;
				}
			}

			if (carry > 0) {
				temp.append(carry);
			}
			temp = temp.reverse();

			if (begin == 0) {
				result = temp.toString();
				begin++;
			} else {
				for(int k = 0; k < count; k++) {
					temp.append(0);
				}
				count++;
				result = add(result, temp.toString());
			}
		}

		return result;
	}

	private static String add(String result, String temp) {

		StringBuilder sum = new StringBuilder();
		int i = result.length() - 1, j = temp.length() - 1;
		int carry = 0;

		while (i >= 0 && j >= 0) {
			int a = Integer.parseInt(String.valueOf(result.charAt(i)));
			int b = Integer.parseInt(String.valueOf(temp.charAt(j)));
			int val = a + b + carry;

			if (val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}

			sum.append(val);
			i--;
			j--;
		}

		while (i >= 0) {
			int val = Integer.parseInt(String.valueOf(result.charAt(i))) + carry;
			if (val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			sum.append(val);
			i--;
		}

		while (j >= 0) {
			int val = Integer.parseInt(String.valueOf(temp.charAt(j))) + carry;
			if (val >= 10) {
				carry = val / 10;
				val = val % 10;
			} else {
				carry = 0;
			}
			sum.append(val);
			j--;
		}

		if (carry > 0) {
			sum.append(carry);
		}

		return sum.reverse().toString();
	}

}

package facebook;

public class AddStrings {

	public static void main(String[] args) {
		String a = "123456789", b = "98443";
		String result = sum(a, b);
		System.out.println(result);
	}

	private static String sum(String a, String b) {
		int m = a.length(), n = b.length();
		int i = m - 1, j = n - 1, carry = 0;

		StringBuilder sb = new StringBuilder();

		while (i >= 0 && j >= 0) {
			int sum = (a.charAt(i--) - '0') + (b.charAt(j--) - '0') + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}

		while (i >= 0) {
			int sum = (a.charAt(i--) - '0') + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}

		while (j >= 0) {
			int sum = (b.charAt(j--) - '0') + carry;
			sb.append(sum % 10);
			carry = sum / 10;
		}

		if (carry > 0) sb.append(carry);

		return sb.reverse().toString();
	}

}

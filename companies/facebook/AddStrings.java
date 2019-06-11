package facebook;

public class AddStrings {

	public static void main(String[] args) {
		String a = "123456789", b = "98443";
		String result = sum(a, b);
		System.out.println(result);
	}

	private static String sum(String a, String b) {
		if(a == null || a.isEmpty() || b == null || b.isEmpty()) return null;
		
		int carry = 0;
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1, j = b.length() - 1;
		
		for(; i >= 0 && j >= 0; i--, j--) {
			int sum = (a.charAt(i) - '0') + (b.charAt(j) - '0') + carry;
			carry = sum / 10;
			sum %= 10;
			
			sb.append(sum);
		}
		
		while(i >= 0) {
			int sum = (a.charAt(i) - '0') + carry;
			carry = sum / 10;
			sum %= 10;
			
			sb.append(sum);
			i--;
		}
		
		while(j >= 0) {
			int sum = (b.charAt(j) - '0') + carry;
			carry = sum / 10;
			sum %= 10;
			
			sb.append(sum);
			j--;
		}
		
		if(carry > 0) sb.append(carry);
		return sb.reverse().toString();
	}

}

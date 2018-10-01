package facebook;

public class AddBinary {

	public static void main(String[] args) {
		String a = "1010", b = "1011";
		String result = add(a, b);
		System.out.println(result);
	}

	private static String add(String a, String b) {
		if(a == null || a.length() == 0 || b == null || b.length() == 0)
			return null;
		
		StringBuilder sb = new StringBuilder();
		if(a.length() != b.length()) {
			int pad = Math.abs(a.length() - b.length());
			for(int i = 0; i < pad; i++)
				sb.append("0");
		}
		
		if(a.length() > b.length())
			b = sb.toString() + b;
		else if(a.length() < b.length())
			a = sb.toString() + a;
		
		StringBuilder result = new StringBuilder();
		int carry = 0;
		
		for(int i = a.length() - 1; i >= 0; i--) {
			int ai = a.charAt(i) - '0', bi = b.charAt(i) - '0';
			int sum = ai + bi + carry;
			if(sum == 0 || sum == 1) {
				result.append(sum);
				carry = 0;
			} else if(sum == 2) {
				result.append(0);
				carry = 1;
			} else if(sum == 3) {
				result.append(1);
				carry = 1;
			}
		}
		
		if(carry == 1)
			result.append(carry);
		
		return result.reverse().toString();
	}

}

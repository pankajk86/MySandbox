package strings;

public class FractionAddAndSubstract {

	public static void main(String[] args) {
		String s = "1/3-1/2";
		String result = fractionMaths(s);
		
		System.out.println(result);
	}

	private static String fractionMaths(String s) {

		String[] parts = createParts(s);
		String result = parts[0];

		for (int i = 1; i < parts.length; i++) {
			result = calculate(result, parts[i]);
		}

		return result;
	}

	private static String calculate(String result, String part) {
		
		int num1 = Integer.parseInt(result.split("/")[0]);
		int den1 = Integer.parseInt(result.split("/")[1]);
		
		int num2 = Integer.parseInt(part.split("/")[0]);
		int den2 = Integer.parseInt(part.split("/")[1]);
		
		int num = (num1 * den2) + (num2 * den1);
		int den = (den1 * den2);
		
		int gcd = getGCD(num, den);
		
		num = num / gcd;
		den = den / gcd;
		
		if(den < 0) {
			num *= -1;
			den *= -1;
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.valueOf(num)).append("/").append(den);

		return sb.toString();
	}

	private static String[] createParts(String s) {
		int n = 0, start = 0;

		if (s.charAt(0) == '-') {
			start = 1;
		}

		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				n++;
			}
		}

		String[] parts = new String[n + 1];
		int k = start, l = 0;

		for (int i = start; i < s.length(); i++) {
			if (s.charAt(i) == '+' || s.charAt(i) == '-') {
				parts[l] = s.substring(k, i);
				k = i;
				l++;
			}
		}

		parts[l] = s.substring(k);

		if (start == 1) {
			parts[0] = '-' + parts[0];
		}

		return parts;
	}

	public static int getGCD(int n1, int n2) {
		if (n2 == 0) {
			return n1;
		}
		return getGCD(n2, n1 % n2);
	}

}
